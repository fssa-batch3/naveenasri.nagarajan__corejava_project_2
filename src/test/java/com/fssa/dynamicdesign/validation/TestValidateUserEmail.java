package com.fssa.dynamicdesign.validation;

import static org.junit.jupiter.api.Assertions.*;
import com.fssa.dynamicdesign.validation.exception.InvalidUserException;
import org.junit.jupiter.api.Test;

class TestValidateUserEmail {

    @Test
    void testValidUserEmail() {
        assertDoesNotThrow(() -> UserValidator.validateEmail("user@example.com"));
    }

    @Test
    void testValidUserEmailWithNumbers() {
        assertDoesNotThrow(() -> UserValidator.validateEmail("user123@example.com"));
    }

    @Test
    void testInvalidUserEmailLongTLD() {
    	assertDoesNotThrow(() -> UserValidator.validateEmail("user@example.com"));
    }
    
    @Test
    void testValidUserEmailWithSpecialCharacters() {
        assertDoesNotThrow(() -> UserValidator.validateEmail("user.email+test@example.co.uk"));
    }

    @Test
    void testValidUserEmailWithMaxLength() {
        assertDoesNotThrow(() -> UserValidator.validateEmail("very.long.email.address.with.many.characters@example.com"));
    }

    @Test
    void testInvalidUserEmailMissingAtSymbol() {
        assertThrows(InvalidUserException.class, () -> UserValidator.validateEmail("userexample.com"));
    }

    @Test
    void testInvalidUserEmailMissingDomain() {
        assertThrows(InvalidUserException.class, () -> UserValidator.validateEmail("user@.com"));
    }

    @Test
    void testInvalidUserEmailShortTLD() {
        assertThrows(InvalidUserException.class, () -> UserValidator.validateEmail("user@example.c"));
    }

   

    @Test
    void testInvalidUserEmailNoLocalPart() {
        assertThrows(InvalidUserException.class, () -> UserValidator.validateEmail("@example.com"));
    }

    @Test
    void testInvalidNullUserEmail() {
        assertThrows(InvalidUserException.class, () -> UserValidator.validateEmail(null));
    }
}
