package dynamicDesign.service;

// import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.SQLException;
import java.util.List;

import dynamicDesign.dao.DesignDAO;
import dynamicDesign.dao.exception.DAOException;
import dynamicDesign.model.Design;
import dynamicDesign.service.exception.ServiceException;
import dynamicDesign.validation.DesignValidator;

public class DesignService {
	public boolean createDesign(Design design) throws ServiceException {
		DesignDAO designDAO = new DesignDAO();

		try {
			if (design == null) {
				throw new ServiceException("Design is null");
			}

			if (designDAO.createDesign(design)) {
				System.out.println("Design " + design.getDesignName() + " created successfully.");
				return true;
			} else {
				return false;
			}
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}

//	public List<Design> listDesigns() throws ServiceException {
//		DesignDAO designDAO = new DesignDAO();
//
//		try {
//			return designDAO.listDesigns();
//		} catch (SQLException e) {
//			throw new ServiceException(e);
//		}
//	}

	public boolean updateDesign(Design design) throws ServiceException {
		DesignDAO designDAO = new DesignDAO();

		try {
			if (design == null) {
				throw new IllegalArgumentException("Design is null");
			}

			return designDAO.updateDesign(design);
		} catch (SQLException e) {
			throw new ServiceException(e);
		}
	}

	public boolean deleteDesign(int designId) throws ServiceException {
		DesignDAO designDAO = new DesignDAO();

		try {
			return designDAO.deleteDesign(designId);
		} catch (SQLException e) {
			throw new ServiceException(e);
		}
	}

}
