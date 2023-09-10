package com.fssa.dynamicdesign.service;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import com.fssa.dynamicdesign.model.Design;
import com.fssa.dynamicdesign.service.exception.ServiceException;

class TestDesignUpdateFeature {

	@Test
	void testUpdateDesignSuccess() {
	    DesignService designService = new DesignService();
	    Design designToUpdate = new Design(29, "fansy living Room",
	            "https://cdn.pixabay.com/photo/2016/06/24/10/47/house-1477041_1280.jpg", 110.00,
	            "Interior design helps one elevate their existence,their lifestyle and their perception of the world.It is a fundamental human desire to seek and identify beauty in the surrounding.",
	            4);
	    try {
	        assertTrue(designService.updateDesign(designToUpdate), "Design update should succeed.");
	    } catch (ServiceException e) {
	        fail("Unexpected ServiceException: " + e.getMessage());
	    }
	}


    @Test
    void testUpdateNonExistentDesign() {
        DesignService designService = new DesignService();
        Design nonExistentDesign = new Design(1000, "Updated Design", "https://example.com/updated", 150.0,
                "Interior design helps one elevate their existence, their lifestyle and their perception of the world. It is a fundamental human desire to seek and identify beauty in the surrounding.",
                4);
        assertThrows(ServiceException.class, () -> {
            designService.updateDesign(nonExistentDesign);
        }, "Expected ServiceException for updating non-existent design.");
    }

    @Test
    void testUpdateWithNegativePrice() {
        DesignService designService = new DesignService();
        Design designToUpdate = new Design(3, "Updated Design", "https://example.com/updated", -50.0, "", 2);
        assertThrows(ServiceException.class, () -> {
            designService.updateDesign(designToUpdate);
        }, "Expected ServiceException for updating design with negative price.");
    }

    @Test
    void testUpdateWithNegativeRooms() {
        DesignService designService = new DesignService();
        Design designToUpdate = new Design(4, "Updated Design", "https://example.com/updated", 150.0,
                "Interior design helps one elevate their existence, their lifestyle and their perception of the world. It is a fundamental human desire to seek and identify beauty in the surrounding.",
                -3);
        assertThrows(ServiceException.class, () -> {
            designService.updateDesign(designToUpdate);
        }, "Expected ServiceException for updating design with negative rooms.");
    }
}
