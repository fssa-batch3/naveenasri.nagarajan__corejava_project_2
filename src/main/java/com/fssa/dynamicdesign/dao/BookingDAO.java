package com.fssa.dynamicdesign.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fssa.dynamicdesign.dao.exception.DAOException;
import com.fssa.dynamicdesign.model.Booking;
import com.fssa.dynamicdesign.util.ConnectionUtil;

public class BookingDAO {

    public static final String CREATE_BOOKING = "INSERT INTO booking (design_name, design_url, expected_amount, expected_months, message, user_id, architect_id) VALUES (?, ?, ?, ?, ?, ?, ?)";
    public static final String CHECK_ID_EXISTS_IN_USER = "SELECT * FROM user WHERE user_id=? AND is_deleted = 0";
    public static final String CHECK_ID_EXISTS_IN_ARCHITECT = "SELECT * FROM architect WHERE architect_id=? AND is_deleted = 0";
    public static final String LIST_BOOKINGS_BY_USER_ID = "SELECT * FROM booking WHERE user_id=?";
    public static final String LIST_BOOKINGS_BY_ARCHITECT_ID = "SELECT * FROM booking WHERE architect_id = ?";
    public static final String UPDATE_BOOKING_STATUS = "UPDATE booking SET status = ? WHERE booking_id = ?";

    
    public boolean createBooking(Booking booking) throws DAOException {
    	 try (Connection connection = ConnectionUtil.getConnection();
    	         PreparedStatement pmt = connection.prepareStatement(CREATE_BOOKING)) {
    		 
    		 pmt.setString(1, booking.getDesignName());
    		 pmt.setString(2, booking.getDesignUrl());
    		 pmt.setInt(3, booking.getExpectedAmount());
    		 pmt.setInt(4, booking.getExpectedMonths());
    		 pmt.setString(5, booking.getMessage());
    		 pmt.setInt(6, booking.getUserId());
    		 pmt.setInt(7, booking.getArchitectId());

    		 

 	        int rows = pmt.executeUpdate();
 	        return rows == 1; 
 	        
 	    } catch (SQLException e) {
 	        throw new DAOException("Error while booking the architect: " + e.getMessage());
 	    }
    	 
    }
    
    
    /**
     * Check if a user with the given ID exists in the database.
     *
     * @param userId The ID of the user to check
     * @return true if the user exists, false otherwise
     * @throws DAOException if a database error occurs
     */
    public boolean checkIdExistsInUser(int userId) throws DAOException {
        try (Connection connection = ConnectionUtil.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(CHECK_ID_EXISTS_IN_USER)) {
            pstmt.setInt(1, userId);
            ResultSet resultSet = pstmt.executeQuery();
            return resultSet.next();
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    /**
     * Check if an architect with the given ID exists in the database.
     *
     * @param architectId The ID of the architect to check
     * @return true if the architect exists, false otherwise
     * @throws DAOException if a database error occurs
     */
    public boolean checkIdExistsInArchitect(int architectId) throws DAOException {
        try (Connection connection = ConnectionUtil.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(CHECK_ID_EXISTS_IN_ARCHITECT)) {
            pstmt.setInt(1, architectId);
            ResultSet resultSet = pstmt.executeQuery();
            return resultSet.next();
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    
    /**
     * Retrieves a list of bookings for a given user ID.
     *
     * @param userId The ID of the user for whom to retrieve bookings.
     * @return A list of bookings for the specified user ID.
     * @throws DAOException if an error occurs while retrieving the bookings.
     */
    public List<Booking> listBookingsByUserId(int userId) throws DAOException {
        List<Booking> bookings = new ArrayList<>();

        try (Connection connection = ConnectionUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(LIST_BOOKINGS_BY_USER_ID)) {

            preparedStatement.setInt(1, userId);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Booking booking = new Booking();
                booking.setBookingId(resultSet.getInt("booking_id"));
                booking.setDesignName(resultSet.getString("design_name"));
                booking.setDesignUrl(resultSet.getString("design_url"));
                booking.setExpectedAmount(resultSet.getInt("expected_amount"));
                booking.setExpectedMonths(resultSet.getInt("expected_months"));
                booking.setMessage(resultSet.getString("message"));
                booking.setUserId(resultSet.getInt("user_id"));
                booking.setArchitectId(resultSet.getInt("architect_id"));
                booking.setStatus(resultSet.getString("status"));
                
              bookings.add(booking);
            }

            return bookings;
        } catch (SQLException e) {
            throw new DAOException("Error while retrieving bookings by user ID");
        }
    }
    
    
    /**
     * Retrieves a list of bookings for a given architect ID.
     *
     * @param architectId The ID of the architect for whom to retrieve bookings.
     * @return A list of bookings for the specified architect ID.
     * @throws DAOException if an error occurs while retrieving the bookings.
     */
    public List<Booking> listBookingsByArchitectId(int architectId) throws DAOException {
        List<Booking> bookings = new ArrayList<>();

        try (Connection connection = ConnectionUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(LIST_BOOKINGS_BY_ARCHITECT_ID)) {

            preparedStatement.setInt(1, architectId);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Booking booking = new Booking();
                booking.setBookingId(resultSet.getInt("booking_id"));
                booking.setDesignName(resultSet.getString("design_name"));
                booking.setDesignUrl(resultSet.getString("design_url"));
                booking.setExpectedAmount(resultSet.getInt("expected_amount"));
                booking.setExpectedMonths(resultSet.getInt("expected_months"));
                booking.setMessage(resultSet.getString("message"));
                booking.setUserId(resultSet.getInt("user_id"));
                booking.setArchitectId(resultSet.getInt("architect_id"));
                booking.setStatus(resultSet.getString("status")); 

                bookings.add(booking);
            }

            return bookings;
        } catch (SQLException e) {
            throw new DAOException("Error while retrieving bookings by architect ID");
        }
    }

    public boolean updateBookingStatus(int bookingId, String newStatus) throws DAOException {

        try (Connection connection = ConnectionUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_BOOKING_STATUS)) {

            preparedStatement.setString(1, newStatus);
            preparedStatement.setInt(2, bookingId);

            int rowsUpdated = preparedStatement.executeUpdate();

            return rowsUpdated > 0; // Returns true if at least one row was updated
        } catch (SQLException e) {
            throw new DAOException("Error updating booking status: " + e.getMessage());
        }
    }

}
