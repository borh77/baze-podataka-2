package rs.ac.uns.ftn.db.jdbc.pizzeria.dao;

import java.sql.SQLException;
import java.util.List;

import rs.ac.uns.ftn.db.jdbc.pizzeria.dto.ArtikalStatistikaDTO;
import rs.ac.uns.ftn.db.jdbc.pizzeria.dto.LokalStatistikaDTO;
import rs.ac.uns.ftn.db.jdbc.pizzeria.dto.PicaMajstorStatistikaDTO;

/**
 * DAO interfejs za kompleksne upite i izveštaje
 */
public interface IzvestajDAO {
	
	/**
	 * JEDNOSTAVAN UPIT:
	 * Statistika porudžbina po lokalu
	 * Spaja: Lokal, Zaposljava, Porudzbina
	 * Agregacije: COUNT, SUM, AVG
	 */
	List<LokalStatistikaDTO> getStatistikaPoLokalu() throws SQLException;
	
	/**
	 * KOMPLEKSAN UPIT 1:
	 * Statistika prodaje artikala po tipovima
	 * Spaja: Artikal, Stavka, Porudzbina, Cena, Meni (5 tabela)
	 * LEFT OUTER JOIN, GROUP BY, HAVING, ORDER BY
	 */
	List<ArtikalStatistikaDTO> getStatistikaProdajeArtikala() throws SQLException;
	
	/**
	 * KOMPLEKSAN UPIT 2:
	 * Statistika pica majstora sa priremljenim picama
	 * Spaja: Radnik, Pica_Majstor, Stavka, Porudzbina, Zaposljava, Lokal (5 tabela)
	 * LEFT OUTER JOIN, GROUP BY, ORDER BY
	 */
	List<PicaMajstorStatistikaDTO> getStatistikaPicaMajstora() throws SQLException;
}
