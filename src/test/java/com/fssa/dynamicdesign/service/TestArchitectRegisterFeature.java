package com.fssa.dynamicdesign.service;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import com.fssa.dynamicdesign.model.Architect;
import com.fssa.dynamicdesign.service.ArchitectService;
import com.fssa.dynamicdesign.service.exception.ServiceException;

 class TestArchitectRegisterFeature {

	@Test
	 void testArchitectRegistrationSuccess() {
		ArchitectService architectService = new ArchitectService();

		// Create a sample valid architect
		// ********************** Important ******************
		// change ArchitectID , Email , Architect Name
		// ***************************************************
		Architect architect = new Architect( "profilePhoto.jpg", "Ajaiii", "Female", "9876543210", "123 Main Street",
				"coverPhoto.jpg", "ajaiii@example.com", "Navee@123", "Bachelor of Architecture", 4,
				"degreeCertificate.jpg", "NATACertificate.jpg");
		try {
			assertTrue(architectService.registerArchitect(architect));
		} catch (ServiceException e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	 void testArchitectRegistrationValidURLs() {
		ArchitectService architectService = new ArchitectService();
		// ********************** Important ******************
		// change ArchitectID , Email , Architect Name
		// ***************************************************
		// Create a sample architect with valid URLs for profile photo, cover photo,
		// degree certificate, and NATACertificate
		Architect architect = new Architect( "https://example1.com/profile.jpg", "JohnDoy", "Male", "9876543210",
				"123 Main Street", "https://example.com/cover.jpg", "johyuh@example.com", "Password@123",
				"Bachelor of Architecture", 5, "https://example.com/degree.jpg", "https://example.com/NATACert.jpg");
		try {
			assertTrue(architectService.registerArchitect(architect));
		} catch (ServiceException e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	 void testArchitectRegistrationNullName() {
		ArchitectService architectService = new ArchitectService();

		// Create a sample architect with invalid details (missing required fields)
		Architect architect = new Architect("profilePhoto.jpg", null, "Male", "9876543210", "123 Main Street",
				"coverPhoto.jpg", "john.doe@example.com", "Password@123", "Bachelor of Architecture", 5,
				"degreeCertificate.jpg", "NATACertificate.jpg");

		try {
			architectService.registerArchitect(architect);
			fail("The Name of the Architect is null");
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	 void testArchitectRegistrationNull() {
		ArchitectService architectService = new ArchitectService();

		// Create a sample architect with invalid details (missing required fields)
		Architect architect = null;

		try {
			architectService.registerArchitect(architect);
			fail("Architect is null");
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}

	@Test
	 void testArchitectRegistrationEmailExists() {
		ArchitectService architectService = new ArchitectService();

		// Create a sample architect with an email that already exists in the database
		Architect architect = new Architect( "profilePhoto.jpg", "Maha", "Male", "9876543210", "123 Main Street",
				"coverPhoto.jpg", "maha@example.com", "Password@123", "Bachelor of Architecture", 5,
				"degreeCertificate.jpg", "NATACertificate.jpg");

		try {
			architectService.registerArchitect(architect);
			fail("This Email is already Exists");
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}

	@Test
	 void testArchitectRegistrationInvalidURLs() {
		ArchitectService architectService = new ArchitectService();

		// Create a sample architect with invalid URLs for profile photo, cover photo,
		// degree certificate, and NATACertificate
		Architect architect = new Architect( "invalidprofile.jpg", "JohnDoe", "Male", "9876543210", "123 Main Street",
				"invalidcover.jpg", "john.doe@example.com", "Password@123", "Bachelor of Architecture", 5,
				"invaliddegree.jpg", "invalidNATACert.jpg");

		try {
			assertFalse(architectService.registerArchitect(architect));
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}

//	@Test
//	 void testArchitectRegistrationInvalidExperience() {
//		ArchitectService architectService = new ArchitectService();
//
//		// Create a sample architect with negative experience
//		Architect architect = new Architect(5, "profilePhoto.jpg", "JohnDoe", "Male", "9876543210", "123 Main Street",
//				"coverPhoto.jpg", "john.doe@example.com", "Password@123", "Bachelor of Architecture", -2,
//				"degreeCertificate.jpg", "NATACertificate.jpg");
//
//		try {
//			assertFalse(architectService.registerArchitect(architect));
//		} catch (ServiceException e) {
//			e.printStackTrace();
//		}
//	}

//    @Test
//     void testArchitectRegistrationEmptyEmailExists() {
//        ArchitectService architectService = new ArchitectService();
//
//        // Create a sample architect with an email that already exists in the database
//        Architect architect = new Architect(3,"profilePhoto.jpg", "Maha", "Male", "9876543210", "123 Main Street",
//                "coverPhoto.jpg", "", "Password@123", "Bachelor of Architecture", 5,
//                "degreeCertificate.jpg", "NATACertificate.jpg");
//
//        try {
//            architectService.registerArchitect(architect);
//            fail();
//        } catch (ServiceException e) {
//            e.printStackTrace();
//        }
//    }
}
