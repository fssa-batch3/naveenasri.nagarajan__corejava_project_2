package com.fssa.dynamicdesign.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fssa.dynamicdesign.model.Architect;
import com.fssa.dynamicdesign.util.ConnectionDb;


public class ArchitectDAO {


	public boolean arcRegister(Architect architect) throws SQLException {

		String query = "INSERT INTO architect ( profilePhoto, name, gender, phoneNumber, address, coverPhoto, email, password, education, experience, degreeCertificate, NATACertificate) "
				+ "VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		try (Connection connection = ConnectionDb.getConnection(); PreparedStatement pmt = connection.prepareStatement(query)) {
		
			pmt.setString(1, architect.getProfilePhoto());
			pmt.setString(2, architect.getName());
			pmt.setString(3, architect.getGender());
			pmt.setString(4, architect.getPhoneNumber());
			pmt.setString(5, architect.getAddress());
			pmt.setString(6, architect.getCoverPhoto());
			pmt.setString(7, architect.getEmail());
			pmt.setString(8, architect.getPassword());
			pmt.setString(9, architect.getEducation());
			pmt.setInt(10, architect.getExperience());
			pmt.setString(11, architect.getDegreeCertificate());
			pmt.setString(12, architect.getNATACertificate());

			int rows = pmt.executeUpdate();
			return rows == 1;
		}
	}

	// Method to check if a ARCHITECT with the given email exists in the database
	public boolean isEmailExists(String email) throws SQLException {
		String query = "SELECT * FROM ARCHITECT WHERE email = ?";
		try (Connection connection = ConnectionDb.getConnection(); PreparedStatement pmt = connection.prepareStatement(query)) {
			pmt.setString(1, email);
			ResultSet rs = pmt.executeQuery();
			return rs.next(); // If a row is found, the email exists
		}
	}

	public boolean login(Architect architect, String email) throws SQLException {
		String query = "SELECT * FROM ARCHITECT WHERE email = ? AND password = ?";
		try (Connection connection = ConnectionDb.getConnection(); PreparedStatement pmt = connection.prepareStatement(query)) {
			pmt.setString(1, email); // Use provided email for the query
			pmt.setString(2, architect.getPassword());
			try (ResultSet rs = pmt.executeQuery()) {
				return rs.next(); // If a row is found, authentication is successful
			}
		}
	}

	public List<Architect> listArchitects() throws SQLException {
		List<Architect> architects = new ArrayList<>();
		String query = "SELECT * FROM ARCHITECT";
		try (Connection connection = ConnectionDb.getConnection(); PreparedStatement pmt = connection.prepareStatement(query);) {

			ResultSet resultSet = pmt.executeQuery();

			while (resultSet.next()) {
				int architectID = resultSet.getInt("architectID");
				String profilePhoto = resultSet.getString("profilePhoto");
				String name = resultSet.getString("name");
				String gender = resultSet.getString("gender");
				String phoneNumber = resultSet.getString("phoneNumber");
				String address = resultSet.getString("address");
				String coverPhoto = resultSet.getString("coverPhoto");
				String email = resultSet.getString("email");
				String password = resultSet.getString("password");
				String education = resultSet.getString("education");
				int experience = resultSet.getInt("experience");
				String degreeCertificate = resultSet.getString("degreeCertificate");
				String nataCertificate = resultSet.getString("NATACertificate");

				Architect architect = new Architect(architectID, profilePhoto, name, gender, phoneNumber, address,
						coverPhoto, email, password, education, experience, degreeCertificate, nataCertificate);
				architects.add(architect);
			}

			resultSet.close();

			return architects;
		}
	}

	// Update architect information based on email
	public boolean updateArchitect(Architect architect, String email) throws SQLException {
		String query = "UPDATE ARCHITECT SET profilePhoto=?, name=?, gender=?, phoneNumber=?, address=?, "
				+ "coverPhoto=?, education=?, experience=?, degreeCertificate=?, NATACertificate=? " + "WHERE email=?";
		try (Connection connection = ConnectionDb.getConnection(); PreparedStatement pmt = connection.prepareStatement(query);) {
			pmt.setString(1, architect.getProfilePhoto());
			pmt.setString(2, architect.getName());
			pmt.setString(3, architect.getGender());
			pmt.setString(4, architect.getPhoneNumber());
			pmt.setString(5, architect.getAddress());
			pmt.setString(6, architect.getCoverPhoto());
			pmt.setString(7, architect.getEducation());
			pmt.setInt(8, architect.getExperience());
			pmt.setString(9, architect.getDegreeCertificate());
			pmt.setString(10, architect.getNATACertificate());
			pmt.setString(11, email); // Use the provided email parameter for WHERE clause
			int rows = pmt.executeUpdate();

			return rows == 1;
		}
	}

	// Delete architect based on architect ID
	public boolean deleteArchitect(String email) throws SQLException {
		String query = "UPDATE architect SET isDeleted = ? WHERE email = ?";

		try (Connection connection = ConnectionDb.getConnection(); PreparedStatement pmt = connection.prepareStatement(query)) {
			pmt.setBoolean(1, true); // Set isDeleted to true to mark the architect as deleted
			pmt.setString(2, email);
			int rows = pmt.executeUpdate();
			return rows == 1;
		}
	}

}
