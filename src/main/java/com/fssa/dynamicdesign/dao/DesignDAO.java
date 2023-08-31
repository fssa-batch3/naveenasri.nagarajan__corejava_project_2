package com.fssa.dynamicdesign.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fssa.dynamicdesign.dao.exception.DAOException;
import com.fssa.dynamicdesign.model.Design;
import com.fssa.dynamicdesign.util.ConnectionUtil;

public class DesignDAO {

    /**
     * Create a new design and store it in the database.
     *
     * @param design The Design object to be created
     * @return true if creation is successful, false otherwise
     * @throws DAOException if a database error occurs
     */
    public boolean createDesign(Design design) throws DAOException {
    	String query = "INSERT INTO designs (design_name, design_url, price, description, no_of_rooms, architect_id) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection connection = ConnectionUtil.getConnection();
             PreparedStatement pmt = connection.prepareStatement(query)) {

            // Check if architectId exists before inserting
            if (checkIdExistsInArchitect(design.getArchitectId())) {
                pmt.setString(1, design.getDesignName());
                pmt.setString(2, design.getDesignUrl());
                pmt.setDouble(3, design.getPrice());
                pmt.setString(4, design.getDescription());
                pmt.setInt(5, design.getNoOfRooms());
                pmt.setInt(6, design.getArchitectId());
            }

            int rows = pmt.executeUpdate();
            return rows == 1;

        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    /**
     * Retrieve a list of all designs from the database.
     *
     * @return List of Design objects representing all designs in the database
     * @throws SQLException if a database error occurs
     */
    public List<Design> listDesigns() throws SQLException {
        List<Design> designs = new ArrayList<>();
        String query = "SELECT designs.design_id, designs.design_name, designs.design_url, designs.price,designs.description, designs.no_of_rooms, "
                + "architect.architect_id, architect.name, architect.phone_number, architect.email, architect.experience "
                + "FROM designs "
                + "INNER JOIN architect ON designs.architect_id = architect.architect_id";

        try (Connection connection = ConnectionUtil.getConnection();
             PreparedStatement pmt = connection.prepareStatement(query);
             ResultSet resultSet = pmt.executeQuery()) {

            while (resultSet.next()) {
                // Retrieve design details from the result set
                String designName = resultSet.getString("design_name");
                String designUrl = resultSet.getString("design_url");
                double price = resultSet.getDouble("price");
                String description = resultSet.getString("description");
                int noOfRooms = resultSet.getInt("no_of_rooms");
                int architectID = resultSet.getInt("architect_id");

                Design design = new Design(designName, designUrl, price,description, noOfRooms, architectID);
                designs.add(design);
            }

            return designs;
        }
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

    /**
     * Update a design's information in the database.
     *
     * @param design The updated Design object
     * @return true if update is successful, false otherwise
     * @throws SQLException if a database error occurs
     */
    public boolean updateDesign(Design design) throws SQLException {
        String query = "UPDATE designs SET design_name=?, design_url=?, price=?,description=?, no_of_rooms=? WHERE design_id=?";
        
        try (Connection connection = ConnectionUtil.getConnection();
             PreparedStatement pmt = connection.prepareStatement(query)) {
            pmt.setString(1, design.getDesignName());
            pmt.setString(2, design.getDesignUrl());
            pmt.setDouble(3, design.getPrice());
            pmt.setString(4, design.getDescription());
            pmt.setInt(5, design.getNoOfRooms());
            pmt.setInt(6, design.getDesignId());

            int rows = pmt.executeUpdate();
            return rows == 1;
        }
    }

    /**
     * Delete a design based on design ID.
     *
     * @param designId The ID of the design to be deleted
     * @return true if deletion is successful, false otherwise
     * @throws SQLException if a database error occurs
     */
    public boolean deleteDesign(int designId) throws SQLException {
        String query = "UPDATE designs SET is_deleted = ? WHERE design_id = ?";

        try (Connection connection = ConnectionUtil.getConnection();
             PreparedStatement pmt = connection.prepareStatement(query)) {
            pmt.setBoolean(1, true); // Set isDeleted to true to mark the design as deleted
            pmt.setInt(2, designId);
            int rows = pmt.executeUpdate();
            return rows == 1;
        }
    }
}
