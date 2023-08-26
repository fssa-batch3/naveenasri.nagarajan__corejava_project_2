package com.fssa.dynamicdesign.validation;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import com.fssa.dynamicdesign.validation.ArchitectValidator;
import com.fssa.dynamicdesign.validation.exception.InvalidArchitectException;

 class TestValidateArchitectID {

	@Test
	 void testValidArchitectID() {
		try {
			assertTrue(ArchitectValidator.validateArchitectID(12345));
			System.out.println("Valid architect ID test passed.");
		} catch (InvalidArchitectException e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	 void testInvalidNegativeArchitectID() {
		try {
			assertFalse(ArchitectValidator.validateArchitectID(-123));
		} catch (InvalidArchitectException e) {
			// Correct exception type is caught
			System.out.println("Caught InvalidArchitectException for an invalid negative architect ID.");
			e.printStackTrace();
		}
	}

	@Test
	 void testValidZeroArchitectID() {
		try {
			assertTrue(ArchitectValidator.validateArchitectID(0));
			System.out.println("Valid zero architect ID test passed.");
		} catch (InvalidArchitectException e) {
			System.out.println("Caught InvalidArchitectException for a valid zero architect ID.");
			fail();
		}
	}

	@Test
	 void testInvalidNonNumericArchitectID() {
		try {
			assertFalse(ArchitectValidator.validateArchitectID(Integer.parseInt("-1"))); // -1 as a string
		} catch (InvalidArchitectException e) {
			// Correct exception type is caught
			System.out.println("Caught InvalidArchitectException for an invalid non-numeric architect ID.");
			e.printStackTrace();
		}
	}

	@Test
	 void testValidLargeArchitectID() {
		try {
			assertTrue(ArchitectValidator.validateArchitectID(999999));
			System.out.println("Valid large architect ID test passed.");
		} catch (InvalidArchitectException e) {
			System.out.println("Caught InvalidArchitectException for a valid large architect ID.");
			fail();
		}
	}
}
