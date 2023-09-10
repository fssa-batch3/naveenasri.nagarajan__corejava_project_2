package com.fssa.dynamicdesign.validation;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import com.fssa.dynamicdesign.model.Design;
import com.fssa.dynamicdesign.validation.exception.InvalidDesignException;

class TestValidateDesignNull {

    @Test
    void testValidDesign() {
        // Create a valid Design object
        // This should not throw an exception
        assertDoesNotThrow(() -> DesignValidator.validateDesignNull(new Design()));
    }
    
    @Test
    void testNullDesign() {
        // Pass null as the Design object, it should throw an InvalidDesignException
        assertThrows(InvalidDesignException.class, () -> DesignValidator.validateDesignNull(null));
    }
}
