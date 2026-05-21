package rs.ac.uns.ftn.db.jdbc.pizzeria.service;

import java.sql.SQLException;
import java.util.List;

import rs.ac.uns.ftn.db.jdbc.pizzeria.dao.RadnikDAO;
import rs.ac.uns.ftn.db.jdbc.pizzeria.dao.impl.RadnikDAOImpl;
import rs.ac.uns.ftn.db.jdbc.pizzeria.model.Radnik;

public class RadnikService {
	
	private RadnikDAO radnikDAO = new RadnikDAOImpl();
	
	public List<Radnik> getAllRadnici() throws SQLException {
		return (List<Radnik>) radnikDAO.findAll();
	}
	
	public Radnik getRadnikById(int mbr) throws SQLException {
		return radnikDAO.findById(mbr);
	}
	
	public List<Radnik> getRadniciByType(String tipr) throws SQLException {
		return radnikDAO.findByType(tipr);
	}
	
	public boolean saveRadnik(Radnik radnik) throws SQLException {
		return radnikDAO.save(radnik);
	}
	
	public boolean deleteRadnik(int mbr) throws SQLException {
		return radnikDAO.deleteById(mbr);
	}
}
