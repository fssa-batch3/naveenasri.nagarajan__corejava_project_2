package com.fssa.dynamicDesign.TestDesign;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import com.fssa.dynamicDesign.model.Design;
import com.fssa.dynamicDesign.service.DesignService;
import com.fssa.dynamicDesign.service.exception.ServiceException;

public class TestCreateFeature {

    @Test
    public void testCreateDesignSuccess() {
        DesignService designService = new DesignService();
        Design design1 = new Design(199,"Living Room Design", "https://example.com/design1", 100.0, "user@example.com", 1);
        try {
            assertTrue(designService.createDesign(design1));
            System.out.println("Your Design Added Successfully ");
        } catch (ServiceException e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    public void testNegativePriceValue() {
        DesignService designService = new DesignService();
        Design design = new Design(1,"Modern design", "https://example.com/negative_price", -50.0, "user@example.com", 3);
        try {
            assertFalse(designService.createDesign(design));
            fail("Expected ServiceException for negative price value");
        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testNegativeRooms() {
        DesignService designService = new DesignService();
        Design design = new Design(1,"Modern design", "https://example.com/negative_id", 80.0, "user@example.com", -5);
        try {
            assertFalse(designService.createDesign(design));
            fail("Expected ServiceException for negative number of rooms");
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
            fail("Expected ServiceException for null design object");
        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }
}
