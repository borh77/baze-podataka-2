package rs.ac.uns.ftn.db.jdbc.pizzeria.dao;

import java.sql.SQLException;
import java.util.List;
import rs.ac.uns.ftn.db.jdbc.pizzeria.model.Radnik;

public interface RadnikDAO extends CRUDDao<Radnik, Integer> {
	List<Radnik> findByType(String tipr) throws SQLException;
}
