package com.fssa.dynamicdesign.service;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.fssa.dynamicdesign.service.exception.ServiceException;

class TestDesignDeleteFeature {

    @Test
    void testDeleteDesignSuccess() {
        DesignService designService = new DesignService();
        int designIdToDelete = 29;

        assertDoesNotThrow(() -> {
            assertTrue(designService.deleteDesign(designIdToDelete));
            System.out.println("Design deleted successfully");
        });
    }

    @Test
    void testDeleteNonExistingDesign() {
        DesignService designService = new DesignService();
        int nonExistingDesignId = 1000;

        assertDoesNotThrow(() -> {
            assertFalse(designService.deleteDesign(nonExistingDesignId));
            System.out.println("Design not found, delete failed");
        });
    }

    @Test
    void testDeleteDesignWithInvalidId() {
        DesignService designService = new DesignService();
        int invalidDesignId = -1;

        assertThrows(ServiceException.class, () -> {
            designService.deleteDesign(invalidDesignId);
        });
    }

    @Test
    void testDeleteDesignWithNullId() {
        DesignService designService = new DesignService();
        int nullDesignId = 0;

        assertThrows(ServiceException.class, () -> {
            designService.deleteDesign(nullDesignId);
        });
    }
}
