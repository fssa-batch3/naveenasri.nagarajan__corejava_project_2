package com.fssa.dynamicDesign.validation;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.fssa.dynamicDesign.validation.ArchitectValidator;
import com.fssa.dynamicDesign.validation.exception.InvalidArchitectException;

public class TestValidateAddress {

	@Test
	public void testValidAddress() {
		try {
			assertTrue(ArchitectValidator.validateAddress("123 Main Street"));
			System.out.println("Valid address test passed.");
		} catch (InvalidArchitectException e) {
			e.printStackTrace();
			System.out.println("Caught InvalidArchitectException for a valid address.");
		}
	}

	@Test
	public void testValidAddressWithSpecialCharacters() {
		try {
			assertTrue(ArchitectValidator.validateAddress("Apt #4B, 456 Elm Ave"));
			System.out.println("Valid address with special characters test passed.");
		} catch (InvalidArchitectException e) {
			e.printStackTrace();
			System.out.println("Caught InvalidArchitectException for a valid address with special characters.");
		}
	}

	@Test
	public void testInvalidNullAddress() {
		try {
			assertFalse(ArchitectValidator.validateAddress(null));
			System.out.println("Invalid null address test passed.");
		} catch (InvalidArchitectException e) {
			// Correct exception type is caught
			System.out.println("Caught InvalidArchitectException for an invalid null address.");
		}
	}

	@Test
	public void testInvalidEmptyAddress() {
		try {
			assertFalse(ArchitectValidator.validateAddress(""));
			System.out.println("Invalid empty address test passed.");
		} catch (InvalidArchitectException e) {
			// Correct exception type is caught
			System.out.println("Caught InvalidArchitectException for an invalid empty address.");
		}
	}

	@Test
	public void testInvalidWhitespaceOnlyAddress() {
		try {
			assertFalse(ArchitectValidator.validateAddress("   "));
			System.out.println("Invalid whitespace-only address test passed.");
		} catch (InvalidArchitectException e) {
			// Correct exception type is caught
			System.out.println("Caught InvalidArchitectException for an invalid whitespace-only address.");
		}
	}
}
