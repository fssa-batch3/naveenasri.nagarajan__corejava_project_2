package dynamicDesign.service;

import java.sql.SQLException;
import java.util.List;

import dynamicDesign.dao.ArchitectDAO;
import dynamicDesign.model.Architect;
import dynamicDesign.service.exception.ServiceException;
import dynamicDesign.validation.ArchitectValidator;
import dynamicDesign.validation.exception.InvalidUserException;

public class ArchitectService {

	public boolean registerArchitect(Architect architect) throws ServiceException {
		ArchitectDAO architectDAO = new ArchitectDAO();

		try {
			// Check if the Architect is null
			if (architect == null) {
				throw new InvalidUserException("Architect is null");
			}

			// Check if the email already exists
			if (architectDAO.isEmailExists(architect.getEmail())) {
				throw new ServiceException("Architect with this email already exists");
			}

			ArchitectValidator.validateArchitect(architect);
			return architectDAO.arcRegister(architect);
		} catch (InvalidUserException | SQLException e) {
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
				throw new InvalidUserException("Architect is null");
			}

			// Check if the email exists before attempting to update
			if (!architectDAO.isEmailExists(email)) {
				throw new ServiceException("Architect with this email does not exist");
			}

			ArchitectValidator.validateArchitect(architect);
			return architectDAO.updateArchitect(architect, email);
		} catch (InvalidUserException | SQLException e) {
			throw new ServiceException(e);
		}
	}

	// Delete architect based on email
	public boolean deleteArchitect(String email) throws ServiceException {
		ArchitectDAO architectDAO = new ArchitectDAO();

		try {
			// Check if the email exists before attempting to delete
			if (!architectDAO.isEmailExists(email)) {
				throw new ServiceException("Architect with this email does not exist");
			}

			return architectDAO.deleteArchitect(email);
		} catch (SQLException e) {
			throw new ServiceException(e);
		}
	}

}
