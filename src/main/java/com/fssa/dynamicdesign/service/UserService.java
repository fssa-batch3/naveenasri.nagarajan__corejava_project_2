package com.fssa.dynamicdesign.service;

import java.sql.SQLException;

import com.fssa.dynamicdesign.dao.UserDAO;
import com.fssa.dynamicdesign.dao.exception.DAOException;
import com.fssa.dynamicdesign.model.User;
import com.fssa.dynamicdesign.service.exception.ServiceException;
import com.fssa.dynamicdesign.validation.UserValidator;
import com.fssa.dynamicdesign.validation.exception.InvalidUserException;

public class UserService {

    /**
     * Registers a new user.
     *
     * @param user The user to be registered.
     * @return True if registration is successful, false otherwise.
     * @throws ServiceException If an error occurs during registration.
     */
    public boolean registerUser(User user) throws ServiceException {
        UserDAO userDAO = new UserDAO();

        try {
        	
        	 // Check if the user is null
            if (user == null) {
                throw new InvalidUserException("User is null while updating");
            }
            
            
            // Check if the email already exists
            if (userDAO.isEmailExists(user.getEmail())) {
                throw new ServiceException("User with this email already exists");
            }

            // Validate the user's details using the UserValidator
            UserValidator.validateUser(user);

            return userDAO.register(user);
        } catch (InvalidUserException | SQLException e) {
            throw new ServiceException(e);
        }
    }

    /**
     * Logs in a user.
     *
     * @param user  The user attempting to log in.
     * @param email The user's email.
     * @return True if login is successful, false otherwise.
     * @throws ServiceException If an error occurs during login.
     */
    public boolean loginUser(User user, String email) throws ServiceException {
        try {
            // Validate the email and password using UserValidator
            UserValidator.validateEmail(email);
            UserValidator.validatePassword(user.getPassword());

            UserDAO userDAO = new UserDAO();

            // Check if the user exists before attempting to log in
            if (!userDAO.isEmailExists(email)) {
                throw new ServiceException("Before logging in, you have to register");
            }

            return userDAO.login(user, email);
        } catch (ServiceException e) {
            throw e;
        } catch (Exception e) {
            throw new ServiceException(e.getLocalizedMessage());
        }
    }

    /**
     * Updates user information.
     *
     * @param user  The updated user information.
     * @param email The email of the user to be updated.
     * @return True if update is successful, false otherwise.
     * @throws ServiceException If an error occurs during update.
     */
    public boolean updateUser(User user, String email) throws ServiceException {
        UserDAO userDAO = new UserDAO();

        try {
            // Check if the user is null
            if (user == null) {
                throw new InvalidUserException("User is null while updating");
            }

            // Check if the user exists before attempting to update
            if (!userDAO.isEmailExists(email)) {
                throw new ServiceException("User with this email does not exist");
            }

            // Validate the user's details using the UserValidator
            UserValidator.validateUser(user);

            return userDAO.updateUser(user);
        } catch (InvalidUserException | SQLException e) {
            throw new ServiceException(e);
        }
    }

    /**
     * Deletes a user based on email.
     *
     * @param email The email of the user to be deleted.
     * @return True if deletion is successful, false otherwise.
     * @throws ServiceException If an error occurs during deletion.
     */
    public boolean deleteUser(String email) throws ServiceException {
        UserDAO userDAO = new UserDAO();
        try {
            // Check if the email is null
            if (email == null) {
                throw new InvalidUserException("User is null while deleting ");
            }

            // Check if the user exists before attempting to delete
            if (!userDAO.isEmailExists(email)) {
                throw new ServiceException("User with this email does not exist");
            }

            // Validate the email using the UserValidator
            UserValidator.validateEmail(email);

            return userDAO.deleteUser(email);
        } catch (InvalidUserException | SQLException e) {
            throw new ServiceException(e);
        }
    }
    
    
    /**
     * Retrieves a user by their email address.
     *
     * @param email The email address of the user to retrieve.
     * @return The User object if found, or null if not found.
     * @throws ServiceException If an error occurs while retrieving the user.
     */
    public User getUserByEmail(String email) throws ServiceException {
        try {
            // Validate the email (if needed)
            UserValidator.validateEmail(email);

            UserDAO userDAO = new UserDAO(); // Assuming you have a UserDAO implementation

            // Retrieve the user by email from the DAO
            return userDAO.getUserByEmail(email);
        } catch (InvalidUserException | DAOException e) {
            throw new ServiceException(e);
        }
    }

}
