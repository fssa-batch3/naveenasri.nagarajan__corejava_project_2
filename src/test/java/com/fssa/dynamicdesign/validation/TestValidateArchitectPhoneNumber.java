package com.fssa.dynamicdesign.validation;

import static org.junit.jupiter.api.Assertions.*;
import com.fssa.dynamicdesign.validation.exception.InvalidArchitectException;
import org.junit.jupiter.api.Test;

class TestValidateArchitectPhoneNumber {

    @Test
    void testValidPhoneNumber() {
        assertDoesNotThrow(() -> ArchitectValidator.validatePhoneNumber("+919876543210"));
    }

    @Test
    void testValidPhoneNumberWithoutCountryCode() {
        assertDoesNotThrow(() -> ArchitectValidator.validatePhoneNumber("9876543210"));
    }

    @Test
    void testInvalidPhoneNumberInvalidFormat() {
        assertThrows(InvalidArchitectException.class, () -> ArchitectValidator.validatePhoneNumber("12345"));
    }

    @Test
    void testInvalidPhoneNumberInvalidPrefix() {
        assertThrows(InvalidArchitectException.class, () -> ArchitectValidator.validatePhoneNumber("+921234567890"));
    }

    @Test
    void testInvalidPhoneNumberShorterLength() {
        assertThrows(InvalidArchitectException.class, () -> ArchitectValidator.validatePhoneNumber("+9198765"));
    }

    @Test
    void testInvalidPhoneNumberLongerLength() {
        assertThrows(InvalidArchitectException.class, () -> ArchitectValidator.validatePhoneNumber("+9198765432100"));
    }

    @Test
    void testInvalidPhoneNumberWithLetters() {
        assertThrows(InvalidArchitectException.class, () -> ArchitectValidator.validatePhoneNumber("+91987abcde"));
    }

    @Test
    void testInvalidNullPhoneNumber() {
        assertThrows(InvalidArchitectException.class, () -> ArchitectValidator.validatePhoneNumber(null));
    }
}
