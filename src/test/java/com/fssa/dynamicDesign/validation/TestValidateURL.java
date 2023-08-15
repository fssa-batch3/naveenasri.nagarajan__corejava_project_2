package com.fssa.dynamicdesign.validation;

import static org.junit.jupiter.api.Assertions.assertFalse;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import com.fssa.dynamicdesign.validation.exception.InvalidArchitectException;

public class TestValidateURL {

    @Test
    public void testValidURL() {
        try {
            assertTrue(ArchitectValidator.validateURL("https://example.com"));
            System.out.println("Valid URL test passed.");
        } catch (InvalidArchitectException e) {
            e.printStackTrace();
            fail("Caught InvalidUserException for a valid URL.");
        }
    }

    @Test
    public void testInvalidEmptyURL() {
        try {
            assertFalse(ArchitectValidator.validateURL(""));
            System.out.println("Invalid empty URL test passed.");
            fail();
        } catch (InvalidArchitectException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testInvalidWhitespaceURL() {
        try {
            assertFalse(ArchitectValidator.validateURL("   "));
            System.out.println("Invalid WhiteSpace URL test passed.");
            fail();
        } catch (InvalidArchitectException e) {
            e.printStackTrace();
        }
    }
    
    @Test
    public void testInvalidNullURL() {
        try {
            assertFalse(ArchitectValidator.validateURL(null));
            System.out.println("Invalid null URL test passed.");
            fail();
        } catch (InvalidArchitectException e) {
            e.printStackTrace();
        }
    }
}
