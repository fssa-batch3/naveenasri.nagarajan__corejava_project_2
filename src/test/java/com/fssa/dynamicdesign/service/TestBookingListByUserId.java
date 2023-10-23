package com.fssa.dynamicdesign.service;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.fssa.dynamicdesign.model.Booking;

 class TestBookingListByUserId {

    @Test
    void testListBookingsByUserIdNotEmptyTrue() {
        BookingService bookingService = new BookingService();
        int userId = 70; // Replace with a valid user ID in your test data.

        assertDoesNotThrow(() -> {
            List<Booking> bookings = bookingService.listBookingsByUserId(userId);
            assertNotNull(bookings, "List of bookings is null.");
            assertTrue(!bookings.isEmpty(), "List of bookings is empty.");
        }, "Exception occurred while fetching bookings for the user from the database.");
    }

    @Test
    void testListBookingsByUserIdWithNoBookings() {
        BookingService bookingService = new BookingService();
        int userId = 69; // Replace with a valid user ID with no bookings in your test data.

        assertDoesNotThrow(() -> {
            List<Booking> bookings = bookingService.listBookingsByUserId(userId);
            assertNotNull(bookings, "List of bookings is null.");
            assertTrue(bookings.isEmpty(), "List of bookings is not empty.");
        }, "Exception occurred while fetching bookings for the user from the database.");
    }

    @Test
    void testListBookingsByInvalidUserId() {
        BookingService bookingService = new BookingService();
        int userId = -1; // Replace with an invalid (non-existent) user ID.

        assertDoesNotThrow(() -> {
            List<Booking> bookings = bookingService.listBookingsByUserId(userId);
            assertNotNull(bookings, "List of bookings is null.");
            assertTrue(bookings.isEmpty(), "List of bookings is not empty for an invalid user.");
        }, "Exception occurred while fetching bookings for an invalid user from the database.");
    }

  
}
