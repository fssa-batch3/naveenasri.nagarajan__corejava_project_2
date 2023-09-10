package com.fssa.dynamicdesign.service;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.fssa.dynamicdesign.model.User;
import com.fssa.dynamicdesign.service.exception.ServiceException;

class TestUserUpdateFeature {

    @Test
    void testUpdateSuccess() {
        UserService userService = new UserService();
        // check the userID, give valid details
        User user1 = new User("maha@gmail.com", "Mahasenthil", "Maha@123", "9876543215", "user");
        assertDoesNotThrow(() -> assertTrue(userService.updateUser(user1, "maha@gmail.com")));
    }

    @Test
    void testUpdateEmailIsNotFound() {
        UserService userService = new UserService();
        User user1 = new User("noemail@gmail.com", "MahaKanmani", "Navee@123", "8072444056", "user");
        assertThrows(ServiceException.class, () -> userService.updateUser(user1, "noemail@gmail.com"));
    }

    @Test
    void testUpdateInvalidEmailFormat() {
        UserService userService = new UserService();
        User user1 = new User("maha12@gmail.com", "MahaKanmani", "Navee@123", "8072444056", "user");
        assertThrows(ServiceException.class, () -> userService.updateUser(user1, "invalidemailformat"));
    }

    @Test
    void testUpdateMissingRequiredField() {
        UserService userService = new UserService();
        // Leaving the name field empty
        User user1 = new User("maha12@gmail.com", "", "Navee@123", "8072444056", "user");
        assertThrows(ServiceException.class, () -> userService.updateUser(user1, "maha12@gmail.com"));
    }
}
