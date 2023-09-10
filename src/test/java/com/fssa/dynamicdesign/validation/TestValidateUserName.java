package com.fssa.dynamicdesign.validation;

import static org.junit.jupiter.api.Assertions.*;

import com.fssa.dynamicdesign.validation.exception.InvalidUserException;
import org.junit.jupiter.api.Test;

class TestValidateUserName {

    @Test
    void testValidUserName() {
        assertDoesNotThrow(() -> UserValidator.validateName("ValidUserName"));
    }

    @Test
    void testValidUserNameWithNumbers() {
        assertDoesNotThrow(() -> UserValidator.validateName("User123"));
    }

    @Test
    void testValidUserNameWithUnderscore() {
        assertDoesNotThrow(() -> UserValidator.validateName("User_Name"));
    }

    @Test
    void testInvalidUserNameStartingWithNumber() {
        assertThrows(InvalidUserException.class, () -> UserValidator.validateName("123InvalidUserName"));
    }

    @Test
    void testInvalidUserNameShorterLength() {
        assertThrows(InvalidUserException.class, () -> UserValidator.validateName("Ab"));
    }

    @Test
    void testInvalidUserNameLongerLength() {
        assertThrows(InvalidUserException.class, () -> UserValidator.validateName("ThisIsAVeryLongUserNameThatExceedsTheLimit"));
    }

    @Test
    void testInvalidUserNameWithSpaces() {
        assertThrows(InvalidUserException.class, () -> UserValidator.validateName("Invalid User Name"));
    }

    @Test
    void testInvalidUserNameWithSpecialCharacters() {
        assertThrows(InvalidUserException.class, () -> UserValidator.validateName("Invalid$UserName"));
    }

    @Test
    void testInvalidNullUserName() {
        assertThrows(InvalidUserException.class, () -> UserValidator.validateName(null));
    }
}
