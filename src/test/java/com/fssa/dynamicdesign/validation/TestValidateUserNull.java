package com.fssa.dynamicdesign.validation;

import static org.junit.jupiter.api.Assertions.*;

import com.fssa.dynamicdesign.model.User;
import com.fssa.dynamicdesign.validation.exception.InvalidUserException;
import org.junit.jupiter.api.Test;

class TestValidateUserNull {

    @Test
    void testValidUser() {
        assertDoesNotThrow(() -> UserValidator.validateUserNull(new User()));
    }

    @Test
    void testInvalidNullUser() {
        assertThrows(InvalidUserException.class, () -> UserValidator.validateUserNull(null));
    }
}
