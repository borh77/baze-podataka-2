package rs.ac.uns.ftn.db.jdbc.pizzeria.dao;

import java.sql.SQLException;
import java.util.List;
import rs.ac.uns.ftn.db.jdbc.pizzeria.model.Musterija;

public interface MusterijaDAO extends CRUDDao<Musterija, Integer> {
	List<Musterija> findByName(String name) throws SQLException;
}
