package com.fssa.dynamicdesign.service;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class TestUpdateStatus {

	 @Test
	    void testUpdateStatusAcceptedSuccess() {
	        BookingService bookingService = new BookingService();
	        assertDoesNotThrow(() -> assertTrue(bookingService.updateBookingStatus(1, "Accepted")));
	    }
	 
	 
	 @Test
	    void testUpdateStatusRejectedSuccess() {
	        BookingService bookingService = new BookingService();
	        assertDoesNotThrow(() -> assertTrue(bookingService.updateBookingStatus(1, "Rejected")));
	    }

}
