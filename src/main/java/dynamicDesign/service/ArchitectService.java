package dynamicDesign.service;

import java.sql.SQLException;
import java.util.List;

import dynamicDesign.dao.ArchitectDAO;
import dynamicDesign.model.Architect;
import dynamicDesign.service.exception.ServiceException;
import dynamicDesign.validation.ArchitectValidator;
import dynamicDesign.validation.exception.InvalidArchitectException;

public class ArchitectService {

	public boolean registerArchitect(Architect architect) throws ServiceException {
		ArchitectDAO architectDAO = new ArchitectDAO();

		try {
			// Check if the Architect is null
			if (architect == null) {
				throw new InvalidArchitectException("Architect is null");
			}

			// Validate the architect's details using the ArchitectValidator
			ArchitectValidator.validateArchitect(architect);

			// Call the DAO's arcRegister method to register the architect
			return architectDAO.arcRegister(architect);
		} catch (SQLException | InvalidArchitectException e) {
			throw new ServiceException(e);
		}
	}
	
	
	public List<Architect> listArchitects() throws ServiceException {
		ArchitectDAO architectDAO = new ArchitectDAO();

		try {
			return architectDAO.listArchitects();
		} catch (SQLException e) {
			throw new ServiceException(e);
		}
	}

	public boolean updateArchitect(Architect architect, String email) throws ServiceException {
		ArchitectDAO architectDAO = new ArchitectDAO();

		try {
			// Check if the architect is null
			if (architect == null) {
				throw new InvalidArchitectException("Architect is null");
			}

			// Check if the email exists before attempting to update
			if (!architectDAO.isEmailExists(email)) {
				throw new ServiceException("Architect with this email does not exist");
			}

			ArchitectValidator.validateArchitect(architect);
			return architectDAO.updateArchitect(architect, email);
		} catch (InvalidArchitectException | SQLException e) {
			throw new ServiceException(e);
		}
	}

	public boolean deleteArchitect(int architectId) throws ServiceException, InvalidArchitectException {
		ArchitectDAO architectDAO = new ArchitectDAO();

		try {
			// Check if the architectId is valid
			if (architectId <= 0) {
				throw new InvalidArchitectException("Invalid architect ID");
			}

			return architectDAO.deleteArchitect(architectId);
		} catch (SQLException e) {
			throw new ServiceException(e);
		}
	}

}
