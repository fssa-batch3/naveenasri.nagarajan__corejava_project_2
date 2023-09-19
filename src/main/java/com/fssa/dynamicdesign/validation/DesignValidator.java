package com.fssa.dynamicdesign.validation;

import com.fssa.dynamicdesign.model.Design;
import com.fssa.dynamicdesign.validation.exception.InvalidDesignException;

import java.util.List;

public class DesignValidator {

    /**
     * Validates the provided Design object.
     *
     * @param design The Design object to be validated.
     * @return True if the Design is valid, false otherwise.
     * @throws InvalidDesignException If the Design is not valid or null.
     */
    public static boolean validateDesign(Design design) throws InvalidDesignException {
        validateDesignNull(design);
        validateNotEmpty(design.getDesignName(), "Design name is required");
        validateNotEmpty(design.getDesignUrls(), "Design URLs are null or empty");
        validateNotNegative(design.getPricePerSqFt(), "Price must be a non-negative value");
        validateNotNegative(design.getSquareFeet(), "Square feet must be a non-negative value");
        validateCategory(design.getCategory());
        validateFloorPlan(design.getFloorPlan());
        validateLength(design.getBio(), "Design bio must be between 45 and 180 characters", 45, 180);
        validateLength(design.getBrief(), "Design brief must be more than 100 characters", 100,2000);
        validateNotNegative(design.getDesignId(), "Invalid design ID: Null or negative value.");
        validateNotNegative(design.getArchitectId(), "Invalid architect ID: Null or negative value.");
       

        return true;
    }

    /**
     * Validates if the provided Design is null.
     *
     * @param design The Design object to be validated.
     * @throws InvalidDesignException If the Design is null.
     */
    public static void validateDesignNull(Design design) throws InvalidDesignException {
        if (design == null) {
            throw new InvalidDesignException("Design is null");
        }
    }

    /**
     * Validates if a value is not null or empty.
     *
     * @param value  The value to be validated.
     * @param error  The error message to be thrown if the value is null or empty.
     * @throws InvalidDesignException If the value is null or empty.
     */
    public static void validateNotEmpty(String value, String error) throws InvalidDesignException {
        if (value == null || value.trim().isEmpty()) {
            throw new InvalidDesignException(error);
        }
    }

    /**
     * Validates if a list is not null or empty.
     *
     * @param list  The list to be validated.
     * @param error  The error message to be thrown if the list is null or empty.
     * @throws InvalidDesignException If the list is null or empty.
     */
    public static void validateNotEmpty(List<String> list, String error) throws InvalidDesignException {
        if (list == null || list.isEmpty()) {
            throw new InvalidDesignException(error);
        }
    }

    /**
     * Validates if a numeric value is not negative.
     *
     * @param value  The numeric value to be validated.
     * @param error  The error message to be thrown if the value is negative.
     * @throws InvalidDesignException If the value is negative.
     */
    public static void validateNotNegative(double value, String error) throws InvalidDesignException {
        if (value < 0) {
            throw new InvalidDesignException(error);
        }
    }

    /**
     * Validates if a numeric value is not negative.
     *
     * @param value  The numeric value to be validated.
     * @param error  The error message to be thrown if the value is negative.
     * @throws InvalidDesignException If the value is negative.
     */
    public static void validateNotNegative(int value, String error) throws InvalidDesignException {
        if (value < 0) {
            throw new InvalidDesignException(error);
        }
    }

    /**
     * Validates a string against an allowed set of values.
     *
     * @param value  The string to be validated.
     * @param allowedValues  An array of allowed values.
     * @throws InvalidDesignException If the value is not one of the allowed values.
     */
    public static void validateCategory(String value) throws InvalidDesignException {
        String[] allowedCategories = {"Bedroom", "Livingroom", "Kitchen", "Bathroom", "others"};
        boolean validCategory = false;
        for (String allowedCategory : allowedCategories) {
            if (allowedCategory.equalsIgnoreCase(value)) {
                validCategory = true;
                break;
            }
        }
        if (!validCategory) {
            throw new InvalidDesignException("Invalid design category");
        }
    }

    /**
     * Validates a string against an allowed set of values.
     *
     * @param value  The string to be validated.
     * @param allowedValues  An array of allowed values.
     * @throws InvalidDesignException If the value is not one of the allowed values.
     */
    public static void validateFloorPlan(String value) throws InvalidDesignException {
        String[] allowedFloorPlans = {"1BHK", "2BHK", "3BHK", "3+BHK", "others"};
        boolean validFloorPlan = false;
        for (String allowedPlan : allowedFloorPlans) {
            if (allowedPlan.equalsIgnoreCase(value)) {
                validFloorPlan = true;
                break;
            }
        }
        if (!validFloorPlan) {
            throw new InvalidDesignException("Invalid design floor plan");
        }
    }

    /**
     * Validates the length of a string.
     *
     * @param value  The string to be validated.
     * @param error  The error message to be thrown if the length is not within the specified range.
     * @param minLength  The minimum allowed length.
     * @param maxLength  The maximum allowed length.
     * @throws InvalidDesignException If the length is not within the specified range.
     */
    public static void validateLength(String value, String error, int minLength, int maxLength) throws InvalidDesignException {
        if (value == null || value.trim().isEmpty() || value.length() < minLength || value.length() > maxLength) {
            throw new InvalidDesignException(error);
        }
    }
    
   


    
}
