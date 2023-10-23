package com.fssa.dynamicdesign.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fssa.dynamicdesign.dao.exception.DAOException;
import com.fssa.dynamicdesign.model.Architect;
import com.fssa.dynamicdesign.model.Design;
import com.fssa.dynamicdesign.service.DesignService;
import com.fssa.dynamicdesign.service.exception.ServiceException;
import com.fssa.dynamicdesign.util.ConnectionUtil;


public class DesignDAO {

	
	public boolean createDesign(Design design) throws DAOException {
	    String query = "INSERT INTO designs ( design_name, style, price_per_sqft, square_feet, "
	            + "category, floor_plan, time_required, bio, brief, architect_id, unique_id) "
	            + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	    try (Connection connection = ConnectionUtil.getConnection();
	         PreparedStatement pmt = connection.prepareStatement(query)) {

	        // Check if architectId exists before inserting
	        if (!checkIdExistsInArchitect(design.getArchitectId())) {
	            throw new DAOException("Architect with ID " + design.getArchitectId() + " does not exist.");
	        }
	        long uniqueID = System.currentTimeMillis();
	        pmt.setString(1, design.getDesignName());
	        pmt.setString(2, design.getStyle());
	        pmt.setDouble(3, design.getPricePerSqFt());
	        pmt.setInt(4, design.getSquareFeet());
	        pmt.setString(5, design.getCategory());
	        pmt.setString(6, design.getFloorPlan());
	        pmt.setInt(7, design.getTimeRequired());
	        pmt.setString(8, design.getBio());
	        pmt.setString(9, design.getBrief());
	        pmt.setInt(10, design.getArchitectId());
	        pmt.setLong(11, uniqueID);

	        int rows = pmt.executeUpdate();
	        // If the insert was successful, proceed to insert design URLs
	        if (rows == 1) {
	            for (String url : design.getDesignUrls()) {
	                String urlInsertSql = "INSERT INTO assets (unique_id, image_url) VALUES (?, ?)";
	                try (PreparedStatement urlStatement = connection.prepareStatement(urlInsertSql)) {
	                    urlStatement.setLong(1, uniqueID); // Assuming you have a way to get the design ID
	                    urlStatement.setString(2, url);
	                    urlStatement.executeUpdate();
	                }
	            }
	            return true;
	        }
	        return false;
	    } catch (SQLException e) {
	        throw new DAOException(e);
	    }
	}


	/**
	 * Retrieve a list of all designs from the database.
	 *
	 * @return List of Design objects representing all designs in the database
	 * @throws DAOException if a database error occurs
	 */
	public List<Design> listDesigns() throws DAOException {
		List<Design> designs = new ArrayList<>();
		String query = "SELECT d.design_id, d.design_name, d.style, d.price_per_sqft, "
				+ "d.square_feet, d.category, d.floor_plan, d.time_required, d.bio, "
				+ "d.brief, d.architect_id, d.unique_id, "
				+ "a.name AS architect_name, a.phone_number AS architect_phone, "
				+ "a.email AS architect_email, a.experience AS architect_experience " + "FROM designs AS d "
				+ "INNER JOIN architect AS a ON d.architect_id = a.architect_id " + "WHERE d.is_deleted = 0";

		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement pmt = connection.prepareStatement(query);
				ResultSet resultSet = pmt.executeQuery()) {

			while (resultSet.next()) {
				// Retrieve design details from the result set
				Design design = new Design();
				design.setDesignId(resultSet.getInt("design_id"));
				design.setDesignName(resultSet.getString("design_name"));
				design.setStyle(resultSet.getString("style"));
				design.setPricePerSqFt(resultSet.getDouble("price_per_sqft"));
				design.setSquareFeet(resultSet.getInt("square_feet"));
				design.setCategory(resultSet.getString("category"));
				design.setFloorPlan(resultSet.getString("floor_plan"));
				design.setTimeRequired(resultSet.getInt("time_required"));
				design.setBio(resultSet.getString("bio"));
				design.setBrief(resultSet.getString("brief"));
				design.setArchitectId(resultSet.getInt("architect_id"));
				design.setUniqueId(resultSet.getLong("unique_id"));

				// Create an Architect object and set its properties
				Architect architect = new Architect();
				architect.setName(resultSet.getString("architect_name"));
				architect.setPhoneNumber(resultSet.getString("architect_phone"));
				architect.setEmail(resultSet.getString("architect_email"));
				architect.setExperience(resultSet.getInt("architect_experience"));

				// Set the Architect object in the Design
				design.setArchitect(architect);

				// Retrieve design URLs for the current design
				List<String> designUrls = getDesignUrlsByUniqueId(design.getUniqueId(), connection);
				design.setDesignUrls(designUrls);

				designs.add(design);
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		}

		return designs;
	}

