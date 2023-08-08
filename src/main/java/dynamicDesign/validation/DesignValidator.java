package dynamicDesign.validation;

import java.util.regex.Pattern;

import dynamicDesign.model.Design;
import dynamicDesign.validation.exception.InvalidDesignException;

public class DesignValidator {

	public static boolean validateDesign(Design design) throws  InvalidDesignException {
		if (design == null) {
			throw new InvalidDesignException("Design is null");
		}

		if (design.getDesignName() == null || design.getDesignName().trim().isEmpty()) {
			throw new InvalidDesignException("Design name is required");
		}

		if (design.getDesignUrl() == null || design.getDesignUrl().trim().isEmpty()) {
			throw new InvalidDesignException("Design URL is required");
		}

		if (design.getPrice() < 0) {
			throw new InvalidDesignException("Price must be a non-negative value");
		}

		if (design.getEmail() == null || !isValidEmail(design.getEmail())) {
			throw new InvalidDesignException("Invalid email");
		}

		if (design.getNoOfRoom() < 0) {
			throw new InvalidDesignException("Number of rooms must be a non-negative value");
		}

		// Add validation for design ID
		if (design.getDesignId() < 0) {
			throw new InvalidDesignException("Invalid design ID");
		}

		return true;
	}

	// Helper method to validate email format
	public static boolean isValidEmail(String email) {
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
}
