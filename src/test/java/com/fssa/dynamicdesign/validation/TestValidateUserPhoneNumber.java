package com.fssa.dynamicdesign.validation;

import static org.junit.jupiter.api.Assertions.*;
import com.fssa.dynamicdesign.validation.exception.InvalidUserException;
import org.junit.jupiter.api.Test;

class TestValidateUserPhoneNumber {

    @Test
    void testValidUserPhoneNumber() {
        assertDoesNotThrow(() -> UserValidator.validatePhoneNumber("9876543210"));
    }

    @Test
    void testValidUserPhoneNumberstartsix() {
        assertDoesNotThrow(() -> UserValidator.validatePhoneNumber("6876543210"));
    }
    
    @Test
    void testValidUserPhoneNumberWithCountryCode() {
        assertDoesNotThrow(() -> UserValidator.validatePhoneNumber("+919876543210"));
    }
    
    @Test
    void testValidUserPhoneNumberWithCountryCodestartsix() {
        assertDoesNotThrow(() -> UserValidator.validatePhoneNumber("+916876543210"));
    }

    @Test
    void testInvalidUserPhoneNumberTooShort() {
        assertThrows(InvalidUserException.class, () -> UserValidator.validatePhoneNumber("12345"));
    }

    @Test
    void testInvalidUserPhoneNumberTooLong() {
        assertThrows(InvalidUserException.class, () -> UserValidator.validatePhoneNumber("1234567890123456"));
    }

    @Test
    void testInvalidUserPhoneNumberInvalidFormat() {
        assertThrows(InvalidUserException.class, () -> UserValidator.validatePhoneNumber("12345abcde"));
    }

    @Test
    void testInvalidNullUserPhoneNumber() {
        assertThrows(InvalidUserException.class, () -> UserValidator.validatePhoneNumber(null));
    }
}
