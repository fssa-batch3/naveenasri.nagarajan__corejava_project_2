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
		boolean match = false;

		if (name == null)
			return false;

		String regex = "^[A-Za-z]\\w{2,29}$";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(name);
		match = m.matches();
		if (match) {
			System.out.println("The user name is valid.");
		} else {
			System.out.println("The user name is not valid");
		}

		return match;
	}

	public static boolean validatePassword(String password) {
		boolean match = false;

		if (password == null)
			return false;

		String pattern_string = "(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=])(?=.*[^\\s]).{8,}$";
		match = Pattern.matches(pattern_string, password);

		if (match) {

			System.out.println("Valid password.");
		} else {
			System.out.println("Invalid password.");
		}

		return match;
	}

	public static boolean validateEmail(String email) {
		boolean isMatch = false;

		if (email == null)
			return false;
		String regex = "^.*@.*\\..*$";
		isMatch = Pattern.matches(regex, email);
		if (isMatch) {
			System.out.println("The email address is: Valid");
		} else {
			System.out.println("The email address is: Invalid");
		}
		return isMatch;

	}
	
	
	public static boolean validatePhoneNumber(String phoneNumber) {
	    // Check if the provided phone number is null
	    if (phoneNumber == null)
	        return false;

	    // Phone number regex pattern for Indian phone numbers (starting with +91)
	    String regex = "^\\+91[6-9]\\d{9}$";

	    // Compile the regex pattern into a Pattern object
	    Pattern pattern = Pattern.compile(regex);

	    // Create a Matcher object to match the provided phone number against the pattern
	    Matcher matcher = pattern.matcher(phoneNumber);

	    // Perform the match and store the result in a boolean variable
	    boolean isMatch = matcher.matches();

	    // Print whether the phone number is valid or invalid based on the match result
	    if (isMatch) {
	        System.out.println("The phone number is: Valid");
	    } else {
	        System.out.println("The phone number is: Invalid");
	    }

	    // Return the match result, which is true if the phone number is valid, false otherwise
	    return isMatch;
	}


}