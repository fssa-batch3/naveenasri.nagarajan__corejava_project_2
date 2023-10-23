package com.fssa.dynamicdesign.service;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import com.fssa.dynamicdesign.model.User;
import com.fssa.dynamicdesign.validation.exception.InvalidUserException;

class TestUserGetUserById {

    @Test
    void testGetUserByIdWithExistingId() {
        UserService userService = new UserService();
        int existingUserId = 1; // Replace with a valid user ID that exists in your test data.

        assertDoesNotThrow(() -> {
            User user = userService.getUserById(existingUserId);
            assertNotNull(user, "User with an existing ID should be found.");
        }, "Exception occurred while fetching a user with an existing ID.");
    }

    @Test
    void testGetUserByIdWithNonExistentId() {
        UserService userService = new UserService();
        int nonExistentUserId = 999; // Replace with a non-existent user ID.

        assertDoesNotThrow(() -> {
            User user = userService.getUserById(nonExistentUserId);
            assertNull(user, "User with a non-existent ID should not be found.");
        }, "Exception occurred while fetching a user with a non-existent ID.");
    }

    @Test
    void testGetUserByIdWithNegativeId() {
        UserService userService = new UserService();
        int negativeUserId = -1; // Replace with a negative user ID.

        assertThrows(InvalidUserException.class, () -> {
             userService.getUserById(negativeUserId);
        }, "Exception should occur for a negative user ID.");
    }

    @Test
    void testGetUserByIdWithZeroId() {
        UserService userService = new UserService();
        int zeroUserId = 0; // Replace with a zero user ID.

        assertThrows(InvalidUserException.class, () -> {
           userService.getUserById(zeroUserId);
        }, "Exception should occur for a zero user ID.");
    }
}
