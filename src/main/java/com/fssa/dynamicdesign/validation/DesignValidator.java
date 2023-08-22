package com.fssa.dynamicdesign.validation;

import java.util.regex.Pattern;

import com.fssa.dynamicdesign.model.Design;
import com.fssa.dynamicdesign.validation.exception.InvalidDesignException;

public class DesignValidator {

	public static boolean validateDesign(Design design) throws InvalidDesignException {
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

		return true;
	}

	// Helper method to validate email format
	public static boolean isValidEmail(String email) throws InvalidDesignException {
		boolean isMatch = true;

		if (email == null)
			return false;
		String regex = "^.*@.*\\..*$";
		isMatch = Pattern.matches(regex, email);
		if (isMatch) {
			System.out.println("The email address is: Valid");
		} else {
			throw new InvalidDesignException("The email address is: Invalid");
		}
		return isMatch;
	}

	// Helper method to validate design ID
	public static boolean isValidDesignId(int designId) throws InvalidDesignException {
		if (designId < 0) {
			System.out.println();
			throw new InvalidDesignException("The design ID is invalid: Null or negative value.");
		}

		System.out.println("The design ID is valid.");
		return true;
	}

}