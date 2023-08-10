package com.fssa.dynamicDesign.service;

// import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.SQLException;
import java.util.List;

import com.fssa.dynamicDesign.dao.DesignDAO;
import com.fssa.dynamicDesign.dao.exception.DAOException;
import com.fssa.dynamicDesign.model.Design;
import com.fssa.dynamicDesign.service.exception.ServiceException;
import com.fssa.dynamicDesign.validation.DesignValidator;
import com.fssa.dynamicDesign.validation.UserValidator;
import com.fssa.dynamicDesign.validation.exception.InvalidDesignException;

public class DesignService {
	public boolean createDesign(Design design) throws ServiceException {

		DesignDAO designDAO = new DesignDAO();
		try {
			if (design == null) {
				throw new ServiceException("Design is null");
			}

			DesignValidator.validateDesign(design);
			if (designDAO.createDesign(design)) {
				System.out.println("Design " + design.getDesignName() + " created successfully.");
				return true;
			} else {
				return false;
			}
		} catch (DAOException | InvalidDesignException e) {
			throw new ServiceException(e);
		}
	}

	public List<Design> listDesigns() throws ServiceException {
		DesignDAO designDAO = new DesignDAO();

		try {
			return designDAO.listDesigns();
		} catch (SQLException e) {
			throw new ServiceException(e);
		}
	}

	public boolean updateDesign(Design design) throws ServiceException {
		DesignDAO designDAO = new DesignDAO();

		try {
			if (design == null) {
				throw new InvalidDesignException("Design is null");
			}

			DesignValidator.validateDesign(design);

			return designDAO.updateDesign(design);
		} 
//		catch (InvalidDesignException e) {
//			System.out.println("While Updating Design The Design details should be valid");
//			throw new InvalidDesignException(e);
//		} 
		catch (SQLException | InvalidDesignException e) {
			throw new ServiceException(e);
		}
	}

	public boolean deleteDesign(int designId) throws ServiceException {
		DesignDAO designDAO = new DesignDAO();

		try {
			DesignValidator.isValidDesignId(designId);
			return designDAO.deleteDesign(designId);
		} catch (SQLException | InvalidDesignException  e) {
			throw new ServiceException(e);
		}
	}

}
