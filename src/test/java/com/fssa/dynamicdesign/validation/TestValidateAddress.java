package com.fssa.dynamicdesign.validation;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import com.fssa.dynamicdesign.validation.exception.InvalidArchitectException;

 class TestValidateAddress {

	@Test
	 void testValidAddress() {
		try {
			assertTrue(ArchitectValidator.validateAddress("123 Main Street"));
			System.out.println("Valid address test passed.");
		} catch (InvalidArchitectException e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	 void testValidAddressWithSpecialCharacters() {
		try {
			assertTrue(ArchitectValidator.validateAddress("Apt #4B, 456 Elm Ave"));
			System.out.println("Valid address with special characters test passed.");
		} catch (InvalidArchitectException e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	 void testInvalidNullAddress() {
		try {
			assertFalse(ArchitectValidator.validateAddress(null));
		} catch (InvalidArchitectException e) {
			// Correct exception type is caught
			System.out.println("Caught InvalidArchitectException for an invalid null address.");
			e.printStackTrace();
		}
	}

	@Test
	 void testInvalidEmptyAddress() {
		try {
			assertFalse(ArchitectValidator.validateAddress(""));
		} catch (InvalidArchitectException e) {
			// Correct exception type is caught
			System.out.println("Caught InvalidArchitectException for an invalid empty address.");
			e.printStackTrace();
		}
	}

	@Test
	 void testInvalidWhitespaceOnlyAddress() {
		try {
			assertFalse(ArchitectValidator.validateAddress("   "));
		} catch (InvalidArchitectException e) {
			// Correct exception type is caught
			System.out.println("Caught InvalidArchitectException for an invalid whitespace-only address.");
			e.printStackTrace();
		}
	}
}
