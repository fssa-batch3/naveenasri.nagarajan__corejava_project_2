package com.fssa.dynamicdesign.service;

import java.sql.SQLException;
import java.util.List;

import com.fssa.dynamicdesign.dao.DesignDAO;
import com.fssa.dynamicdesign.dao.exception.DAOException;
import com.fssa.dynamicdesign.model.Design;
import com.fssa.dynamicdesign.service.exception.ServiceException;
import com.fssa.dynamicdesign.validation.DesignValidator;
import com.fssa.dynamicdesign.validation.exception.InvalidDesignException;

public class DesignService {

    /**
     * Creates a new design.
     *
     * @param design The design to be created.
     * @return True if creation is successful, false otherwise.
     * @throws ServiceException If an error occurs during creation.
     */
    public boolean createDesign(Design design) throws ServiceException {

        DesignDAO designDAO = new DesignDAO();
        try {

            // Validate the design's details using the DesignValidator
            DesignValidator.validateDesign(design);

            // Check if the architect ID exists before creating the design
            designDAO.checkIdExistsInArchitect(design.getArchitectId());

            return designDAO.createDesign(design);

        } catch (DAOException | InvalidDesignException e) {
            throw new ServiceException(e);
        }
        
    }

    /**
     * Retrieves a list of all designs.
     *
     * @return A list of designs.
     * @throws ServiceException If an error occurs while fetching designs.
     */
    public List<Design> listDesigns() throws ServiceException {
        DesignDAO designDAO = new DesignDAO();

        try {
            return designDAO.listDesigns();

        } catch (SQLException e) {
            throw new ServiceException(e);
        }
    }

    /**
     * Updates a design's information.
     *
     * @param design The updated design information.
     * @return True if update is successful, false otherwise.
     * @throws ServiceException If an error occurs during update.
     */
    public boolean updateDesign(Design design) throws ServiceException {
        DesignDAO designDAO = new DesignDAO();

        try {
            // Validate the design's details using the DesignValidator
            DesignValidator.validateDesign(design);

            return designDAO.updateDesign(design);

        } catch (SQLException | InvalidDesignException e) {
            throw new ServiceException(e);
        }
    }

    /**
     * Deletes a design based on design ID.
     *
     * @param designId The ID of the design to be deleted.
     * @return True if deletion is successful, false otherwise.
     * @throws ServiceException If an error occurs during deletion.
     */
    public boolean deleteDesign(int designId) throws ServiceException {
        DesignDAO designDAO = new DesignDAO();

        try {
            // Validate the design ID using the DesignValidator
            DesignValidator.validateDesignId(designId);

            return designDAO.deleteDesign(designId);
        } catch (SQLException | InvalidDesignException e) {
            throw new ServiceException(e);
        }
    }
}
