package com.fssa.dynamicdesign.validation;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import com.fssa.dynamicdesign.validation.exception.InvalidDesignException;

class TestValidateDesignArchitectId {
	 @Test
	    void testValidArchitectId() {
	        // A valid architect ID (non-negative)
	        int validArchitectId = 1;

	        // This should not throw an exception
	        assertDoesNotThrow(() -> DesignValidator.validateArchitectId(validArchitectId));
	    }

	    @Test
	    void testNegativeArchitectId() {
	        // Pass a negative architect ID, it should throw an InvalidDesignException
	        int negativeArchitectId = -2;
	        assertThrows(InvalidDesignException.class, () -> DesignValidator.validateArchitectId(negativeArchitectId));
	    }

	    @Test
	    void testZeroArchitectId() {
	        // Pass zero as an architect ID, it should not throw an exception
	        int zeroArchitectId = 0;
	        assertDoesNotThrow(() -> DesignValidator.validateArchitectId(zeroArchitectId));
	    }	
}
