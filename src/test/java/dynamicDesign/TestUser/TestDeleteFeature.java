package dynamicDesign.TestUser;

import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import dynamicDesign.service.UserService;
import dynamicDesign.service.exception.ServiceException;

public class TestDeleteFeature {

	@Test
	public void testDeleteUserSuccess() {
		UserService userService = new UserService();
		// Assuming a user with the email "maha@example.com" exists in the database
		try {
			boolean isDeleted = userService.deleteUser("babu@gmail.com");
			assertTrue(isDeleted, "User deletion failed.");
		} catch (ServiceException e) {
			e.printStackTrace();
			fail("Exception occurred while deleting the user.");
		}
	}

	@Test
	public void testDeleteNonExistingUser() {
		UserService userService = new UserService();
		// Assuming a user with the email "nonexisting@example.com" does not exist in
		// the database
		try {
			userService.deleteUser("nonexisting@example.com");
			fail("User with non-existing email should not be deleted, but method succeeded.");
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testDeleteUserWithInvalidEmailFormat() {
		UserService userService = new UserService();
		// Assuming "invalid_email_format" is not a valid email format
		try {
			userService.deleteUser("invalid_email_format");
			fail("User with invalid email format should not be deleted, but method succeeded.");
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}

}
