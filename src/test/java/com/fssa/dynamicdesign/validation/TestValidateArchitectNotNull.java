package com.fssa.dynamicdesign.validation;

import static org.junit.jupiter.api.Assertions.*;
import com.fssa.dynamicdesign.model.Architect;
import com.fssa.dynamicdesign.validation.exception.InvalidArchitectException;
import org.junit.jupiter.api.Test;

class TestValidateArchitectNotNull {

    @Test
    void testValidArchitect() {
        assertDoesNotThrow(() -> ArchitectValidator.validateArchitectNotNull(new Architect()));
    }

    @Test
    void testInvalidNullArchitect() {
        assertThrows(InvalidArchitectException.class, () -> ArchitectValidator.validateArchitectNotNull(null));
    }
}
