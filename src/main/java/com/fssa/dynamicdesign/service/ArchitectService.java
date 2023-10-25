package com.fssa.dynamicdesign.service;

import java.sql.SQLException;
import java.util.Base64;
import java.util.List;

import com.fssa.dynamicdesign.dao.ArchitectDAO;
import com.fssa.dynamicdesign.dao.exception.DAOException;
import com.fssa.dynamicdesign.model.Architect;
import com.fssa.dynamicdesign.service.exception.ServiceException;
import com.fssa.dynamicdesign.util.PasswordUtil;
import com.fssa.dynamicdesign.validation.ArchitectValidator;
import com.fssa.dynamicdesign.validation.exception.InvalidArchitectException;

public class ArchitectService {

    /**
     * Registers a new architect.
     *
     * @param architect The architect to be registered.
     * @return True if registration is successful, false otherwise.
     * @throws ServiceException If an error occurs during registration.
     */
    public boolean registerArchitect(Architect architect) throws ServiceException {
        ArchitectDAO architectDAO = new ArchitectDAO();

        try {
            // Validate the architect's details using the ArchitectValidator
            ArchitectValidator.validateArchitect(architect);
            
            byte[] salt = PasswordUtil.generateSalt();
            byte[] derivedKey = PasswordUtil.deriveKey(architect.getPassword(), salt);
            architect.setSalt(Base64.getEncoder().encodeToString(salt));
            architect.setPassword(Base64.getEncoder().encodeToString(derivedKey));
            
            
            // Call the DAO's arcRegister method to register the architect
            return architectDAO.arcRegister(architect);
        } catch (Exception e) {
            throw new ServiceException(e);
        }
    }

    /**
     * Logs in an architect.
     *
     * @param architect The architect attempting to log in.
     * @param email The email of the architect.
     * @return True if login is successful, false otherwise.
     * @throws ServiceException If an error occurs during login.
     */
    public boolean loginArchitect(Architect architect, String email) throws ServiceException {
        try {
            // Validate email format and password using ArchitectValidator
            ArchitectValidator.validateEmail(email);
            ArchitectValidator.validatePassword(architect.getPassword());

            ArchitectDAO architectDAO = new ArchitectDAO();

            // Check if the email exists in the database
            if (!architectDAO.isEmailExists(email)) {
                throw new ServiceException("Before logging in, you have to register");
            }

            
            return architectDAO.login(architect, email);

        } catch (SQLException | InvalidArchitectException | DAOException e) {
            throw new ServiceException(e);
        }
    }

    /**
     * Retrieves a list of all architects.
     *
     * @return A list of architects.
     * @throws ServiceException If an error occurs while fetching architects.
     */
    public List<Architect> listArchitects() throws ServiceException {
        ArchitectDAO architectDAO = new ArchitectDAO();

        try {
            return architectDAO.listArchitects();
        } catch (SQLException e) {
            throw new ServiceException(e);
        }
    }

    /**
     * Updates architect information.
     *
     * @param architect The updated architect information.
     * @param email The email of the architect to be updated.
     * @return True if update is successful, false otherwise.
     * @throws ServiceException If an error occurs during update.
     */
    public boolean updateArchitect(Architect architect, String email) throws ServiceException {
        ArchitectDAO architectDAO = new ArchitectDAO();

        try {
            // Check if the architect is null
            if (architect == null) {
                throw new InvalidArchitectException("Update Architect is null");
            }

            // Check if the email exists before attempting to update
            if (!architectDAO.isEmailExists(email)) {
                throw new ServiceException("Architect with this email does not exist");
            }

            // Validate the architect's details using the ArchitectValidator
            ArchitectValidator.validateUpdateArchitect(architect);
            
            
            return architectDAO.updateArchitect(architect, email);
        } catch (InvalidArchitectException | SQLException e) {
            throw new ServiceException(e);
        }
    }

    /**
     * Deletes an architect based on email.
     *
     * @param email The email of the architect to be deleted.
     * @return True if deletion is successful, false otherwise.
     * @throws ServiceException If an error occurs during deletion.
     */
    public boolean deleteArchitect(String email) throws ServiceException {
        ArchitectDAO architectDAO = new ArchitectDAO();
        try {
            // Check if the architect is null
            if (email == null) {
                throw new InvalidArchitectException("Delete Architect is null");
            }

            // Check if the email exists before attempting to delete
            if (!architectDAO.isEmailExists(email)) {
                throw new ServiceException("Architect with this email does not exist");
            }

            // Validate the architect's details using the ArchitectValidator
            ArchitectValidator.validateEmail(email);
            
            return architectDAO.deleteArchitect(email);
        } catch (InvalidArchitectException | SQLException e) {
            throw new ServiceException(e);
        }
    }
    
    
    /**
     * Retrieves an architect by their email address.
     *
     * @param email The email address of the architect to retrieve.
     * @return The Architect object if found, or null if not found.
     * @throws ServiceException If an error occurs while retrieving the architect.
     */
    public Architect getArchitectByEmail(String email) throws ServiceException {
        try {
            // Validate the email (if needed)
            ArchitectValidator.validateEmail(email);

            ArchitectDAO architectDAO = new ArchitectDAO(); // Assuming you have an ArchitectDAO implementation

            // Retrieve the architect by email from the DAO
            return architectDAO.getArchitectByEmail(email);
        }catch (InvalidArchitectException | DAOException e) {
            throw new ServiceException(e);
        }
    }
    
    
    /**
     * Get an architect by their ID.
     *
     * @param architectId The ID of the architect to retrieve.
     * @return The Architect object if found, or null if not found.
     * @throws ServiceException If an error occurs while retrieving the architect.
     */
    public Architect getArchitectById(int architectId) throws ServiceException {
        try {
            // Validate the architectId (if needed)
            ArchitectValidator.validateArchitectID(architectId);

            ArchitectDAO architectDAO = new ArchitectDAO(); // Assuming you have an ArchitectDAO implementation

            // Retrieve the architect by ID from the DAO
            return architectDAO.getArchitectById(architectId);
        } catch (InvalidArchitectException | DAOException e) {
            throw new ServiceException(e);
        }
    }


}
