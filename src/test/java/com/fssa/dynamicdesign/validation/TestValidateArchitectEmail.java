package com.fssa.dynamicdesign.validation;

import static org.junit.jupiter.api.Assertions.*;
import com.fssa.dynamicdesign.validation.exception.InvalidArchitectException;
import org.junit.jupiter.api.Test;

class TestValidateArchitectEmail {

    @Test
    void testValidEmail() {
        assertDoesNotThrow(() -> ArchitectValidator.validateEmail("valid.email@example.com"));
    }

    @Test
    void testValidEmailWithNumbers() {
        assertDoesNotThrow(() -> ArchitectValidator.validateEmail("user123@example.co"));
    }

    @Test
    void testValidEmailWithSpecialCharacters() {
        assertDoesNotThrow(() -> ArchitectValidator.validateEmail("user@example.co.uk"));
    }

    @Test
    void testInvalidEmailNoAtSymbol() {
        assertThrows(InvalidArchitectException.class, () -> ArchitectValidator.validateEmail("invalid.email.com"));
    }

    @Test
    void testInvalidEmailInvalidDomain() {
        assertThrows(InvalidArchitectException.class, () -> ArchitectValidator.validateEmail("user@invalid"));
    }

    @Test
    void testInvalidEmailNoTld() {
        assertThrows(InvalidArchitectException.class, () -> ArchitectValidator.validateEmail("user@invalid."));
    }

    @Test
    void testInvalidNullEmail() {
        assertThrows(InvalidArchitectException.class, () -> ArchitectValidator.validateEmail(null));
    }
}
