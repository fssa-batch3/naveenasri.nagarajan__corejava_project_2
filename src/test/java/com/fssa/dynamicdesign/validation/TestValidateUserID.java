package com.fssa.dynamicdesign.validation;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import com.fssa.dynamicdesign.validation.exception.InvalidUserException;

class TestValidateUserID {

    @Test
    void testValidUserID() {
        assertDoesNotThrow(() -> UserValidator.validateUserID(12345));
    }

    @Test
    void testValidUserIDWithMaxValue() {
        assertDoesNotThrow(() -> UserValidator.validateUserID(Integer.MAX_VALUE));
    }

    @Test
    void testvalidZeroUserID() {
        assertDoesNotThrow(() -> UserValidator.validateUserID(0));
    }
    @Test
    void testInvalidNegativeUserID() {
        assertThrows(InvalidUserException.class, () -> UserValidator.validateUserID(-123));
    }

    @Test
    void testInvalidNonNumericUserID() {
        assertThrows(InvalidUserException.class, () -> UserValidator.validateUserID(Integer.parseInt("-1")));
    }
 

    
}
