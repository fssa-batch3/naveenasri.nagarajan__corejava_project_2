package com.fssa.dynamicdesign.service;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.fssa.dynamicdesign.model.Booking;
import com.fssa.dynamicdesign.service.exception.ServiceException;

class TestCreateBooking {

	@Test
	void testCreateBookingSuccess() {
		BookingService bookingService = new BookingService();
		Booking booking = new Booking();

		booking.setDesignName("Modern Living Room");
		booking.setDesignUrl("https://cdn.pixabay.com/photo/2016/04/18/13/53/room-1336497_1280.jpg");
		booking.setExpectedAmount(100);
		booking.setExpectedMonths(12);
		booking.setMessage(" I like this design can you please do this same design for me");
		booking.setUserId(70);
		booking.setArchitectId(79);

		try {
			assertTrue(bookingService.createBooking(booking));

		} catch (ServiceException e) {
			e.printStackTrace();
		}
		System.out.println("Design Added Successfully");
	}
	
	 @Test
	    void testCreateBookingSuccess1() {
			BookingService bookingService = new BookingService();

	        Booking booking = new Booking();
	        // Set up booking details
	        booking.setDesignName("Sample Design");
	        booking.setDesignUrl("http://example.com/sample.jpg");
	        booking.setExpectedAmount(1000);
	        booking.setExpectedMonths(6);
	        booking.setMessage("Test message");
	        booking.setUserId(1);
	        booking.setArchitectId(2);

	        try {
				assertTrue(bookingService.createBooking(booking));

			} catch (ServiceException e) {
				e.printStackTrace();
			}
			System.out.println("Booking should be created successfully.");
	    }

}
