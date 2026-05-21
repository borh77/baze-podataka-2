package rs.ac.uns.ftn.db.jdbc.pizzeria.service;

import java.sql.SQLException;
import java.util.List;

import rs.ac.uns.ftn.db.jdbc.pizzeria.dao.IzvestajDAO;
import rs.ac.uns.ftn.db.jdbc.pizzeria.dao.impl.IzvestajDAOImpl;
import rs.ac.uns.ftn.db.jdbc.pizzeria.dto.ArtikalStatistikaDTO;
import rs.ac.uns.ftn.db.jdbc.pizzeria.dto.LokalStatistikaDTO;
import rs.ac.uns.ftn.db.jdbc.pizzeria.dto.PicaMajstorStatistikaDTO;

/**
 * Servis za kompleksne upite i izveštaje
 */
public class IzvestajService {
	
	private IzvestajDAO izvestajDAO = new IzvestajDAOImpl();
	
	/**
	 * JEDNOSTAVAN UPIT:
	 * Statistika porudžbina po lokalu
	 */
	public List<LokalStatistikaDTO> getStatistikaPoLokalu() throws SQLException {
		return izvestajDAO.getStatistikaPoLokalu();
	}
	
	/**
	 * KOMPLEKSAN UPIT 1:
	 * Statistika prodaje artikala po tipovima
	 */
	public List<ArtikalStatistikaDTO> getStatistikaProdajeArtikala() throws SQLException {
		return izvestajDAO.getStatistikaProdajeArtikala();
	}
	
	/**
	 * KOMPLEKSAN UPIT 2:
	 * Statistika pica majstora sa priremljenim picama
	 */
	public List<PicaMajstorStatistikaDTO> getStatistikaPicaMajstora() throws SQLException {
		return izvestajDAO.getStatistikaPicaMajstora();
	}
}
