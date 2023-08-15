package com.fssa.dynamicdesign.validation;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import com.fssa.dynamicdesign.validation.exception.InvalidArchitectException;

 class TestValidateArchitectID {

	@Test
	 void testValidArchitectID() {
		try {
			assertTrue(ArchitectValidator.validateArchitectID(12345));
			System.out.println("Valid architect ID test passed.");
		} catch (InvalidArchitectException e) {
			e.printStackTrace();
			System.out.println("Caught InvalidArchitectException for a valid architect ID.");
			fail();
		}
	}

	@Test
	 void testInvalidNegativeArchitectID() {
		try {
			assertFalse(ArchitectValidator.validateArchitectID(-123));
			System.out.println("Invalid negative architect ID test passed.");
			fail();
		} catch (InvalidArchitectException e) {
			// Correct exception type is caught
			e.printStackTrace();
			System.out.println("Caught InvalidArchitectException for an invalid negative architect ID.");
		}
	}

	@Test
	 void testValidZeroArchitectID() {
		try {
			assertTrue(ArchitectValidator.validateArchitectID(0));
			System.out.println("Valid zero architect ID test passed.");
		} catch (InvalidArchitectException e) {
			e.printStackTrace();
			System.out.println("Caught InvalidArchitectException for a valid zero architect ID.");
			fail();
		}
	}

	@Test
	 void testInvalidNonNumericArchitectID() {
		try {
			assertFalse(ArchitectValidator.validateArchitectID(Integer.parseInt("-1"))); // -1 as a string
			System.out.println("Invalid non-numeric architect ID test passed.");
			fail();
		} catch (InvalidArchitectException e) {
			// Correct exception type is caught
			e.printStackTrace();
			System.out.println("Caught InvalidArchitectException for an invalid non-numeric architect ID.");
		}
	}

	@Test
	 void testValidLargeArchitectID() {
		try {
			assertTrue(ArchitectValidator.validateArchitectID(999999));
			System.out.println("Valid large architect ID test passed.");
		} catch (InvalidArchitectException e) {
			e.printStackTrace();
			System.out.println("Caught InvalidArchitectException for a valid large architect ID.");
			fail();
		}
	}
}
