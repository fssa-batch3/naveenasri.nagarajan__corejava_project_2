package dynamicDesign.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import dynamicDesign.model.User;
import dynamicDesign.validation.exception.InvalidUserException;

public class UserValidator {

	public static boolean validateUser(User user) throws InvalidUserException {
		if (user != null && validateName(user.getUsername()) && validatePassword(user.getPassword())
				&& validateEmail(user.getEmail())) {
			return true;
		} else {
			throw new InvalidUserException("User details not valid");
		}
	}

	public static boolean validateName(String name) {
		if (name == null)
			return false;

		String regex = "^[A-Za-z]\\w{2,29}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(name);
		boolean isMatch = matcher.matches();
		if (isMatch) {
			System.out.println("The user name is valid.");
		} else {
			System.out.println("The user name is not valid");
		}

		return isMatch;
	}

	public static boolean validatePassword(String password) {
		if (password == null)
			return false;

		String patternString = "(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=])(?=.*[^\\s]).{8,}$";
		boolean isMatch = Pattern.matches(patternString, password);

		if (isMatch) {
			System.out.println("Valid password.");
		} else {
			System.out.println("Invalid password.");
		}

		return isMatch;
	}

	public static boolean validateEmail(String email) {
		if (email == null)
			return false;

		String regex = "^.*@.*\\..*$";
		boolean isMatch = Pattern.matches(regex, email);
		if (isMatch) {
			System.out.println("The email address is: Valid");
		} else {
			System.out.println("The email address is: Invalid");
		}
		return isMatch;
	}

	public static boolean validatePhoneNumber(String phoneNumber) {
		if (phoneNumber == null)
			return false;

		String regex = "^(\\+?91|91)?[6-9]\\d{9}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(phoneNumber);
		boolean isMatch = matcher.matches();

		if (isMatch) {
			System.out.println("The phone number is: Valid");
		} else {
			System.out.println("The phone number is: Invalid");
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
