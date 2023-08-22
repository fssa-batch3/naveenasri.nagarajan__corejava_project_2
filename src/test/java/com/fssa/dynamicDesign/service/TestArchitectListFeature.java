package com.fssa.dynamicdesign.service;

import static org.junit.jupiter.api.Assertions.fail;

import java.sql.SQLException;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.fssa.dynamicdesign.dao.ArchitectDAO;
import com.fssa.dynamicdesign.model.Architect;
import com.fssa.dynamicdesign.service.ArchitectService;
import com.fssa.dynamicdesign.service.exception.ServiceException;

 class TestArchitectListFeature {


	@Test
	 void testListArchitectsNotEmptyTrue() {
	    ArchitectDAO architectDAO = new ArchitectDAO();

	    try {
	        List<Architect> architects = architectDAO.listArchitects();
	        Assertions.assertNotNull(architects, "List of architects is null.");
	        Assertions.assertTrue(!architects.isEmpty(), "List of architects is empty."); 
	    } catch (SQLException e) {
	        e.printStackTrace();
	        Assertions.fail("Exception occurred while fetching architects from the database.");
	        fail();
	    }
	}


	@Test
	 void testListArchitects() {
		ArchitectService architectService = new ArchitectService();

		try {
			List<Architect> architects = architectService.listArchitects();
			Assertions.assertNotNull(architects, "List of architects is null.");
			Assertions.assertFalse(architects.isEmpty(), "List of architects is not empty.");
		} catch (ServiceException e) {
			e.printStackTrace();
			fail("Exception occurred while fetching architects from the service.");
		}
	}



}
