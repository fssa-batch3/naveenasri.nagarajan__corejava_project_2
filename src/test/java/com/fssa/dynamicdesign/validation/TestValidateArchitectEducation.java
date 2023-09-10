package com.fssa.dynamicdesign.validation;

import static org.junit.jupiter.api.Assertions.*;
import com.fssa.dynamicdesign.validation.exception.InvalidArchitectException;
import org.junit.jupiter.api.Test;

class TestValidateArchitectEducation {

    @Test
    void testValidEducation() {
        assertDoesNotThrow(() -> ArchitectValidator.validateEducation("Bachelor of Architecture"));
    }

    @Test
    void testValidEducationWithWhitespace() {
        assertDoesNotThrow(() -> ArchitectValidator.validateEducation("   Master of Design   "));
    }

    @Test
    void testInvalidEmptyEducation() {
        assertThrows(InvalidArchitectException.class, () -> ArchitectValidator.validateEducation(""));
    }

    @Test
    void testInvalidNullEducation() {
        assertThrows(InvalidArchitectException.class, () -> ArchitectValidator.validateEducation(null));
    }

    @Test
    void testInvalidEducationWithNumbers() {
        assertThrows(InvalidArchitectException.class, () -> ArchitectValidator.validateEducation("Education123"));
    }

    @Test
    void testInvalidEducationWithSpecialCharacters() {
        assertThrows(InvalidArchitectException.class, () -> ArchitectValidator.validateEducation("Education@Design"));
    }
}
