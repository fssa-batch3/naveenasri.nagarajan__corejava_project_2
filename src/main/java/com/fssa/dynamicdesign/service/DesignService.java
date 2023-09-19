package com.fssa.dynamicdesign.service;

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
            if (!designDAO.checkIdExistsInArchitect(design.getArchitectId())) {
                throw new ServiceException("Architect with ID " + design.getArchitectId() + " does not exist.");
            }

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

        } catch (DAOException e) {
            throw new ServiceException("Error listing designs");
        }
    }

    
    public List<Design> listDesignsByArchitectId(int architectId) throws ServiceException {
        DesignDAO designDAO = new DesignDAO();

        try {
            return designDAO.listDesignsByArchitectId(architectId);
        } catch (DAOException e) {
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
        public boolean updateDesign(long uniqueId, Design updatedDesign) throws ServiceException {
        	DesignDAO designDAO = new DesignDAO();
            try {
                return designDAO.updateDesign(uniqueId, updatedDesign);
            } catch (DAOException e) {
                throw new ServiceException("Error while updating design using unique ID");
            }
        }
    

    /**
     * Deletes a design based on design ID.
     *
     * @param designId The ID of the design to be deleted.
     * @return True if deletion is successful, false otherwise.
     * @throws ServiceException If an error occurs during deletion.
     */
    public boolean deleteDesign(long uniqueId , String error) throws ServiceException {
        DesignDAO designDAO = new DesignDAO();

        try {
            // Validate the design ID using the DesignValidator
            DesignValidator.validateNotNegative(uniqueId ,error);

            return designDAO.deleteDesign(uniqueId);
        } catch (DAOException | InvalidDesignException e) {
            throw new ServiceException(e);
        }
    }
    
    
    
    public List<Design> getDesignByUniqueId(long uniqueId) throws ServiceException {
        DesignDAO designDAO = new DesignDAO();
        try {
            // Validate the unique ID using the DesignValidator
           

         // Check if the unique ID exists in the database
            if (!designDAO.checkUniqueIdExists(uniqueId)) {
                throw new ServiceException("Design with unique ID " + uniqueId + " does not exist.");
            }
            
            return designDAO.getDesignByUniqueId(uniqueId);

        } catch (DAOException  e) {
            throw new ServiceException("Error while fetching design by unique ID");
        }
    }




}
