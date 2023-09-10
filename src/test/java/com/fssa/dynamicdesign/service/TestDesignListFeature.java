package com.fssa.dynamicdesign.service;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.fssa.dynamicdesign.model.Design;
import com.fssa.dynamicdesign.service.exception.ServiceException;

class TestDesignListFeature {

    @Test
    void testListDesignsNotEmptySuccess() {
        DesignService designService = new DesignService();

        assertDoesNotThrow(() -> {
            List<Design> designs = designService.listDesigns();
            assertNotNull(designs, "List of designs is null.");
            assertTrue(!designs.isEmpty(), "List of designs is empty.");
        }, "Exception occurred while fetching designs from the database.");
    }

    @Test
    void testListDesignsNotEmptyFailure() {
        DesignService designService = new DesignService();

        assertThrows(ServiceException.class, () -> {
            List<Design> designs = designService.listDesigns();
            assertNotNull(designs, "List of designs is null.");
            assertFalse(designs.isEmpty(), "List of designs is empty.");
        }, "Expected ServiceException for an empty list of designs.");
    }
}
