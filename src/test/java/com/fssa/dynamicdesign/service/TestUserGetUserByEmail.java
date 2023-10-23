package com.fssa.dynamicdesign.service;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import com.fssa.dynamicdesign.model.User;
import com.fssa.dynamicdesign.validation.exception.InvalidUserException;

 class TestUserGetUserByEmail {

    @Test
    void testGetUserByEmailWithExistingEmail() {
        UserService userService = new UserService();
        String existingEmail = "user@example.com"; // Replace with an email that exists in your test data.

        assertDoesNotThrow(() -> {
            User user = userService.getUserByEmail(existingEmail);
            assertNotNull(user, "User with an existing email should be found.");
        }, "Exception occurred while fetching a user with an existing email.");
    }

    @Test
    void testGetUserByEmailWithNonExistentEmail() {
        UserService userService = new UserService();
        String nonExistentEmail = "nonexistent@example.com"; // Replace with a non-existent email.

        assertDoesNotThrow(() -> {
            User user = userService.getUserByEmail(nonExistentEmail);
            assertNull(user, "User with a non-existent email should not be found.");
        }, "Exception occurred while fetching a user with a non-existent email.");
    }

    @Test
    void testGetUserByEmailWithInvalidEmail() {
        UserService userService = new UserService();
        String invalidEmail = "invalidemail"; // Replace with an invalid email.

        assertThrows(InvalidUserException.class, () -> {
            userService.getUserByEmail(invalidEmail);
        }, "Exception should occur for an invalid email.");
    }
}
