package com.fssa.dynamicdesign.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.fssa.dynamicdesign.dao.exception.DAOException;
import com.fssa.dynamicdesign.model.User;
import com.fssa.dynamicdesign.service.exception.ServiceException;
import com.fssa.dynamicdesign.util.ConnectionUtil;
import com.fssa.dynamicdesign.util.PasswordUtil;

public class UserDAO {

	/**
	 * Registers a new user in the database.
	 *
	 * @param user The User object containing registration details.
	 * @return true if registration is successful, false otherwise.
	 * @throws DAOException if a database error occurs.
	 */
	public boolean register(User user) throws DAOException {
	    String query = "INSERT INTO USER (email, user_name, password, phone_number, type , salt) VALUES (?, ?, ?, ?, ?, ?)";

	    try (Connection connection = ConnectionUtil.getConnection();
	         PreparedStatement pmt = connection.prepareStatement(query)) { 
	        // Set parameters for the prepared statement
	        pmt.setString(1, user.getEmail());
	        pmt.setString(2, user.getUsername());
	        pmt.setString(3, user.getPassword());
	        pmt.setString(4, user.getPhonenumber()); // corrected method name to getPhoneNumber
	        pmt.setString(5, user.getType());
	        pmt.setString(6, user.getSalt());
	        
	        int rows = pmt.executeUpdate(); 
	        return rows == 1; // Return true if one row was affected (registration successful)
	    } catch (SQLException e) {
	        throw new DAOException("Error while registering the user: " + e.getMessage());
	    }
	}

	/**
	 * Authenticates the user with the provided email and password.
	 *
	 * @param user  The User object representing the user to be authenticated.
	 * @param email The email of the user to be authenticated.
	 * @return true if authentication is successful, false otherwise.
	 * @throws DAOException if a database error occurs.
	 */
	public boolean login(User user, String email) throws DAOException {
	  //  String query = "SELECT * FROM USER WHERE email = ? AND password = ? AND is_deleted = 0";
	    String query = "SELECT * FROM USER WHERE email = ? AND is_deleted = 0";

	    try (Connection connection = ConnectionUtil.getConnection();
	         PreparedStatement pstmt = connection.prepareStatement(query)) {
	        pstmt.setString(1, email); // Use the provided email for the query
//	        pstmt.setString(2, user.getPassword());
	      
	        try (ResultSet rs = pstmt.executeQuery()) {
	        	if(rs.next()) {
	        		String password = rs.getString("password");
	        		String salt = rs.getString("salt");
	        		if(PasswordUtil.verifyPassword(user.getPassword(), salt, password)) {
	        			return true;
	        		}else {
	        	        throw new DAOException("Incorrect Email or Password");
	        		}
	        	}
	        	
	         //   return rs.next(); // Return true if a row is found (authentication successful)
	            return false;
	        }
	    } catch (Exception e) {
	        throw new DAOException("Error while authenticating the user: " + e.getMessage());
	    }
	}


	/**
	 * Updates user information based on email.
	 *
	 * @param user The User object containing the updated information.
	 * @return true if the update is successful, false otherwise.
	 * @throws DAOException if a database error occurs.
	 */
	public boolean updateUser(User user) throws DAOException {
	    String query = "UPDATE USER SET user_name=?, phone_number=? WHERE email=? AND is_deleted = 0";
	    try (Connection connection = ConnectionUtil.getConnection();
	         PreparedStatement pstmt = connection.prepareStatement(query)) {
	        pstmt.setString(1, user.getUsername());
	        pstmt.setString(2, user.getPhonenumber());
	        pstmt.setString(3, user.getEmail());
	        int rows = pstmt.executeUpdate();
	        return rows == 1; // Return true if one row was affected (update successful)
	    } catch (SQLException e) {
	        throw new DAOException("Error while updating user information: " + e.getMessage());
	    }
	}

	
	/**
	 * Checks if a user with the given email exists in the database.
	 *
	 * @param email The email to check for existence.
	 * @return true if the email exists, false otherwise.
	 * @throws DAOException if a database error occurs.
	 */
	public boolean isEmailExists(String email) throws DAOException {
	    String query = "SELECT * FROM USER WHERE email = ? AND is_deleted = 0";
	    try (Connection connection = ConnectionUtil.getConnection();
	         PreparedStatement pstmt = connection.prepareStatement(query)) {
	        pstmt.setString(1, email);
	        ResultSet rs = pstmt.executeQuery();
	        return rs.next(); // Returns true if a row is found (email exists in the database)
	    } catch (SQLException e) {
	        throw new DAOException("Error while checking if the email exists for the user: " + e.getMessage());
	    }
	}
	


	/**
	 * Deletes a user based on email by marking them as deleted in the database.
	 *
	 * @param email The email of the user to be deleted.
	 * @return true if the deletion is successful, false otherwise.
	 * @throws DAOException if a database error occurs.
	 */
	public boolean deleteUser(String email) throws DAOException {
	    String query = "UPDATE USER SET is_deleted = ? WHERE email = ? AND is_deleted = 0";
	    try (Connection connection = ConnectionUtil.getConnection();
	         PreparedStatement pstmt = connection.prepareStatement(query)) {
	        pstmt.setBoolean(1, true); // Set isDeleted to true to mark the user as deleted
	        pstmt.setString(2, email);
	        int rows = pstmt.executeUpdate();
	        return rows == 1; // Return true if one row was affected (deletion successful)
	    } catch (SQLException e) {
	        throw new DAOException("Error while deleting the user: " + e.getMessage());
	    }
	}

    
    /**
     * Get a user by their email address.
     *
     * @param email The email address of the user to retrieve.
     * @return The User object if found, or null if not found.
     * @throws ServiceException If a database error occurs.
     */
    public User getUserByEmail(String email) throws DAOException {
        String query = "SELECT * FROM user WHERE email = ? AND is_deleted = 0";
        User user = new User();

        try (Connection connection = ConnectionUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                user.setUserId(resultSet.getInt("user_id"));
                user.setEmail(resultSet.getString("email"));
                user.setUsername(resultSet.getString("user_name"));
                user.setPassword(resultSet.getString("password"));
                user.setPhonenumber(resultSet.getString("phone_number"));
                user.setType(resultSet.getString("type"));
            }
        } catch (SQLException e) {
            throw new DAOException("Error fetching user by email: " + e.getMessage());
        }

        return user;
    }
    
    
    public User getUserById(int userid) throws DAOException {
        String query = "SELECT * FROM user WHERE user_id = ? AND is_deleted = 0";
        User user = new User();

        try (Connection connection = ConnectionUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, userid);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                // Create a User object with the retrieved data
                user.setUserId(resultSet.getInt("user_id"));
                user.setUsername(resultSet.getString("user_name"));
                user.setEmail(resultSet.getString("email"));
                user.setPhonenumber(resultSet.getString("phone_number"));
                user.setType(resultSet.getString("type"));
            }
        } catch (SQLException e) {
            throw new DAOException("Error fetching user by Id: " + e.getMessage());
        }

        return user;
    }
    
    
  
}
