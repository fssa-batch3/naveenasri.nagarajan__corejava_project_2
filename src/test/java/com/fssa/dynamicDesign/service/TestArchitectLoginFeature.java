package com.fssa.dynamicdesign.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.fssa.dynamicdesign.model.Architect;
import com.fssa.dynamicdesign.service.exception.ServiceException;

public class TestArchitectLoginFeature {

	@Test
	public void testloginSuccess() {
		ArchitectService architectService = new ArchitectService();
		String email = "ajai@example.com";
		String password = "Navee@123";
		Architect architect1 = new Architect(email, password);
		try {
			assertTrue(architectService.loginArchitect(architect1, email));
		} catch (ServiceException e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	public void testEmailNotExists() {
		ArchitectService architectService = new ArchitectService();
		String email = "nonexisting@gmail.com";
		String password = "Password@796";
		Architect architect2 = new Architect(email, password);
		try {
			architectService.loginArchitect(architect2, email);
			fail();
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testLoginEmailCheck() {
		ArchitectService architectService = new ArchitectService();
		String email = "invalidemail"; // Invalid email format
		String password = "Architect@123";
		Architect architect1 = new Architect(email, password);
		try {
			architectService.loginArchitect(architect1, email); // Expecting login failure
			fail("Login with invalid email format should fail.");
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testLoginNullArchitect() {
		ArchitectService architectService = new ArchitectService();
		try {
			architectService.loginArchitect(null, "architect@gmail.com"); // Expecting login failure
			fail();
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}
}
