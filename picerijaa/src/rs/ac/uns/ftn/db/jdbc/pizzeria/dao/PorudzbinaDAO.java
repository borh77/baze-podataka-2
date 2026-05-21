package rs.ac.uns.ftn.db.jdbc.pizzeria.dao;

import java.sql.SQLException;
import java.util.List;
import rs.ac.uns.ftn.db.jdbc.pizzeria.model.Porudzbina;

public interface PorudzbinaDAO extends CRUDDao<Porudzbina, Integer> {
	List<Porudzbina> findByStatus(String statusPor) throws SQLException;
	List<Porudzbina> findByMusterija(int mbm) throws SQLException;
}
