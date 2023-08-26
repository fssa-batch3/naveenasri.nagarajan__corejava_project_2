package com.fssa.dynamicdesign.validation;

import com.fssa.dynamicdesign.model.Design;
import com.fssa.dynamicdesign.validation.exception.InvalidDesignException;

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
		validateDesignName(design.getDesignName());
		validateDesignUrl(design.getDesignUrl());
		validatePrice(design.getPrice());
		validateNoOfRooms(design.getNoOfRooms());
		validateDesignId(design.getDesignId());
		validateArchitectId(design.getArchitectId());

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
	 * Validates the design's name.
	 *
	 * @param designName The name of the design to be validated.
	 * @throws InvalidDesignException If the design name is null or empty.
	 */
	public static void validateDesignName(String designName) throws InvalidDesignException {
		if (designName == null || designName.trim().isEmpty()) {
			throw new InvalidDesignException("Design name is required");
		}
	}

	/**
	 * Validates the design's URL.
	 *
	 * @param designUrl The URL of the design to be validated.
	 * @throws InvalidDesignException If the design URL is null or empty.
	 */
	public static void validateDesignUrl(String designUrl) throws InvalidDesignException {
		if (designUrl == null || designUrl.trim().isEmpty()) {
			throw new InvalidDesignException("Design URL is required");
		}
	}

	/**
	 * Validates the design's price.
	 *
	 * @param price The price of the design to be validated.
	 * @throws InvalidDesignException If the price is negative.
	 */
	public static void validatePrice(double price) throws InvalidDesignException {
		if (price < 0) {
			throw new InvalidDesignException("Price must be a non-negative value");
		}
	}

	/**
	 * Validates the number of rooms in the design.
	 *
	 * @param noOfRooms The number of rooms in the design to be validated.
	 * @throws InvalidDesignException If the number of rooms is negative.
	 */
	public static void validateNoOfRooms(int noOfRooms) throws InvalidDesignException {
		if (noOfRooms < 0) {
			throw new InvalidDesignException("Number of rooms must be a non-negative value");
		}
	}

	/**
	 * Validates the design's ID.
	 *
	 * @param designId The ID of the design to be validated.
	 * @throws InvalidDesignException If the design ID is negative.
	 */
	public static void validateDesignId(int designId) throws InvalidDesignException {
		if (designId < 0) {
			throw new InvalidDesignException("Invalid design ID: Null or negative value.");
		}
	}

	/**
	 * Validates the architect's ID associated with the design.
	 *
	 * @param architectId The ID of the architect associated with the design to be
	 *                    validated.
	 * @throws InvalidDesignException If the architect ID is negative.
	 */
	public static void validateArchitectId(int architectId) throws InvalidDesignException {
		if (architectId < 0) {
			throw new InvalidDesignException("Invalid architect ID: Null or negative value.");
		}
	}
}
