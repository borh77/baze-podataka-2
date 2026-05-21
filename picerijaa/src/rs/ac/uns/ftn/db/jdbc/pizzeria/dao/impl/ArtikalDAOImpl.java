package rs.ac.uns.ftn.db.jdbc.pizzeria.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import rs.ac.uns.ftn.db.jdbc.pizzeria.connection.ConnectionUtil_HikariCP;
import rs.ac.uns.ftn.db.jdbc.pizzeria.dao.ArtikalDAO;
import rs.ac.uns.ftn.db.jdbc.pizzeria.model.Artikal;

public class ArtikalDAOImpl implements ArtikalDAO {

	@Override
	public int count() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean delete(Artikal entity) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int deleteAll() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean deleteById(Integer id) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean existsById(Integer id) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<Artikal> findAll() throws SQLException {
		String query = "SELECT SifArt, OpisArt, NazivArt, TipArt, VelArt FROM Artikal";
		List<Artikal> artikalList = new ArrayList<Artikal>();

		try (Connection connection = ConnectionUtil_HikariCP.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(query);
				ResultSet resultSet = preparedStatement.executeQuery()) {

			while (resultSet.next()) {
				Artikal artikal = new Artikal();
				artikal.setSifArt(resultSet.getInt("SifArt"));
				artikal.setOpisArt(resultSet.getString("OpisArt"));
				artikal.setNazivArt(resultSet.getString("NazivArt"));
				artikal.setTipArt(resultSet.getString("TipArt"));
				artikal.setVelArt(resultSet.getString("VelArt"));
				artikalList.add(artikal);
			}

		}
		return artikalList;
	}

	@Override
	public Iterable<Artikal> findAllById(Iterable<Integer> ids) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Artikal findById(Integer id) throws SQLException {
		String query = "SELECT SifArt, OpisArt, NazivArt, TipArt, VelArt FROM Artikal WHERE SifArt = ?";
		Artikal artikal = null;

		try (Connection connection = ConnectionUtil_HikariCP.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			
			preparedStatement.setInt(1, id);
			
			try (ResultSet resultSet = preparedStatement.executeQuery()) {
				if (resultSet.next()) {
					artikal = new Artikal();
					artikal.setSifArt(resultSet.getInt("SifArt"));
					artikal.setOpisArt(resultSet.getString("OpisArt"));
					artikal.setNazivArt(resultSet.getString("NazivArt"));
					artikal.setTipArt(resultSet.getString("TipArt"));
					artikal.setVelArt(resultSet.getString("VelArt"));
				}
			}

		}
		return artikal;
	}

	@Override
	public boolean save(Artikal entity) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int saveAll(Iterable<Artikal> entities) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Artikal> findByType(String tipArt) throws SQLException {
		String query = "SELECT SifArt, OpisArt, NazivArt, TipArt, VelArt FROM Artikal WHERE TipArt = ?";
		List<Artikal> artikalList = new ArrayList<Artikal>();

		try (Connection connection = ConnectionUtil_HikariCP.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			
			preparedStatement.setString(1, tipArt);
			
			try (ResultSet resultSet = preparedStatement.executeQuery()) {
				while (resultSet.next()) {
					Artikal artikal = new Artikal();
					artikal.setSifArt(resultSet.getInt("SifArt"));
					artikal.setOpisArt(resultSet.getString("OpisArt"));
					artikal.setNazivArt(resultSet.getString("NazivArt"));
					artikal.setTipArt(resultSet.getString("TipArt"));
					artikal.setVelArt(resultSet.getString("VelArt"));
					artikalList.add(artikal);
				}
			}

		}
		return artikalList;
	}

}