	/**
	 * Search for designs by name in the database.
	 *
	 * @param searchQuery The search query to match design names.
	 * @return List of Design objects representing designs that match the search
	 *         query.
	 * @throws DAOException if a database error occurs.
	 */
	public List<Design> searchDesignsByName(String searchQuery) throws DAOException {
		List<Design> designs = new ArrayList<>();
		String query = "SELECT d.design_id, d.design_name, d.style, d.price_per_sqft, "
				+ "d.square_feet, d.category, d.floor_plan, d.time_required, d.bio, "
				+ "d.brief, d.architect_id, d.unique_id, "
				+ "a.name AS architect_name, a.phone_number AS architect_phone, "
				+ "a.email AS architect_email, a.experience AS architect_experience " + "FROM designs AS d "
				+ "INNER JOIN architect AS a ON d.architect_id = a.architect_id "
				+ "WHERE d.is_deleted = 0 AND d.design_name LIKE ?";

		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(query)) {

			String likeQuery = "%" + searchQuery + "%";
			preparedStatement.setString(1, likeQuery);

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				// Retrieve design details from the result set (same as in listDesigns)
				Design design = new Design();
				design.setDesignId(resultSet.getInt("design_id"));
				design.setDesignName(resultSet.getString("design_name"));
				design.setStyle(resultSet.getString("style"));
				design.setPricePerSqFt(resultSet.getDouble("price_per_sqft"));
				design.setSquareFeet(resultSet.getInt("square_feet"));
				design.setCategory(resultSet.getString("category"));
				design.setFloorPlan(resultSet.getString("floor_plan"));
				design.setTimeRequired(resultSet.getInt("time_required"));
				design.setBio(resultSet.getString("bio"));
				design.setBrief(resultSet.getString("brief"));
				design.setArchitectId(resultSet.getInt("architect_id"));
				design.setUniqueId(resultSet.getLong("unique_id"));

				// Create an Architect object and set its properties (same as in listDesigns)
				Architect architect = new Architect();
				architect.setName(resultSet.getString("architect_name"));
				architect.setPhoneNumber(resultSet.getString("architect_phone"));
				architect.setEmail(resultSet.getString("architect_email"));
				architect.setExperience(resultSet.getInt("architect_experience"));

				// Set the Architect object in the Design (same as in listDesigns)
				design.setArchitect(architect);

				// Retrieve design URLs for the current design (same as in listDesigns)
				List<String> designUrls = getDesignUrlsByUniqueId(design.getUniqueId(), connection);
				design.setDesignUrls(designUrls);

				designs.add(design);
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		}

