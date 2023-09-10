package com.fssa.dynamicdesign.service;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.fssa.dynamicdesign.model.Architect;
import com.fssa.dynamicdesign.service.exception.ServiceException;

class TestArchitectRegisterFeature {

    @Test
    void testArchitectRegistrationSuccess() {
        ArchitectService architectService = new ArchitectService();
        // Create a sample valid architect
        // ********************** Important ******************
        // change ArchitectID , Email , Architect Name
        // ***************************************************
        Architect architect = new Architect( "profilePhoto.jpg", "Ajaiii", "Female", "9876543210", "123 Main Street",
                "coverPhoto.jpg", "ajaiii@example.com", "Navee@123", "Bachelor of Architecture", 4,
                "degreeCertificate.jpg", "NATACertificate.jpg");
        assertDoesNotThrow(() -> assertTrue(architectService.registerArchitect(architect)));
    }

    @Test
    void testArchitectRegistrationInValidURLs() {
        ArchitectService architectService = new ArchitectService();
        Architect architect = new Architect( "     ", "JohnDoy", "Male", "9876543210",
                "123 Main Street", "https://example.com/cover.jpg", "johyuh@example.com", "Password@123",
                "Bachelor of Architecture", 5, "https://example.com/degree.jpg", "https://example.com/NATACert.jpg");
        assertThrows(ServiceException.class, () -> architectService.registerArchitect(architect));
    }

    @Test
    void testArchitectRegistrationNullName() {
        ArchitectService architectService = new ArchitectService();
        // Create a sample architect with invalid details (missing required fields)
        Architect architect = new Architect("profilePhoto.jpg", null, "Male", "9876543210", "123 Main Street",
                "coverPhoto.jpg", "john.doe@example.com", "Password@123", "Bachelor of Architecture", 5,
                "degreeCertificate.jpg", "NATACertificate.jpg");
        assertThrows(ServiceException.class, () -> architectService.registerArchitect(architect));
    }

    @Test
    void testArchitectRegistrationNull() {
        ArchitectService architectService = new ArchitectService();
        // Create a sample architect that is null
        Architect architect = null;
        assertThrows(ServiceException.class, () -> architectService.registerArchitect(architect));
    }

    @Test
    void testArchitectRegistrationEmailExists() {
        ArchitectService architectService = new ArchitectService();
        // Create a sample architect with an email that already exists in the database
        Architect architect = new Architect( "profilePhoto.jpg", "Maha", "Male", "9876543210", "123 Main Street",
                "coverPhoto.jpg", "maha@example.com", "Password@123", "Bachelor of Architecture", 5,
                "degreeCertificate.jpg", "NATACertificate.jpg");
        assertThrows(ServiceException.class, () -> architectService.registerArchitect(architect));
    }

    @Test
    void testArchitectRegistrationInvalidURLs() {
        ArchitectService architectService = new ArchitectService();
        // Create a sample architect with invalid URLs for profile photo, cover photo,
        // degree certificate, and NATACertificate
        Architect architect = new Architect( "invalidprofile.jpg", "JohnDoe", "Male", "9876543210", "123 Main Street",
                "invalidcover.jpg", "john.doe@example.com", "Password@123", "Bachelor of Architecture", 5,
                "invaliddegree.jpg", "invalidNATACert.jpg");
        assertThrows(ServiceException.class, () -> architectService.registerArchitect(architect));
    }

    @Test
    void testArchitectRegistrationInvalidExperience() {
        ArchitectService architectService = new ArchitectService();
        // Create a sample architect with negative experience
        Architect architect = new Architect(5, "profilePhoto.jpg", "JohnDoe", "Male", "9876543210", "123 Main Street",
                "coverPhoto.jpg", "john.doe@example.com", "Password@123", "Bachelor of Architecture", -2,
                "degreeCertificate.jpg", "NATACertificate.jpg");
        assertThrows(ServiceException.class, () -> architectService.registerArchitect(architect));
    }

    @Test
    void testArchitectRegistrationEmptyEmailExists() {
        ArchitectService architectService = new ArchitectService();
        // Create a sample architect with an empty email
        Architect architect = new Architect(3,"profilePhoto.jpg", "Maha", "Male", "9876543210", "123 Main Street",
                "coverPhoto.jpg", "", "Password@123", "Bachelor of Architecture", 5,
                "degreeCertificate.jpg", "NATACertificate.jpg");
        assertThrows(ServiceException.class, () -> architectService.registerArchitect(architect));
    }
}
