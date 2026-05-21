package rs.ac.uns.ftn.db.jdbc.pizzeria.dao;

import java.sql.SQLException;
import java.util.List;
import rs.ac.uns.ftn.db.jdbc.pizzeria.model.Lokal;

public interface LokalDAO extends CRUDDao<Lokal, Integer> {
	List<Lokal> findByCity(String city) throws SQLException;
}
