package dynamicDesign.service;

import dynamicDesign.model.*;
import dynamicDesign.service.exception.ServiceException;

import java.sql.SQLException;

import dynamicDesign.dao.*;
import dynamicDesign.validation.*;
import dynamicDesign.validation.exception.InvalidUserException;

public class UserService {


	
	public boolean registerUser(User user) throws ServiceException {
	    UserDAO userDAO = new UserDAO();

	    try {
	        // Check if the user is null
	        if (user == null) {
	            throw new InvalidUserException("User is null");
	        }
	        // Check if the email already exists
	        if (userDAO.isEmailExists(user.getEmail())) {
	            throw new ServiceException("User with this email already exists");
	        }

	        UserValidator.validateUser(user);
	        return userDAO.register(user);
	    } catch (InvalidUserException | SQLException e) {
	        throw new ServiceException(e);
	    }
	}

	public boolean loginUser(User user, String email) throws ServiceException {
	    try {
	        UserValidator.validateEmail(email); // Use the provided email for validation
	        UserValidator.validatePassword(user.getPassword());

	        UserDAO userDAO = new UserDAO();

	        // Check if the email already exists
	        if (!userDAO.isEmailExists(email)) {
	            throw new ServiceException("Before logging in, you have to register");
	        }

	        if (userDAO.login(user, email)) {
	            System.out.println(email + " Successfully logged in");
	            return true;
	        } else {
	            return false;
	        }
	    } catch (ServiceException e) {
	        throw e; // Rethrow the ServiceException
	    } catch (Exception e) {
	        throw new ServiceException(e.getLocalizedMessage());
	    }
	}



	    // Update user information
	    public boolean updateUser(User user, String email) throws ServiceException {
	        UserDAO userDAO = new UserDAO();

	        try {
	            // Check if the user is null
	            if (user == null) {
	                throw new InvalidUserException("User is null");
	            }

	            // Check if the email exists before attempting to update
	            if (!userDAO.isEmailExists(email)) {
	                throw new ServiceException("User with this email does not exist");
	            }

	            UserValidator.validateUser(user);
	            return userDAO.updateUser(user, email);
	        } catch (InvalidUserException | SQLException e) {
	            throw new ServiceException(e);
	        }
	    }

	 // Delete user based on email
	    public static boolean deleteUser(String email) throws ServiceException {
	        UserDAO userDAO = new UserDAO();

	        try {
	            // Check if the email exists before attempting to delete
	            if (!userDAO.isEmailExists(email)) {
	                throw new ServiceException("User with this email does not exist");
	            }
	            
	            
	            return userDAO.deleteUser(email);
	        } catch (SQLException e) {
	            throw new ServiceException(e);
	        }
	    }
	    
	    
	    public static void main(String[]args) {
	      try{
	    	  System.out.print(deleteUser("maha12@gmail.com"));
	      }catch(Exception e) {
	    	  e.printStackTrace();
	    	  
	      }
	    }


}
