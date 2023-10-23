package com.fssa.dynamicdesign.service;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class TestBookingUpdateStatus {

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

    @Test
    void testUpdateStatusPendingSuccess() {
        BookingService bookingService = new BookingService();
        assertDoesNotThrow(() -> assertTrue(bookingService.updateBookingStatus(1, "Pending")));
    }

    @Test
    void testUpdateStatusInvalidStatus() {
        BookingService bookingService = new BookingService();
        assertThrows(IllegalArgumentException.class, () -> {
            bookingService.updateBookingStatus(1, "InvalidStatus");
        });
    }

}
