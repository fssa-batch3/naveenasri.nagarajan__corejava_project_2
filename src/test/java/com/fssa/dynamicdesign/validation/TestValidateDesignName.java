package com.fssa.dynamicdesign.validation;

import static org.junit.jupiter.api.Assertions.*;

import com.fssa.dynamicdesign.validation.exception.InvalidDesignException;
import org.junit.jupiter.api.Test;

class TestValidateDesignName {

    @Test
    void testValidDesignName() {
        // A valid non-empty design name
        String validDesignName = "Sample Design Name";

        // This should not throw an exception
        assertDoesNotThrow(() -> DesignValidator.validateDesignName(validDesignName));
    }

    @Test
    void testNullDesignName() {
        // Pass a null design name, it should throw an InvalidDesignException
        assertThrows(InvalidDesignException.class, () -> DesignValidator.validateDesignName(null));
    }

    @Test
    void testEmptyDesignName() {
        // Pass an empty design name, it should throw an InvalidDesignException
        assertThrows(InvalidDesignException.class, () -> DesignValidator.validateDesignName(""));
    }

    @Test
    void testWhitespaceDesignName() {
        // Pass a design name with only whitespace characters, it should throw an InvalidDesignException
        assertThrows(InvalidDesignException.class, () -> DesignValidator.validateDesignName("    "));
    }
}
