package com.fssa.dynamicdesign.validation;

import java.util.regex.Pattern;

import com.fssa.dynamicdesign.model.Architect;
import com.fssa.dynamicdesign.validation.exception.InvalidArchitectException;

public class ArchitectValidator {

    public static void validateArchitect(Architect architect) throws InvalidArchitectException {
        if (architect == null || !isArchitectValid(architect)) {
            throw new InvalidArchitectException("Architect details not valid");
        }
    }

    public static boolean isArchitectValid(Architect architect) {
        return architect != null &&
                validateArchitectID(architect.getArchitectID()) &&
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
                validateURL(architect.getNATACertificate());
    }

    public static boolean validateArchitectID(int architectID) {
        return architectID >= 0 && Pattern.matches("^\\d+$", Integer.toString(architectID));
    }

    public static boolean validateName(String name) {
        return name != null && Pattern.matches("^[A-Za-z]\\w{2,29}$", name);
    }

    public static boolean validateGender(String gender) {
        return gender != null && Pattern.matches("^(Male|Female|Other)$", gender);
    }

    public static boolean validatePhoneNumber(String phoneNumber) {
        return phoneNumber != null && Pattern.matches("^(\\+?91|91)?[6-9]\\d{9}$", phoneNumber);
    }

    public static boolean validateAddress(String address) {
        return address != null && !address.trim().isEmpty();
    }

    public static boolean validateEmail(String email) {
        return email != null && Pattern.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", email);
    }

    public static boolean validatePassword(String password) {
        return password != null && Pattern.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=])(?=.*[^\\s]).{8,}$", password);
    }

    public static boolean validateEducation(String education) {
        return education != null && Pattern.matches("^[A-Za-z ]+$", education.trim());
    }

    public static boolean validateExperience(int experience) {
        return experience >= 0 && Pattern.matches("^\\d{1,2}$", Integer.toString(experience));
    }

    public static boolean validateURL(String url) {
        return url != null && !url.trim().isEmpty();
    }

    public static void validateDeleteArchitect(Architect architect) throws InvalidArchitectException {
        if (architect == null || architect.getArchitectID() <= 0 || !validateEmail(architect.getEmail())) {
            throw new InvalidArchitectException("Invalid Architect details for deletion");
        }
    }
}
