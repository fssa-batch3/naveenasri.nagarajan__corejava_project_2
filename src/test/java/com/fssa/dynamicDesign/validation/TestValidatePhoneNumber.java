package com.fssa.dynamicDesign.validation;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import com.fssa.dynamicDesign.validation.UserValidator;
import com.fssa.dynamicDesign.validation.exception.InvalidUserException;

public class TestValidatePhoneNumber {

	@Test
	public void testValidPhoneNumber() {
		try {
			assertTrue(UserValidator.validatePhoneNumber("+919876543210"));
			System.out.println("Valid phone number test passed.");
		} catch (InvalidUserException e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	public void testValidPhoneNumberWithoutCountryCode() {
		try {
			assertTrue(UserValidator.validatePhoneNumber("9876543210"));
			System.out.println("Valid phone number without country code test passed.");
		} catch (InvalidUserException e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	public void testInvalidPhoneNumberWithInvalidCountryCode() {
		try {
			assertFalse(UserValidator.validatePhoneNumber("+920987654321"));
			System.out.println("Invalid phone number with invalid country code test passed.");
			fail();
		} catch (InvalidUserException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testInvalidPhoneNumberWithInvalidLength() {
		try {
			assertFalse(UserValidator.validatePhoneNumber("987654321"));
			System.out.println("Invalid phone number with invalid length test passed.");
			fail();
		} catch (InvalidUserException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testInvalidPhoneNumberWithNonNumericCharacters() {
		try {
			assertFalse(UserValidator.validatePhoneNumber("9876abcd12"));
			System.out.println("Invalid phone number with non-numeric characters test passed.");
			fail();
		} catch (InvalidUserException e) {
			e.printStackTrace();
		}
	}
}
