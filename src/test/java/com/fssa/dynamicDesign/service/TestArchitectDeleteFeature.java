
package com.fssa.dynamicdesign.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.fssa.dynamicdesign.model.Architect;
import com.fssa.dynamicdesign.service.ArchitectService;
import com.fssa.dynamicdesign.service.exception.ServiceException;

public class TestArchitectDeleteFeature {

	@Test
	public void testDeleteArchitectSuccess() {
		ArchitectService architectService = new ArchitectService();
		// Assuming an architect with the email "architect@gmail.com" exists in the
		// database
		try {
			Architect architect = new Architect(3, "profile.jpg", "Architect Name", "Male", "9876543210", "Address",
					"cover.jpg", "ajai@example.com", "Architect@123", "B.Arch", 5, "degree.pdf", "nata.pdf", false);
			boolean isDeleted = architectService.deleteArchitect(architect);
			assertTrue(isDeleted, "Architect deletion failed.");
		} catch (ServiceException e) {
			e.printStackTrace();
			fail("Exception occurred while deleting the architect.");
		}
	}

	@Test
	public void testDeleteNonExistingArchitect() {
		ArchitectService architectService = new ArchitectService();
		// Assuming an architect with the email "nonexisting@example.com" does not exist
		// in the database
		Architect architect = new Architect(2, "profile.jpg", "Non Existing Architect", "Male", "9876543210", "Address",
				"cover.jpg", "nonexisting@example.com", "Architect@123", "B.Arch", 5, "degree.pdf", "nata.pdf", false);
		try {
			architectService.deleteArchitect(architect);
			fail("Architect with non-existing email should not be deleted, but method succeeded.");
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testDeleteArchitectWithInvalidArchitectId() {
		ArchitectService architectService = new ArchitectService();
		Architect architect = new Architect(-1, "profile.jpg", "Architect Name", "Male", "9876543210", "Address",
				"cover.jpg", "architect@gmail.com", "Architect@123", "B.Arch", 5, "degree.pdf", "nata.pdf", false);
		try {
			boolean isDeleted = architectService.deleteArchitect(architect);
			assertFalse(isDeleted, "Architect should not be deleted.");
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}

}
