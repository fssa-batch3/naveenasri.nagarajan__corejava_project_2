package com.fssa.dynamicdesign.service;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import com.fssa.dynamicdesign.model.Architect;
import com.fssa.dynamicdesign.validation.exception.InvalidArchitectException;

class TestArchitectGetArchitectById {

    @Test
    void testGetArchitectByIdWithExistingId() {
        ArchitectService architectService = new ArchitectService();
        int existingArchitectId = 1; // Replace with a valid architect ID that exists in your test data.

        assertDoesNotThrow(() -> {
            Architect architect = architectService.getArchitectById(existingArchitectId);
            assertNotNull(architect, "Architect with an existing ID should be found.");
        }, "Exception occurred while fetching an architect with an existing ID.");
    }

    @Test
    void testGetArchitectByIdWithNonExistentId() {
        ArchitectService architectService = new ArchitectService();
        int nonExistentArchitectId = 999; // Replace with a non-existent architect ID.

        assertDoesNotThrow(() -> {
            Architect architect = architectService.getArchitectById(nonExistentArchitectId);
            assertNull(architect, "Architect with a non-existent ID should not be found.");
        }, "Exception occurred while fetching an architect with a non-existent ID.");
    }

    @Test
    void testGetArchitectByIdWithNegativeId() {
        ArchitectService architectService = new ArchitectService();
        int negativeArchitectId = -1; // Replace with a negative architect ID.

        assertThrows(InvalidArchitectException.class, () -> {
             architectService.getArchitectById(negativeArchitectId);
        }, "Exception should occur for a negative architect ID.");
    }

    @Test
    void testGetArchitectByIdWithZeroId() {
        ArchitectService architectService = new ArchitectService();
        int zeroArchitectId = 0; // Replace with a zero architect ID.

        assertThrows(InvalidArchitectException.class, () -> {
           architectService.getArchitectById(zeroArchitectId);
        }, "Exception should occur for a zero architect ID.");
    }
}
