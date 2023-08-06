package dynamicDesign.TestUser;

// import static org.junit.jupiter.api.Assertions.assertFalse;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import dynamicDesign.model.User;
import dynamicDesign.service.UserService;
import dynamicDesign.service.exception.ServiceException;

public class TestRegisterFeature {

//	public static void main(String[] args) {
//
//		User user1 = new User("navee@gmail.com", "Naveena", "Navee@123");
//		UserService userService = new UserService();
//
//		try {
//			userService.registerUser(user1);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//	}

	@Test
	public void testRegistrationSuccess() {
		UserService userService = new UserService();
		User user1 = new User("babu@gmail.com", "Babu", "Navee@123", "9876543123", "user");
		try {
			assertTrue(userService.registerUser(user1));
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testRegistrationEmailEmpty() {

		UserService userService = new UserService();
		User user1 = new User("", "Babu", "Babu@123", "9876543123", "user");
		try {
			userService.registerUser(user1);
			fail();
		} catch (ServiceException e) {
			e.printStackTrace();

		}
	}
	
	@Test
	public void testRegistrationphonenumer() {

		UserService userService = new UserService();
		User user1 = new User("babu@gmail.com", "Babu", "Babu@123", "987654h123", "user");
		try {
			userService.registerUser(user1);
			fail();
		} catch (ServiceException e) {
			e.printStackTrace();

		}
	}

	@Test
	public void testRegistrationEmptyPassword() {
		UserService userService = new UserService();
		User user = new User("JohnDoe", "", "john@example.com", "8565473543", "user");
		try {
			userService.registerUser(user);
			fail("Expected ServiceException for empty password, but none was thrown.");
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testRegistrationNullPassword() {
		UserService userService = new UserService();
		User user = new User("JohnDoe", null, "john@example.com", "8565473543", "user");
		try {
			userService.registerUser(user);
			fail("Expected ServiceException for null password, but none was thrown.");
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testRegistrationEmptyUsername() {
		UserService userService = new UserService();
		User user = new User("", "P@ssw0rd", "john@example.com", "8565473543", "user");
		try {
			userService.registerUser(user);
			fail("Expected ServiceException for empty username, but none was thrown.");
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testRegistrationNullUser() {
		UserService userService = new UserService();
		try {
			userService.registerUser(null);
			fail("Expected ServiceException for null user, but none was thrown.");
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}

}