package com.fssa.dynamicdesign.validation;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import com.fssa.dynamicdesign.validation.exception.InvalidArchitectException;

class TestValidateArchitectID {

    @Test
    void testValidArchitectID() {
        assertDoesNotThrow(() -> ArchitectValidator.validateArchitectID(12345));
    }

    @Test
    void testInvalidNegativeArchitectID() {
        assertThrows(InvalidArchitectException.class, () -> ArchitectValidator.validateArchitectID(-123));
    }

    @Test
    void testValidZeroArchitectID() {
        assertDoesNotThrow(() -> ArchitectValidator.validateArchitectID(0));
    }

    @Test
    void testInvalidNonNumericArchitectID() {
        assertThrows(InvalidArchitectException.class, () -> ArchitectValidator.validateArchitectID(Integer.parseInt("-1")));
    }

    @Test
    void testValidLargeArchitectID() {
        assertDoesNotThrow(() -> ArchitectValidator.validateArchitectID(999999));
    }
}
