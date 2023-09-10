package com.fssa.dynamicdesign.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.fssa.dynamicdesign.model.User;
import com.fssa.dynamicdesign.service.UserService;
import com.fssa.dynamicdesign.service.exception.ServiceException;

class TestUserRegisterFeature {

    @Test
    void testRegistrationSuccess() {
        UserService userService = new UserService();
        // email is not repeating so give unique email
        // ********************** Important ******************
        // change userID , Email
        // ***************************************************
        User user1 = new User("kishore@gmail.com", "Maha", "Kishore@123", "9876212345", "user");
        assertDoesNotThrow(() -> userService.registerUser(user1));
    }

    @Test
    void testRegistrationNullPassword() {
        UserService userService = new UserService();
        User user = new User("maha@gmail.com", "Maha", null, "9876212345", "user");
        assertThrows(ServiceException.class, () -> userService.registerUser(user));
    }

    @Test
    void testRegistrationNullUser() {
        UserService userService = new UserService();
        assertThrows(ServiceException.class, () -> userService.registerUser(null));
    }

    @Test
    void testRegistrationEmailEmpty() {
        UserService userService = new UserService();
        User user1 = new User("", "Maha", "Maha@123", "9876212345", "user");
        assertThrows(ServiceException.class, () -> userService.registerUser(user1));
    }

    @Test
    void testRegistrationPhoneNumberInvalid() {
        UserService userService = new UserService();
        User user1 = new User("maha@gmail.com", "Maha", "Maha@123", "98762h12345", "user");
        assertThrows(ServiceException.class, () -> userService.registerUser(user1));
    }

    @Test
    void testRegistrationEmptyPassword() {
        UserService userService = new UserService();
        User user = new User("maha@gmail.com", "Maha", "", "9876212345", "user");
        assertThrows(ServiceException.class, () -> userService.registerUser(user));
    }

    @Test
    void testRegistrationEmptyUsername() {
        UserService userService = new UserService();
        User user = new User("maha@gmail.com", "", "Maha@123", "9876212345", "user");
        assertThrows(ServiceException.class, () -> userService.registerUser(user));
    }
}
