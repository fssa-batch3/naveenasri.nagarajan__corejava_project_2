package dynamicDesign.TestUser;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import dynamicDesign.model.User;
import dynamicDesign.service.UserService;
import dynamicDesign.service.exception.ServiceException;

public class TestLoginFeature {

	@Test
	public void loginSuccess() {
		UserService userService = new UserService();
		User user1 = new User("maha12@gmail.com", "Navee@123");
		try {
			assertTrue(userService.loginUser(user1));
		} catch (ServiceException e) {
			e.printStackTrace();

		}
	}

	@Test

	public void loginFailed() {
		UserService userService = new UserService();
		User user2 = new User("ahkbkj@gmail.com", "Password@796");
		try {
			assertFalse(userService.loginUser(user2));
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}
	


}