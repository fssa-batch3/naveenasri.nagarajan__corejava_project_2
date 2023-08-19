package com.fssa.dynamicdesign.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fssa.dynamicdesign.dao.exception.DAOException;
import com.fssa.dynamicdesign.model.Design;
import com.fssa.dynamicdesign.util.ConnectionDb;

public class DesignDAO {

	// Add new design to DB - Create
	public boolean createDesign(Design design) throws DAOException {
		String query = "INSERT INTO designs ( designName, designUrl, price, email, noOfRooms) VALUES ( ?, ?, ?, ?, ?)";

		try (Connection connection = ConnectionDb.getConnection();
				PreparedStatement pmt = connection.prepareStatement(query);) {

			pmt.setString(1, design.getDesignName());
			pmt.setString(2, design.getDesignUrl());
			pmt.setDouble(3, design.getPrice());
			pmt.setString(4, design.getEmail());
			pmt.setInt(5, design.getNoOfRoom());

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
		try (Connection connection = ConnectionDb.getConnection();

				PreparedStatement pmt = connection.prepareStatement(query);
				ResultSet resultSet = pmt.executeQuery()) {

			while (resultSet.next()) {
				 // Use the correct column name here
				String designName = resultSet.getString("designname");
				String designUrl = resultSet.getString("designurl");
				double price = resultSet.getDouble("price");
				String email = resultSet.getString("email");
				int noOfRoom = resultSet.getInt("noofrooms");

				Design design = new Design( designName, designUrl, price, email, noOfRoom);
				designs.add(design);
			}

			return designs;
		}
	}

	// Other methods and constructor

	public boolean updateDesign(Design design) throws SQLException {

		String query = "UPDATE designs SET designName=?, designUrl=?, price=?, email=?, noOfRooms =? WHERE designid=?";

		try (Connection connection = ConnectionDb.getConnection();
				PreparedStatement pmt = connection.prepareStatement(query)) {
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

		try (Connection connection = ConnectionDb.getConnection();
				PreparedStatement pmt = connection.prepareStatement(query)) {
			pmt.setBoolean(1, true); // Set isDeleted to true to mark the design as deleted
			pmt.setInt(2, designId);
			int rows = pmt.executeUpdate();
			return rows == 1;
		}
	}

}
