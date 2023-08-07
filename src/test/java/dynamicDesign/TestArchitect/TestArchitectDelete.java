package dynamicDesign.TestArchitect;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import dynamicDesign.service.ArchitectService;
import dynamicDesign.service.exception.ServiceException;
import dynamicDesign.validation.exception.InvalidArchitectException;

public class TestArchitectDelete {

    @Test
    public void testDeleteArchitectSuccess() {
        ArchitectService architectService = new ArchitectService();
        // Assume you have a valid architectId for an existing architect
        int architectIdToDelete = 1;

        try {
            assertTrue(architectService.deleteArchitect(architectIdToDelete));
            System.out.println("Architect deleted successfully");
        } catch (ServiceException | InvalidArchitectException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testDeleteNonExistingArchitect() {
        ArchitectService architectService = new ArchitectService();
        // Assume you have an architectId that does not exist in the database
        int nonExistingArchitectId = 1000;

        try {
            assertFalse(architectService.deleteArchitect(nonExistingArchitectId));
            System.out.println("Architect not found, delete failed");
        } catch (ServiceException | InvalidArchitectException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testDeleteArchitectWithInvalidId() {
        ArchitectService architectService = new ArchitectService();
        // Assume you have an invalid architectId, e.g. negative value
        int invalidArchitectId = -1;

        try {
            assertFalse(architectService.deleteArchitect(invalidArchitectId));
            System.out.println("Invalid architect ID, delete failed");
        } catch (ServiceException | InvalidArchitectException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testDeleteArchitectWithNullId() {
        ArchitectService architectService = new ArchitectService();
        int nullArchitectId = 0;  // Assuming 0 is considered a null architect ID

        try {
            assertFalse(architectService.deleteArchitect(nullArchitectId));
            System.out.println("Null architect ID, delete failed");
        } catch (ServiceException | InvalidArchitectException e) {
            e.printStackTrace();
        }
    }
}
