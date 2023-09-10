package com.fssa.dynamicdesign.validation;

import static org.junit.jupiter.api.Assertions.*;
import com.fssa.dynamicdesign.validation.exception.InvalidArchitectException;
import org.junit.jupiter.api.Test;

class TestValidateArchitectGender {

    @Test
    void testValidMaleGender() {
        assertDoesNotThrow(() -> ArchitectValidator.validateGender("Male"));
    }

    @Test
    void testValidFemaleGender() {
        assertDoesNotThrow(() -> ArchitectValidator.validateGender("Female"));
    }

    @Test
    void testValidOtherGender() {
        assertDoesNotThrow(() -> ArchitectValidator.validateGender("Other"));
    }

    @Test
    void testInvalidNullGender() {
        assertThrows(InvalidArchitectException.class, () -> ArchitectValidator.validateGender(null));
    }

    @Test
    void testInvalidNonAllowedGender() {
        assertThrows(InvalidArchitectException.class, () -> ArchitectValidator.validateGender("NonAllowed"));
    }

    @Test
    void testInvalidMixedCaseGender() {
        assertThrows(InvalidArchitectException.class, () -> ArchitectValidator.validateGender("mAle"));
    }
}
