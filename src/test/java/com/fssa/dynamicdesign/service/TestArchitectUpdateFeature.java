package com.fssa.dynamicdesign.service;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import com.fssa.dynamicdesign.model.Architect;
import com.fssa.dynamicdesign.service.exception.ServiceException;

class TestArchitectUpdateFeature {

    @Test
    void testUpdateSuccess() {
        ArchitectService architectService = new ArchitectService();
        Architect architect = new Architect("profileeePhoto.jpg", "Mahasenthil", "Female", "9876543210", "123 Main Street",
                "coverPhoto.jpg", "maha@example.com", "Navee@123", "Bachelor of Architecture", 5,
                "degreeCertificate.jpg", "NATACertificate.jpg");

        assertDoesNotThrow(() -> {
            assertTrue(architectService.updateArchitect(architect, "maha@example.com"));
        });
    }

    @Test
    void testUpdateEmailNotFound() {
        ArchitectService architectService = new ArchitectService();
        Architect architect = new Architect("profilePhoto.jpg", "Maha", "Female", "9876543210", "123 Main Street",
                "coverPhoto.jpg", "maha987@example.com", "Navee@123", "Bachelor of Architecture", 5,
                "degreeCertificate.jpg", "NATACertificate.jpg");

        assertThrows(ServiceException.class, () -> {
            architectService.updateArchitect(architect, "noemail@example.com");
        });
    }

    @Test
    void testUpdateInvalidEmailFormat() {
        ArchitectService architectService = new ArchitectService();
        Architect architect = new Architect("profilePhoto.jpg", "Maha", "Female", "9876543210", "123 Main Street",
                "coverPhoto.jpg", "maha@example.com", "Navee@123", "Bachelor of Architecture", 5,
                "degreeCertificate.jpg", "NATACertificate.jpg");

        assertThrows(ServiceException.class, () -> {
            architectService.updateArchitect(architect, "invalidemailformat");
        });
    }

    @Test
    void testUpdateMissingRequiredField() {
        ArchitectService architectService = new ArchitectService();
        Architect architect = new Architect("profilePhoto.jpg", "", "Female", "9876543210", "123 Main Street",
                "coverPhoto.jpg", "maha@example.com", "Navee@123", "Bachelor of Architecture", 5,
                "degreeCertificate.jpg", "NATACertificate.jpg");

        assertThrows(ServiceException.class, () -> {
            architectService.updateArchitect(architect, "maha@example.com");
        });
    }

    @Test
    void testUpdateNullArchitect() {
        ArchitectService architectService = new ArchitectService();
        Architect architect = null;

        assertThrows(ServiceException.class, () -> {
            architectService.updateArchitect(architect, "maha@example.com");
        });
    }

    @Test
    void testUpdateNullEmail() {
        ArchitectService architectService = new ArchitectService();
        Architect architect = new Architect("profilePhoto.jpg", "Maha", "Female", "9876543210", "123 Main Street",
                "coverPhoto.jpg", "maha@example.com", "Navee@123", "Bachelor of Architecture", 5,
                "degreeCertificate.jpg", "NATACertificate.jpg");

        assertThrows(ServiceException.class, () -> {
            architectService.updateArchitect(architect, null);
        });
    }

    @Test
    void testUpdateEmptyEmail() {
        ArchitectService architectService = new ArchitectService();
        Architect architect = new Architect("profilePhoto.jpg", "Maha", "Female", "9876543210", "123 Main Street",
                "coverPhoto.jpg", "maha@example.com", "Navee@123", "Bachelor of Architecture", 5,
                "degreeCertificate.jpg", "NATACertificate.jpg");

        assertThrows(ServiceException.class, () -> {
            architectService.updateArchitect(architect, "");
        });
    }
}
