package com.fssa.dynamicdesign.service;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import com.fssa.dynamicdesign.service.exception.ServiceException;

class TestDesignDeleteFeature {

	@Test
    void testDeleteDesignSuccess() {
        DesignService designService = new DesignService();

        long uniqueId = 1694883124857L; // Replace with a valid uniqueId that exists in the database

        try {
            assertTrue(designService.deleteDesign(uniqueId, "Error message"));
        } catch (ServiceException e) {
            fail("Unexpected ServiceException: " + e.getMessage());
        }
        System.out.println("Design Deleted Successfully");
    }
//    @Test
//    void testDeleteDesignInvalidId() {
//        DesignService designService = new DesignService();
//
//        int uniqueId = -1; // Replace with an invalid uniqueId
//
//        try {
//            // Ensure that the expected ServiceException is thrown due to an invalid ID
//            assertThrows(ServiceException.class, () -> {
//                designService.deleteDesign(uniqueId, "Error message");
//            }, "Expected ServiceException for an invalid design ID.");
//        } catch (ServiceException e) {
//            // Handle the expected exception
//            assertEquals("Error message", e.getMessage()); // Verify the error message
//        }
//    }
//
//    @Test
//    void testDeleteDesignDatabaseError() {
//        DesignService designService = new DesignService();
//
//        int uniqueId = 12345; // Replace with a valid uniqueId that exists in the database
//
//        try {
//            // Simulate a database error by causing the DAO method to throw an exception
//            assertThrows(ServiceException.class, () -> {
//                designService.deleteDesign(uniqueId, "Error message");
//            }, "Expected ServiceException for a database error.");
//        } catch (ServiceException e) {
//            // Handle the expected exception
//            assertEquals("Error message", e.getMessage()); // Verify the error message
//        }
//    }
}
