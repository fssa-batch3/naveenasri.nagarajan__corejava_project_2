package com.fssa.dynamicdesign.service;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

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
        try {
            assertTrue(architectService.loginArchitect(architect1, email), "Login should succeed.");
        } catch (ServiceException e) {
            fail("Unexpected ServiceException: " + e.getMessage());
        }
    }

    @Test
    void testEmailNotExists() {
        ArchitectService architectService = new ArchitectService();
        String email = "nonexisting@gmail.com";
        String password = "Password@796";
        Architect architect2 = new Architect(email, password);
        try {
            assertFalse(architectService.loginArchitect(architect2, email), "Login should fail for non-existing email.");
        } catch (ServiceException e) {
        	e.printStackTrace();
        }
    }

    @Test
    void testLoginEmailCheck() {
        ArchitectService architectService = new ArchitectService();
        String email = "invalidemail"; // Invalid email format
        String password = "Architect@123";
        Architect architect1 = new Architect(email, password);
        try {
            assertFalse(architectService.loginArchitect(architect1, email), "Login should fail for invalid email format.");
        } catch (ServiceException e) {
        	e.printStackTrace();
        }
    }

    @Test
    void testLoginNullArchitect() {
        ArchitectService architectService = new ArchitectService();
        String email = null; // Invalid email format
        String password = "Architect@123";
        Architect architect1 = new Architect(email, password);
        try {
            assertFalse(architectService.loginArchitect(architect1, email), "Login should fail for null architect.");
        } catch (ServiceException e) {
        	e.printStackTrace();
        }
    }
}
