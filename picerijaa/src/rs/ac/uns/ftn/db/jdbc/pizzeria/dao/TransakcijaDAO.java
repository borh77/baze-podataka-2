package rs.ac.uns.ftn.db.jdbc.pizzeria.dao;

import java.sql.SQLException;
import java.util.List;

import rs.ac.uns.ftn.db.jdbc.pizzeria.model.Porudzbina;
import rs.ac.uns.ftn.db.jdbc.pizzeria.model.Stavka;

/**
 * DAO interfejs za transakcije
 */
public interface TransakcijaDAO {
	
	/**
	 * TRANSAKCIJA:
	 * Kreiranje nove porudžbine sa stavkama i računom
	 * - INSERT u Porudzbina
	 * - INSERT u Stavka (više zapisa)
	 * - INSERT u Racun
	 * - COMMIT ili ROLLBACK
	 * 
	 * @param porudzbina Nova porudžbina
	 * @param stavke Lista stavki porudžbine
	 * @param nacPl Način plaćanja (GOTOVINA, PLATNA_KARITCA, PRENOS_NA_RACUN)
	 * @return true ako je transakcija uspela, false inače
	 */
	boolean napraviPorudzbinuSaStavkama(Porudzbina porudzbina, List<Stavka> stavke, String nacPl) throws SQLException;
}
