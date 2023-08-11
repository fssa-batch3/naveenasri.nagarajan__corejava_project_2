package com.fssa.dynamicdesign.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.fssa.dynamicdesign.model.User;
import com.fssa.dynamicdesign.validation.exception.InvalidUserException;

public class UserValidator {

	public static boolean validateUser(User user) throws InvalidUserException {
		if (user != null && validateUserID(user.getUserId())&& validateName(user.getUsername()) && validatePassword(user.getPassword())
				&& validateEmail(user.getEmail()) && validatePhoneNumber(user.getPhonenumber())) {
			return true;
		} else {
			throw new InvalidUserException("User details not valid");
		}
	}

	
	
	public static boolean validateUserID(int userID) throws InvalidUserException {
		if (userID < 0) {
			throw new InvalidUserException("User ID is invalid: Negative value.");
		}

		String regexUserID = "^[0-9]+$";
		boolean match = Pattern.matches(regexUserID, Integer.toString(userID));

		if (match) {
			System.out.println("User ID is valid.");
		} else {
			throw new InvalidUserException("User ID is invalid: Only non-negative numbers are allowed.");
		}

		return match;
	}

	
	
	public static boolean validateName(String name) throws InvalidUserException {
		if (name == null) {
			throw new InvalidUserException("User name is null");
		}

		String regex = "^[A-Za-z]\\w{2,29}$";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(name);
		boolean match = m.matches();

		if (match) {
			System.out.println("The User name is valid.");
		} else {
			throw new InvalidUserException("The User name is not valid");
		}

		return match;
	}
	
	

	public static boolean validatePassword(String password) throws InvalidUserException {
	    boolean isMatch = true;
	    if (password == null) {
	        return false;
	    }
	    String patternString = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=])(?=.*[^\\s]).{8,}$";
	    Pattern pattern = Pattern.compile(patternString);
	    isMatch = pattern.matcher(password).matches();

	    if (isMatch) {
	        System.out.println("Valid password.");
	    } else {
	        throw new InvalidUserException("User password is InValid");
	    }

	    return isMatch;
	}


	
	public static boolean validateEmail(String email) throws InvalidUserException {
		if (email == null) {
			throw new InvalidUserException("Email address is null");
		}

		String regex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
		boolean isMatch = Pattern.matches(regex, email);

		if (isMatch) {
			System.out.println("The email address is: Valid");
		} else {
			throw new InvalidUserException("The email address is: Invalid");
		}

		return isMatch;
	}

	public static boolean validatePhoneNumber(String phoneNumber) throws InvalidUserException {
		if (phoneNumber == null)
			return false;

		String regex = "^(\\+?91|91)?[6-9]\\d{9}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(phoneNumber);
		boolean isMatch = matcher.matches();

		if (isMatch) {
			System.out.println("The phone number is: Valid");
		} else {
			throw new InvalidUserException("The phone number is: Invalid");
		}

		return isMatch;
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
