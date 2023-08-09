package com.fssa.dynamicDesign.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.fssa.dynamicDesign.model.Architect;
import com.fssa.dynamicDesign.validation.exception.InvalidArchitectException;

public class ArchitectValidator {

	public static boolean validateArchitect(Architect architect) throws InvalidArchitectException {
		if (architect != null && validateArchitectID(architect.getArchitectID()) && validateName(architect.getName())
				&& validateGender(architect.getGender()) && validatePhoneNumber(architect.getPhoneNumber())
				&& validateAddress(architect.getAddress()) && validateEmail(architect.getEmail())
				&& validatePassword(architect.getPassword()) && validateEducation(architect.getEducation())
				&& validateExperience(architect.getExperience()) && validateURL(architect.getProfilePhoto())
				&& validateURL(architect.getCoverPhoto()) && validateURL(architect.getDegreeCertificate())
				&& validateURL(architect.getNATACertificate())) {
			return true;
		} else {
			throw new InvalidArchitectException("Architect details not valid");
		}
	}

	public static boolean validateArchitectID(int architectID) throws InvalidArchitectException {
		if (architectID < 0) {
			throw new InvalidArchitectException("Architect ID is invalid: Negative value.");
		}

		String regexArchitectID = "^[0-9]+$";
		boolean match = Pattern.matches(regexArchitectID, Integer.toString(architectID));

		if (match) {
			System.out.println("Architect ID is valid.");
		} else {
			throw new InvalidArchitectException("Architect ID is invalid: Only non-negative numbers are allowed.");
		}

		return match;
	}

	public static boolean validateName(String name) throws InvalidArchitectException {
		if (name == null) {
			throw new InvalidArchitectException("Architect name is null");
		}

		String regex = "^[A-Za-z]\\w{2,29}$";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(name);
		boolean match = m.matches();

		if (match) {
			System.out.println("The Architect name is valid.");
		} else {
			throw new InvalidArchitectException("The Architect name is not valid");
		}

		return match;
	}

	public static boolean validateGender(String gender) throws InvalidArchitectException {
		if (gender == null) {
			throw new InvalidArchitectException("Architect gender is null");
		}

		String regex = "^(Male|Female|Other)$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(gender);
		boolean isMatch = matcher.matches();

		if (isMatch) {
			System.out.println("The Architect gender is valid.");
		} else {
			throw new InvalidArchitectException("The Architect gender is not valid");
		}

		return isMatch;
	}

	public static boolean validatePhoneNumber(String phoneNumber) throws InvalidArchitectException {
		if (phoneNumber == null) {
			throw new InvalidArchitectException("Phone number is null");
		}

		String regex = "^(\\+?91|91)?[6-9]\\d{9}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(phoneNumber);
		boolean isMatch = matcher.matches();

		if (isMatch) {
			System.out.println("The phone number is: Valid");
		} else {
			throw new InvalidArchitectException("The phone number is: Invalid");
		}

		return isMatch;
	}

	public static boolean validateAddress(String address) throws InvalidArchitectException {
		if (address == null || address.trim().isEmpty()) {
			throw new InvalidArchitectException("Architect address is null or empty");
		}

		String regex = ".+";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(address);
		boolean isMatch = matcher.matches();

		if (isMatch) {
			System.out.println("The Architect address is valid.");
		} else {
			throw new InvalidArchitectException("The Architect address is not valid");
		}

		return isMatch;
	}

	
	
	public static boolean validateEmail(String email) throws InvalidArchitectException {
		if (email == null) {
			throw new InvalidArchitectException("Email address is null");
		}

		String regex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
		boolean isMatch = Pattern.matches(regex, email);

		if (isMatch) {
			System.out.println("The email address is: Valid");
		} else {
			throw new InvalidArchitectException("The email address is: Invalid");
		}

		return isMatch;
	}

	public static boolean validatePassword(String password) throws InvalidArchitectException {
		if (password == null) {
			throw new InvalidArchitectException("Architect password is null");
		}

		String patternString = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=])(?=.*[^\\s]).{8,}$";
		Pattern pattern = Pattern.compile(patternString);
		boolean isMatch = pattern.matcher(password).matches();

		if (isMatch) {
			System.out.println("Valid password.");
		} else {
			throw new InvalidArchitectException("User password not valid");
		}

		return isMatch;
	}

	public static boolean validateEducation(String education) throws InvalidArchitectException {
		if (education == null || education.trim().isEmpty()) {
			throw new InvalidArchitectException("Education is null or empty");
		}

		String regexEducation = "^[A-Za-z ]+$";
		Pattern pattern = Pattern.compile(regexEducation);
		boolean match = pattern.matcher(education).matches();

		if (match) {
			System.out.println("Education is valid.");
		} else {
			throw new InvalidArchitectException("Education is invalid");
		}

		return match;
	}

	public static boolean validateExperience(int experience) throws InvalidArchitectException {
		if (experience < 0) {
			throw new InvalidArchitectException("Experience is invalid: Negative value.");
		}

		String regexExperience = "^[0-9]{1,2}$";
		boolean match = Pattern.matches(regexExperience, Integer.toString(experience));

		if (match) {
			System.out.println("Experience is valid.");
		} else {
			throw new InvalidArchitectException("Experience is invalid");
		}

		return match;
	}

	public static boolean validateURL(String url) throws InvalidArchitectException {
		if (url == null || url.trim().isEmpty()) {
			throw new InvalidArchitectException("URL is null or empty");
		}

		System.out.println("URL is valid.");
		return true;
	}
	
}
