package dynamicDesign.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import dynamicDesign.dao.exception.DAOException;
import dynamicDesign.model.Design;
import java.util.ArrayList;

public class DesignDAO {

	// connect to database
	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "123456");
	}

	// Add new user to DB - Register
	public boolean createDesign(Design design) throws DAOException {
		try (Connection connection = getConnection()) {
			String query = "INSERT INTO designs (designid, designname, designurl, price, email, noofroom) VALUES (?, ?, ?, ?, ?, ?)";
			try (PreparedStatement pmt = connection.prepareStatement(query)) {
				pmt.setInt(1, design.getDesignId());
				pmt.setString(2, design.getDesignName());
				pmt.setString(3, design.getDesignUrl());
				pmt.setDouble(4, design.getPrice());
				pmt.setString(5, design.getEmail());
				pmt.setInt(6, design.getNoOfRoom());

				int rows = pmt.executeUpdate();
				return rows == 1;
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

//	// List all designs from the DB
//	public List<Design> listDesigns() throws SQLException {
//		List<Design> designs = new ArrayList<>();
//		Connection connection = getConnection();
//		String query = "SELECT * FROM designs";
//		PreparedStatement pmt = connection.prepareStatement(query);
//
//		ResultSet resultSet = pmt.executeQuery();
//
//		while (resultSet.next()) {
//			int designId = resultSet.getInt(1); // Use the correct column name here
//			String designName = resultSet.getString("designname");
//			String designUrl = resultSet.getString("designurl");
//			double price = resultSet.getDouble("price");
//			String email = resultSet.getString("email");
//			int noOfRoom = resultSet.getInt("noofroom");
//
//			Design design = new Design(designId, designName, designUrl, price, email, noOfRoom);
//			designs.add(design);
//		}
//
//		resultSet.close();
//		pmt.close();
//		connection.close();
//
//		return designs;
//	}

	// Other methods and constructor

	public boolean updateDesign(Design design) throws SQLException {
		Connection connection = getConnection();
		String query = "UPDATE designs SET designname=?, designurl=?, price=?, email=?, noofroom=? WHERE designid=?";

		try (PreparedStatement pmt = connection.prepareStatement(query)) {
			pmt.setString(1, design.getDesignName());
			pmt.setString(2, design.getDesignUrl());
			pmt.setDouble(3, design.getPrice());
			pmt.setString(4, design.getEmail());
			pmt.setInt(5, design.getNoOfRoom());
			pmt.setInt(6, design.getDesignId());

			int rows = pmt.executeUpdate();
			return rows == 1;
		} finally {
			connection.close();
		}
	}
	
	// Delete design based on design ID
	public boolean deleteDesign(int designId) throws SQLException {
	    Connection connection = getConnection();
	    
	    String query = "UPDATE designs SET isDeleted = ? WHERE designid = ?";
	    
	    try (PreparedStatement pmt = connection.prepareStatement(query)) {
	        pmt.setBoolean(1, true); // Set isDeleted to true to mark the design as deleted
	        pmt.setInt(2, designId);
	        int rows = pmt.executeUpdate();
	        return rows == 1;
	    }
	}


}
