package com.fssa.dynamicDesign.TestDesign;

import static org.junit.Assert.assertNotNull;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.fssa.dynamicDesign.model.Design;
import com.fssa.dynamicDesign.service.exception.ServiceException;

public class TestListDesign {
	public static void main(String[] args) {

		String selectQuery = "SELECT * FROM designs"; // Change the table name to 'designs'
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root",
				"123456");

				PreparedStatement statement = connection.prepareStatement(selectQuery);) {

			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				int designId = resultSet.getInt("designId"); // Assuming the column name is designid
				String designName = resultSet.getString("designName");
				String designUrl = resultSet.getString("designUrl");
				double price = resultSet.getDouble("price");
				String email = resultSet.getString("email");
				int noOfRooms = resultSet.getInt("noOfRooms");

				System.out.println("------------------------------------");
				System.out.println("Design ID: " + designId);
				System.out.println("Design Name: " + designName);
				System.out.println("Design URL: " + designUrl);
				System.out.println("Price: " + price);
				System.out.println("Email: " + email);
				System.out.println("Number of Rooms: " + noOfRooms);
				System.out.println("------------------------------------");
				System.out.println();
			}

			resultSet.close();
			statement.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

//	@Test
//	 public void testListDesignSuccess() {
//	 	DesignDAO design1 = new DesignDAO();
//	 	DesignService designService1 = new DesignService();
//	 	try {
//	 		assertTrue(designService1.createDesign(new Design("Modern design", "https://example.com/negative_id", 80.0, "user@example.com", 5)));
//	 		List<Design> list = design1.listDesigns();
//	 		assertNotNull(list);
//	 	}catch(ServiceException e) {
//	 		e.printStackTrace();
//	 	}

	// }
	// @Test
	// public void testListDesignFailure() {
	// DesignDAO design1 = new DesignDAO();
	// try {
	// DesignService designService1 = new DesignService("Modern design",
	// "https://example.com/negative_id", 80.0, "user@example.com", 5);
	// assertFalse(designService1);
	// }catch(ServiceException e) {
	// e.printStackTrace();
	// }

	// ArrayList<Design> list = null;

	// try {
	// list = DesignDAO.listDesigns();

	// }catch (DAOException e) {
	// e.printStackTrace();
	// }
	// assertEquals(0, list.size());
	// }

}
