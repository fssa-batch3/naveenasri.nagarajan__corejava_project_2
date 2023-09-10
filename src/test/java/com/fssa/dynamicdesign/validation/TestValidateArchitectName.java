package com.fssa.dynamicdesign.validation;

import static org.junit.jupiter.api.Assertions.*;
import com.fssa.dynamicdesign.validation.exception.InvalidArchitectException;
import org.junit.jupiter.api.Test;

class TestValidateArchitectName {

    @Test
    void testValidArchitectName() {
        assertDoesNotThrow(() -> ArchitectValidator.validateName("ValidName"));
    }

    @Test
    void testValidArchitectNameWithNumbers() {
        assertDoesNotThrow(() -> ArchitectValidator.validateName("ValidName123"));
    }

    @Test
    void testInvalidArchitectNameStartingWithNumber() {
        assertThrows(InvalidArchitectException.class, () -> ArchitectValidator.validateName("123InvalidName"));
    }

    @Test
    void testInvalidArchitectNameShorterLength() {
        assertThrows(InvalidArchitectException.class, () -> ArchitectValidator.validateName("Ab"));
    }

    @Test
    void testInvalidArchitectNameLongerLength() {
        assertThrows(InvalidArchitectException.class, () -> ArchitectValidator.validateName("ThisIsAVeryLongNameThatExceedsTheLimit"));
    }

    @Test
    void testInvalidArchitectNameWithSpaces() {
        assertThrows(InvalidArchitectException.class, () -> ArchitectValidator.validateName("Invalid Name With Spaces"));
    }

    @Test
    void testInvalidArchitectNameWithSpecialCharacters() {
        assertThrows(InvalidArchitectException.class, () -> ArchitectValidator.validateName("Invalid$Name"));
    }

    @Test
    void testInvalidNullArchitectName() {
        assertThrows(InvalidArchitectException.class, () -> ArchitectValidator.validateName(null));
    }
}
