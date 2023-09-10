package com.fssa.dynamicdesign.service;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.fssa.dynamicdesign.service.exception.ServiceException;

class TestUserDeleteFeature {

    @Test
    void testDeleteUserSuccess() {
        UserService userService = new UserService();
        // Assuming a user with the email "babu@gmail.com" exists in the database
        String emailToDelete = "keshavnesh@gmail.com";
        assertDoesNotThrow(() -> {
            boolean isDeleted = userService.deleteUser(emailToDelete);
            assertTrue(isDeleted, "User deletion failed.");
        });
    }

    @Test
    void testDeleteNonExistingUser() {
        UserService userService = new UserService();
        // Assuming a user with the email "nonexisting@example.com" does not exist in
        // the database
        String emailToDelete = "nonexisting@example.com";
        assertThrows(ServiceException.class, () -> userService.deleteUser(emailToDelete));
    }

    @Test
    void testDeleteUserWithInvalidUserEmail() {
        UserService userService = new UserService();
        String emailToDelete = "babugmail.com";
        assertThrows(ServiceException.class, () -> userService.deleteUser(emailToDelete));
    }
}
