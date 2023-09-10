package com.fssa.dynamicdesign.service;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.fssa.dynamicdesign.model.Architect;
import com.fssa.dynamicdesign.service.exception.ServiceException;

class TestArchitectLoginFeature {

    @Test
    void testLoginSuccess() {
        ArchitectService architectService = new ArchitectService();
        String email = "ajaiii@example.com";
        String password = "Navee@123";
        Architect architect1 = new Architect(email, password);
        assertDoesNotThrow(() -> assertTrue(architectService.loginArchitect(architect1, email)));
    }

    @Test
    void testEmailNotExists() {
        ArchitectService architectService = new ArchitectService();
        String email = "nonexisting@gmail.com";
        String password = "Password@796";
        Architect architect2 = new Architect(email, password);
        assertThrows(ServiceException.class, () -> architectService.loginArchitect(architect2, email));
    }

    @Test
    void testLoginEmailCheck() {
        ArchitectService architectService = new ArchitectService();
        String email = "invalidemail"; // Invalid email format
        String password = "Architect@123";
        Architect architect1 = new Architect(email, password);
        assertThrows(ServiceException.class, () -> architectService.loginArchitect(architect1, email));
    }

    @Test
    void testLoginNullArchitect() {
        ArchitectService architectService = new ArchitectService();
        String email = null; // Invalid email format
        String password = "Architect@123";
        Architect architect1 = new Architect(email, password);
        assertThrows(ServiceException.class, () -> architectService.loginArchitect(architect1, email));
    }
}
