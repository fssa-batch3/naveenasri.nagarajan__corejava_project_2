
package com.fssa.dynamicdesign.service;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import com.fssa.dynamicdesign.model.Architect;
import com.fssa.dynamicdesign.service.ArchitectService;
import com.fssa.dynamicdesign.service.exception.ServiceException;

 class TestArchitectDeleteFeature {

	@Test
	 void testDeleteArchitectSuccess() {
		ArchitectService architectService = new ArchitectService();
		// Assuming an architect with the email "architect@gmail.com" exists in the
		// database
		String emailToDelete = "john.doe@example.com";
		try {
			boolean isDeleted = architectService.deleteArchitect(emailToDelete);
			assertTrue(isDeleted, "Architect deletion failed.");
		} catch (ServiceException e) {
			e.printStackTrace();
			fail("Exception occurred while deleting the architect.");
		}
	}

	@Test
	 void testDeleteNonExistingArchitect() {
		ArchitectService architectService = new ArchitectService();
		// Assuming an architect with the email "nonexisting@example.com" does not exist
		// in the database
		String emailToDelete = "nonexisting@example.com";
			try {
			architectService.deleteArchitect(emailToDelete);
			fail("Architect with non-existing email should not be deleted, but method succeeded.");
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}

	@Test
	 void testDeleteArchitectWithInvalidArchitectEmail() {
		ArchitectService architectService = new ArchitectService();
		String emailToDelete = "babugmail.com";
		try {
			boolean isDeleted = architectService.deleteArchitect(emailToDelete);
			assertFalse(isDeleted, "Architect should not be deleted.");
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}

}
