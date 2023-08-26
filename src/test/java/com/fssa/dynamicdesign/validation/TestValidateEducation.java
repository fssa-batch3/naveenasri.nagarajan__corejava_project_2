package com.fssa.dynamicdesign.validation;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import com.fssa.dynamicdesign.validation.exception.InvalidArchitectException;

class TestValidateEducation {

	@Test
	void testValidEducation() {
		try {
			assertTrue(ArchitectValidator.validateEducation("Bachelor of Science"));
			System.out.println("Valid education test passed.");
		} catch (InvalidArchitectException e) {
			e.printStackTrace();
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
			fail();
		}
	}

	@Test
	void testInvalidNullEducation() {
		try {
			assertFalse(ArchitectValidator.validateEducation(null));
		} catch (InvalidArchitectException e) {
			// Correct exception type is caught
			System.out.println("Caught InvalidArchitectException for an invalid null education.");
			e.printStackTrace();
		}
	}

	@Test
	void testInvalidEmptyEducation() {
		try {
			assertFalse(ArchitectValidator.validateEducation(""));
		} catch (InvalidArchitectException e) {
			// Correct exception type is caught
			System.out.println("Caught InvalidArchitectException for an invalid empty education.");
			e.printStackTrace();
		}
	}

	@Test
	void testInvalidEducationWithNumbers() {
		try {
			assertFalse(ArchitectValidator.validateEducation("PhD in Physics 123"));
		} catch (InvalidArchitectException e) {
			// Correct exception type is caught
			System.out.println("Caught InvalidArchitectException for an invalid education with numbers.");
			e.printStackTrace();
		}
	}

	@Test
	void testInvalidEducationWithSpecialCharacters() {
		try {
			assertFalse(ArchitectValidator.validateEducation("High School Diploma @#$"));
		} catch (InvalidArchitectException e) {
			// Correct exception type is caught
			System.out.println("Caught InvalidArchitectException for an invalid education with special characters.");
			e.printStackTrace();
		}
	}
}