		return designs;
	}

	/**
	 * Update a design's information, including image URLs, in the database.
	 *
	 * @param design The updated Design object
	 * @return true if update is successful, false otherwise
	 * @throws DAOException if a database error occurs
	 */
	public boolean updateDesign(long uniqueId, Design updatedDesign) throws DAOException {
		String selectDesignQuery = "SELECT * FROM designs WHERE unique_id=? AND is_deleted=0";
		String updateDesignQuery = "UPDATE designs SET design_name=?, style=?, price_per_sqft=?, "
				+ "square_feet=?, category=?, floor_plan=?, time_required=?, bio=?, brief=?"
				+ "WHERE unique_id=? AND is_deleted=0";

		String deleteDesignUrlsQuery = "DELETE FROM assets WHERE unique_id=?";
		String insertDesignUrlsQuery = "INSERT INTO assets (unique_id, image_url) VALUES (?, ?)";

		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement selectPmt = connection.prepareStatement(selectDesignQuery);
				PreparedStatement updatePmt = connection.prepareStatement(updateDesignQuery);
				PreparedStatement deleteUrlsPmt = connection.prepareStatement(deleteDesignUrlsQuery);
				PreparedStatement insertUrlsPmt = connection.prepareStatement(insertDesignUrlsQuery)) {

			// Check if the provided uniqueId exists before updating
			selectPmt.setLong(1, uniqueId);
			ResultSet resultSet = selectPmt.executeQuery();

			if (!resultSet.next()) {
				throw new DAOException("Design with UniqueID " + uniqueId + " does not exist.");
			}

			// Retrieve the existing design information
			resultSet.getString("design_name");
			resultSet.getString("style");
			resultSet.getDouble("price_per_sqft");
			resultSet.getInt("square_feet");
			resultSet.getString("category");
			resultSet.getString("floor_plan");
			resultSet.getInt("time_required");
			resultSet.getString("bio");
			resultSet.getString("brief");

			// Set parameters for the design update
			updatePmt.setString(1, updatedDesign.getDesignName());
			updatePmt.setString(2, updatedDesign.getStyle());
			updatePmt.setDouble(3, updatedDesign.getPricePerSqFt());
			updatePmt.setInt(4, updatedDesign.getSquareFeet());
			updatePmt.setString(5, updatedDesign.getCategory());
			updatePmt.setString(6, updatedDesign.getFloorPlan());
			updatePmt.setInt(7, updatedDesign.getTimeRequired());
			updatePmt.setString(8, updatedDesign.getBio());
			updatePmt.setString(9, updatedDesign.getBrief());
			updatePmt.setLong(10, uniqueId);

			// Execute the design update
			int rowsUpdated = updatePmt.executeUpdate();

			// If the update was successful, delete existing design URLs and insert the
			// updated URLs
			if (rowsUpdated == 1) {
				deleteUrlsPmt.setLong(1, uniqueId);
				deleteUrlsPmt.executeUpdate();

				for (String url : updatedDesign.getDesignUrls()) {
					insertUrlsPmt.setLong(1, uniqueId);
					insertUrlsPmt.setString(2, url);
					insertUrlsPmt.executeUpdate();
				}

				return true;
			}

			return false;
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

	/**
	 * Delete a design based on design ID.
	 *
	 * @param designId The ID of the design to be deleted
	 * @return true if deletion is successful, false otherwise
	 * @throws SQLException if a database error occurs
	 */
	public boolean deleteDesign(long uniqueId) throws DAOException {
		String query = "UPDATE designs SET is_deleted = ? WHERE unique_id = ? AND is_deleted = 0 ";

		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement pmt = connection.prepareStatement(query)) {
			pmt.setBoolean(1, true); // Set isDeleted to true to mark the design as deleted
			pmt.setLong(2, uniqueId);
			int rows = pmt.executeUpdate();
			return rows == 1;
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

	public List<Design> getDesignByUniqueId(long uniqueId) throws DAOException {
		String designQuery = "SELECT * FROM designs WHERE unique_id = ?";
		String urlQuery = "SELECT image_url FROM assets WHERE unique_id = ?";
		List<Design> designs = new ArrayList<>();

		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement designStatement = connection.prepareStatement(designQuery);
				PreparedStatement urlStatement = connection.prepareStatement(urlQuery)) {

			designStatement.setLong(1, uniqueId);
			ResultSet designResultSet = designStatement.executeQuery();

			while (designResultSet.next()) {
				Design design = new Design();
				design.setUniqueId(designResultSet.getLong("unique_id"));
				design.setDesignName(designResultSet.getString("design_name"));
				design.setStyle(designResultSet.getString("style"));
				design.setPricePerSqFt(designResultSet.getDouble("price_per_sqft"));
				design.setSquareFeet(designResultSet.getInt("square_feet"));
				design.setCategory(designResultSet.getString("category"));
				design.setFloorPlan(designResultSet.getString("floor_plan"));
				design.setTimeRequired(designResultSet.getInt("time_required"));
				design.setBio(designResultSet.getString("bio"));
				design.setBrief(designResultSet.getString("brief"));
				design.setArchitectId(designResultSet.getInt("architect_id"));

				// Retrieve DesignUrls for the design
				urlStatement.setLong(1, design.getUniqueId());
				ResultSet urlResultSet = urlStatement.executeQuery();
				List<String> designUrls = new ArrayList<>();
				while (urlResultSet.next()) {
					designUrls.add(urlResultSet.getString("image_url"));
				}
				design.setDesignUrls(designUrls);

				designs.add(design);
			}

			return designs;
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

	public List<Design> listDesignsByCategory(String category) throws DAOException {
		List<Design> designs = new ArrayList<>();
		String query = "SELECT d.design_id, d.design_name, d.style, d.price_per_sqft, "
				+ "d.square_feet, d.category, d.floor_plan, d.time_required, d.bio, "
				+ "d.brief, d.architect_id, d.unique_id, "
				+ "a.name AS architect_name, a.phone_number AS architect_phone, "
				+ "a.email AS architect_email, a.experience AS architect_experience " + "FROM designs AS d "
				+ "INNER JOIN architect AS a ON d.architect_id = a.architect_id "
				+ "WHERE d.is_deleted = 0 AND d.category = ?"; // Adjust the WHERE clause

		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(query)) {

			preparedStatement.setString(1, category); // Set the category parameter

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				// Retrieve design details from the result set (same as in listDesigns)
				Design design = new Design();
				design.setDesignId(resultSet.getInt("design_id"));
				design.setDesignName(resultSet.getString("design_name"));
				design.setStyle(resultSet.getString("style"));
				design.setPricePerSqFt(resultSet.getDouble("price_per_sqft"));
				design.setSquareFeet(resultSet.getInt("square_feet"));
				design.setCategory(resultSet.getString("category"));
				design.setFloorPlan(resultSet.getString("floor_plan"));
				design.setTimeRequired(resultSet.getInt("time_required"));
				design.setBio(resultSet.getString("bio"));
				design.setBrief(resultSet.getString("brief"));
				design.setArchitectId(resultSet.getInt("architect_id"));
				design.setUniqueId(resultSet.getLong("unique_id"));

				// Create an Architect object and set its properties (same as in listDesigns)
				Architect architect = new Architect();
				architect.setName(resultSet.getString("architect_name"));
				architect.setPhoneNumber(resultSet.getString("architect_phone"));
				architect.setEmail(resultSet.getString("architect_email"));
				architect.setExperience(resultSet.getInt("architect_experience"));

				// Set the Architect object in the Design (same as in listDesigns)
				design.setArchitect(architect);

				// Retrieve design URLs for the current design
				List<String> designUrls = getDesignUrlsByUniqueId(design.getUniqueId(), connection);
				design.setDesignUrls(designUrls);

				designs.add(design);

			}
		} catch (SQLException e) {
			throw new DAOException(e);
		}

		return designs;
	}

	// main method for search feature

	class Main {
		public static void main(String[] args) {
			// Create an instance of your DesignDAO (you should replace this with your
			// actual DAO instantiation)
			DesignDAO designDAO = new DesignDAO();

			// Create a DesignService instance, injecting the DesignDAO
			DesignService designService = new DesignService();

			// Define the search query
			String searchQuery = "Athena"; // Replace with your desired search query

			try {
				// Call the searchDesignsByName method to search for designs by name
				List<Design> searchResults = designService.searchDesignsByName(searchQuery);

				// Print the search results
				if (!searchResults.isEmpty()) {
					System.out.println("Search Results for '" + searchQuery + "':");
					for (Design design : searchResults) {
						System.out.println("Design Name: " + design.getDesignName());
						System.out.println("Architect: " + design.getArchitect().getName());
						// Add more fields as needed
						System.out.println(); // Separation line
					}
				} else {
					System.out.println("No designs found matching the search query: " + searchQuery);
				}
			} catch (ServiceException e) {
				// Handle any exceptions that may occur during the search
				System.err.println("Error searching for designs: " + e.getMessage());
			}
		}
	}

	public List<String> getDesignUrlsByUniqueId(long uniqueId, Connection connection) throws SQLException {
		List<String> designUrls = new ArrayList<>();
		String query = "SELECT image_url FROM assets WHERE unique_id = ?";

		try (PreparedStatement pmt = connection.prepareStatement(query)) {
			pmt.setLong(1, uniqueId);
			ResultSet resultSet = pmt.executeQuery();

			while (resultSet.next()) {
				designUrls.add(resultSet.getString("image_url"));
			}
		}

		return designUrls;
	}

	public List<String> getDesignUrlsByUniqueId(long uniqueId) throws SQLException {
		String urlQuery = "SELECT image_url FROM assets WHERE unique_id = ?";
		List<String> designUrls = new ArrayList<>();

		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement urlStatement = connection.prepareStatement(urlQuery)) {

			urlStatement.setLong(1, uniqueId);
			ResultSet urlResultSet = urlStatement.executeQuery();

			while (urlResultSet.next()) {
				designUrls.add(urlResultSet.getString("image_url"));
			}
		}

		return designUrls;
	}

	/**
	 * Check if an architect with the given ID exists in the database.
	 *
	 * @param architectId The ID of the architect to check
	 * @return true if the architect exists, false otherwise
	 * @throws DAOException if a database error occurs
	 */
	public boolean checkIdExistsInArchitect(int architectId) throws DAOException {
		String query = "SELECT * FROM architect WHERE architect_id=?";
		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement pmt = connection.prepareStatement(query)) {
			pmt.setInt(1, architectId);
			ResultSet resultSet = pmt.executeQuery();
			return resultSet.next();
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

	public boolean checkUniqueIdExists(long uniqueId) throws DAOException {
		String query = "SELECT * FROM designs WHERE unique_id = ? AND is_deleted = 0 ";

		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(query)) {

			preparedStatement.setLong(1, uniqueId);
			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				int count = resultSet.getInt(1);
				return count > 0; // If count is greater than 0, the uniqueId exists
			}

			return false; // No records found

		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

	// list design by architect Id
	public List<Design> listDesignsByArchitectId(int architectId) throws DAOException {
		String query = "SELECT * FROM designs WHERE architect_id = ? AND is_deleted = 0";

		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(query)) {

			preparedStatement.setInt(1, architectId);
			ResultSet resultSet = preparedStatement.executeQuery();
			List<Design> designs = new ArrayList<>();

			while (resultSet.next()) {
				Design design = new Design();
				design.setUniqueId(resultSet.getLong("unique_id"));
				design.setDesignName(resultSet.getString("design_name"));
				design.setStyle(resultSet.getString("style"));
				design.setPricePerSqFt(resultSet.getDouble("price_per_sqft"));
				design.setSquareFeet(resultSet.getInt("square_feet"));
				design.setCategory(resultSet.getString("category"));
				design.setFloorPlan(resultSet.getString("floor_plan"));
				design.setTimeRequired(resultSet.getInt("time_required"));
				design.setBio(resultSet.getString("bio"));
				design.setBrief(resultSet.getString("brief"));
				design.setArchitectId(resultSet.getInt("architect_id"));

				// Retrieve DesignUrls for the design and set them
				List<String> designUrls = getDesignUrlsByUniqueId(design.getUniqueId());
				design.setDesignUrls(designUrls);

				designs.add(design);
			}

			return designs;

		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

}
