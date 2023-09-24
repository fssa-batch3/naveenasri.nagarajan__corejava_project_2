package com.fssa.dynamicdesign.service;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.fssa.dynamicdesign.model.Design;
import com.fssa.dynamicdesign.service.exception.ServiceException;

class TestDesignCreateFeature {

	@Test
	void testCreateDesignSuccess() {
		DesignService designService = new DesignService();
		Design design = new Design();
		List<String> designsUrl = new ArrayList<>();
		design.setDesignName("Modern Living Room");
		designsUrl.add("https://cdn.pixabay.com/photo/2016/04/18/13/53/room-1336497_1280.jpg");
		designsUrl.add("https://cdn.pixabay.com/photo/2016/04/18/13/53/room-1336497_1280.jpg");
		designsUrl.add("https://cdn.pixabay.com/photo/2016/04/18/13/53/room-1336497_1280.jpg");
		designsUrl.add("https://cdn.pixabay.com/photo/2016/04/18/13/53/room-1336497_1280.jpg");
		design.setDesignUrls(designsUrl);
		design.setStyle("Modern");
		design.setPricePerSqFt(120.0);
		design.setSquareFeet(1500);
		design.setCategory("Livingroom");
		design.setFloorPlan("2BHK");
		design.setTimeRequired(2);
		
		design.setBio(
				"Modern living room design Modern living room designModern living room design Modern living room design Modern living room design");
		design.setBrief(
				"A brief description of the design Modern living room design Modern living room design Modern living room design Modern living room design Modern living room design Modern living room design Modern living room design Modern living room design.");
		design.setArchitectId(76);

		try {
			assertTrue(designService.createDesign(design));
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		System.out.println("Design Added Successfully");

	}

	@Test
	void testCreateDesignWithNullDesignObject() {
		DesignService designService = new DesignService();
		Design design = null;

		try {
			designService.createDesign(design);
			fail("Expected ServiceException but no exception was thrown.");
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}

}
