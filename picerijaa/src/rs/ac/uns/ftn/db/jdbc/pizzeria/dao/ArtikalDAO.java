package rs.ac.uns.ftn.db.jdbc.pizzeria.dao;

import java.sql.SQLException;
import java.util.List;
import rs.ac.uns.ftn.db.jdbc.pizzeria.model.Artikal;

public interface ArtikalDAO extends CRUDDao<Artikal, Integer> {
	List<Artikal> findByType(String tipArt) throws SQLException;
}
