package com.fssa.dynamicdesign.service;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.fssa.dynamicdesign.model.Booking;

class TestBookingListByArchitectId {
    
    @Test
    void testListBookingsByArchitectIdNotEmptyTrue() {
        BookingService bookingService = new BookingService();
        int architectId = 79; // Replace with a valid architect ID in your test data.

        assertDoesNotThrow(() -> {
            List<Booking> bookings = bookingService.listBookingsByArchitectId(architectId);
            assertNotNull(bookings, "List of bookings is null.");
            assertTrue(!bookings.isEmpty(), "List of bookings is empty.");
        }, "Exception occurred while fetching bookings for the Architect from the database.");
    }

    @Test
    void testListBookingsByArchitectIdWithNoBookings()  {
        BookingService bookingService = new BookingService();
        int architectId = 80; // Replace with a valid architect ID with no bookings in your test data.

        assertDoesNotThrow(() -> {
            List<Booking> bookings = bookingService.listBookingsByArchitectId(architectId);
            assertNotNull(bookings, "List of bookings is null.");
            assertTrue(bookings.isEmpty(), "List of bookings is not empty.");
        }, "Exception occurred while fetching bookings for the Architect from the database.");
    }
    

	@Test
    void testListBookingsByArchitectIdWithNullResult() {
        BookingService bookingService = new BookingService();
        int architectId = 81; // Replace with a valid architect ID with no bookings in your test data.

        assertDoesNotThrow(() -> {
            List<Booking> bookings = bookingService.listBookingsByArchitectId(architectId);
            assertNull(bookings, "List of bookings should be null.");
        }, "Exception occurred while fetching bookings for the Architect from the database.");
    }
    
    @Test
    void testListBookingsByArchitectIdWithSpecificBooking() {
        BookingService bookingService = new BookingService();
        int architectId = 79; // Replace with a valid architect ID in your test data.
        String expectedDesignName = "Modern Living Room"; // Replace with a specific design name in your test data.

        assertDoesNotThrow(() -> {
            List<Booking> bookings = bookingService.listBookingsByArchitectId(architectId);
            assertNotNull(bookings, "List of bookings is null.");
            assertTrue(!bookings.isEmpty(), "List of bookings is empty.");
            boolean found = false;
            for (Booking booking : bookings) {
                if (expectedDesignName.equals(booking.getDesignName())) {
                    found = true;
                    break;
                }
            }
            assertTrue(found, "Expected booking not found.");
        }, "Exception occurred while fetching bookings for the Architect from the database.");
    }
}
