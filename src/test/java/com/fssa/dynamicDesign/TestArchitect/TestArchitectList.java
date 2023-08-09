package com.fssa.dynamicDesign.TestArchitect;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.sql.SQLException;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.fssa.dynamicDesign.dao.ArchitectDAO;
import com.fssa.dynamicDesign.model.Architect;
import com.fssa.dynamicDesign.service.ArchitectService;
import com.fssa.dynamicDesign.service.exception.ServiceException;

public class TestArchitectList {


	@Test
	public void testListArchitectsNotEmptyTrue() {
	    ArchitectDAO architectDAO = new ArchitectDAO();

	    try {
	        List<Architect> architects = architectDAO.listArchitects();
	        Assertions.assertNotNull(architects, "List of architects is null.");
	        Assertions.assertTrue(!architects.isEmpty(), "List of architects is empty."); 
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
			Assertions.assertNotNull(architects, "List of architects is null.");
			Assertions.assertFalse(architects.isEmpty(), "List of architects is not empty.");
		} catch (ServiceException e) {
			e.printStackTrace();
			Assertions.fail("Exception occurred while fetching architects from the service.");
		}
	}



}
