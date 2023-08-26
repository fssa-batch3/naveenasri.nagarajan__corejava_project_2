package com.fssa.dynamicdesign.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.fssa.dynamicdesign.model.User;
import com.fssa.dynamicdesign.util.ConnectionUtil;

public class UserDAO {

    /**
     * Register a new user in the database.
     *
     * @param user The User object containing registration details.
     * @return true if registration is successful, false otherwise.
     * @throws SQLException if a database error occurs.
     */
    public boolean register(User user) throws SQLException {
        String query = "INSERT INTO USER (email, userName, password, phoneNumber, type) VALUES (?, ?, ?, ?, ?)";

        try (Connection connection = ConnectionUtil.getConnection();
             PreparedStatement pmt = connection.prepareStatement(query)) {
            // Set parameters for the prepared statement
            pmt.setString(1, user.getEmail());
            pmt.setString(2, user.getUsername());
            pmt.setString(3, user.getPassword());
            pmt.setString(4, user.getPhonenumber());
            pmt.setString(5, user.getType());

            int rows = pmt.executeUpdate();
            return rows == 1; // Return true if one row was affected (registration successful)
        }
    }

    /**
     * Check if a user with the given email exists in the database.
     *
     * @param email The email to check for existence.
     * @return true if the email exists, false otherwise.
     * @throws SQLException if a database error occurs.
     */
    public boolean isEmailExists(String email) throws SQLException {
        String query = "SELECT * FROM USER WHERE email = ?";
        try (Connection connection = ConnectionUtil.getConnection();
             PreparedStatement pmt = connection.prepareStatement(query)) {
            pmt.setString(1, email);
            ResultSet rs = pmt.executeQuery();
            return rs.next(); // Return true if a row is found (email exists in the database)
        }
    }

    /**
     * Authenticate the user with the provided email and password.
     *
     * @param user  The User object containing the provided email and password.
     * @param email The email of the user to be authenticated.
     * @return true if authentication is successful, false otherwise.
     * @throws SQLException if a database error occurs.
     */
    public boolean login(User user, String email) throws SQLException {
        String query = "SELECT * FROM USER WHERE email = ? AND password = ?";
        try (Connection connection = ConnectionUtil.getConnection();
             PreparedStatement pmt = connection.prepareStatement(query)) {
            pmt.setString(1, email); // Use provided email for the query
            pmt.setString(2, user.getPassword());
            try (ResultSet rs = pmt.executeQuery()) {
                return rs.next(); // Return true if a row is found (authentication successful)
            }
        }
    }

    /**
     * Update user information based on email.
     *
     * @param user The User object containing updated information.
     * @return true if update is successful, false otherwise.
     * @throws SQLException if a database error occurs.
     */
    public boolean updateUser(User user) throws SQLException {
        String query = "UPDATE USER SET username=?, phonenumber=? WHERE email=?";
        try (Connection connection = ConnectionUtil.getConnection();
             PreparedStatement pmt = connection.prepareStatement(query)) {
            pmt.setString(1, user.getUsername());
            pmt.setString(2, user.getPhonenumber());
            pmt.setString(3, user.getEmail());
            int rows = pmt.executeUpdate();
            return rows == 1; // Return true if one row was affected (update successful)
        }
    }

    /**
     * Delete user based on email.
     *
     * @param email The email of the user to be deleted.
     * @return true if deletion is successful, false otherwise.
     * @throws SQLException if a database error occurs.
     */
    public boolean deleteUser(String email) throws SQLException {
        String query = "UPDATE USER SET isDeleted = ? WHERE email = ?";
        try (Connection connection = ConnectionUtil.getConnection();
             PreparedStatement pmt = connection.prepareStatement(query)) {
            pmt.setBoolean(1, true); // Set isDeleted to true to mark the user as deleted
            pmt.setString(2, email);
            int rows = pmt.executeUpdate();
            return rows == 1; // Return true if one row was affected (deletion successful)
        }
    }
}
