package dynamicDesign.TestArchitect;

import java.sql.SQLException;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import dynamicDesign.service.ArchitectService;
import dynamicDesign.service.exception.ServiceException;
import dynamicDesign.model.Architect;
import dynamicDesign.dao.ArchitectDAO;


public class TestArchitectList {

	public void testArchitectRegistration() {
	    ArchitectDAO architectDAO = new ArchitectDAO();
	    ArchitectService architectService = new ArchitectService();

	    try {
	        Architect architect = new Architect("profilePhoto.jpg", "Maha", "Female", "9876543210", "123 Main Street",
	                "coverPhoto.jpg", "maha@example.com", "Navee@123", "Bachelor of Architecture", 5,
	                "degreeCertificate.jpg", "NATACertificate.jpg");

	        boolean isRegisteredDAO = architectDAO.arcRegister(architect);
	        boolean isRegisteredService = architectService.registerArchitect(architect);

	        Assertions.assertTrue(isRegisteredDAO, "Architect registration failed in DAO.");
	        Assertions.assertTrue(isRegisteredService, "Architect registration failed in Service.");
	    } catch (SQLException | ServiceException e) {
	        e.printStackTrace();
	        Assertions.fail("Exception occurred while registering an architect.");
	    }
	}
	
	
	@Test
	public void testListArchitectsEmpty() {
		ArchitectDAO architectDAO = new ArchitectDAO();

		try {
			List<Architect> architects = architectDAO.listArchitects();
			// Assuming there are no architects in the database
			Assertions.assertTrue(architects.isEmpty(), "List of architects is not empty.");
		} catch (SQLException e) {
			e.printStackTrace();
			Assertions.fail("Exception occurred while fetching architects from the database.");
		}
	}


	@Test
	public void testListArchitectsfail() {
		ArchitectDAO architectDAO = new ArchitectDAO();

		try {
			List<Architect> architects = architectDAO.listArchitects();
			// Assuming that there are some architects in the database
			Assertions.assertNotNull(architects, "List of architects is null.");
			Assertions.assertFalse(architects.isEmpty(), "List of architects is empty.");
			// Additional assertions can be made based on the expected number of architects
			// and their attributes in the database.
		} catch (SQLException e) {
			e.printStackTrace();
			Assertions.fail("Exception occurred while fetching architects from the database.");
		}
	}

	

	@Test
	public void testListArchitects() {
		ArchitectService architectService = new ArchitectService();

		try {
			List<Architect> architects = architectService.listArchitects();
			// Assuming that the ArchitectService delegates the call to the ArchitectDAO
			// and returns the list of architects from the DAO.
			// You may mock the DAO if needed.
			// The list of architects can be retrieved from the database and compared with
			// the expected result.
			// For simplicity, let's assume that the service simply returns an empty list
			// for this test.
			Assertions.assertNotNull(architects, "List of architects is null.");
			Assertions.assertTrue(architects.isEmpty(), "List of architects is not empty.");
		} catch (ServiceException e) {
			e.printStackTrace();
			Assertions.fail("Exception occurred while fetching architects from the service.");
		}
	}

	@Test
	public void testListArchitectsException() {
		ArchitectService architectService = new ArchitectService();

		try {
			// Assuming that the ArchitectService handles exceptions from the DAO and throws
			// a ServiceException.
			// You may mock the DAO to throw a SQLException for this test.
			// For simplicity, let's assume that the service throws a ServiceException.
			architectService.listArchitects();
			Assertions.fail("Expected ServiceException, but no exception was thrown.");
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}
}
