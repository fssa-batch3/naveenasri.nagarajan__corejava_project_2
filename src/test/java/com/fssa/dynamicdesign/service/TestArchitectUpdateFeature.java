package com.fssa.dynamicdesign.service;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.jupiter.api.Test;

import com.fssa.dynamicdesign.model.Architect;
import com.fssa.dynamicdesign.service.ArchitectService;
import com.fssa.dynamicdesign.service.exception.ServiceException;

 class TestArchitectUpdateFeature {

	@Test
	 void testUpdateSuccess() {
		ArchitectService architectService = new ArchitectService();
		Architect architect = new Architect(73,"profileeePhoto.jpg", "Maha", "Female", "9876543210", "123 Main Street",
				"coverPhoto.jpg", "maha@example.com", "Navee@123", "Bachelor of Architecture", 5,
				"degreeCertificate.jpg", "NATACertificate.jpg");
		try {
			assertTrue(architectService.updateArchitect(architect, "maha@example.com"));
		} catch (ServiceException e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	 void testUpdateEmailNotFound() {
		ArchitectService architectService = new ArchitectService();
		Architect architect = new Architect(2,"profilePhoto.jpg", "Maha", "Female", "9876543210", "123 Main Street",
				"coverPhoto.jpg", "maha@example.com", "Navee@123", "Bachelor of Architecture", 5,
				"degreeCertificate.jpg", "NATACertificate.jpg");
		try {
			// Assuming the architect with email "maha@example.com" does not exist in the
			// system
			architectService.updateArchitect(architect, "noemail@example.com");
			 fail("Email should not be able to edit, but method succeeded.");
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}

	@Test
	 void testUpdateInvalidEmailFormat() {
		ArchitectService architectService = new ArchitectService();
		Architect architect = new Architect(3,"profilePhoto.jpg", "Maha", "Female", "9876543210", "123 Main Street",
				"coverPhoto.jpg", "maha@example.com", "Navee@123", "Bachelor of Architecture", 5,
				"degreeCertificate.jpg", "NATACertificate.jpg");
		try {
			// Assuming "invalid_email_format" is not a valid email format
			architectService.updateArchitect(architect, "invalidemailformat");
			fail();
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}

	@Test
	 void testUpdateMissingRequiredField() {
		ArchitectService architectService = new ArchitectService();
		// Leaving the name field empty
		Architect architect = new Architect(4,"profilePhoto.jpg", "", "Female", "9876543210", "123 Main Street",
				"coverPhoto.jpg", "maha@example.com", "Navee@123", "Bachelor of Architecture", 5,
				"degreeCertificate.jpg", "NATACertificate.jpg");
		try {
			architectService.updateArchitect(architect, "maha@example.com");
			fail();
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}

	@Test
	 void testUpdateNullArchitect() {
		ArchitectService architectService = new ArchitectService();
		Architect architect = null;
		try {
			architectService.updateArchitect(architect, "maha@example.com");
			fail("Expected ServiceException, but method succeeded.");
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}

	@Test
	 void testUpdateNullEmail() {
		ArchitectService architectService = new ArchitectService();
		Architect architect = new Architect(5,"profilePhoto.jpg", "Maha", "Female", "9876543210", "123 Main Street",
				"coverPhoto.jpg", "maha@example.com", "Navee@123", "Bachelor of Architecture", 5,
				"degreeCertificate.jpg", "NATACertificate.jpg");
		try {
			architectService.updateArchitect(architect, null);
			fail("Expected ServiceException, but method succeeded.");
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}

	@Test
	 void testUpdateEmptyEmail() {
		ArchitectService architectService = new ArchitectService();
		Architect architect = new Architect(6,"profilePhoto.jpg", "Maha", "Female", "9876543210", "123 Main Street",
				"coverPhoto.jpg", "maha@example.com", "Navee@123", "Bachelor of Architecture", 5,
				"degreeCertificate.jpg", "NATACertificate.jpg");
		try {
			architectService.updateArchitect(architect, "");
			fail("Expected ServiceException, but method succeeded.");
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}

}
