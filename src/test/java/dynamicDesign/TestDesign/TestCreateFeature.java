package dynamicDesign.TestDesign;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import dynamicDesign.model.Design;
import dynamicDesign.service.DesignService;
import dynamicDesign.service.exception.ServiceException;

public class TestCreateFeature {

	@Test
	public void testRegistrationSuccess() {
		DesignService designService = new DesignService();
		Design design1 = new Design("Living Room Design", "https://example.com/design1", 100.0, "user@example.com", 1);
		try {
			assertTrue(designService.createDesign(design1));
			System.out.println("Your Design Added Successfully ");
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testNegativePriceValue() {
	    DesignService designService = new DesignService();
	    Design design = new Design("Modern design", "https://example.com/negative_price", -50.0, "user@example.com", 3);
	    try {
	        assertFalse(designService.createDesign(design));
	    } catch (ServiceException e) {
	        e.printStackTrace();
	    }
	}
	
	@Test
	public void testNegativeRooms() {
	    DesignService designService = new DesignService();
	    Design design = new Design("Modern design", "https://example.com/negative_id", 80.0, "user@example.com", -5);
	    try {
	        assertFalse(designService.createDesign(design));
	    } catch (ServiceException e) {
	        e.printStackTrace();
	    }
	}

	@Test
	public void testNullDesignObject() {
	    DesignService designService = new DesignService();
	    Design design = null;
	    try {
	        assertFalse(designService.createDesign(design));
	    } catch (ServiceException e) {
	        e.printStackTrace();
	    }
	}

	



}
