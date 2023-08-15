package com.fssa.dynamicdesign.service;

import org.junit.jupiter.api.Test;

import com.fssa.dynamicdesign.model.Design;
import com.fssa.dynamicdesign.service.exception.ServiceException;

import static org.junit.jupiter.api.Assertions.fail;

 class TestDesignUpdateFeature {

	@Test
	 void testUpdateDesignSuccess() {
	    DesignService designService = new DesignService();
	    Design designToUpdate = new Design(1, "Living Design", "https://example.com/design10", 110.00, "user@example.com", 1);
	    try {
	        if (!designService.updateDesign(designToUpdate)) {
	            fail("Failed to update design.");
	        } else {
	            System.out.println("Design Updated Successfully");
	        }
	    }  catch (ServiceException e) {
	        e.printStackTrace();
	    }
	}

    @Test
     void testUpdateNonExistentDesign() {
        DesignService designService = new DesignService();
        Design nonExistentDesign = new Design(2, "Updated Design", "https://example.com/updated", 150.0, "user@example.com", 2);
        try {
            if (designService.updateDesign(nonExistentDesign)) {
                fail("Successfully updated non-existent design.");
            }
        }  catch (ServiceException e) {
	        e.printStackTrace();
	    }
    }

    @Test
     void testUpdateWithNegativePrice() {
        DesignService designService = new DesignService();
        Design designToUpdate = new Design(3, "Updated Design", "https://example.com/updated", -50.0, "user@example.com", 2);
        try {
            if (designService.updateDesign(designToUpdate)) {
                fail("Successfully updated design with negative price.");
            }
        }  catch (ServiceException e) {
	        e.printStackTrace();
	    }
    }

    @Test
     void testUpdateWithInvalidEmail() {
        DesignService designService = new DesignService();
        Design designToUpdate = new Design(4, "Updated Design", "https://example.com/updated", 150.0, "invalidemail", 2);
        try {
            if (designService.updateDesign(designToUpdate)) {
                fail("Successfully updated design with invalid email.");
            }
        } catch (ServiceException e) {
	        e.printStackTrace();
	    }
    }

    @Test
     void testUpdateWithNegativeRooms() {
        DesignService designService = new DesignService();
        Design designToUpdate = new Design(5, "Updated Design", "https://example.com/updated", 150.0, "user@example.com", -2);
        try {
            if (designService.updateDesign(designToUpdate)) {
                fail("Successfully updated design with negative rooms.");
            }
        }  catch (ServiceException e) {
	        e.printStackTrace();
	    }
    }
}
