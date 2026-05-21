package rs.ac.uns.ftn.db.jdbc.pizzeria.dao;

import java.sql.SQLException;
import java.util.List;
import rs.ac.uns.ftn.db.jdbc.pizzeria.model.Stavka;

public interface StavkaDAO extends CRUDDao<Stavka, Integer> {
	List<Stavka> findByPorudzbina(int porID) throws SQLException;
}
