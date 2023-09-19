package com.fssa.dynamicdesign.service;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.fssa.dynamicdesign.model.Design;
import com.fssa.dynamicdesign.service.exception.ServiceException;

class TestDesignUpdateFeature {

	
	
	@Test
	void testUpdateDesignSuccess() {
	    DesignService designService = new DesignService();

	    // Create an updated design object with the desired changes
	    Design updatedDesign = new Design();
	    updatedDesign.setDesignName("Updated Living Room"); // Example update
	    List<String> designsUrl = new ArrayList<>();
	    designsUrl.add("https://cdn.pixabay.com/photo/2016/04/18/13/53/room-1336497_1280.jpg");
	    designsUrl.add("https://cdn.pixabay.com/photo/2016/04/18/13/53/room-1336497_1280.jpg");
	    designsUrl.add("https://cdn.pixabay.com/photo/2016/04/18/13/53/room-1336497_1280.jpg");
	    designsUrl.add("https://cdn.pixabay.com/photo/2016/04/18/13/53/room-1336497_1280.jpg");
	    updatedDesign.setDesignUrls(designsUrl);
	    updatedDesign.setStyle("Traditional");
	    updatedDesign.setPricePerSqFt(1200.0);
	    updatedDesign.setSquareFeet(1500);
	    updatedDesign.setCategory("Bed room");
	    updatedDesign.setFloorPlan("1BHK");
	    updatedDesign.setTimeRequired(1);
	    updatedDesign.setBio("Modern living room design Modern living room designModern living room design Modern living room design Modern living room design");
	    updatedDesign.setBrief("A brief description of the design Modern living room design Modern living room design Modern living room design Modern living room design Modern living room design Modern living room design Modern living room design Modern living room design.");

	    long uniqueId = 1694865488611L;
	    try {
	        assertTrue(designService.updateDesign(uniqueId, updatedDesign));
	    } catch (ServiceException e) {
	        fail("Unexpected ServiceException: " + e.getMessage());
	    }
	    System.out.println("Design Updated Successfully");
	}


}
