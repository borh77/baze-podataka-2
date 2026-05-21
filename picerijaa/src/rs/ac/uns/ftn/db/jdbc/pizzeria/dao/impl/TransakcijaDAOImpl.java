package rs.ac.uns.ftn.db.jdbc.pizzeria.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import rs.ac.uns.ftn.db.jdbc.pizzeria.connection.ConnectionUtil_HikariCP;
import rs.ac.uns.ftn.db.jdbc.pizzeria.dao.TransakcijaDAO;
import rs.ac.uns.ftn.db.jdbc.pizzeria.model.Porudzbina;
import rs.ac.uns.ftn.db.jdbc.pizzeria.model.Stavka;

/**
 * Implementacija DAO-a za transakcije
 */
public class TransakcijaDAOImpl implements TransakcijaDAO {

	@Override
	public boolean napraviPorudzbinuSaStavkama(Porudzbina porudzbina, List<Stavka> stavke, String nacPl) 
			throws SQLException {
		/**
		 * TRANSAKCIJA:
		 * - INSERT u Porudzbina tabelu
		 * - INSERT u Stavka tabelu (više zapisa)
		 * - INSERT u Racun tabelu
		 * - Ako bilo šta ne uspe, ROLLBACK svih promena
		 * - Ako sve uspe, COMMIT
		 */
		
		Connection connection = null;
		PreparedStatement psPorudzbina = null;
		PreparedStatement psStavka = null;
		PreparedStatement psRacun = null;
		
		try {
			// Dobavi konekciju i isključi auto-commit
			connection = ConnectionUtil_HikariCP.getConnection();
			connection.setAutoCommit(false);
			
			// 1. INSERT u Porudzbina
			String sqlPorudzbina = 
				"INSERT INTO Porudzbina (PorID, DatVrPor, StatusPor, Suma, NacPreuz, Kasir_Mbr, Musterija_Mbm) " +
				"VALUES (?, ?, ?, ?, ?, ?, ?)";
			
			psPorudzbina = connection.prepareStatement(sqlPorudzbina);
			psPorudzbina.setInt(1, porudzbina.getPorID());
			psPorudzbina.setDate(2, new java.sql.Date(porudzbina.getDatVrPor().getTime()));
			psPorudzbina.setString(3, porudzbina.getStatusPor());
			psPorudzbina.setDouble(4, porudzbina.getSuma());
			psPorudzbina.setString(5, porudzbina.getNacPreuz());
			psPorudzbina.setInt(6, porudzbina.getKasirMbr());
			psPorudzbina.setInt(7, porudzbina.getMusterijaMbm());
			
			int rowsPorudzbina = psPorudzbina.executeUpdate();
			
			if (rowsPorudzbina == 0) {
				throw new SQLException("Neuspešan INSERT u Porudzbina tabelu");
			}
			
			// 2. INSERT u Stavka (za svaku stavku)
			String sqlStavka = 
				"INSERT INTO Stavka (StvID, KolStv, Porudzbina_PorID, Pica_Majstor_Mbr, Artikal_SifArt) " +
				"VALUES (?, ?, ?, ?, ?)";
			
			psStavka = connection.prepareStatement(sqlStavka);
			
			for (Stavka stavka : stavke) {
				psStavka.setInt(1, stavka.getStvID());
				psStavka.setInt(2, stavka.getKolStv());
				psStavka.setInt(3, stavka.getPorudzbinaPorID());
				psStavka.setInt(4, stavka.getPicaMajstorMbr());
				psStavka.setInt(5, stavka.getArtikalSifArt());
				
				int rowsStavka = psStavka.executeUpdate();
				
				if (rowsStavka == 0) {
					throw new SQLException("Neuspešan INSERT u Stavka tabelu za stavku ID: " + stavka.getStvID());
				}
			}
			
			// 3. INSERT u Racun (samo ako je porudžbina preuzeta)
			if ("PREUZETA".equals(porudzbina.getStatusPor())) {
				String sqlRacun = 
					"INSERT INTO Racun (RacID, NacPl, DatVrRac, Izn, Kasir_Mbr) " +
					"VALUES (?, ?, ?, ?, ?)";
				
				psRacun = connection.prepareStatement(sqlRacun);
				
				// Generiši RacID (u realnoj aplikaciji bi se koristila sekvenca)
				int racID = porudzbina.getPorID(); // Za jednostavnost koristimo isti ID
				
				psRacun.setInt(1, racID);
				psRacun.setString(2, nacPl);
				psRacun.setDate(3, new java.sql.Date(porudzbina.getDatVrPor().getTime()));
				psRacun.setDouble(4, porudzbina.getSuma());
				psRacun.setInt(5, porudzbina.getKasirMbr());
				
				int rowsRacun = psRacun.executeUpdate();
				
				if (rowsRacun == 0) {
					throw new SQLException("Neuspešan INSERT u Racun tabelu");
				}
			}
			
			// Ako je sve prošlo OK, COMMIT
			connection.commit();
			System.out.println("✅ TRANSAKCIJA USPEŠNA: Porudžbina kreirana sa " + stavke.size() + " stavke/i");
			return true;
			
		} catch (SQLException e) {
			// Ako bilo šta ne uspe, ROLLBACK
			if (connection != null) {
				try {
					connection.rollback();
					System.err.println("❌ TRANSAKCIJA NEUSPEŠNA: ROLLBACK izvršen");
					System.err.println("Razlog: " + e.getMessage());
				} catch (SQLException rollbackException) {
					System.err.println("❌ Greška prilikom ROLLBACK-a: " + rollbackException.getMessage());
				}
			}
			throw e;
			
		} finally {
			// Zatvori sve resurse
			try {
				if (psRacun != null) psRacun.close();
				if (psStavka != null) psStavka.close();
				if (psPorudzbina != null) psPorudzbina.close();
				if (connection != null) {
					connection.setAutoCommit(true); // Vrati auto-commit na default
					connection.close();
				}
			} catch (SQLException e) {
				System.err.println("Greška prilikom zatvaranja resursa: " + e.getMessage());
			}
		}
	}
}
