package com.fssa.dynamicdesign.dao;

import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fssa.dynamicdesign.dao.exception.DAOException;
import com.fssa.dynamicdesign.model.Architect;
import com.fssa.dynamicdesign.util.ConnectionUtil;

public class ArchitectDAO {

	/**
	 * Register Architect DAO method
	 *
	 * @param architect Architect object containing registration details
	 * @return true if registration is successful, false otherwise
	 * @throws SQLException if a database error occurs
	 */
	public boolean arcRegister(Architect architect) throws SQLException {

		String query = "INSERT INTO architect ( profile_photo, name, gender, phone_number, address, cover_photo, email, password, education, experience, degree_certificate, nata_certificate) "
				+ "VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement pmt = connection.prepareStatement(query)) {

			// Set parameters for the prepared statement
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

			// Return true if one row was affected (registration successful)
			return rows == 1;
		}
	}

	/**
	 * Check if an ARCHITECT with the given email exists in the database
	 *
	 * @param email Email to check for existence
	 * @return true if the email exists, false otherwise
	 * @throws SQLException if a database error occurs
	 */
	public boolean isEmailExists(String email) throws SQLException {
		String query = "SELECT * FROM ARCHITECT WHERE email = ?";
		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement pmt = connection.prepareStatement(query)) {

			// Set the email parameter for the prepared statement
			pmt.setString(1, email);
			ResultSet rs = pmt.executeQuery();

			// If a row is found, the email exists
			return rs.next();
		}
	}
	


	/**
	 * Authenticate an architect based on email and password
	 *
	 * @param architect Architect object containing email and password for
	 *                  authentication
	 * @param email     Email of the architect to be authenticated
	 * @return true if authentication is successful, false otherwise
	 * @throws SQLException if a database error occurs
	 */
	public boolean login(Architect architect, String email) throws SQLException {
		String query = "SELECT * FROM ARCHITECT WHERE email = ? AND password = ?";
		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement pmt = connection.prepareStatement(query)) {

			// Set parameters for the prepared statement
			pmt.setString(1, email); // Use provided email for the query
			pmt.setString(2, architect.getPassword());

			try (ResultSet rs = pmt.executeQuery()) {
				return rs.next(); // If a row is found, authentication is successful
			}
		}
	}

	/**
	 * Retrieve a list of all architects from the database
	 *
	 * @return List of Architect objects representing all architects in the database
	 * @throws SQLException if a database error occurs
	 */
	public List<Architect> listArchitects() throws SQLException {
		List<Architect> architects = new ArrayList<>();
		String query = "SELECT * FROM ARCHITECT WHERE is_deleted = 0";
		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement pmt = connection.prepareStatement(query)) {

			ResultSet resultSet = pmt.executeQuery();

			while (resultSet.next()) {

				// Retrieve architect details from the result set
				Architect architect = new Architect();
				architect.setArchitectID(resultSet.getInt("architect_id"));
				architect.setProfilePhoto(resultSet.getString("profile_photo"));
				architect.setName(resultSet.getString("name"));
				architect.setGender(resultSet.getString("gender"));
				architect.setPhoneNumber(resultSet.getString("phone_number"));
				architect.setAddress(resultSet.getString("address"));
				architect.setCoverPhoto(resultSet.getString("cover_photo"));
				architect.setEmail(resultSet.getString("email"));
				architect.setPassword(resultSet.getString("password"));
				architect.setEducation(resultSet.getString("education"));
				architect.setExperience(resultSet.getInt("experience"));
				architect.setDegreeCertificate(resultSet.getString("degree_certificate"));
				architect.setNATACertificate(resultSet.getString("nata_certificate"));

				// Create and add Architect object to the list

				architects.add(architect);
			}

			resultSet.close();

			return architects;
		}
	}

	/**
	 * Update architect information based on email
	 *
	 * @param architect Updated Architect object with new details
	 * @param email     Email of the architect to be updated
	 * @return true if update is successful, false otherwise
	 * @throws SQLException if a database error occurs
	 */
	public boolean updateArchitect(Architect architect, String email) throws SQLException {
		String query = "UPDATE ARCHITECT SET profile_photo=?, name=?, gender=?, phone_number=?, address=?, "
				+ "cover_photo=?, education=?, experience=?, degree_certificate=?, nata_certificate=? "
				+ "WHERE email=?";
		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement pmt = connection.prepareStatement(query)) {

			// Set parameters for the prepared statement
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

	/**
	 * Delete architect based on architect's email
	 *
	 * @param email Email of the architect to be deleted
	 * @return true if deletion is successful, false otherwise
	 * @throws SQLException if a database error occurs
	 */
	public boolean deleteArchitect(String email) throws SQLException {

		String query = "UPDATE architect SET is_deleted = ? WHERE email = ?";

		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement pmt = connection.prepareStatement(query)) {

			// Set parameters for the prepared statement
			pmt.setBoolean(1, true); // Set isDeleted to true to mark the architect as deleted
			pmt.setString(2, email);

			int rows = pmt.executeUpdate();

			return rows == 1; // Return true if one row was affected (deletion successful)
		}
	}

	/**
	 * Get an architect by their email address.
	 *
	 * @param email The email address of the architect to retrieve.
	 * @return The Architect object if found, or null if not found.
	 * @throws DAOException If a database error occurs.
	 */
	public Architect getArchitectByEmail(String email) throws DAOException {
		String query = "SELECT * FROM architect WHERE email = ?";
		Architect architect = new Architect();

		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			preparedStatement.setString(1, email);
			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				// Create an Architect object with the retrieved data
				architect.setArchitectID(resultSet.getInt("architect_id"));
				architect.setName(resultSet.getString("name"));
				architect.setGender(resultSet.getString("gender"));
				architect.setPhoneNumber(resultSet.getString("phone_number"));
				architect.setAddress(resultSet.getString("address"));
				architect.setProfilePhoto(resultSet.getString("profile_photo"));
				architect.setCoverPhoto(resultSet.getString("cover_photo"));
				architect.setEmail(resultSet.getString("email"));
				architect.setPassword(resultSet.getString("password"));
				architect.setEducation(resultSet.getString("education"));
				architect.setExperience(resultSet.getInt("experience"));
				architect.setDegreeCertificate(resultSet.getString("degree_certificate"));
				architect.setNATACertificate(resultSet.getString("nata_certificate"));
			}
		} catch (SQLException e) {
			throw new DAOException("Error fetching architect by email: " + e.getMessage());
		}

		return architect;
	}

	/**
	 * Get an architect by their ID.
	 *
	 * @param architectId The ID of the architect to retrieve.
	 * @return The Architect object if found, or null if not found.
	 * @throws DAOException If a database error occurs.
	 */
	public Architect getArchitectById(int architectId) throws DAOException {
		String query = "SELECT * FROM architect WHERE architect_id = ?";
		Architect architect = null;

		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			preparedStatement.setInt(1, architectId);
			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				architect = new Architect();
				// Populate the Architect object with the retrieved data
				architect.setArchitectID(resultSet.getInt("architect_id"));
				architect.setName(resultSet.getString("name"));
				architect.setGender(resultSet.getString("gender"));
				architect.setPhoneNumber(resultSet.getString("phone_number"));
				architect.setAddress(resultSet.getString("address"));
				architect.setProfilePhoto(resultSet.getString("profile_photo"));
				architect.setCoverPhoto(resultSet.getString("cover_photo"));
				architect.setEmail(resultSet.getString("email"));
				architect.setPassword(resultSet.getString("password"));
				architect.setEducation(resultSet.getString("education"));
				architect.setExperience(resultSet.getInt("experience"));
				architect.setDegreeCertificate(resultSet.getString("degree_certificate"));
				architect.setNATACertificate(resultSet.getString("nata_certificate"));
			}
		} catch (SQLException e) {
			throw new DAOException("Error fetching architect by ID: " + e.getMessage());
		}

		return architect;

	}

	
}