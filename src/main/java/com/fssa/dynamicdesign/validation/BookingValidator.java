package com.fssa.dynamicdesign.validation;

import java.util.regex.Pattern;

import com.fssa.dynamicdesign.model.Booking;
import com.fssa.dynamicdesign.validation.exception.InvalidBookingException;

public class BookingValidator {

    /**
     * Validates the provided booking object.
     *
     * @param booking The booking to be validated.
     * @return True if the booking is valid, false otherwise.
     * @throws InvalidBookingException If the booking is not valid or null.
     */
    public static boolean validateBooking(Booking booking) throws InvalidBookingException {
        validateBookingNotNull(booking);
        validatePositiveInt(booking.getBookingId(), "Booking ID is not valid");
        validatePositiveInt(booking.getExpectedAmount(), "Expected amount is not valid");
        validatePositiveInt(booking.getExpectedMonths(), "Expected months is not valid");
        validatePositiveInt(booking.getArchitectId(), "Architect ID is not valid");
        validateDesignName(booking.getDesignName());
        validateDesignUrl(booking.getDesignUrl());
        validateMessage(booking.getMessage());
        validateStatus(booking.getStatus());

        return true;
    }

    /**
     * Validates the booking object for null.
     *
     * @param booking The booking object to be validated.
     * @return True if the booking object is not null, false otherwise.
     * @throws InvalidBookingException If the booking object is null.
     */
    public static boolean validateBookingNotNull(Booking booking) throws InvalidBookingException {
        if (booking == null) {
            throw new InvalidBookingException("Booking is null");
        }
        return true;
    }

    /**
     * Validates a positive integer.
     *
     * @param value       The integer value to be validated.
     * @param errorMessage The error message to be used if the value is not valid.
     * @throws InvalidBookingException If the value is not a positive integer.
     */
    public static void validatePositiveInt(int value, String errorMessage) throws InvalidBookingException {
        if (value > 0) {
            throw new InvalidBookingException(errorMessage);
        }
    }

    /**
     * Validates the design name.
     *
     * @param designName The design name to be validated.
     * @throws InvalidBookingException If the design name is null or empty.
     */
    public static void validateDesignName(String designName) throws InvalidBookingException {
        if (designName == null || designName.trim().isEmpty()) {
            throw new InvalidBookingException("Design name is null or empty");
        }
    }

    /**
     * Validates the design URL.
     *
     * @param designUrl The design URL to be validated.
     * @throws InvalidBookingException If the design URL is not a valid URL.
     */
    public static void validateDesignUrl(String designUrl) throws InvalidBookingException {
        if (designUrl == null || designUrl.trim().isEmpty()) {
            throw new InvalidBookingException("Design URL is null or empty");
        }
    }

    /**
     * Validates the message.
     *
     * @param message The message to be validated.
     * @throws InvalidBookingException If the message is null or empty.
     */
    public static void validateMessage(String message) throws InvalidBookingException {
        if (message == null || message.trim().isEmpty()) {
            throw new InvalidBookingException("Message is null or empty");
        }
    }

    /**
     * Validates the status.
     *
     * @param status The status to be validated.
     * @throws InvalidBookingException If the status is not one of "Pending," "Accepted," or "Rejected."
     */
    public static void validateStatus(String status) throws InvalidBookingException {
        if (!"Pending".equals(status) && !"Accepted".equals(status) && !"Rejected".equals(status)) {
            throw new InvalidBookingException("Status is not valid");
        }
    }
}
