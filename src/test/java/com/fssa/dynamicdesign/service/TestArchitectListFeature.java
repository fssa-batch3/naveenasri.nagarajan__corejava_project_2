package com.fssa.dynamicdesign.service;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.fssa.dynamicdesign.model.Architect;

class TestArchitectListFeature {

    @Test
    void testListArchitectsNotEmptyTrue() {
        ArchitectService architectService = new ArchitectService();

        assertDoesNotThrow(() -> {
            List<Architect> architects = architectService.listArchitects();
            assertNotNull(architects, "List of architects is null.");
            assertTrue(!architects.isEmpty(), "List of architects is empty.");
        }, "Exception occurred while fetching architects from the database.");
    }

    @Test
    void testListArchitects() {
        ArchitectService architectService = new ArchitectService();

        assertDoesNotThrow(() -> {
            List<Architect> architects = architectService.listArchitects();
            assertNotNull(architects, "List of architects is null.");
            assertFalse(architects.isEmpty(), "List of architects is not empty.");
        }, "Exception occurred while fetching architects from the service.");
    }
}
