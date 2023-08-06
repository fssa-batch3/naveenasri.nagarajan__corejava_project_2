package dynamicDesign.TestArchitect;

import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import dynamicDesign.model.Architect;
import dynamicDesign.service.ArchitectService;
import dynamicDesign.service.exception.ServiceException;

public class TestArchitectDelete {

	@Test
	public void testDeleteArchitectSuccess() {
		ArchitectService architectService = new ArchitectService();
		// Assuming an architect with the email "john.doe@example.com" exists in the
		// database
		try {
			boolean isDeleted = architectService.deleteArchitect("john.doe@example.com");
			assertTrue(isDeleted, "Architect deletion failed.");
		} catch (ServiceException e) {
			e.printStackTrace();
			fail("Exception occurred while deleting the architect.");
		}
	}

	@Test
	public void testDeleteNonExistingArchitect() {
		ArchitectService architectService = new ArchitectService();
		// Assuming an architect with the email "nonexisting@example.com" does not exist
		// in the database
		try {
			architectService.deleteArchitect("nonexisting@example.com");
			fail("Architect with non-existing email should not be deleted, but method succeeded.");
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testDeleteArchitectWithInvalidEmailFormat() {
		ArchitectService architectService = new ArchitectService();
		// Assuming "invalid_email_format" is not a valid email format
		try {
			architectService.deleteArchitect("invalid_email_format");
			fail("Architect with invalid email format should not be deleted, but method succeeded.");
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}
}
