package com.fssa.dynamicdesign.validation;

import static org.junit.jupiter.api.Assertions.*;
import com.fssa.dynamicdesign.validation.exception.InvalidArchitectException;
import org.junit.jupiter.api.Test;

class TestValidateArchitectAddress {

    @Test
    void testValidAddress() {
        assertDoesNotThrow(() -> ArchitectValidator.validateAddress("123 Main Street"));
    }

    @Test
    void testValidAddressWithWhitespace() {
        assertDoesNotThrow(() -> ArchitectValidator.validateAddress("  456 Elm Avenue  "));
    }

    @Test
    void testInvalidEmptyAddress() {
        assertThrows(InvalidArchitectException.class, () -> ArchitectValidator.validateAddress(""));
    }

    @Test
    void testInvalidNullAddress() {
        assertThrows(InvalidArchitectException.class, () -> ArchitectValidator.validateAddress(null));
    }

    @Test
    void testInvalidWhitespaceAddress() {
        assertThrows(InvalidArchitectException.class, () -> ArchitectValidator.validateAddress("     "));
    }
}
