package dynamicDesign.TestUser;

import static org.junit.Assert.*;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import dynamicDesign.model.User;
import dynamicDesign.service.UserService;
import dynamicDesign.service.exception.ServiceException;

public class TestUpdateFeature {

	@Test
	public void testUpdateSuccess() {
		UserService userService = new UserService();
		User user1 = new User("maha12@gmail.com", "Mahasenthil", "Navee@123", "8072444056", "user");
		try {
			assertTrue(userService.updateUser(user1, "maha12@gmail.com"));
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testUpdateEmailNotFound() {
		UserService userService = new UserService();
		User user1 = new User("maha12@gmail.com", "MahaKanmani", "Navee@123", "8072444056", "user");
		try {
			// Assuming the user with email "maha12@gmail.com" does not exist in the system
			userService.updateUser(user1, "noemail@gmail.com");
			fail();
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testUpdateInvalidEmailFormat() {
		UserService userService = new UserService();
		User user1 = new User("maha12@gmail.com", "MahaKanmani", "Navee@123", "8072444056", "user");
		try {
			// Assuming "invalid_email_format" is not a valid email format
			userService.updateUser(user1, "invalidemailformat");
			fail();
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testUpdateMissingRequiredField() {
		UserService userService = new UserService();
		// Leaving the name field empty
		User user1 = new User("maha12@gmail.com", "", "Navee@123", "8072444056", "user");
		try {
			userService.updateUser(user1, "maha12@gmail.com");
			fail();
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}

}
