package com.fssa.dynamicdesign.service;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.fssa.dynamicdesign.model.Design;
import com.fssa.dynamicdesign.service.exception.ServiceException;


  class TestDesignListFeature {
//	public static void main(String[] args) {
//
//		String selectQuery = "SELECT * FROM designs"; // Change the table name to 'designs'
//		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root",
//				"123456");
//
//				PreparedStatement statement = connection.prepareStatement(selectQuery);) {
//
//			ResultSet resultSet = statement.executeQuery();
//
//			while (resultSet.next()) {
//				int designId = resultSet.getInt("designId"); // Assuming the column name is designid
//				String designName = resultSet.getString("designName");
//				String designUrl = resultSet.getString("designUrl");
//				double price = resultSet.getDouble("price");
//				String email = resultSet.getString("email");
//				int noOfRooms = resultSet.getInt("noOfRooms");
//
//				System.out.println("------------------------------------");
//				System.out.println("Design ID: " + designId);
//				System.out.println("Design Name: " + designName);
//				System.out.println("Design URL: " + designUrl);
//				System.out.println("Price: " + price);
//				System.out.println("Email: " + email);
//				System.out.println("Number of Rooms: " + noOfRooms);
//				System.out.println("------------------------------------");
//				System.out.println();
//			}
//
//			resultSet.close();
//			statement.close();
//			connection.close();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}

	@Test
	void testListDesignsNotEmptysuccess() {
		DesignService designservice = new DesignService();


		try {
			List<Design> designs = designservice.listDesigns();
			assertNotNull(designs, "List of designs is null.");
			assertTrue(!designs.isEmpty(), "List of designs is empty.");
		} catch (ServiceException e) {
			e.printStackTrace();
			fail("Exception occurred while fetching designs from the database.");
		}
	}
	

	@Test
	void testListDesignsNotEmptyFailure() {
		DesignService designservice = new DesignService();

		try {
			List<Design> designs = designservice.listDesigns();
			assertNotNull(designs, "List of designs is null.");
			assertFalse(designs.isEmpty(), "List of designs is empty.");
		} catch (ServiceException e) {
			fail("Exception occurred while fetching designs from the database.");
		}
	}

}
