package com.fssa.dynamicdesign.validation;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import com.fssa.dynamicdesign.validation.UserValidator;
import com.fssa.dynamicdesign.validation.exception.InvalidUserException;

public class TestValidateEmail {

	@Test
	public void testValidEmail() {
		try {
			assertTrue(UserValidator.validateEmail("valid@example.com"));
			System.out.println("Valid email test passed.");
		} catch (InvalidUserException e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	public void testValidEmailWithTwoDots() {
		try {
			assertTrue(UserValidator.validateEmail("valid.name@example.co.uk"));
			System.out.println("Valid email with two dots test passed.");
		} catch (InvalidUserException e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	public void testValidEmailEmpty() {
		try {
			assertFalse(UserValidator.validateEmail(""));
			System.out.println("Invalid email with empty String test passed.");
			fail();
		} catch (InvalidUserException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testInvalidEmailWithoutAtSymbol() {
		try {
			assertFalse(UserValidator.validateEmail("invalid_email.com"));
			System.out.println("Invalid email without at symbol test passed.");
			fail();
		} catch (InvalidUserException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testInvalidEmailWithoutDomain() {
		try {
			assertFalse(UserValidator.validateEmail("invalid@.com"));
			System.out.println("Invalid email without domain test passed.");
			fail();
		} catch (InvalidUserException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testInvalidEmailWithoutTLD() {
		try {
			assertFalse(UserValidator.validateEmail("invalid@example"));
			System.out.println("Invalid email without TLD test passed.");
			fail();
		} catch (InvalidUserException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testInvalidEmailWithSpaces() {
		try {
			assertFalse(UserValidator.validateEmail("invalid email@example.com"));
			System.out.println("Invalid email with spaces test passed.");
			fail();
		} catch (InvalidUserException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testInvalidEmailWithSpecialCharacters() {
		try {
			assertFalse(UserValidator.validateEmail("invalid$email@example.com"));
			System.out.println("Invalid email with special characters test passed.");
			fail();
		} catch (InvalidUserException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testInvalidEmailWithoutDot() {
		try {
			assertFalse(UserValidator.validateEmail("invalidemail@com"));
			System.out.println("Invalid email without dot test passed.");
			fail();
		} catch (InvalidUserException e) {
			e.printStackTrace();
		}
	}
}
