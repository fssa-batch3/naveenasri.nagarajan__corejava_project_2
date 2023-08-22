package com.fssa.interiordesign.validation;

import java.util.regex.Pattern;

import com.fssa.interiordesign.model.Design;
import com.fssa.interiordesign.validation.exception.InvalidDesignException;

public class NewDesignValidator {

	public static void validateDesign(Design design) throws InvalidDesignException {
		if (design == null) {
			throw new InvalidDesignException("Design is null");
		}

		validateDesignName(design.getDesignName());
		validateDesignUrl(design.getDesignUrl());
		validatePrice(design.getPrice());
		validateEmail(design.getEmail());
		// validateNoOfRooms(design.getNoOfRooms());

		// Add validation for design ID
		validateDesignId(design.getDesignId());
	}

	private static void validateDesignName(String designName) throws InvalidDesignException {
		if (designName == null || designName.trim().isEmpty()) {
			throw new InvalidDesignException("Design name is required");
		}
	}

	private static void validateDesignUrl(String designUrl) throws InvalidDesignException {
		if (designUrl == null || designUrl.trim().isEmpty()) {
			throw new InvalidDesignException("Design URL is required");
		}
	}

	private static void validatePrice(double price) throws InvalidDesignException {
		if (price < 0) {
			throw new InvalidDesignException("Price must be a non-negative value");
		}
	}

	private static void validateEmail(String email) throws InvalidDesignException {
		if (email == null || !isValidEmail(email)) {
			throw new InvalidDesignException("Invalid email");
		}
	}

	private static void validateNoOfRooms(int noOfRooms) throws InvalidDesignException {
		if (noOfRooms < 0) {
			throw new InvalidDesignException("Number of rooms must be a non-negative value");
		}
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

	private static void validateDesignId(Integer designId) throws InvalidDesignException {
		if (designId != null && designId < 0) {
			throw new InvalidDesignException("The design ID is invalid: Negative value.");
		}
	}

}
