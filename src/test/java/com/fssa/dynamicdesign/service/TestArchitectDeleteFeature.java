package com.fssa.dynamicdesign.service;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.fssa.dynamicdesign.service.exception.ServiceException;

class TestArchitectDeleteFeature {

    @Test
    void testDeleteArchitectSuccess() {
        ArchitectService architectService = new ArchitectService();
        String emailToDelete = "john.doe@example.com";

        assertDoesNotThrow(() -> {
            boolean isDeleted = architectService.deleteArchitect(emailToDelete);
            assertTrue(isDeleted, "Architect deletion failed.");
        });
    }

    @Test
    void testDeleteNonExistingArchitect() {
        ArchitectService architectService = new ArchitectService();
        String emailToDelete = "nonexisting@example.com";

        assertThrows(ServiceException.class, () -> {
            architectService.deleteArchitect(emailToDelete);
        });
    }

    @Test
    void testDeleteArchitectWithInvalidArchitectEmail() {
        ArchitectService architectService = new ArchitectService();
        String emailToDelete = "babugmail.com";

        assertThrows(ServiceException.class, () -> {
            architectService.deleteArchitect(emailToDelete);
        });
    }
}
