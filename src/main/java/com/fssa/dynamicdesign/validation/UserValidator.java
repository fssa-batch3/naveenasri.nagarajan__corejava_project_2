package com.fssa.dynamicdesign.validation;

import java.util.regex.Pattern;

import com.fssa.dynamicdesign.model.User;
import com.fssa.dynamicdesign.validation.exception.InvalidUserException;

public class UserValidator {

	/**
	 * Validates the provided user object.
	 *
	 * @param user The user to be validated.
	 * @return True if the user is valid, false otherwise.
	 * 
	 */
	public static boolean validateUser(User user) throws InvalidUserException {
		validateUserNull(user); // Check for null user
		validateUserID(user.getUserId());
		validateName(user.getUsername());
		validatePassword(user.getPassword());
		validateEmail(user.getEmail());
		validatePhoneNumber(user.getPhonenumber());
		
		return true;
	}

	/**
	 * Validates the user is null.
	 *
	 * @param The user to be validated.
	 * @return True if the user not null is valid, false otherwise.
	 * @throws InvalidUserException If the user is null.
	 */
	public static void validateUserNull(User user) throws InvalidUserException {
		if (user == null) {
			throw new InvalidUserException("User is null");
		}
	}

	/**
	 * Validates the user's ID.
	 *
	 * @param userID The user ID to be validated.
	 * @return True if the user ID is valid, false otherwise.
	 * @throws InvalidUserException If the user ID is not valid.
	 */
	public static boolean validateUserID(int userID) throws InvalidUserException {
		if (userID < 0) {
			throw new InvalidUserException("User ID is invalid: Negative value");
		}
		return Pattern.matches("^\\d+$", Integer.toString(userID));
	}

	/**
	 * Validates the user's name.
	 *
	 * @param name The user's name to be validated.
	 * @return True if the name is valid, false otherwise.
	 * @throws InvalidUserException If the name is not valid.
	 */
	public static boolean validateName(String name) throws InvalidUserException {
		if (name == null || !Pattern.matches("^[A-Za-z]\\w{2,29}$", name)) {
			throw new InvalidUserException("User name is not valid");
		}
		return true;
	}

	/**
	 * Validates the user's password.
	 *
	 * @param password The user's password to be validated.
	 * @return True if the password is valid, false otherwise.
	 * @throws InvalidUserException If the password is not valid.
	 */
	public static boolean validatePassword(String password) throws InvalidUserException {
		if (password == null
				|| !Pattern.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=])(?=.*[^\\s]).{8,}$", password)) {
			throw new InvalidUserException("User password is not valid");
		}
		return true;
	}

	/**
	 * Validates the user's email address.
	 *
	 * @param email The user's email address to be validated.
	 * @return True if the email address is valid, false otherwise.
	 * @throws InvalidUserException If the email address is not valid.
	 */
	public static boolean validateEmail(String email) throws InvalidUserException {
		if (email == null || !Pattern.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", email)) {
			throw new InvalidUserException("Email address is not valid");
		}
		return true;
	}

	/**
	 * Validates the user's phone number.
	 *
	 * @param phoneNumber The user's phone number to be validated.
	 * @return True if the phone number is valid, false otherwise.
	 * @throws InvalidUserException If the phone number is not valid.
	 */
	public static boolean validatePhoneNumber(String phoneNumber) throws InvalidUserException {
		if (phoneNumber == null || !Pattern.matches("^(\\+?91)?[6-9]\\d{9}$", phoneNumber)) {
			throw new InvalidUserException("Phone number is not valid");
		}
		return true;
	}
	
	
}
