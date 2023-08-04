package dynamicDesign.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import dynamicDesign.model.Design;
import java.util.ArrayList; 
public class DesignDAO {

	// connect to database
	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "123456");
	}

	// Add new user to DB - Register
	public boolean createDesign(Design design) throws SQLException {
		Connection connection = getConnection();
		String query = "INSERT INTO designs (design_name ,design_url,price,email,noofrooms) VALUES (?,?,?,?,?)";
		PreparedStatement pmt = connection.prepareStatement(query);
		pmt.setString(1, design.getDesignName());
		pmt.setString(2, design.getDesignUrl());
		pmt.setDouble(3, design.getPrice());
		pmt.setString(4, design.getEmail());
		pmt.setInt(5, design.getNoOfRoom());
		int rows = pmt.executeUpdate();

		// Return successful or not

		pmt.close();
		connection.close();

		return rows == 1;

	}

	// List all designs from the DB
	public List<Design> listDesigns() throws SQLException {
		List<Design> designs = new ArrayList<>();
		Connection connection = getConnection();
		String query = "SELECT * FROM designs";
		PreparedStatement pmt = connection.prepareStatement(query);

		ResultSet resultSet = pmt.executeQuery();

		while (resultSet.next()) {
			String designName = resultSet.getString("designname");
			String designUrl = resultSet.getString("designurl");
			double price = resultSet.getDouble("price");
			String email = resultSet.getString("email");
			int noOfRoom = resultSet.getInt("noofroom");

			Design design = new Design(designName, designUrl, price, email, noOfRoom);
			designs.add(design);
		}

		resultSet.close();
		pmt.close();
		connection.close();

		return designs;
	}

}
