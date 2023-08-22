package com.fssa.dynamicdesign.validation;

import com.fssa.dynamicdesign.model.Design;
import com.fssa.dynamicdesign.validation.exception.InvalidDesignException;

public class DesignValidator {
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

	public static void validateDesignNull(Design design) throws InvalidDesignException {
		 if (design == null) {
		        throw new InvalidDesignException("Design is null");
		    }
	}
	
	public static void validateDesignName(String designName) throws InvalidDesignException {
	    if (designName == null || designName.trim().isEmpty()) {
	        throw new InvalidDesignException("Design name is required");
	    }
	}

	public static void validateDesignUrl(String designUrl) throws InvalidDesignException {
	    if (designUrl == null || designUrl.trim().isEmpty()) {
	        throw new InvalidDesignException("Design URL is required");
	    }
	}

	public static void validatePrice(double price) throws InvalidDesignException {
	    if (price < 0) {
	        throw new InvalidDesignException("Price must be a non-negative value");
	    }
	}


	public static void validateNoOfRooms(int noOfRooms) throws InvalidDesignException {
	    if (noOfRooms < 0) {
	        throw new InvalidDesignException("Number of rooms must be a non-negative value");
	    }
	}

	public static void validateDesignId(int designId) throws InvalidDesignException {
	    if (designId < 0) {
	        throw new InvalidDesignException("Invalid design ID: Null or negative value.");
	    }
	}
	
	public static void validateArchitectId(int architectId) throws InvalidDesignException {
	    if (architectId < 0) {
	        throw new InvalidDesignException("Invalid architect ID: Null or negative value.");
	    }
	}
	


}