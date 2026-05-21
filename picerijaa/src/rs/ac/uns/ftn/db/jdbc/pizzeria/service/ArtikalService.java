package rs.ac.uns.ftn.db.jdbc.pizzeria.service;

import java.sql.SQLException;
import java.util.List;

import rs.ac.uns.ftn.db.jdbc.pizzeria.dao.ArtikalDAO;
import rs.ac.uns.ftn.db.jdbc.pizzeria.dao.impl.ArtikalDAOImpl;
import rs.ac.uns.ftn.db.jdbc.pizzeria.model.Artikal;

public class ArtikalService {
	
	private ArtikalDAO artikalDAO = new ArtikalDAOImpl();
	
	public List<Artikal> getAllArtikli() throws SQLException {
		return (List<Artikal>) artikalDAO.findAll();
	}
	
	public Artikal getArtikalById(int sifArt) throws SQLException {
		return artikalDAO.findById(sifArt);
	}
	
	public List<Artikal> getArtikliByType(String tipArt) throws SQLException {
		return artikalDAO.findByType(tipArt);
	}
	
	public boolean saveArtikal(Artikal artikal) throws SQLException {
		return artikalDAO.save(artikal);
	}
	
	public boolean deleteArtikal(int sifArt) throws SQLException {
		return artikalDAO.deleteById(sifArt);
	}
}
