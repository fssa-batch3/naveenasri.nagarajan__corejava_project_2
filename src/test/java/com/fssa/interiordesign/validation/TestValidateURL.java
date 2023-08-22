package com.fssa.interiordesign.validation;

import static org.junit.jupiter.api.Assertions.assertFalse;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import com.fssa.interiordesign.validation.ArchitectValidator;
import com.fssa.interiordesign.validation.exception.InvalidArchitectException;

 class TestValidateURL {

    @Test
     void testValidURL() {
        try {
            assertTrue(ArchitectValidator.validateURL("https://example.com"));
            System.out.println("Valid URL test passed.");
        } catch (InvalidArchitectException e) {
            e.printStackTrace();
            fail("Caught InvalidUserException for a valid URL.");
        }
    }

    @Test
     void testInvalidEmptyURL() {
        try {
            assertFalse(ArchitectValidator.validateURL(""));
            System.out.println("Invalid empty URL test passed.");
            fail();
        } catch (InvalidArchitectException e) {
            e.printStackTrace();
        }
    }

    @Test
     void testInvalidWhitespaceURL() {
        try {
            assertFalse(ArchitectValidator.validateURL("   "));
            System.out.println("Invalid WhiteSpace URL test passed.");
            fail();
        } catch (InvalidArchitectException e) {
            e.printStackTrace();
        }
    }
    
    @Test
     void testInvalidNullURL() {
        try {
            assertFalse(ArchitectValidator.validateURL(null));
            System.out.println("Invalid null URL test passed.");
            fail();
        } catch (InvalidArchitectException e) {
            e.printStackTrace();
        }
    }
}
