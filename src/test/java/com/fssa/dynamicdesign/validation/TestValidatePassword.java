package com.fssa.dynamicdesign.validation;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import com.fssa.dynamicdesign.validation.exception.InvalidUserException;

 class TestValidatePassword {

    @Test
     void testValidPassword() {
        try {
            assertTrue(UserValidator.validatePassword("Password@123"));
            System.out.println("Valid password test passed.");
        } catch (InvalidUserException e) {
            fail("Caught InvalidUserException for a valid password.");
        }
    }

    @Test
     void testInvalidPasswordWithoutNumbers() {
        try {
            assertFalse(UserValidator.validatePassword("Password@"));
        } catch (InvalidUserException e) {
            System.out.println("Invalid password without numbers is not passed.");
            e.printStackTrace();
        }
    }

    @Test
     void testInvalidPasswordWithoutSpecialCharacters() {
        try {
            assertFalse(UserValidator.validatePassword("password123"));
        } catch (InvalidUserException e) {
            System.out.println("Invalid password without special characters is not passed.");
            e.printStackTrace();
        }
    }

    @Test
     void testInvalidPasswordWithoutCapitalLetters() {
        try {
            assertFalse(UserValidator.validatePassword("password123"));
        } catch (InvalidUserException e) {
            System.out.println("Invalid password without capital letters is not passed.");
            e.printStackTrace();
        }
    }

    @Test
     void testInvalidPasswordWithoutAnyLetters() {
        try {
            assertFalse(UserValidator.validatePassword(""));
        } catch (InvalidUserException e) {
            System.out.println("Invalid password without Any letters is not  passed.");
            e.printStackTrace();
        }
    }
    
    @Test
     void testInvalidPasswordWithoutSmallLetters() {
        try {
            assertFalse(UserValidator.validatePassword("PASSWORD@123"));
        } catch (InvalidUserException e) {
            System.out.println("Invalid password without small letters is not passed.");
            e.printStackTrace();
        }
    }

    @Test
     void testInvalidPasswordShorterLength() {
        try {
            assertFalse(UserValidator.validatePassword("Pas@123"));
        } catch (InvalidUserException e) {
            System.out.println("Invalid password shorter length is not passed.");
            e.printStackTrace();
        }
    }
}
