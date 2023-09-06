package com.fssa.dynamicdesign.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.fssa.dynamicdesign.model.User;
import com.fssa.dynamicdesign.service.UserService;
import com.fssa.dynamicdesign.service.exception.ServiceException;

 class TestUserDeleteFeature {

	@Test
	 void testDeleteUserSuccess() {
		UserService userService = new UserService();
		// Assuming a user with the email "babu@gmail.com" exists in the database
		String emailToDelete = "keshavnesh@gmail.com";
		try {
			boolean isDeleted = userService.deleteUser(emailToDelete);
			assertTrue(isDeleted, "User deletion failed.");
		} catch (ServiceException e) {
			e.printStackTrace();
			fail("Exception occurred while deleting the user.");
		}
	}

	@Test
	 void testDeleteNonExistingUser() {
		UserService userService = new UserService();
		// Assuming a user with the email "nonexisting@example.com" does not exist in
		// the database
		String emailToDelete = "nonexisting@example.com";
		try {
			userService.deleteUser(emailToDelete);	
			fail("User with non-existing email should not be deleted, but method succeeded.");
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}

	@Test
	 void testDeleteUserWithInvalidUserEmail() {
		UserService userService = new UserService();
		String emailToDelete = "babugmail.com";
		try {
			boolean isDeleted = userService.deleteUser(emailToDelete);;
			assertFalse(isDeleted, "User Email should not be valid.");
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}

}
