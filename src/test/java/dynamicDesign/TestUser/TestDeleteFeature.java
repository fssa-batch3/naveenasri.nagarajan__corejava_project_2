package dynamicDesign.TestUser;

import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Test;

import dynamicDesign.service.UserService;

import dynamicDesign.service.exception.ServiceException;

public class TestDeleteFeature {

	@Test
	void testDeleteUserSuccess1() {
		 UserService userService = new UserService();
		// Assuming this email exists in the database
		String email = "maha12@gmail.com";
		try {
			assertTrue(UserService.deleteUser(email));
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}

    @Test
   void testDeleteUserNotFound() {
        UserService userService = new UserService();
        // Assuming this email does not exist in the database
        String email = "nonexistent_user@gmail.com";
        try {
            userService.deleteUser(email);
            fail("This user is not found");
        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }

  

}
