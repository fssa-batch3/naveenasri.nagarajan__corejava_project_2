package com.fssa.dynamicdesign.validation;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.fssa.dynamicdesign.validation.exception.InvalidArchitectException;
import org.junit.jupiter.api.Test;

class TestValidateArchitectURL {

    @Test
    void testValidURL() {
        assertDoesNotThrow(() -> ArchitectValidator.validateURL("https://example.com", "URL is valid"));
    }

    @Test
    void testValidURLWithWhitespace() {
        assertDoesNotThrow(() -> ArchitectValidator.validateURL("   https://example.com   ", "URL is valid with space"));
    }

    @Test
    void testInvalidEmptyURL() {
        assertThrows(InvalidArchitectException.class, () -> ArchitectValidator.validateURL("", "URL is empty"));
    }

    @Test
    void testInvalidNullURL() {
        assertThrows(InvalidArchitectException.class, () -> ArchitectValidator.validateURL(null, "URL is null"));
    }

    @Test
    void testInvalidWhitespaceURL() {
        assertThrows(InvalidArchitectException.class, () -> ArchitectValidator.validateURL("     ", "URL is empty"));
    }
}
