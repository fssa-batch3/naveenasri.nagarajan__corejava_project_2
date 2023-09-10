package com.fssa.dynamicdesign.validation;

import static org.junit.jupiter.api.Assertions.*;

import com.fssa.dynamicdesign.validation.exception.InvalidDesignException;
import org.junit.jupiter.api.Test;

class TestValidateNoOfRooms {

    @Test
    void testValidNoOfRooms() {
        // A valid number of rooms (non-negative)
        int validNoOfRooms = 5;

        // This should not throw an exception
        assertDoesNotThrow(() -> DesignValidator.validateNoOfRooms(validNoOfRooms));
    }

    @Test
    void testNegativeNoOfRooms() {
        // Pass a negative number of rooms, it should throw an InvalidDesignException
        int negativeNoOfRooms = -2;
        assertThrows(InvalidDesignException.class, () -> DesignValidator.validateNoOfRooms(negativeNoOfRooms));
    }
}

