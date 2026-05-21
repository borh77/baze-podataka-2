package rs.ac.uns.ftn.db.jdbc.pizzeria.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import rs.ac.uns.ftn.db.jdbc.pizzeria.connection.ConnectionUtil_HikariCP;
import rs.ac.uns.ftn.db.jdbc.pizzeria.dao.IzvestajDAO;
import rs.ac.uns.ftn.db.jdbc.pizzeria.dto.ArtikalStatistikaDTO;
import rs.ac.uns.ftn.db.jdbc.pizzeria.dto.LokalStatistikaDTO;
import rs.ac.uns.ftn.db.jdbc.pizzeria.dto.PicaMajstorStatistikaDTO;

/**
 * Implementacija DAO-a za kompleksne upite i izveštaje
 */
public class IzvestajDAOImpl implements IzvestajDAO {

	@Override
	public List<LokalStatistikaDTO> getStatistikaPoLokalu() throws SQLException {
		/**
		 * JEDNOSTAVAN UPIT:
		 * - Spaja Lokal, Zaposljava, Kasir, Porudzbina (2-3 tabele)
		 * - Agregacije: COUNT, SUM, AVG
		 * - GROUP BY lokal
		 * - ORDER BY ukupan promet
		 */
		String query = 
			"SELECT l.LokID, l.Nazl, l.Adrl, " +
			"       COUNT(DISTINCT p.PorID) AS BrojPorudzbina, " +
			"       NVL(SUM(p.Suma), 0) AS UkupanPromet, " +
			"       NVL(AVG(p.Suma), 0) AS ProsecnaVrednost " +
			"FROM Lokal l " +
			"LEFT JOIN Zaposljava z ON l.LokID = z.Lokal_LokID " +
			"LEFT JOIN Kasir k ON z.Radnik_Mbr = k.Mbr " +
			"LEFT JOIN Porudzbina p ON k.Mbr = p.Kasir_Mbr " +
			"GROUP BY l.LokID, l.Nazl, l.Adrl " +
			"ORDER BY UkupanPromet DESC";
		
		List<LokalStatistikaDTO> rezultati = new ArrayList<>();
		
		try (Connection connection = ConnectionUtil_HikariCP.getConnection();
		     PreparedStatement preparedStatement = connection.prepareStatement(query);
		     ResultSet resultSet = preparedStatement.executeQuery()) {
			
			while (resultSet.next()) {
				LokalStatistikaDTO dto = new LokalStatistikaDTO();
				dto.setLokalID(resultSet.getInt("LokID"));
				dto.setNazivLokala(resultSet.getString("Nazl"));
				dto.setAdresaLokala(resultSet.getString("Adrl"));
				dto.setBrojPorudzbina(resultSet.getInt("BrojPorudzbina"));
				dto.setUkupanPromet(resultSet.getDouble("UkupanPromet"));
				dto.setProsecnaVrednost(resultSet.getDouble("ProsecnaVrednost"));
				rezultati.add(dto);
			}
		}
		
		return rezultati;
	}

	@Override
	public List<ArtikalStatistikaDTO> getStatistikaProdajeArtikala() throws SQLException {
		/**
		 * KOMPLEKSAN UPIT 1:
		 * - Spaja 5 tabela: Artikal, Stavka, Porudzbina, Cena, Meni
		 * - LEFT OUTER JOIN da uključi i neprodane artikle
		 * - Agregacije: COUNT, SUM, AVG
		 * - GROUP BY tip artikla
		 * - HAVING za filtriranje grupa (samo tipovi sa artiklima)
		 * - ORDER BY ukupna vrednost
		 */
		String query = 
			"SELECT a.TipArt, " +
			"       COUNT(DISTINCT a.SifArt) AS BrojArtikala, " +
			"       COUNT(DISTINCT s.StvID) AS BrojProdatih, " +
			"       NVL(SUM(s.KolStv), 0) AS UkupnaKolicina, " +
			"       NVL(SUM(s.KolStv * c.Iznos), 0) AS UkupnaVrednost, " +
			"       NVL(AVG(c.Iznos), 0) AS ProsecnaCena, " +
			"       NVL(AVG(s.KolStv), 0) AS ProsecnaKolicina " +
			"FROM Artikal a " +
			"LEFT JOIN Cena c ON a.SifArt = c.Artikal_SifArt AND c.Vazeca = 'D' " +
			"LEFT JOIN Stavka s ON a.SifArt = s.Artikal_SifArt " +
			"LEFT JOIN Porudzbina p ON s.Porudzbina_PorID = p.PorID " +
			"LEFT JOIN Meni m ON EXISTS (SELECT 1 FROM Sadrzi sd WHERE sd.Artikal_SifArt = a.SifArt AND sd.Meni_MeniID = m.MeniID) " +
			"GROUP BY a.TipArt " +
			"HAVING COUNT(DISTINCT a.SifArt) > 0 " +
			"ORDER BY UkupnaVrednost DESC";
		
		List<ArtikalStatistikaDTO> rezultati = new ArrayList<>();
		
		try (Connection connection = ConnectionUtil_HikariCP.getConnection();
		     PreparedStatement preparedStatement = connection.prepareStatement(query);
		     ResultSet resultSet = preparedStatement.executeQuery()) {
			
			while (resultSet.next()) {
				ArtikalStatistikaDTO dto = new ArtikalStatistikaDTO();
				dto.setTipArtikla(resultSet.getString("TipArt"));
				dto.setBrojArtikala(resultSet.getInt("BrojArtikala"));
				dto.setBrojProdatih(resultSet.getInt("BrojProdatih"));
				dto.setUkupnaKolicina(resultSet.getInt("UkupnaKolicina"));
				dto.setUkupnaVrednost(resultSet.getDouble("UkupnaVrednost"));
				dto.setProsecnaCena(resultSet.getDouble("ProsecnaCena"));
				dto.setProsecnaKolicina(resultSet.getDouble("ProsecnaKolicina"));
				rezultati.add(dto);
			}
		}
		
		return rezultati;
	}

