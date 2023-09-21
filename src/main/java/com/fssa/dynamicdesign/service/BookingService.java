package com.fssa.dynamicdesign.service;

import java.util.List;

import com.fssa.dynamicdesign.dao.BookingDAO;
import com.fssa.dynamicdesign.dao.exception.DAOException;
import com.fssa.dynamicdesign.model.Booking;
import com.fssa.dynamicdesign.service.exception.ServiceException;
import com.fssa.dynamicdesign.validation.BookingValidator;
import com.fssa.dynamicdesign.validation.exception.InvalidBookingException;

public class BookingService {

	public boolean createBooking(Booking booking) throws ServiceException {
		BookingDAO bookingDAO = new BookingDAO();
		try {
			// Check if the booking is null
			if (booking == null) {
				throw new InvalidBookingException("Booking is null create updating");
			}

			// Validate the booking using the BookingValidator
			 BookingValidator.validateBooking(booking);

			// Check if the user ID exists before creating the design
			if (!bookingDAO.checkIdExistsInUser(booking.getUserId())) {
				throw new ServiceException("User with ID " + booking.getUserId() + " does not exist.");
			}

			// Check if the architect ID exists before creating the design
			if (!bookingDAO.checkIdExistsInArchitect(booking.getArchitectId())) {
				throw new ServiceException("Architect with ID " + booking.getArchitectId() + " does not exist.");
			}

			return bookingDAO.createBooking(booking);
		} catch (InvalidBookingException | DAOException e) {
			throw new ServiceException(e);
		}
	}

	/**
	 * Retrieves a list of bookings for a given user ID.
	 *
	 * @param userId The ID of the user for whom to retrieve bookings.
	 * @return A list of bookings for the specified user ID.
	 * @throws ServiceException if an error occurs while retrieving the bookings.
	 */
	public List<Booking> listBookingsByUserId(int userId) throws ServiceException {
		BookingDAO bookingDAO = new BookingDAO();

		try {
			return bookingDAO.listBookingsByUserId(userId);
		} catch (DAOException e) {
			throw new ServiceException("Error while retrieving bookings by user ID");
		}
	}

	/**
	 * Retrieves a list of bookings for a given architect ID.
	 *
	 * @param architectId The ID of the architect for whom to retrieve bookings.
	 * @return A list of bookings for the specified architect ID.
	 * @throws ServiceException if an error occurs while retrieving the bookings.
	 */
	public List<Booking> listBookingsByArchitectId(int architectId) throws ServiceException {
		BookingDAO bookingDAO = new BookingDAO();

		try {
			return bookingDAO.listBookingsByArchitectId(architectId);
		} catch (DAOException e) {
			throw new ServiceException("Error while retrieving bookings by architect ID");
		}
	}

	public boolean updateBookingStatus(int bookingId, String newStatus) throws ServiceException {
		BookingDAO bookingDAO = new BookingDAO();

		try {
			BookingValidator.validateStatus(newStatus);

			return bookingDAO.updateBookingStatus(bookingId, newStatus);
		} catch (InvalidBookingException | DAOException e) {
			throw new ServiceException("Error updating booking status: " + e.getMessage());
		}
	}

}
