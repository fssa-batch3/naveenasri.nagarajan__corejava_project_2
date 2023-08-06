package dynamicDesign.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import dynamicDesign.model.Architect;
import dynamicDesign.validation.exception.InvalidUserException;

public class ArchitectValidator {

    public static boolean validateArchitect(Architect architect) throws InvalidUserException {
        if (architect != null &&
            validateName(architect.getName()) &&
            validateGender(architect.getGender()) &&
            validatePhoneNumber(architect.getPhoneNumber()) &&
            validateAddress(architect.getAddress()) &&
            validateEmail(architect.getEmail()) &&
            validatePassword(architect.getPassword()) &&
            validateEducation(architect.getEducation()) &&
            validateExperience(architect.getExperience()) &&
            validateURL(architect.getProfilePhoto()) &&
            validateURL(architect.getCoverPhoto()) &&
            validateURL(architect.getDegreeCertificate()) &&
            validateURL(architect.getNATACertificate())) {
            return true;
        } else {
            throw new InvalidUserException("Architect details not valid");
        }
    }

    public static boolean validateName(String name) {
        boolean match = false;
        if (name == null)
            return false;

        // The name should start with a letter and can contain letters, digits, or underscores.
        String regex = "^[A-Za-z]\\w{2,99}$";
        Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(name);
		match = m.matches();
		if (match) {
			System.out.println("The Architect name is valid.");
		} else {
			System.out.println("The Architect name is not valid");
		}

		return match;
    }

  
public static boolean validateGender(String gender) {
    if (gender == null)
        return false;

    // Gender should be one of the allowed values (e.g., "Male", "Female", "Other").
    String regex = "^(Male|Female|Other)$";
    Pattern pattern = Pattern.compile(regex);
    Matcher matcher = pattern.matcher(gender);
    boolean isMatch = matcher.matches();

    if (isMatch) {
        System.out.println("The Architect gender is valid.");
    } else {
        System.out.println("The Architect gender is not valid");
    }

    return isMatch;
}


public static boolean validatePhoneNumber(String phoneNumber) {
    // Check if the provided phone number is null
    if (phoneNumber == null)
        return false;

    // Phone number regex pattern for Indian phone numbers (starting with +91)
    String regex = "^(\\+?91|91)?[6-9]\\d{9}$";

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



public static boolean validateAddress(String address) {
    if (address == null)
        return false;

    // Address validation can be based on specific rules for your application.
    // For simplicity, we assume any non-null address is valid.

    // Add your custom address validation regex pattern here.
    // For example, the following regex allows any non-empty string as a valid address.
    String regex = ".+";

    Pattern pattern = Pattern.compile(regex);
    Matcher matcher = pattern.matcher(address);
    boolean isMatch = matcher.matches();

    if (isMatch) {
        System.out.println("The Architect address is valid.");
    } else {
        System.out.println("The Architect address is not valid");
    }

    return isMatch;
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

public static boolean validateEducation(String education) {
    // Check if the education is null or empty
    if (education == null || education.trim().isEmpty()) {
        System.out.println("Education is invalid: Empty or null value.");
        return false;
    }

    // Define the regex pattern for valid education (only letters and spaces)
    String regexEducation = "^[A-Za-z ]+$";

    // Check if the education matches the regex pattern
    boolean match = Pattern.matches(regexEducation, education);

    // Validate education
    if (match) {
        System.out.println("Education is valid.");
    } else {
        System.out.println("Education is invalid: Only letters and spaces are allowed.");
    }

    return match;
}

public static boolean validateExperience(int experience) {
    // Check if the experience is negative
    if (experience < 0) {
        System.out.println("Experience is invalid: Negative value.");
        return false;
    }

    // Define the regex pattern for valid experience (only number)
    String regexExperience = "^[0-9]{1,2}$";

    // Check if the experience matches the regex pattern
    boolean match = Pattern.matches(regexExperience, Integer.toString(experience));

    // Validate experience
    if (match) {
        System.out.println("Experience is valid.");
    } else {
        System.out.println("Experience is invalid: Only numbers are allowed.");
    }

    return match;
}

public static boolean validateURL(String url) {
    // Check if the URL is null or empty after trimming
    if (url == null || url.trim().isEmpty()) {
        System.out.println("URL is invalid: Empty or null value.");
        return false;
    }

    // Validate URL
    System.out.println("URL is valid.");
    return true;
}

}
