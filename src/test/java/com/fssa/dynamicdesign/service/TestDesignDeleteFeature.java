package com.fssa.dynamicdesign.service;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

import com.fssa.dynamicdesign.service.DesignService;
import com.fssa.dynamicdesign.service.exception.ServiceException;

 class TestDesignDeleteFeature {

	@Test
	 void testDeleteDesignSuccess() {
		DesignService designService = new DesignService();
		// Assume you have a valid designId for an existing design
		int designIdToDelete = 1;

		try {
			assertTrue(designService.deleteDesign(designIdToDelete));
			System.out.println("Design deleted successfully");
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}

	@Test
	 void testDeleteNonExistingDesign() {
		DesignService designService = new DesignService();
		// Assume you have a designId that does not exist in the database
		int nonExistingDesignId = 1000;

		try {
			assertFalse(designService.deleteDesign(nonExistingDesignId));
			System.out.println("Design not found, delete failed");
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}

	@Test
	 void testDeleteDesignWithInvalidId() {
		DesignService designService = new DesignService();
		// Assume you have an invalid designId, e.g. negative value
		int invalidDesignId = -1;

		try {
			assertFalse(designService.deleteDesign(invalidDesignId));
			System.out.println("Invalid design ID, delete failed");
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}

	@Test
	 void testDeleteDesignWithNullId() {
		DesignService designService = new DesignService();
		int nullDesignId = 0; // Assuming 0 is considered a null design ID

		try {
			assertFalse(designService.deleteDesign(nullDesignId));
			System.out.println("Null design ID, delete failed");
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}

}
