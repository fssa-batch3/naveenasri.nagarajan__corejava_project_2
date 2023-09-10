package com.fssa.dynamicdesign.validation;

import static org.junit.jupiter.api.Assertions.*;

import com.fssa.dynamicdesign.validation.exception.InvalidDesignException;
import org.junit.jupiter.api.Test;

class TestValidateDesignDescription {

    @Test
    void testValidDescription() {
        // A valid description with a length between 45 and 180 characters
        String validDescription = "This is a valid description that meets the length requirements.";

        // This should not throw an exception
        assertDoesNotThrow(() -> DesignValidator.validateDesignDescription(validDescription));
    }

    @Test
    void testNullDescription() {
        // Pass a null description, it should throw an InvalidDesignException
        assertThrows(InvalidDesignException.class, () -> DesignValidator.validateDesignDescription(null));
    }

    @Test
    void testEmptyDescription() {
        // Pass an empty description, it should throw an InvalidDesignException
        assertThrows(InvalidDesignException.class, () -> DesignValidator.validateDesignDescription(""));
    }

    @Test
    void testShortDescription() {
        // Pass a description shorter than 45 characters, it should throw an InvalidDesignException
        String shortDescription = "Short description.";
        assertThrows(InvalidDesignException.class, () -> DesignValidator.validateDesignDescription(shortDescription));
    }

    @Test
    void testLongDescription() {
        // Pass a description longer than 180 characters, it should throw an InvalidDesignException
        String longDescription = "This is a very long description that exceeds the length limit of 180 characters. This is a very long description that exceeds the length limit of 180 characters. This is a very long description that exceeds the length limit of 180 characters.";
        assertThrows(InvalidDesignException.class, () -> DesignValidator.validateDesignDescription(longDescription));
    }
}

