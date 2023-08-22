package com.fssa.dynamicdesign.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fssa.dynamicdesign.dao.exception.DAOException;
import com.fssa.dynamicdesign.model.Architect;
import com.fssa.dynamicdesign.model.Design;
import com.fssa.dynamicdesign.util.ConnectionDb;

public class ViewArchitectDAO {

//	// Add new design to DB - Create
//	public boolean createDesign(Design design) throws DAOException {
//		String query = "INSERT INTO designs ( designName, designUrl, price, email, noOfRooms) VALUES ( ?, ?, ?, ?, ?)";
//
//		try (Connection connection = ConnectionDb.getConnection();
//				PreparedStatement pmt = connection.prepareStatement(query);) {
//
//			pmt.setString(1, design.getDesignName());
//			pmt.setString(2, design.getDesignUrl());
//			pmt.setDouble(3, design.getPrice());
//			pmt.setString(4, design.getEmail());
//			pmt.setInt(5, design.getNoOfRoom());
//
//			int rows = pmt.executeUpdate();
//			return rows == 1;
//
//		} catch (SQLException e) {
//			throw new DAOException(e);
//		}
//	}
	
	// inner joins  code for create design 
	public boolean createDesign(Design design) throws DAOException {
	    String query = "INSERT INTO designs (designName, designUrl, price, noOfRooms, architect_id) VALUES (?, ?, ?, ?, ?)";

	    try (Connection connection = ConnectionDb.getConnection();
	         PreparedStatement pmt = connection.prepareStatement(query);) {

	        pmt.setString(1, design.getDesignName());
	        pmt.setString(2, design.getDesignUrl());
	        pmt.setDouble(3, design.getPrice());
	  //      pmt.setInt(4, design.getNoOfRooms());
	        
	        // Set the architect_id foreign key
	  //      pmt.setInt(5, design.getViewArchitect().getArchitectID());

	        int rows = pmt.executeUpdate();
	        return rows == 1;

	    } catch (SQLException e) {
	        throw new DAOException(e);
	    }
	}


	// List all designs from the DB
//	public List<Design> listDesigns() throws SQLException {
//		List<Design> designs = new ArrayList<>();
//		String query = "SELECT * FROM designs";
//		try (Connection connection = ConnectionDb.getConnection();
//
//				PreparedStatement pmt = connection.prepareStatement(query);
//				ResultSet resultSet = pmt.executeQuery()) {
//
//			while (resultSet.next()) {
//				 // Use the correct column name here
//				String designName = resultSet.getString("designname");
//				String designUrl = resultSet.getString("designurl");
//				double price = resultSet.getDouble("price");
//				String email = resultSet.getString("email");
//				int noOfRoom = resultSet.getInt("noofrooms");
//
//				Design design = new Design( designName, designUrl, price, email, noOfRoom);
//				designs.add(design);
//			}
//
//			return designs;
//		}
//	}

	public List<Design> listDesigns() throws SQLException {
	    List<Design> designs = new ArrayList<>();
	    String query = "SELECT designs.designId, designs.designName, designs.designUrl, designs.price,  designs.noOfRooms, " +
	                   "architect.architectID, architect.profilePhoto, architect.name AS architectName, architect.gender, architect.phoneNumber, " +
	                   "architect.address AS architectAddress, architect.coverPhoto AS architectCoverPhoto, architect.email AS architectEmail, " +
	                   "architect.password AS architectPassword, architect.education, architect.experience, architect.degreeCertificate, architect.NATACertificate " +
	                   "FROM designs " +
	                   "INNER JOIN architect ON designs.architect_id = architect.architectID";

	    try (Connection connection = ConnectionDb.getConnection();
	         PreparedStatement pmt = connection.prepareStatement(query);
	         ResultSet resultSet = pmt.executeQuery()) {

	        while (resultSet.next()) {
	            int designId = resultSet.getInt("designId");
	            String designName = resultSet.getString("designName");
	            String designUrl = resultSet.getString("designUrl");
	            double price = resultSet.getDouble("price");
	            int noOfRooms = resultSet.getInt("noOfRooms");

	            int architectID = resultSet.getInt("architectID");
	            String architectProfilePhoto = resultSet.getString("profilePhoto");
	            String architectName = resultSet.getString("architectName");
	            String architectGender = resultSet.getString("gender");
	            String architectPhoneNumber = resultSet.getString("phoneNumber");
	            String architectAddress = resultSet.getString("architectAddress");
	            String architectCoverPhoto = resultSet.getString("architectCoverPhoto");
	            String architectEmail = resultSet.getString("architectEmail");
	            String architectPassword = resultSet.getString("architectPassword");
	            String architectEducation = resultSet.getString("education");
	            int architectExperience = resultSet.getInt("experience");
	            String architectDegreeCertificate = resultSet.getString("degreeCertificate");
	            String architectNATACertificate = resultSet.getString("NATACertificate");

	            Architect viewArchitect = new Architect(architectID, architectProfilePhoto, architectName, architectGender,
	                                                    architectPhoneNumber, architectAddress, architectCoverPhoto,
	                                                    architectEmail, architectPassword, architectEducation,
	                                                    architectExperience, architectDegreeCertificate, architectNATACertificate);

	       //     Design design = new Design(designId, designName, designUrl, price,  noOfRooms);
	      //      designs.add(design);
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
		//	pmt.setInt(5, design.getNoOfRooms());
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
