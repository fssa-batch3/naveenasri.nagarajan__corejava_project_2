package com.fssa.dynamicdesign.dao;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.fssa.dynamicdesign.dao.exception.DAOException;

class TestArchitectIsEmailExists {

    @Test
    void testIsEmailExistsWithExistingEmail() {
        ArchitectDAO architectDAO = new ArchitectDAO();
        String existingEmail = "architect@example.com"; // Replace with an email that exists in your test data.

        assertDoesNotThrow(() -> {
            boolean emailExists = architectDAO.isEmailExists(existingEmail);
            assertTrue(emailExists, "Email should exist in the database.");
        }, "Exception occurred while checking for an existing email.");
    }

    @Test
    void testIsEmailExistsWithNonExistentEmail() {
        ArchitectDAO architectDAO = new ArchitectDAO();
        String nonExistentEmail = "nonexistent@example.com"; // Replace with a non-existent email.

        assertDoesNotThrow(() -> {
            boolean emailExists = architectDAO.isEmailExists(nonExistentEmail);
            assertFalse(emailExists, "Email should not exist in the database.");
        }, "Exception occurred while checking for a non-existent email.");
    }

    @Test
    void testIsEmailExistsWithInvalidEmail() {
        ArchitectDAO architectDAO = new ArchitectDAO();
        String invalidEmail = "invalidemail"; // Replace with an invalid email.

        assertThrows(DAOException.class, () -> {
            architectDAO.isEmailExists(invalidEmail);
        }, "Exception should occur for an invalid email.");
    }
}
