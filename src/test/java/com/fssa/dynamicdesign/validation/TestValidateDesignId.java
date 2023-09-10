package com.fssa.dynamicdesign.validation;

import static org.junit.jupiter.api.Assertions.*;

import com.fssa.dynamicdesign.validation.exception.InvalidDesignException;
import org.junit.jupiter.api.Test;

class TestValidateDesignId {

    @Test
    void testValidDesignId() {
        // A valid design ID (non-negative)
        int validDesignId = 1;

        // This should not throw an exception
        assertDoesNotThrow(() -> DesignValidator.validateDesignId(validDesignId));
    }

    @Test
    void testNegativeDesignId() {
        // Pass a negative design ID, it should throw an InvalidDesignException
        int negativeDesignId = -2;
        assertThrows(InvalidDesignException.class, () -> DesignValidator.validateDesignId(negativeDesignId));
    }

    @Test
    void testZeroDesignId() {
        // Pass zero as a design ID, it should not throw an exception
        int zeroDesignId = 0;
        assertDoesNotThrow(() -> DesignValidator.validateDesignId(zeroDesignId));
    }
}