	@Override
	public List<PicaMajstorStatistikaDTO> getStatistikaPicaMajstora() throws SQLException {
		/**
		 * KOMPLEKSAN UPIT 2:
		 * - Spaja 5 tabela: Radnik, Pica_Majstor, Stavka, Porudzbina, Zaposljava, Lokal
		 * - LEFT OUTER JOIN da uključi i majstore bez stavki
		 * - Agregacije: COUNT, SUM, AVG
		 * - GROUP BY majstor
		 * - ORDER BY broj pripremljenih
		 */
		String query = 
			"SELECT r.Mbr, r.Imer, r.Przr, " +
			"       pm.GodIsk, pm.Zvanje, " +
			"       l.Nazl AS NazivLokala, " +
			"       COUNT(DISTINCT s.StvID) AS BrojPripremljenih, " +
			"       NVL(SUM(s.KolStv), 0) AS UkupnaKolicina, " +
			"       NVL(AVG(s.KolStv), 0) AS ProsecnaKolicina " +
			"FROM Radnik r " +
			"INNER JOIN Pica_Majstor pm ON r.Mbr = pm.Mbr " +
			"LEFT JOIN Zaposljava z ON r.Mbr = z.Radnik_Mbr " +
			"LEFT JOIN Lokal l ON z.Lokal_LokID = l.LokID " +
			"LEFT JOIN Stavka s ON pm.Mbr = s.Pica_Majstor_Mbr " +
			"LEFT JOIN Porudzbina p ON s.Porudzbina_PorID = p.PorID " +
			"WHERE r.Tipr = 'PICA_MAJSTOR' " +
			"GROUP BY r.Mbr, r.Imer, r.Przr, pm.GodIsk, pm.Zvanje, l.Nazl " +
			"ORDER BY BrojPripremljenih DESC, UkupnaKolicina DESC";
		
		List<PicaMajstorStatistikaDTO> rezultati = new ArrayList<>();
		
		try (Connection connection = ConnectionUtil_HikariCP.getConnection();
		     PreparedStatement preparedStatement = connection.prepareStatement(query);
		     ResultSet resultSet = preparedStatement.executeQuery()) {
			
			while (resultSet.next()) {
				PicaMajstorStatistikaDTO dto = new PicaMajstorStatistikaDTO();
				dto.setMbrRadnika(resultSet.getInt("Mbr"));
				dto.setImeRadnika(resultSet.getString("Imer"));
				dto.setPrezimeRadnika(resultSet.getString("Przr"));
				dto.setGodineIskustva(resultSet.getInt("GodIsk"));
				dto.setZvanje(resultSet.getString("Zvanje"));
				dto.setNazivLokala(resultSet.getString("NazivLokala"));
				dto.setBrojPripremljenih(resultSet.getInt("BrojPripremljenih"));
				dto.setUkupnaKolicina(resultSet.getInt("UkupnaKolicina"));
				dto.setProsecnaKolicina(resultSet.getDouble("ProsecnaKolicina"));
				rezultati.add(dto);
			}
		}
		
		return rezultati;
	}
}
