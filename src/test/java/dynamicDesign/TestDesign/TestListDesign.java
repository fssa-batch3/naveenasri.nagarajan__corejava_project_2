package dynamicDesign.TestDesign;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestListDesign {
	public static void main(String[] args) {
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "123456");

			String selectQuery = "SELECT * FROM designs"; // Change the table name to 'designs'
			PreparedStatement statement = connection.prepareStatement(selectQuery);

			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				int designId = resultSet.getInt("designid"); // Assuming the column name is designid
				String designName = resultSet.getString("designname");
				String designUrl = resultSet.getString("designurl");
				double price = resultSet.getDouble("price");
				String email = resultSet.getString("email");
				int noOfRoom = resultSet.getInt("noofroom");

				System.out.println("Design ID: " + designId);
				System.out.println("Design Name: " + designName);
				System.out.println("Design URL: " + designUrl);
				System.out.println("Price: " + price);
				System.out.println("Email: " + email);
				System.out.println("Number of Rooms: " + noOfRoom);
				System.out.println("------------------------------------");
			}

			resultSet.close();
			statement.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
