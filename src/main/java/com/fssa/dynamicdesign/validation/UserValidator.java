package com.fssa.dynamicdesign.validation;

import java.util.regex.Pattern;

import com.fssa.dynamicdesign.model.User;
import com.fssa.dynamicdesign.validation.exception.InvalidUserException;

public class UserValidator {

    public static boolean validateUser(User user) throws InvalidUserException {
        if (user == null || !isValidUser(user)) {
            throw new InvalidUserException("User details are not valid");
        }
        return true;
    }

    private static boolean isValidUser(User user) {
        try {
            return validateUserID(user.getUserId())
                    && validateName(user.getUsername())
                    && validatePassword(user.getPassword())
                    && validateEmail(user.getEmail())
                    && validatePhoneNumber(user.getPhonenumber());
        } catch (InvalidUserException e) {
            // Handle the exception or re-throw it as necessary
            e.printStackTrace(); // Just printing the stack trace as an example
            return false;
        }
    }

    public static boolean validateUserID(int userID) throws InvalidUserException {
        if (userID < 0) {
            throw new InvalidUserException("User ID is invalid: Negative value");
        }
        return Pattern.matches("^\\d+$", Integer.toString(userID));
    }

    public static boolean validateName(String name) throws InvalidUserException {
        if (name == null || !Pattern.matches("^[A-Za-z]\\w{2,29}$", name)) {
            throw new InvalidUserException("User name is not valid");
        }
        return true;
    }

    public static boolean validatePassword(String password) throws InvalidUserException {
        if (password == null || !Pattern.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=])(?=.*[^\\s]).{8,}$", password)) {
            throw new InvalidUserException("User password is not valid");
        }
        return true;
    }

    public static boolean validateEmail(String email) throws InvalidUserException {
        if (email == null || !Pattern.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", email)) {
            throw new InvalidUserException("Email address is not valid");
        }
        return true;
    }

    public static boolean validatePhoneNumber(String phoneNumber) throws InvalidUserException {
        if (phoneNumber == null || !Pattern.matches("^(\\+?91)?[6-9]\\d{9}$", phoneNumber)) {
            throw new InvalidUserException("Phone number is not valid");
        }
        return true;
    }

    public static boolean validateDeleteUser(User user) throws InvalidUserException {
        if (user != null && user.getUserId() > 0 && validateEmail(user.getEmail())) {
            System.out.println("User deletion details are valid.");
            return true;
        } else {
            throw new InvalidUserException("Invalid user details for deletion");
        }
    }
}
