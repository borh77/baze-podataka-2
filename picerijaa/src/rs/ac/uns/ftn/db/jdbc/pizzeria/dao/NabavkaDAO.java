package rs.ac.uns.ftn.db.jdbc.pizzeria.dao;

import java.sql.SQLException;
import java.util.List;
import rs.ac.uns.ftn.db.jdbc.pizzeria.model.Nabavka;

public interface NabavkaDAO extends CRUDDao<Nabavka, Integer> {
	List<Nabavka> findByStatus(String statusNab) throws SQLException;
}
