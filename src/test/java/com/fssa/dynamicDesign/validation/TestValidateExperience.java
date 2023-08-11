package com.fssa.dynamicDesign.validation;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import com.fssa.dynamicDesign.validation.ArchitectValidator;
import com.fssa.dynamicDesign.validation.exception.InvalidArchitectException;

public class TestValidateExperience {

	@Test
	public void testValidExperience() {
		try {
			assertTrue(ArchitectValidator.validateExperience(5));
			System.out.println("Valid experience test passed.");
		} catch (InvalidArchitectException e) {
			e.printStackTrace();
			System.out.println("Caught InvalidArchitectException for a valid experience.");
			fail();
		}
	}

	@Test
	public void testValidExperienceWithSingleDigit() {
		try {
			assertTrue(ArchitectValidator.validateExperience(9));
			System.out.println("Valid single-digit experience test passed.");
		} catch (InvalidArchitectException e) {
			e.printStackTrace();
			System.out.println("Caught InvalidArchitectException for a valid single-digit experience.");
			fail();
		}
	}

	@Test
	public void testInvalidNegativeExperience() {
		try {
			assertFalse(ArchitectValidator.validateExperience(-3));
			System.out.println("Invalid negative experience test passed.");
			fail();
		} catch (InvalidArchitectException e) {
			// Correct exception type is caught
			System.out.println("Caught InvalidArchitectException for an invalid negative experience.");
		}
	}

	@Test
	public void testInvalidExperienceWithNonNumeric() {
		try {
			assertFalse(ArchitectValidator.validateExperience(Integer.parseInt("-1"))); // -1 as a string
			System.out.println("Invalid non-numeric experience test passed.");
			fail();
		} catch (InvalidArchitectException e) {
			// Correct exception type is caught
			System.out.println("Caught InvalidArchitectException for an invalid non-numeric experience.");
		}
	}

	@Test
	public void testInvalidExperienceWithThreeDigits() {
		try {
			assertFalse(ArchitectValidator.validateExperience(123));
			System.out.println("Invalid three-digit experience test passed.");
			fail();
		} catch (InvalidArchitectException e) {
			// Correct exception type is caught
			System.out.println("Caught InvalidArchitectException for an invalid three-digit experience.");
		}
	}

}
