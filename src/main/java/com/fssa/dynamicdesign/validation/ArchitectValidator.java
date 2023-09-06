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
    	validateURL(architect.getProfilePhoto());
    	validateURL(architect.getCoverPhoto());
    	validateURL(architect.getDegreeCertificate());
    	validateURL(architect.getNATACertificate());
    	
    	return true;
    	
    }

    /**
     * Throws an InvalidArchitectException with the provided error message.
     *
     * @param errorMessage The error message for the exception.
     * @throws InvalidArchitectException Always throws the exception.
     */
    private static void throwError(String errorMessage) throws InvalidArchitectException {
        throw new InvalidArchitectException(errorMessage);
    }

    
    /**
     * Validates the architect's ID.
     *
     * @param architectID The architect ID to be validated.
     * @return True if the architect ID is valid, false otherwise.
     * @throws InvalidArchitectException If the architect ID is not valid.
     */
    public static boolean validateArchitectID(int architectID) throws InvalidArchitectException {
        if (architectID < 0) {
            throwError("Architect ID is invalid: Negative value");
        }
        return Pattern.matches("^\\d+$", Integer.toString(architectID));
    }

    
    /**
     * Validates the architect object for null.
     *
     * @param architect The architect object to be validated.
     * @return True if the architect object is not null, false otherwise.
     * @throws InvalidArchitectException If the architect object is null.
     */
    private static boolean validateArchitectNotNull(Architect architect) throws InvalidArchitectException {
        if (architect == null) {
            throwError("Architect is null");
        }
        return true;
    }

    
    /**
     * Validates the architect's name.
     *
     * @param name The architect's name to be validated.
     * @return True if the name is valid, false otherwise.
     * @throws InvalidArchitectException If the name is not valid.
     */
    public static boolean validateName(String name) throws InvalidArchitectException {
        if (name == null || !Pattern.matches("^[A-Za-z]\\w{2,29}$", name)) {
            throwError("Architect name is not valid");
        }
        return true;
    }

    
    /**
     * Validates the architect's gender.
     *
     * @param gender The architect's gender to be validated.
     * @return True if the gender is valid, false otherwise.
     * @throws InvalidArchitectException If the gender is not valid.
     */
    public static boolean validateGender(String gender) throws InvalidArchitectException {
        if (gender == null || !Pattern.matches("^(Male|Female|Other)$", gender)) {
            throwError("Architect gender is not valid");
        }
        return true;
    }

    
    /**
     * Validates the architect's phone number.
     *
     * @param phoneNumber The architect's phone number to be validated.
     * @return True if the phone number is valid, false otherwise.
     * @throws InvalidArchitectException If the phone number is not valid.
     */
    public static boolean validatePhoneNumber(String phoneNumber) throws InvalidArchitectException {
        if (phoneNumber == null || !Pattern.matches("^(\\+?91)?[6-9]\\d{9}$", phoneNumber)) {
            throwError("Phone number is not valid");
        }
        return true;
    }

    
    /**
     * Validates the architect's address.
     *
     * @param address The architect's address to be validated.
     * @return True if the address is valid, false otherwise.
     * @throws InvalidArchitectException If the address is not valid.
     */
    public static boolean validateAddress(String address) throws InvalidArchitectException {
        if (address == null || address.trim().isEmpty()) {
            throwError("Architect address is null or empty");
        }
        return true;
    }

    
    /**
     * Validates the architect's email.
     *
     * @param email The architect's email address to be validated.
     * @return True if the email address is valid, false otherwise.
     * @throws InvalidArchitectException If the email address is not valid.
     */
    public static boolean validateEmail(String email) throws InvalidArchitectException {
        if (email == null || !Pattern.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", email)) {
            throwError("Email address is not valid");
        }
        return true;
    }

    
    
    /**
     * Validates the architect's password.
     *
     * @param password The architect's password to be validated.
     * @return True if the password is valid, false otherwise.
     * @throws InvalidArchitectException If the password is not valid.
     */
    public static boolean validatePassword(String password) throws InvalidArchitectException {
        if (password == null || !Pattern.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=])(?=.*[^\\s]).{8,}$", password)) {
            throwError("Architect password is not valid");
        }
        return true;
    }

    
    
    /**
     * Validates the architect's education.
     *
     * @param education The architect's education to be validated.
     * @return True if the education is valid, false otherwise.
     * @throws InvalidArchitectException If the education is not valid.
     */
    public static boolean validateEducation(String education) throws InvalidArchitectException {
        if (education == null || education.trim().isEmpty() || !Pattern.matches("^[A-Za-z ]+$", education)) {
            throwError("Education is not valid");
        }
        return true;
    }
    
    
    
    /**
     * Validates the architect's experience.
     *
     * @param experience The architect's experience to be validated.
     * @return True if the experience is valid, false otherwise.
     * @throws InvalidArchitectException If the experience is not valid.
     */
    public static boolean validateExperience(int experience) throws InvalidArchitectException {
        if (experience < 0 || !Pattern.matches("^\\d{1,2}$", Integer.toString(experience))) {
            throwError("Experience is not valid");
        }
        return true;
    }

    
    
    /**
     * Validates a URL.
     *
     * @param url The URL to be validated.
     * @return True if the URL is valid, false otherwise.
     * @throws InvalidArchitectException If the URL is not valid.
     */
    public static boolean validateURL(String url) throws InvalidArchitectException {
        if (url == null || url.trim().isEmpty()) {
            throwError("URL is null or empty");
        }
        return true;
    }


 
}
