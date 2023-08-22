package com.fssa.dynamicdesign.service;

import org.junit.jupiter.api.Test;

import com.fssa.dynamicdesign.model.Design;
import com.fssa.dynamicdesign.service.DesignService;
import com.fssa.dynamicdesign.service.exception.ServiceException;

import static org.junit.jupiter.api.Assertions.fail;

class TestDesignUpdateFeature {

	@Test
	void testUpdateDesignSuccess() {
		DesignService designService = new DesignService();
		Design designToUpdate = new Design(5, "Bedroom Design", "https://example.com/design11", 120.00, 3);
		try {
			if (!designService.updateDesign(designToUpdate)) {
				fail("Failed to update design.");
			} else {
				System.out.println("Design Updated Successfully");
			}
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}

	@Test
	void testUpdateNonExistentDesign() {
		DesignService designService = new DesignService();
		Design nonExistentDesign = new Design(1000, "Updated Design", "https://example.com/updated", 150.0, 4);
		try {
			if (designService.updateDesign(nonExistentDesign)) {
				fail("Successfully updated non-existent design.");
			}
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}

	@Test
	void testUpdateWithNegativePrice() {
		DesignService designService = new DesignService();
		Design designToUpdate = new Design(3, "Updated Design", "https://example.com/updated", -50.0, 2);
		try {
			if (designService.updateDesign(designToUpdate)) {
				fail("Successfully updated design with negative price.");
			}
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}

	@Test
	void testUpdateWithNegativeRooms() {
		DesignService designService = new DesignService();
		Design designToUpdate = new Design(4, "Updated Design", "https://example.com/updated", 150.0, -3);
		try {
			if (designService.updateDesign(designToUpdate)) {
				fail("Successfully updated design with invalid email.");
			}
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}

}
