package com.fssa.interiordesign.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.fssa.interiordesign.model.User;
import com.fssa.interiordesign.service.UserService;
import com.fssa.interiordesign.service.exception.ServiceException;

 class TestUserLoginFeature {

	@Test
	 void loginSuccess() {
		UserService userService = new UserService();
		String email = "maha122@gmail.com";
		String password = "Navee@123";
		User user1 = new User(email, password);
		try {
			assertTrue(userService.loginUser(user1, email));
		} catch (ServiceException e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	 void testEmailNotExists() {
		UserService userService = new UserService();
		String email = "ahkbkj@gmail.com";
		String password = "Password@796";
		User user2 = new User(email, password);
		try {
			userService.loginUser(user2, email);
			fail();
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}

	

	@Test
	 void testLoginEmailCheck() {
		UserService userService = new UserService();
		String email = "invalidemail"; // Invalid email format
		String password = "Navee@123";
		User user1 = new User(email, password);
		try {
			userService.loginUser(user1, email); // Expecting login failure
			fail("Login with invalid email format should fail.");
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}

	@Test
	 void testLoginNullUser() {
		UserService userService = new UserService();
		try {
			userService.loginUser(null, "maha12@gmail.com"); // Expecting login failure
			fail();
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}
	
//	@Test
//	 void testLoginPasswordCheck() {
//		UserService userService = new UserService();
//		String email = "maha12@gmail.com";
//		String password = "navee@123"; // Incorrect password format
//		User user1 = new User(email, password);
//		try {
//			assertFalse(userService.loginUser(user1, email));
//		} catch (ServiceException e) {
//			e.printStackTrace();
//		}
//	}
}
