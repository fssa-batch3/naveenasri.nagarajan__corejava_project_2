package com.fssa.dynamicdesign.service;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import com.fssa.dynamicdesign.model.User;
import com.fssa.dynamicdesign.service.exception.ServiceException;

class TestUserRegisterFeature {

	@Test
	void testRegistrationSuccess() {
		UserService userService = new UserService();
		// email is not repeating so give unique email
		// ********************** Important ******************
		// change userID , Email
		// ***************************************************
		User user1 = new User("kishore@gmail.com", "Maha", "Kishore@123", "9876212345", "user");
		try {
			assertTrue(userService.registerUser(user1));
		} catch (ServiceException e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	void testRegistrationNullPassword() {
		UserService userService = new UserService();
		User user = new User("maha@gmail.com", "Maha", null, "9876212345", "user");
		try {
			userService.registerUser(user);
			fail("Expected ServiceException for null password, but none was thrown.");
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}

	@Test
	void testRegistrationNullUser() {
		UserService userService = new UserService();
		try {
			userService.registerUser(null);
			fail("Expected ServiceException for null user, but none was thrown.");
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}

	@Test
	void testRegistrationEmailEmpty() {
		UserService userService = new UserService();
		User user1 = new User("", "Maha", "Maha@123", "9876212345", "user");
		try {
			userService.registerUser(user1);
			fail();
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}

	@Test
	void testRegistrationPhoneNumberInvalid() {
		UserService userService = new UserService();
		User user1 = new User("maha@gmail.com", "Maha", "Maha@123", "98762h12345", "user");
		try {
			userService.registerUser(user1);
			fail();
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}

	@Test
	void testRegistrationEmptyPassword() {
		UserService userService = new UserService();
		User user = new User("maha@gmail.com", "Maha", "", "9876212345", "user");
		try {
			userService.registerUser(user);
			fail("Expected ServiceException for empty password, but none was thrown.");
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}
  
	@Test
	void testRegistrationEmptyUsername() {
		UserService userService = new UserService();
		User user = new User("maha@gmail.com", "", "Maha@123", "9876212345", "user");
		try {
			userService.registerUser(user);
			fail("Expected ServiceException for empty username, but none was thrown.");
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}

}
