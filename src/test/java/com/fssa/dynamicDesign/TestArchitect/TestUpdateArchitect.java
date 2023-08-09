package com.fssa.dynamicDesign.TestArchitect;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.jupiter.api.Test;

import com.fssa.dynamicDesign.model.Architect;
import com.fssa.dynamicDesign.service.ArchitectService;
import com.fssa.dynamicDesign.service.exception.ServiceException;

public class TestUpdateArchitect {

	@Test
	public void testUpdateSuccess() {
		ArchitectService architectService = new ArchitectService();
		Architect architect = new Architect(1,"profilePhoto.jpg", "Maha", "Female", "9876543210", "123 Main Street",
				"coverPhoto.jpg", "maha@example.com", "Navee@123", "Bachelor of Architecture", 5,
				"degreeCertificate.jpg", "NATACertificate.jpg");
		try {
			assertTrue(architectService.updateArchitect(architect, "maha@example.com"));
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testUpdateEmailNotFound() {
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
	public void testUpdateInvalidEmailFormat() {
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
	public void testUpdateMissingRequiredField() {
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
	public void testUpdateNullArchitect() {
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
	public void testUpdateNullEmail() {
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
	public void testUpdateEmptyEmail() {
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
