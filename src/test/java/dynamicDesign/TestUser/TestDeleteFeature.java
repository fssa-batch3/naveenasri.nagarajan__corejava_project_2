package dynamicDesign.TestUser;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import dynamicDesign.model.User;
import dynamicDesign.service.UserService;
import dynamicDesign.service.exception.ServiceException;

public class TestDeleteFeature {

	@Test
	public void testDeleteUserSuccess() {
		UserService userService = new UserService();
		// Assuming a user with the email "babu@gmail.com" exists in the database
		try {
			User user = new User(1, "babu@gmail.com", "Babu", "Navee@123", "9876543123", "user", false);
			boolean isDeleted = userService.deleteUser(user);
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
			User user = new User(2, "nonexisting@example.com", "NonExistingUser", "Navee@123", "9876543123", "user",
					false);
			userService.deleteUser(user);
			fail("User with non-existing email should not be deleted, but method succeeded.");
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testDeleteUserWithInvalidUserId() {
		UserService userService = new UserService();
		User user = new User(-1, "babu@gmail.com", "Babu", "Navee@123", "9876543123", "user", false);
		try {
			boolean isDeleted = userService.deleteUser(user);
			assertFalse(isDeleted, "User should not be deleted.");
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}

}
