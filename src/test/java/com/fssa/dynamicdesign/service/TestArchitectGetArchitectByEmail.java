package com.fssa.dynamicdesign.service;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import com.fssa.dynamicdesign.model.Architect;
import com.fssa.dynamicdesign.validation.exception.InvalidArchitectException;

class TestArchitectGetArchitectByEmail {

    @Test
    void testGetArchitectByEmailWithExistingEmail() {
        ArchitectService architectService = new ArchitectService();
        String existingEmail = "architect@example.com"; // Replace with an email that exists in your test data.

        assertDoesNotThrow(() -> {
            Architect architect = architectService.getArchitectByEmail(existingEmail);
            assertNotNull(architect, "Architect with an existing email should be found.");
        }, "Exception occurred while fetching an architect with an existing email.");
    }

    @Test
    void testGetArchitectByEmailWithNonExistentEmail() {
        ArchitectService architectService = new ArchitectService();
        String nonExistentEmail = "nonexistent@example.com"; // Replace with a non-existent email.

        assertDoesNotThrow(() -> {
            Architect architect = architectService.getArchitectByEmail(nonExistentEmail);
            assertNull(architect, "Architect with a non-existent email should not be found.");
        }, "Exception occurred while fetching an architect with a non-existent email.");
    }

    @Test
    void testGetArchitectByEmailWithInvalidEmail() {
        ArchitectService architectService = new ArchitectService();
        String invalidEmail = "invalidemail"; // Replace with an invalid email.

        assertThrows(InvalidArchitectException.class, () -> {
            architectService.getArchitectByEmail(invalidEmail);
        }, "Exception should occur for an invalid email.");
    }
}
