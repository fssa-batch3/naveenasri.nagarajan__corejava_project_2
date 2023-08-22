package com.fssa.interiordesign.validation;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import com.fssa.interiordesign.validation.ArchitectValidator;
import com.fssa.interiordesign.validation.exception.InvalidArchitectException;

 class TestValidateEducation {

	@Test
	 void testValidEducation() {
		try {
			assertTrue(ArchitectValidator.validateEducation("Bachelor of Science"));
			System.out.println("Valid education test passed.");
		} catch (InvalidArchitectException e) {
			e.printStackTrace();
			System.out.println("Caught InvalidArchitectException for a valid education.");
			fail();
		}
	}

	@Test
	 void testValidEducationWithSpaces() {
		try {
			assertTrue(ArchitectValidator.validateEducation("Master of Arts in Literature"));
			System.out.println("Valid education with spaces test passed.");
		} catch (InvalidArchitectException e) {
			e.printStackTrace();
			System.out.println("Caught InvalidArchitectException for a valid education with spaces.");
			fail();
		}
	}

	@Test
	 void testInvalidNullEducation() {
		try {
			assertFalse(ArchitectValidator.validateEducation(null));
			System.out.println("Invalid null education test passed.");
			fail();
		} catch (InvalidArchitectException e) {
			// Correct exception type is caught
			System.out.println("Caught InvalidArchitectException for an invalid null education.");
		}
	}

	@Test
	 void testInvalidEmptyEducation() {
		try {
			assertFalse(ArchitectValidator.validateEducation(""));
			System.out.println("Invalid empty education test passed.");
			fail();
		} catch (InvalidArchitectException e) {
			// Correct exception type is caught
			System.out.println("Caught InvalidArchitectException for an invalid empty education.");
		}
	}

	@Test
	 void testInvalidEducationWithNumbers() {
		try {
			assertFalse(ArchitectValidator.validateEducation("PhD in Physics 123"));
			System.out.println("Invalid education with numbers test passed.");
			fail();
		} catch (InvalidArchitectException e) {
			// Correct exception type is caught
			System.out.println("Caught InvalidArchitectException for an invalid education with numbers.");
		}
	}

	@Test
	 void testInvalidEducationWithSpecialCharacters() {
		try {
			assertFalse(ArchitectValidator.validateEducation("High School Diploma @#$"));
			System.out.println("Invalid education with special characters test passed.");
			fail();
		} catch (InvalidArchitectException e) {
			// Correct exception type is caught
			System.out.println("Caught InvalidArchitectException for an invalid education with special characters.");
		}
	}
}
