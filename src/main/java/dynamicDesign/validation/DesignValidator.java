package dynamicDesign.validation;


import java.util.regex.Pattern;

import dynamicDesign.model.Design;
import dynamicDesign.service.exception.ServiceException;
import dynamicDesign.validation.exception.InvalidUserException;

public class DesignValidator {
	

    public static boolean validateDesign(Design design) throws ServiceException {
        if (design == null) {
            throw new IllegalArgumentException("Design is null");
        }

        if (design.getDesignName() == null || design.getDesignName().trim().isEmpty()) {
            throw new ServiceException("Design name is required");
        }

        if (design.getDesignUrl() == null || design.getDesignUrl().trim().isEmpty()) {
            throw new ServiceException("Design URL is required");
        }

        if (design.getPrice() < 0) {
            throw new ServiceException("Price must be a non-negative value");
        }

        if (design.getEmail() == null || !isValidEmail(design.getEmail())) {
            throw new ServiceException("Invalid email");
        }

        
        if (design.getNoOfRoom() < 0) {
            throw new ServiceException("Number of rooms must be a non-negative value");
        }
        
        return true;
    }

    // Helper method to validate email format
    public static boolean isValidEmail(String email) {
    	boolean isMatch = false;

		if (email == null)
			return false;
		String regex = "^.*@.*\\..*$";
		isMatch = Pattern.matches(regex, email);
		if (isMatch) {
			System.out.println("The email address is: Valid");
		} else {
			System.out.println("The email address is: Invalid");
		}
		return isMatch;
       
    }
    

}