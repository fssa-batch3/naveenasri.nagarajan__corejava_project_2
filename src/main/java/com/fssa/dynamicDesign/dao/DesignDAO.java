package com.fssa.dynamicDesign.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.fssa.dynamicDesign.dao.exception.DAOException;
import com.fssa.dynamicDesign.model.Design;

import io.github.cdimascio.dotenv.Dotenv;

import java.util.ArrayList;

public class DesignDAO {

	public Connection getConnection() throws SQLException {
		String DB_URL;
		String DB_USER;
		String DB_PASSWORD;

		if (System.getenv("CI") != null) {
			DB_URL = System.getenv("DB_URL");
			DB_USER = System.getenv("DB_USER");
			DB_PASSWORD = System.getenv("DB_PASSWORD");
		} else {
			Dotenv env = Dotenv.load();
			DB_URL = env.get("DB_URL");
			DB_USER = env.get("DB_USER");
			DB_PASSWORD = env.get("DB_PASSWORD");
		}
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "123456");
		// return DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
	}

	// Add new design to DB - Create
	public boolean createDesign(Design design) throws DAOException {
		String query = "INSERT INTO designs (designId, designName, designUrl, price, email, noOfRooms) VALUES (?, ?, ?, ?, ?, ?)";

		try (Connection connection = getConnection(); PreparedStatement pmt = connection.prepareStatement(query);) {
			pmt.setInt(1, design.getDesignId());
			pmt.setString(2, design.getDesignName());
			pmt.setString(3, design.getDesignUrl());
			pmt.setDouble(4, design.getPrice());
			pmt.setString(5, design.getEmail());
			pmt.setInt(6, design.getNoOfRoom());

			int rows = pmt.executeUpdate();
			return rows == 1;

		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

	// List all designs from the DB
	public List<Design> listDesigns() throws SQLException {
		List<Design> designs = new ArrayList<>();
		String query = "SELECT * FROM designs";
		try (Connection connection = getConnection();

				PreparedStatement pmt = connection.prepareStatement(query);
				ResultSet resultSet = pmt.executeQuery()) {

			while (resultSet.next()) {
				int designId = resultSet.getInt(1); // Use the correct column name here
				String designName = resultSet.getString("designname");
				String designUrl = resultSet.getString("designurl");
				double price = resultSet.getDouble("price");
				String email = resultSet.getString("email");
				int noOfRoom = resultSet.getInt("noofrooms");

				Design design = new Design(designId, designName, designUrl, price, email, noOfRoom);
				designs.add(design);
			}

			resultSet.close();
			pmt.close();
			connection.close();

			return designs;
		}
	}

	// Other methods and constructor

	public boolean updateDesign(Design design) throws SQLException {

		String query = "UPDATE designs SET designName=?, designUrl=?, price=?, email=?, noOfRooms =? WHERE designid=?";

		try (Connection connection = getConnection(); PreparedStatement pmt = connection.prepareStatement(query)) {
			pmt.setString(1, design.getDesignName());
			pmt.setString(2, design.getDesignUrl());
			pmt.setDouble(3, design.getPrice());
			pmt.setString(4, design.getEmail());
			pmt.setInt(5, design.getNoOfRoom());
			pmt.setInt(6, design.getDesignId());

			int rows = pmt.executeUpdate();
			return rows == 1;

		}
	}

	// Delete design based on design ID
	public boolean deleteDesign(int designId) throws SQLException {

		String query = "UPDATE designs SET isDeleted = ? WHERE designid = ?";

		try (Connection connection = getConnection(); PreparedStatement pmt = connection.prepareStatement(query)) {
			pmt.setBoolean(1, true); // Set isDeleted to true to mark the design as deleted
			pmt.setInt(2, designId);
			int rows = pmt.executeUpdate();
			return rows == 1;
		}
	}

}
