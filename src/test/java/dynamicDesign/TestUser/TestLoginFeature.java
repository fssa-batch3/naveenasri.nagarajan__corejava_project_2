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
		String email = "maha12@gmail.com";
		String password = "Navee@123";
		User user1 = new User(email,password );
		try {
			assertTrue(userService.loginUser(user1,email));
		} catch (ServiceException e) {
			e.printStackTrace();

		}
	}

	@Test

	public void loginFailed() {
		UserService userService = new UserService();
		String email = "ahkbkj@gmail.com";
		String password = "Password@796";
		User user2 = new User(email,password);
		try {
			assertFalse(userService.loginUser(user2,email));
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testLoginPasswordCheck() {
		UserService userService = new UserService();
		String email = "maha12@gmail.com";
		String password = "navee@123";
		User user1 = new User(email,password );
		try {
			userService.loginUser(user1,email);
			fail("Password is validated so give correct password");
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testLoginEmailCheck() {
		UserService userService = new UserService();
		String email = "Maha12@gmail.com";
		String password = "Navee@123";
		User user1 = new User(email,password );
		try {
			userService.loginUser(user1,email);
			fail("Email is validated so give correct Email");
		} catch (ServiceException e) {
			e.printStackTrace();

		}
	}

}