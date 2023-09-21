package com.fssa.dynamicdesign.service;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.fssa.dynamicdesign.model.Booking;

class TestListBookingByArchitectId {
	 @Test
	     void testListBookingsByArchitectIdNotEmptyTrue() {
		 BookingService bookingService = new BookingService();
	        int architectId = 79; // Replace with a valid user ID in your test data.

	        assertDoesNotThrow(() -> {
	            List<Booking> bookings = bookingService.listBookingsByArchitectId(architectId);
	            assertNotNull(bookings, "List of bookings is null.");
	            assertTrue(!bookings.isEmpty(), "List of bookings is empty.");
	        }, "Exception occurred while fetching bookings for the Architect from the database.");
	    }
	 
	
	 
	 @Test
	     void testListBookingsByArchitectIdWithNoBookings()  {
		 BookingService bookingService = new BookingService();
	        int architectId = 80; // Replace with a valid user ID with no bookings in your test data.

	        assertDoesNotThrow(() -> {
	            List<Booking> bookings = bookingService.listBookingsByArchitectId(architectId);
	            assertNotNull(bookings, "List of bookings is null.");
	            assertTrue(bookings.isEmpty(), "List of bookings is not empty.");
	        }, "Exception occurred while fetching bookings for the Architect from the database.");
	    }
}
