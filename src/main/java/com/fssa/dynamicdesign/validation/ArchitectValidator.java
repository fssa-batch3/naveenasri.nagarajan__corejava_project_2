package com.fssa.dynamicdesign.validation;

import java.util.regex.Pattern;

import com.fssa.dynamicdesign.model.Architect;
import com.fssa.dynamicdesign.validation.exception.InvalidArchitectException;

public class ArchitectValidator {

    /**
     * Validates the provided architect object.
     *
     * @param architect The architect to be validated.
     * @return True if the architect is valid, false otherwise.
     * @throws InvalidArchitectException If the architect is not valid or null.
     */
    public static boolean validateArchitect(Architect architect) throws InvalidArchitectException {
    	validateArchitectNotNull(architect);
        validateArchitectID(architect.getArchitectID());
        validateName(architect.getName());
        validateGender(architect.getGender());
        validatePhoneNumber(architect.getPhoneNumber());
        validateAddress(architect.getAddress());
        validateEmail(architect.getEmail());
        validatePassword(architect.getPassword());
        validateEducation(architect.getEducation());
        validateExperience(architect.getExperience());
        validateURL(architect.getProfilePhoto(), "Profile photo URL is null or empty");
        validateURL(architect.getCoverPhoto(), "Cover photo URL is null or empty");
        validateURL(architect.getDegreeCertificate(), "Degree certificate URL is null or empty");
        validateURL(architect.getNATACertificate(), "NATA certificate URL is null or empty");

        return true;
    }
    
    public static boolean validateUpdateArchitect(Architect architect) throws InvalidArchitectException {
    	validateArchitectNotNull(architect);
        validateArchitectID(architect.getArchitectID());
        validateName(architect.getName());
        validateGender(architect.getGender());
        validatePhoneNumber(architect.getPhoneNumber());
        validateAddress(architect.getAddress());
        validateEmail(architect.getEmail());
        validateEducation(architect.getEducation());
        validateExperience(architect.getExperience());
        validateURL(architect.getProfilePhoto(), "Profile photo URL is null or empty");
        validateURL(architect.getCoverPhoto(), "Cover photo URL is null or empty");
        validateURL(architect.getDegreeCertificate(), "Degree certificate URL is null or empty");
        validateURL(architect.getNATACertificate(), "NATA certificate URL is null or empty");

        return true;
    }

    /**
     * Validates the architect object for null.
     *
     * @param architect The architect object to be validated.
     * @return True if the architect object is not null, false otherwise.
     * @throws InvalidArchitectException If the architect object is null.
     */
    public static boolean validateArchitectNotNull(Architect architect) throws InvalidArchitectException {
        if (architect == null) {
        	throw new InvalidArchitectException("Architect is null");
        }
        return true;
    }
    
    /**
     * Validates the architect's ID.
     *
     * @param architectID The architect ID to be validated.
     * @throws InvalidArchitectException If the architect ID is negative.
     */
    public static void validateArchitectID(int architectID) throws InvalidArchitectException {
        if (architectID < 0) {
            throw new InvalidArchitectException("Architect ID is invalid: Negative value");
        }
    }

    /**
     * Validates the architect's name.
     *
     * @param name The architect's name to be validated.
     * @throws InvalidArchitectException If the name is not valid.
     */
    public static void validateName(String name) throws InvalidArchitectException {
        if (name == null || !Pattern.matches("^[A-Za-z]\\w{2,29}$", name)) {
            throw new InvalidArchitectException("Architect name is not valid");
        }
    }

    /**
     * Validates the architect's gender.
     *
     * @param gender The architect's gender to be validated.
     * @throws InvalidArchitectException If the gender is not valid.
     */
    public static void validateGender(String gender) throws InvalidArchitectException {
        if (gender == null || !Pattern.matches("^(Male|Female|Other)$", gender)) {
            throw new InvalidArchitectException("Architect gender is not valid");
        }
    }

    /**
     * Validates the architect's phone number.
     *
     * @param phoneNumber The architect's phone number to be validated.
     * @throws InvalidArchitectException If the phone number is not valid.
     */
    public static void validatePhoneNumber(String phoneNumber) throws InvalidArchitectException {
        if (phoneNumber == null || !Pattern.matches("^(\\+?91)?[6-9]\\d{9}$", phoneNumber)) {
            throw new InvalidArchitectException("Phone number is not valid");
        }
    }

    /**
     * Validates the architect's address.
     *
     * @param address The architect's address to be validated.
     * @throws InvalidArchitectException If the address is null or empty.
     */
    public static void validateAddress(String address) throws InvalidArchitectException {
        if (address == null || address.trim().isEmpty()) {
            throw new InvalidArchitectException("Architect address is null or empty");
        }
    }

    /**
     * Validates the architect's email.
     *
     * @param email The architect's email address to be validated.
     * @throws InvalidArchitectException If the email address is not valid.
     */
    public static void validateEmail(String email) throws InvalidArchitectException {
        if (email == null || !Pattern.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", email)) {
            throw new InvalidArchitectException("Email address is not valid");
        }
    }

    /**
     * Validates the architect's password.
     *
     * @param password The architect's password to be validated.
     * @throws InvalidArchitectException If the password is not valid.
     */
    public static void validatePassword(String password) throws InvalidArchitectException {
        if (password == null || !Pattern.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=])(?=.*[^\\s]).{8,}$", password)) {
            throw new InvalidArchitectException("Architect password is not valid");
        }
    }

    /**
     * Validates the architect's education.
     *
     * @param education The architect's education to be validated.
     * @throws InvalidArchitectException If the education is null, empty, or contains invalid characters.
     */
    public static void validateEducation(String education) throws InvalidArchitectException {
        if (education == null || education.trim().isEmpty() || !Pattern.matches("^[A-Za-z ]+$", education)) {
            throw new InvalidArchitectException("Education is not valid");
        }
    }

    /**
     * Validates the architect's experience.
     *
     * @param experience The architect's experience to be validated.
     * @throws InvalidArchitectException If the experience is negative or contains more than 2 digits.
     */
    public static void validateExperience(int experience) throws InvalidArchitectException {
        if (experience < 0 || experience >= 100) {
            throw new InvalidArchitectException("Experience is not valid");
        }
    }

    /**
     * Validates a URL.
     *
     * @param url         The URL to be validated.
     * @param errorMessage The error message to be used if the URL is not valid.
     * @throws InvalidArchitectException If the URL is null or empty.
     */
    public static void validateURL(String url, String errorMessage) throws InvalidArchitectException {
        if (url == null || url.trim().isEmpty()) {
            throw new InvalidArchitectException(errorMessage);
        }
    }
}
