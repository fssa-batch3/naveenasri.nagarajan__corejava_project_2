package com.fssa.dynamicdesign.validation;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import com.fssa.dynamicdesign.validation.exception.InvalidUserException;

 class TestValidateUserName {

	@Test
	 void testValidUserName() {
		try {
			assertTrue(UserValidator.validateName("ValidUserName"));
			System.out.println("Valid user name test passed.");
		} catch (InvalidUserException e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	 void testInvalidUserNameStartingWithNumber() {
		try {
			assertFalse(UserValidator.validateName("123InvalidUserName"));
			System.out.println("Invalid user name starting with a number test passed.");
			fail();
		} catch (InvalidUserException e) {
			e.printStackTrace();
		}
	}

	@Test
	 void testInvalidUserNameShorterLength() {
		try {
			assertFalse(UserValidator.validateName("Ab"));
			System.out.println("Invalid user name shorter length test passed.");
			fail();
		} catch (InvalidUserException e) {
			e.printStackTrace();
		}
	}

	@Test
	 void testInvalidUserNameLongerLength() {
		try {
			assertFalse(UserValidator.validateName("ThisIsAVeryLongUserNameThatExceedsTheLimit"));
			System.out.println("Invalid user name longer length test passed.");
			fail();
		} catch (InvalidUserException e) {
			e.printStackTrace();
		}
	}

	@Test
	 void testInvalidUserNameWithSpaces() {
		try {
			assertFalse(UserValidator.validateName("Invalid User Name"));
			System.out.println("Invalid user name with spaces test passed.");
			fail();
		} catch (InvalidUserException e) {
			e.printStackTrace();
		}
	}

	@Test
	 void testInvalidUserNameWithSpecialCharacters() {
		try {
			assertFalse(UserValidator.validateName("Invalid$UserName"));
			System.out.println("Invalid user name with special characters test passed.");
			fail();
		} catch (InvalidUserException e) {
			e.printStackTrace();
		}
	}
}
