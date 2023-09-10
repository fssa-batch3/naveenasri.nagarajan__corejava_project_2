package com.fssa.dynamicdesign.validation;

import static org.junit.jupiter.api.Assertions.*;

import com.fssa.dynamicdesign.validation.exception.InvalidDesignException;
import org.junit.jupiter.api.Test;

class TestValidatePrice {

    @Test
    void testValidPrice() {
        // A valid non-negative price
        double validPrice = 100.0;

        // This should not throw an exception
        assertDoesNotThrow(() -> DesignValidator.validatePrice(validPrice));
    }

    @Test
    void testNegativePrice() {
        // Pass a negative price, it should throw an InvalidDesignException
        assertThrows(InvalidDesignException.class, () -> DesignValidator.validatePrice(-50.0));
    }
}
