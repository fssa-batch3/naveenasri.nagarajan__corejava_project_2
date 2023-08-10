//package com.fssa.dynamicDesign.TestArchitect;
//
//import static org.junit.jupiter.api.Assertions.assertFalse;
//import static org.junit.jupiter.api.Assertions.assertTrue;
//import static org.junit.jupiter.api.Assertions.fail;
//
//import org.junit.jupiter.api.Test;
//
//import com.fssa.dynamicDesign.service.ArchitectService;
//import com.fssa.dynamicDesign.service.exception.ServiceException;
//import com.fssa.dynamicDesign.validation.exception.InvalidArchitectException;
//
//public class TestArchitectDelete {
//
//    @Test
//    public void testDeleteArchitectSuccess() {
//        ArchitectService architectService = new ArchitectService();
//        // Assume you have a valid architectId for an existing architect
//        int architectIdToDelete = 1;
//
//        try {
//            assertTrue(architectService.deleteArchitect(architectIdToDelete));
//            System.out.println("Architect deleted successfully");
//        } catch (ServiceException | InvalidArchitectException e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Test
//    public void testDeleteNonExistingArchitect() {
//        ArchitectService architectService = new ArchitectService();
//        // Assume you have an architectId that does not exist in the database
//        int nonExistingArchitectId = 1000;
//
//        try {
//            assertFalse(architectService.deleteArchitect(nonExistingArchitectId));
//            System.out.println("Architect not found, delete failed");
//        } catch (ServiceException | InvalidArchitectException e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Test
//    public void testDeleteArchitectWithInvalidId() {
//        ArchitectService architectService = new ArchitectService();
//        // Assume you have an invalid architectId, e.g. negative value
//        int invalidArchitectId = -1;
//
//        try {
//            assertFalse(architectService.deleteArchitect(invalidArchitectId));
//            System.out.println("Invalid architect ID, delete failed");
//        } catch (ServiceException | InvalidArchitectException e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Test
//    public void testDeleteArchitectWithNullId() {
//        ArchitectService architectService = new ArchitectService();
//        int nullArchitectId = 0;  // Assuming 0 is considered a null architect ID
//
//        try {
//            assertFalse(architectService.deleteArchitect(nullArchitectId));
//            System.out.println("Null architect ID, delete failed");
//        } catch (ServiceException | InvalidArchitectException e) {
//            e.printStackTrace();
//        }
//    }
//}


package com.fssa.dynamicDesign.TestArchitect;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.fssa.dynamicDesign.model.Architect;
import com.fssa.dynamicDesign.service.ArchitectService;
import com.fssa.dynamicDesign.service.exception.ServiceException;

public class TestArchitectDelete {

    @Test
    public void testDeleteArchitectSuccess() {
        ArchitectService architectService = new ArchitectService();
        // Assuming an architect with the email "architect@gmail.com" exists in the database
        try {
            Architect architect = new Architect(3, "profile.jpg", "Architect Name", "Male", "9876543210", "Address",
                    "cover.jpg", "ajai@example.com", "Architect@123", "B.Arch", 5, "degree.pdf", "nata.pdf", false);
            boolean isDeleted = architectService.deleteArchitect(architect);
            assertTrue(isDeleted, "Architect deletion failed.");
        } catch (ServiceException e) {
            e.printStackTrace();
            fail("Exception occurred while deleting the architect.");
        }
    }

    @Test
    public void testDeleteNonExistingArchitect() {
        ArchitectService architectService = new ArchitectService();
        // Assuming an architect with the email "nonexisting@example.com" does not exist in the database
        Architect architect = new Architect(2, "profile.jpg", "Non Existing Architect", "Male", "9876543210", "Address",
                "cover.jpg", "nonexisting@example.com", "Architect@123", "B.Arch", 5, "degree.pdf", "nata.pdf", false);
        try {
            architectService.deleteArchitect(architect);
            fail("Architect with non-existing email should not be deleted, but method succeeded.");
        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testDeleteArchitectWithInvalidArchitectId() {
        ArchitectService architectService = new ArchitectService();
        Architect architect = new Architect(-1, "profile.jpg", "Architect Name", "Male", "9876543210", "Address",
                "cover.jpg", "architect@gmail.com", "Architect@123", "B.Arch", 5, "degree.pdf", "nata.pdf", false);
        try {
            boolean isDeleted = architectService.deleteArchitect(architect);
            assertFalse(isDeleted, "Architect should not be deleted.");
        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }

}








