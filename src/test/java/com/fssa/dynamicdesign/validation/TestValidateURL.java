package com.fssa.dynamicdesign.validation;

import static org.junit.jupiter.api.Assertions.assertFalse;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import com.fssa.dynamicdesign.validation.ArchitectValidator;
import com.fssa.dynamicdesign.validation.exception.InvalidArchitectException;

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
        	boolean valid = ArchitectValidator.validateURL("");
            assertFalse(valid);
        } catch (InvalidArchitectException e) {
            System.out.println("Invalid empty URL is not passed.");
            e.printStackTrace();
        }
    }
    

    @Test
     void testInvalidWhitespaceURL() {
        try {
            assertFalse(ArchitectValidator.validateURL("   "));
        } catch (InvalidArchitectException e) {
            System.out.println("Invalid WhiteSpace URL is not passed.");
            e.printStackTrace();
        }
    }
    
    @Test
     void testInvalidNullURL() {
        try {
            assertFalse(ArchitectValidator.validateURL(null));
        } catch (InvalidArchitectException e) {
            System.out.println("Invalid null URL is not passed.");
            e.printStackTrace();
        }
    }
}
