package com.fssa.dynamicdesign.validation;

import static org.junit.jupiter.api.Assertions.*;
import com.fssa.dynamicdesign.validation.exception.InvalidUserException;
import org.junit.jupiter.api.Test;

class TestValidateUserPassword {

    @Test
    void testValidUserPassword() {
        assertDoesNotThrow(() -> UserValidator.validatePassword("ValidPass123@"));
    }

    @Test
    void testValidUserPasswordWithMaxLength() {
        assertDoesNotThrow(() -> UserValidator.validatePassword("VerySecurePassword123@#$%^&*"));
    }

    @Test
    void testInvalidUserPasswordNoLowerCase() {
        assertThrows(InvalidUserException.class, () -> UserValidator.validatePassword("UPPERCASE123@"));
    }

    @Test
    void testInvalidUserPasswordNoUpperCase() {
        assertThrows(InvalidUserException.class, () -> UserValidator.validatePassword("lowercase123@"));
    }

    @Test
    void testInvalidUserPasswordNoDigit() {
        assertThrows(InvalidUserException.class, () -> UserValidator.validatePassword("NoDigit@"));
    }

    @Test
    void testInvalidUserPasswordNoSpecialCharacter() {
        assertThrows(InvalidUserException.class, () -> UserValidator.validatePassword("NoSpecialCharacter123"));
    }

    @Test
    void testInvalidUserPasswordShorterLength() {
        assertThrows(InvalidUserException.class, () -> UserValidator.validatePassword("Short1@"));
    }

    @Test
    void testInvalidNullUserPassword() {
        assertThrows(InvalidUserException.class, () -> UserValidator.validatePassword(null));
    }
}
