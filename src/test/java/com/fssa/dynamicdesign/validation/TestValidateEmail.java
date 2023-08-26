package com.fssa.dynamicdesign.validation;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import com.fssa.dynamicdesign.validation.exception.InvalidUserException;

class TestValidateEmail {

	@Test
	void testValidEmail() {
		try {
			assertTrue(UserValidator.validateEmail("valid@example.com"));
			System.out.println("Valid email test passed.");
		} catch (InvalidUserException e) {
			fail();
		}
	}

	@Test
	void testValidEmailWithTwoDots() {
		try {
			assertTrue(UserValidator.validateEmail("valid.name@example.co.uk"));
			System.out.println("Valid email with two dots test passed.");
		} catch (InvalidUserException e) {
			fail();
		}
	}

	@Test
	void testValidEmailEmpty() {
		try {
			assertFalse(UserValidator.validateEmail(""));
		} catch (InvalidUserException e) {
			System.out.println("Invalid email with empty String is not passed.");
			e.printStackTrace();
		}
	}

	@Test
	void testInvalidEmailWithoutAtSymbol() {
		try {
			assertFalse(UserValidator.validateEmail("invalid_email.com"));
		} catch (InvalidUserException e) {
			System.out.println("Invalid email without at symbol is not passed.");
			e.printStackTrace();
		}
	}

	@Test
	void testInvalidEmailWithoutDomain() {
		try {
			assertFalse(UserValidator.validateEmail("invalid@.com"));
		} catch (InvalidUserException e) {
			System.out.println("Invalid email without domain is not passed.");
			e.printStackTrace();
		}
	}

	@Test
	void testInvalidEmailWithoutTLD() {
		try {
			assertFalse(UserValidator.validateEmail("invalid@example"));
		} catch (InvalidUserException e) {
			System.out.println("Invalid email without TLD is not passed.");
			e.printStackTrace();

		}
	}

	@Test
	void testInvalidEmailWithSpaces() {
		try {
			assertFalse(UserValidator.validateEmail("invalid email@example.com"));
		} catch (InvalidUserException e) {
			System.out.println("Invalid email with spaces is not passed.");
			e.printStackTrace();
		}
	}

	@Test
	void testInvalidEmailWithSpecialCharacters() {
		try {
			assertFalse(UserValidator.validateEmail("invalid$email@example.com"));
		} catch (InvalidUserException e) {
			System.out.println("Invalid email with special characters is not passed.");
			e.printStackTrace();
		}
	}

	@Test
	void testInvalidEmailWithoutDot() {
		try {
			assertFalse(UserValidator.validateEmail("invalidemail@com"));
		} catch (InvalidUserException e) {
			System.out.println("Invalid email without dot is not passed.");
			e.printStackTrace();
		}
	}
}
