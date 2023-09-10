package com.fssa.dynamicdesign.validation;

import static org.junit.jupiter.api.Assertions.*;
import com.fssa.dynamicdesign.validation.exception.InvalidArchitectException;
import org.junit.jupiter.api.Test;

class TestValidateArchitectExperience {

    @Test
    void testValidExperience() {
        assertDoesNotThrow(() -> ArchitectValidator.validateExperience(5));
    }

    @Test
    void testValidExperienceWithMaxValue() {
        assertDoesNotThrow(() -> ArchitectValidator.validateExperience(99));
    }

    @Test
    void testInvalidNegativeExperience() {
        assertThrows(InvalidArchitectException.class, () -> ArchitectValidator.validateExperience(-5));
    }

    @Test
    void testInvalidExperienceTooLong() {
        assertThrows(InvalidArchitectException.class, () -> ArchitectValidator.validateExperience(100));
    }

 
}
