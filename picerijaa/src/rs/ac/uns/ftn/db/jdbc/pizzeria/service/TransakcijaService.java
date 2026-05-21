package rs.ac.uns.ftn.db.jdbc.pizzeria.service;

import java.sql.SQLException;
import java.util.List;

import rs.ac.uns.ftn.db.jdbc.pizzeria.dao.TransakcijaDAO;
import rs.ac.uns.ftn.db.jdbc.pizzeria.dao.impl.TransakcijaDAOImpl;
import rs.ac.uns.ftn.db.jdbc.pizzeria.model.Porudzbina;
import rs.ac.uns.ftn.db.jdbc.pizzeria.model.Stavka;

/**
 * Servis za transakcije
 */
public class TransakcijaService {
	
	private TransakcijaDAO transakcijaDAO = new TransakcijaDAOImpl();
	
	/**
	 * TRANSAKCIJA:
	 * Kreiranje nove porudžbine sa stavkama i računom
	 * 
	 * @param porudzbina Nova porudžbina
	 * @param stavke Lista stavki porudžbine
	 * @param nacPl Način plaćanja (GOTOVINA, PLATNA_KARITCA, PRENOS_NA_RACUN)
	 * @return true ako je transakcija uspela, false inače
	 */
	public boolean napraviPorudzbinuSaStavkama(Porudzbina porudzbina, List<Stavka> stavke, String nacPl) 
			throws SQLException {
		
		// Validacija ulaznih podataka
		if (porudzbina == null) {
			throw new IllegalArgumentException("Porudžbina ne sme biti null");
		}
		
		if (stavke == null || stavke.isEmpty()) {
			throw new IllegalArgumentException("Lista stavki ne sme biti prazna");
		}
		
		if (nacPl == null || nacPl.trim().isEmpty()) {
			throw new IllegalArgumentException("Način plaćanja ne sme biti prazan");
		}
		
		// Pozovi DAO za izvršenje transakcije
		return transakcijaDAO.napraviPorudzbinuSaStavkama(porudzbina, stavke, nacPl);
	}
}
