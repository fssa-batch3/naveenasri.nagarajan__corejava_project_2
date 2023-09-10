package com.fssa.dynamicdesign.service;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.fssa.dynamicdesign.model.Design;
import com.fssa.dynamicdesign.service.exception.ServiceException;

class TestDesignCreateFeature {

    @Test
    void testCreateDesignSuccess() {
        DesignService designService = new DesignService();
        Design design1 = new Design("Minimalist Bed Room", "https://cdn.pixabay.com/photo/2020/11/24/11/36/bedroom-5772286_1280.jpg", 100.0,
                "Interior design helps one elevate their existence, their lifestyle and their perception of the world. It is a fundamental human desire to seek and identify beauty in the surrounding.",
                2, 76);

        assertDoesNotThrow(() -> {
            assertTrue(designService.createDesign(design1));
            System.out.println("Your Design Added Successfully ");
        });
    }

    @Test
    void testNegativePriceValue() {
        DesignService designService = new DesignService();
        Design design = new Design("Modern design", "https://example.com/negative_price", -50.0,
                "Interior design helps one elevate their existence, their lifestyle and their perception of the world. It is a fundamental human desire to seek and identify beauty in the surrounding.",
                1, 3);

        assertThrows(ServiceException.class, () -> {
            designService.createDesign(design);
        });
    }

    @Test
    void testNegativeRoomsValue() {
        DesignService designService = new DesignService();
        Design design = new Design("Modern design", "https://example.com/negative_id", 80.0,
                "Interior design helps one elevate their existence, their lifestyle and their perception of the world. It is a fundamental human desire to seek and identify beauty in the surrounding.",
                -5, 5);

        assertThrows(ServiceException.class, () -> {
            designService.createDesign(design);
        });
    }

    @Test
    void testNullDesignObject() {
        DesignService designService = new DesignService();
        Design design = null;

        assertThrows(ServiceException.class, () -> {
            designService.createDesign(design);
        });
    }
}
