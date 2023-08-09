package com.fssa.dynamicDesign.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fssa.dynamicDesign.model.Architect;

public class ArchitectDAO {

// create connection
// connect to database
	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "123456");
	}

	public boolean arcRegister(Architect architect) throws SQLException {

		String query = "INSERT INTO architect (architectID, profilePhoto, name, gender, phoneNumber, address, coverPhoto, email, password, education, experience, degreeCertificate, NATACertificate) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		try (Connection connection = getConnection(); PreparedStatement pmt = connection.prepareStatement(query)) {
			pmt.setInt(1, architect.getArchitectID());
			pmt.setString(2, architect.getProfilePhoto());
			pmt.setString(3, architect.getName());
			pmt.setString(4, architect.getGender());
			pmt.setString(5, architect.getPhoneNumber());
			pmt.setString(6, architect.getAddress());
			pmt.setString(7, architect.getCoverPhoto());
			pmt.setString(8, architect.getEmail());
			pmt.setString(9, architect.getPassword());
			pmt.setString(10, architect.getEducation());
			pmt.setInt(11, architect.getExperience());
			pmt.setString(12, architect.getDegreeCertificate());
			pmt.setString(13, architect.getNATACertificate());

			int rows = pmt.executeUpdate();
			return rows == 1;
		}
	}

	// Method to check if a ARCHITECT with the given email exists in the database
	public boolean isEmailExists(String email) throws SQLException {
		String query = "SELECT * FROM ARCHITECT WHERE email = ?";
		try (Connection connection = getConnection(); PreparedStatement pmt = connection.prepareStatement(query)) {
			pmt.setString(1, email);
			ResultSet rs = pmt.executeQuery();
			return rs.next(); // If a row is found, the email exists
		}
	}

	public List<Architect> listArchitects() throws SQLException {
		List<Architect> architects = new ArrayList<>();
		String query = "SELECT * FROM ARCHITECT";
		try (Connection connection = getConnection(); PreparedStatement pmt = connection.prepareStatement(query);) {

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
				String NATACertificate = resultSet.getString("NATACertificate");

				Architect architect = new Architect(architectID, profilePhoto, name, gender, phoneNumber, address,
						coverPhoto, email, password, education, experience, degreeCertificate, NATACertificate);
				architects.add(architect);
			}

			resultSet.close();
			pmt.close();
			connection.close();

			return architects;
		}
	}

	// Update architect information based on email
	public boolean updateArchitect(Architect architect, String email) throws SQLException {
		String query = "UPDATE ARCHITECT SET profilePhoto=?, name=?, gender=?, phoneNumber=?, address=?, "
				+ "coverPhoto=?, education=?, experience=?, degreeCertificate=?, NATACertificate=? " + "WHERE email=?";
		try (Connection connection = getConnection(); PreparedStatement pmt = connection.prepareStatement(query);) {
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

			// Return successful or not
			pmt.close();
			connection.close();

			return rows == 1;
		}
	}

	// Delete architect based on architect ID
	public boolean deleteArchitect(int architectId) throws SQLException {
		String query = "UPDATE architect SET isDeleted = ? WHERE architectID = ?";

		try (Connection connection = getConnection(); PreparedStatement pmt = connection.prepareStatement(query)) {
			pmt.setBoolean(1, true); // Set isDeleted to true to mark the architect as deleted
			pmt.setInt(2, architectId);
			int rows = pmt.executeUpdate();
			return rows == 1;
		}
	}

}
