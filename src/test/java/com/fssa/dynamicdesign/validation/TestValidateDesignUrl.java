package com.fssa.dynamicdesign.validation;

import static org.junit.jupiter.api.Assertions.*;

import com.fssa.dynamicdesign.validation.exception.InvalidDesignException;
import org.junit.jupiter.api.Test;

class TestValidateDesignUrl {

    @Test
    void testValidDesignUrl() {
        // A valid non-empty design URL
        String validDesignUrl = "https://example.com/design123";

        // This should not throw an exception
        assertDoesNotThrow(() -> DesignValidator.validateDesignUrl(validDesignUrl));
    }

    @Test
    void testNullDesignUrl() {
        // Pass a null design URL, it should throw an InvalidDesignException
        assertThrows(InvalidDesignException.class, () -> DesignValidator.validateDesignUrl(null));
    }

    @Test
    void testEmptyDesignUrl() {
        // Pass an empty design URL, it should throw an InvalidDesignException
        assertThrows(InvalidDesignException.class, () -> DesignValidator.validateDesignUrl(""));
    }

    @Test
    void testWhitespaceDesignUrl() {
        // Pass a design URL with only whitespace characters, it should throw an InvalidDesignException
        assertThrows(InvalidDesignException.class, () -> DesignValidator.validateDesignUrl("    "));
    }
}

