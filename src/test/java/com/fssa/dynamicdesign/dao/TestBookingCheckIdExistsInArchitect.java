package com.fssa.dynamicdesign.dao;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

 class TestBookingCheckIdExistsInArchitect {

    @Test
    void testCheckIdExistsForValidArchitectId() {
        BookingDAO bookingDao = new BookingDAO();
        int architectId = 79; // Replace with a valid architect ID in your test data.

        assertDoesNotThrow(() -> {
            boolean architectExists = bookingDao.checkIdExistsInArchitect(architectId);
            assertTrue(architectExists, "Architect with a valid ID should exist.");
        }, "Exception occurred while checking for a valid architect ID.");
    }

    @Test
    void testCheckIdDoesNotExistsForNonExistentArchitectId() {
        BookingDAO bookingDao = new BookingDAO();
        int architectId = 999; // Replace with a non-existent architect ID.

        assertDoesNotThrow(() -> {
            boolean architectExists = bookingDao.checkIdExistsInArchitect(architectId);
            assertFalse(architectExists, "Architect with a non-existent ID should not exist.");
        }, "Exception occurred while checking for a non-existent architect ID.");
    }

    @Test
    void testCheckIdExistsForNegativeArchitectId() {
        BookingDAO bookingDao = new BookingDAO();
        int architectId = -1; // Replace with a negative architect ID.

        assertDoesNotThrow(() -> {
            boolean architectExists = bookingDao.checkIdExistsInArchitect(architectId);
            assertFalse(architectExists, "Architect with a negative ID should not exist.");
        }, "Exception occurred while checking for a negative architect ID.");
    }
}

