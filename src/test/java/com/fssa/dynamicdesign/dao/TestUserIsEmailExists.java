package com.fssa.dynamicdesign.dao;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.fssa.dynamicdesign.dao.exception.DAOException;

class TestUserIsEmailExists {

    @Test
    void testIsEmailExistsWithExistingEmail() {
        UserDAO userdao = new UserDAO();
        String existingEmail = "user@example.com"; // Replace with an email that exists in your test data.

        assertDoesNotThrow(() -> {
            boolean emailExists = userdao.isEmailExists(existingEmail);
            assertTrue(emailExists, "Email should exist in the database.");
        }, "Exception occurred while checking for an existing email.");
    }

    @Test
    void testIsEmailExistsWithNonExistentEmail() {
        UserDAO userdao = new UserDAO();
        String nonExistentEmail = "nonexistent@example.com"; // Replace with a non-existent email.

        assertDoesNotThrow(() -> {
            boolean emailExists = userdao.isEmailExists(nonExistentEmail);
            assertFalse(emailExists, "Email should not exist in the database.");
        }, "Exception occurred while checking for a non-existent email.");
    }

    @Test
    void testIsEmailExistsWithInvalidEmail() {
        UserDAO userdao = new UserDAO();
        String invalidEmail = "invalidemail"; // Replace with an invalid email.

        assertThrows(DAOException.class, () -> {
        	userdao.isEmailExists(invalidEmail);
        }, "Exception should occur for an invalid email.");
    }
}

