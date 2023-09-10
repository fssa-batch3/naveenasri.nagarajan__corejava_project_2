package com.fssa.dynamicdesign.validation;

import static org.junit.jupiter.api.Assertions.*;
import com.fssa.dynamicdesign.validation.exception.InvalidArchitectException;
import org.junit.jupiter.api.Test;

class TestValidateArchitectPassword {

    @Test
    void testValidPassword() {
        assertDoesNotThrow(() -> ArchitectValidator.validatePassword("Passw0rd!@"));
    }

    @Test
    void testValidPasswordWithSpecialCharacters() {
        assertDoesNotThrow(() -> ArchitectValidator.validatePassword("Complex@Password123"));
    }

    @Test
    void testInvalidPasswordTooShort() {
        assertThrows(InvalidArchitectException.class, () -> ArchitectValidator.validatePassword("Short!"));
    }

    @Test
    void testInvalidPasswordNoUppercase() {
        assertThrows(InvalidArchitectException.class, () -> ArchitectValidator.validatePassword("lowercase123!"));
    }

    @Test
    void testInvalidPasswordNoLowercase() {
        assertThrows(InvalidArchitectException.class, () -> ArchitectValidator.validatePassword("UPPERCASE123!"));
    }

    @Test
    void testInvalidPasswordNoNumber() {
        assertThrows(InvalidArchitectException.class, () -> ArchitectValidator.validatePassword("NoNumber@"));
    }

    @Test
    void testInvalidPasswordNoSpecialCharacter() {
        assertThrows(InvalidArchitectException.class, () -> ArchitectValidator.validatePassword("NoSpecialCharacter123"));
    }

    @Test
    void testInvalidNullPassword() {
        assertThrows(InvalidArchitectException.class, () -> ArchitectValidator.validatePassword(null));
    }
}
