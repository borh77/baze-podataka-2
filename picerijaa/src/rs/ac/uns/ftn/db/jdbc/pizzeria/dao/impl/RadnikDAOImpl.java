package rs.ac.uns.ftn.db.jdbc.pizzeria.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import rs.ac.uns.ftn.db.jdbc.pizzeria.connection.ConnectionUtil_HikariCP;
import rs.ac.uns.ftn.db.jdbc.pizzeria.dao.RadnikDAO;
import rs.ac.uns.ftn.db.jdbc.pizzeria.model.Radnik;

public class RadnikDAOImpl implements RadnikDAO {

	@Override
	public int count() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean delete(Radnik entity) throws SQLException {
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
	public Iterable<Radnik> findAll() throws SQLException {
		String query = "SELECT Mbr, Imer, Przr, Datr, Emailr, Telr, DatSan, Tipr, Radnik_Mbr FROM Radnik";
		List<Radnik> radnikList = new ArrayList<Radnik>();

		try (Connection connection = ConnectionUtil_HikariCP.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(query);
				ResultSet resultSet = preparedStatement.executeQuery()) {

			while (resultSet.next()) {
				Radnik radnik = new Radnik();
				radnik.setMbr(resultSet.getInt("Mbr"));
				radnik.setImer(resultSet.getString("Imer"));
				radnik.setPrzr(resultSet.getString("Przr"));
				radnik.setDatr(resultSet.getDate("Datr"));
				radnik.setEmailr(resultSet.getString("Emailr"));
				radnik.setTelr(resultSet.getString("Telr"));
				radnik.setDatSan(resultSet.getDate("DatSan"));
				radnik.setTipr(resultSet.getString("Tipr"));
				int supervizor = resultSet.getInt("Radnik_Mbr");
				if (!resultSet.wasNull()) {
					radnik.setRadnikMbr(supervizor);
				}
				radnikList.add(radnik);
			}

		}
		return radnikList;
	}

	@Override
	public Iterable<Radnik> findAllById(Iterable<Integer> ids) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Radnik findById(Integer id) throws SQLException {
		String query = "SELECT Mbr, Imer, Przr, Datr, Emailr, Telr, DatSan, Tipr, Radnik_Mbr FROM Radnik WHERE Mbr = ?";
		Radnik radnik = null;

		try (Connection connection = ConnectionUtil_HikariCP.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			
			preparedStatement.setInt(1, id);
			
			try (ResultSet resultSet = preparedStatement.executeQuery()) {
				if (resultSet.next()) {
					radnik = new Radnik();
					radnik.setMbr(resultSet.getInt("Mbr"));
					radnik.setImer(resultSet.getString("Imer"));
					radnik.setPrzr(resultSet.getString("Przr"));
					radnik.setDatr(resultSet.getDate("Datr"));
					radnik.setEmailr(resultSet.getString("Emailr"));
					radnik.setTelr(resultSet.getString("Telr"));
					radnik.setDatSan(resultSet.getDate("DatSan"));
					radnik.setTipr(resultSet.getString("Tipr"));
					int supervizor = resultSet.getInt("Radnik_Mbr");
					if (!resultSet.wasNull()) {
						radnik.setRadnikMbr(supervizor);
					}
				}
			}

		}
		return radnik;
	}

	@Override
	public boolean save(Radnik entity) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int saveAll(Iterable<Radnik> entities) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Radnik> findByType(String tipr) throws SQLException {
		String query = "SELECT Mbr, Imer, Przr, Datr, Emailr, Telr, DatSan, Tipr, Radnik_Mbr FROM Radnik WHERE Tipr = ?";
		List<Radnik> radnikList = new ArrayList<Radnik>();

		try (Connection connection = ConnectionUtil_HikariCP.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			
			preparedStatement.setString(1, tipr);
			
			try (ResultSet resultSet = preparedStatement.executeQuery()) {
				while (resultSet.next()) {
					Radnik radnik = new Radnik();
					radnik.setMbr(resultSet.getInt("Mbr"));
					radnik.setImer(resultSet.getString("Imer"));
					radnik.setPrzr(resultSet.getString("Przr"));
					radnik.setDatr(resultSet.getDate("Datr"));
					radnik.setEmailr(resultSet.getString("Emailr"));
					radnik.setTelr(resultSet.getString("Telr"));
					radnik.setDatSan(resultSet.getDate("DatSan"));
					radnik.setTipr(resultSet.getString("Tipr"));
					int supervizor = resultSet.getInt("Radnik_Mbr");
					if (!resultSet.wasNull()) {
						radnik.setRadnikMbr(supervizor);
					}
					radnikList.add(radnik);
				}
			}

		}
		return radnikList;
	}

}
