package com.fssa.dynamicdesign.service;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.fssa.dynamicdesign.model.User;
import com.fssa.dynamicdesign.service.exception.ServiceException;

class TestUserLoginFeature {

    @Test
    void loginSuccess() {
        UserService userService = new UserService();
        String email = "kala@gmail.com";
        String password = "Kala@123";
        User user1 = new User(email, password);
        assertDoesNotThrow(() -> assertTrue(userService.loginUser(user1, email)));
    }

    @Test
    void testEmailNotExists() {
        UserService userService = new UserService();
        String email = "ahkbkj@gmail.com";
        String password = "Password@796";
        User user2 = new User(email, password);
        assertThrows(ServiceException.class, () -> userService.loginUser(user2, email));
    }

    @Test
    void testLoginEmailCheck() {
        UserService userService = new UserService();
        String email = "invalidemail"; // Invalid email format
        String password = "Maha@123";
        User user1 = new User(email, password);
        assertThrows(ServiceException.class, () -> userService.loginUser(user1, email));
    }

    @Test
    void testLoginPasswordCheck() {
        UserService userService = new UserService();
        String email = "maha@gmail.com";
        String password = "maha@123"; // Incorrect password format
        User user1 = new User(email, password);
        assertThrows(ServiceException.class, () -> userService.loginUser(user1, email));
    }
}
