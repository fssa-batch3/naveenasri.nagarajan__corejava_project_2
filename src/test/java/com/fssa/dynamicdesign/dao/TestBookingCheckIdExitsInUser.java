package com.fssa.dynamicdesign.dao;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

 class TestBookingCheckIdExitsInUser {

    @Test
    void testCheckIdExistsForValidUserId() {
        BookingDAO bookingDao = new BookingDAO();
        int userId = 70; // Replace with a valid user ID in your test data.

        assertDoesNotThrow(() -> {
            boolean userExists = bookingDao.checkIdExistsInUser(userId);
            assertTrue(userExists, "User with a valid ID should exist.");
        }, "Exception occurred while checking for a valid user ID.");
    }

    @Test
    void testCheckIdDoesNotExistsForNonExistentUserId() {
        BookingDAO bookingDao = new BookingDAO();
        int userId = 999; // Replace with a non-existent user ID.

        assertDoesNotThrow(() -> {
            boolean userExists = bookingDao.checkIdExistsInUser(userId);
            assertFalse(userExists, "User with a non-existent ID should not exist.");
        }, "Exception occurred while checking for a non-existent user ID.");
    }

    @Test
    void testCheckIdExistsForNegativeUserId() {
        BookingDAO bookingDao = new BookingDAO();
        int userId = -1; // Replace with a negative user ID.

        assertDoesNotThrow(() -> {
            boolean userExists = bookingDao.checkIdExistsInUser(userId);
            assertFalse(userExists, "User with a negative ID should not exist.");
        }, "Exception occurred while checking for a negative user ID.");
    }
}

