package com.fssa.dynamicdesign.service;

import java.sql.SQLException;
import java.util.List;

import com.fssa.dynamicdesign.dao.ArchitectDAO;
import com.fssa.dynamicdesign.model.Architect;
import com.fssa.dynamicdesign.service.exception.ServiceException;
import com.fssa.dynamicdesign.validation.ArchitectValidator;
import com.fssa.dynamicdesign.validation.exception.InvalidArchitectException;

public class ArchitectService {

	public boolean registerArchitect(Architect architect) throws ServiceException {
		ArchitectDAO architectDAO = new ArchitectDAO();

		try {
			// Check if the Architect is null
			if (architect == null) {
				throw new InvalidArchitectException("Register Architect is null");
			}

			// Validate the architect's details using the ArchitectValidator
			ArchitectValidator.validateArchitect(architect);

			// Call the DAO's arcRegister method to register the architect
			return architectDAO.arcRegister(architect);
		} catch (SQLException | InvalidArchitectException e) {
			throw new ServiceException(e);
		}
	}

	public boolean loginArchitect(Architect architect, String email) throws ServiceException {
		try {
			ArchitectValidator.validateEmail(email);
			ArchitectValidator.validatePassword(architect.getPassword());

			ArchitectDAO architectDAO = new ArchitectDAO();

			if (!architectDAO.isEmailExists(email)) {
				throw new ServiceException("Before logging in, you have to register");
			}

			if (architectDAO.login(architect, email)) {
				return true;
			} else {
				return false;
			}
		} catch (ServiceException e) {
			throw e;
		} catch (Exception e) {
			throw new ServiceException(e.getLocalizedMessage());
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
				throw new InvalidArchitectException("Update Architect is null");
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

	public boolean deleteArchitect(Architect architect) throws ServiceException {
	    ArchitectDAO architectDAO = new ArchitectDAO();
	    try {
	        if (architect == null) {
	            throw new InvalidArchitectException("Delete Architect is null");
	        }

	        if (!architectDAO.isEmailExists(architect.getEmail())) {
	            throw new ServiceException("Architect with this email does not exist");
	        }

	        ArchitectValidator.validateDeleteArchitect(architect);
	        return architectDAO.deleteArchitect(architect);
	    } catch (InvalidArchitectException | SQLException e) {
	        throw new ServiceException(e);
	    }
	}

}
