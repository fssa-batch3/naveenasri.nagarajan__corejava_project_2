package com.fssa.dynamicdesign.validation;

import java.util.regex.Pattern;

import com.fssa.dynamicdesign.model.Architect;
import com.fssa.dynamicdesign.validation.exception.InvalidArchitectException;

public class ArchitectValidator {

    public static boolean validateArchitect(Architect architect) throws InvalidArchitectException {
        if (architect == null || !isValidArchitect(architect)) {
            throw new InvalidArchitectException("Architect details are not valid");
        }
        return true;
    }

    private static boolean isValidArchitect(Architect architect) {
        try {
            return validateArchitectID(architect.getArchitectID())
                    && validateName(architect.getName())
                    && validateGender(architect.getGender())
                    && validatePhoneNumber(architect.getPhoneNumber())
                    && validateAddress(architect.getAddress())
                    && validateEmail(architect.getEmail())
                    && validatePassword(architect.getPassword())
                    && validateEducation(architect.getEducation())
                    && validateExperience(architect.getExperience())
                    && validateURL(architect.getProfilePhoto())
                    && validateURL(architect.getCoverPhoto())
                    && validateURL(architect.getDegreeCertificate())
                    && validateURL(architect.getNATACertificate());
        } catch (InvalidArchitectException e) {
            // Handle the exception or re-throw it as necessary
            e.printStackTrace(); // Just printing the stack trace as an example
            return false;
        }
    }


    private static void throwError(String errorMessage) throws InvalidArchitectException {
        throw new InvalidArchitectException(errorMessage);
    }

    public static boolean validateArchitectID(int architectID) throws InvalidArchitectException {
        if (architectID < 0) {
            throwError("Architect ID is invalid: Negative value");
        }
        return Pattern.matches("^\\d+$", Integer.toString(architectID));
    }

    public static boolean validateName(String name) throws InvalidArchitectException {
        if (name == null || !Pattern.matches("^[A-Za-z]\\w{2,29}$", name)) {
            throwError("Architect name is not valid");
        }
        return true;
    }

    public static boolean validateGender(String gender) throws InvalidArchitectException {
        if (gender == null || !Pattern.matches("^(Male|Female|Other)$", gender)) {
            throwError("Architect gender is not valid");
        }
        return true;
    }

    public static boolean validatePhoneNumber(String phoneNumber) throws InvalidArchitectException {
        if (phoneNumber == null || !Pattern.matches("^(\\+?91)?[6-9]\\d{9}$", phoneNumber)) {
            throwError("Phone number is not valid");
        }
        return true;
    }

    public static boolean validateAddress(String address) throws InvalidArchitectException {
        if (address == null || address.trim().isEmpty()) {
            throwError("Architect address is null or empty");
        }
        return true;
    }

    public static boolean validateEmail(String email) throws InvalidArchitectException {
        if (email == null || !Pattern.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", email)) {
            throwError("Email address is not valid");
        }
        return true;
    }

    public static boolean validatePassword(String password) throws InvalidArchitectException {
        if (password == null || !Pattern.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=])(?=.*[^\\s]).{8,}$", password)) {
            throwError("Architect password is not valid");
        }
        return true;
    }

    public static boolean validateEducation(String education) throws InvalidArchitectException {
        if (education == null || education.trim().isEmpty() || !Pattern.matches("^[A-Za-z ]+$", education)) {
            throwError("Education is not valid");
        }
        return true;
    }

    public static boolean validateExperience(int experience) throws InvalidArchitectException {
        if (experience < 0 || !Pattern.matches("^\\d{1,2}$", Integer.toString(experience))) {
            throwError("Experience is not valid");
        }
        return true;
    }

    public static boolean validateURL(String url) throws InvalidArchitectException {
        if (url == null || url.trim().isEmpty()) {
            throwError("URL is null or empty");
        }
        return true;
    }

    public static boolean validateDeleteArchitect(Architect architect) throws InvalidArchitectException {
        if (architect != null && architect.getArchitectID() > 0 && validateEmail(architect.getEmail())) {
            return true;
        } else {
            throwError("Invalid Architect details for deletion");
        }
        return false;
    }
}
