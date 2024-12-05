package ua.city;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GeographyRegionExp {
    // Insert (Create)
    public void insertGeographyRegion(String regionName) {
        String sql = "INSERT INTO region_injection (regionName) VALUES (?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, regionName);
            pstmt.executeUpdate();
            System.out.println("Geography region inserted successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Select all (Read)
    public void getAllGeographyRegions() {
        String sql = "SELECT * FROM region_injection";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("region_id") +
                        ", Name: " + rs.getString("regionName"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Update
    public void updateGeographyRegion(int regionId, String newRegionName) {
        String sql = "UPDATE region_injection SET regionName = ? WHERE region_id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, newRegionName);
            pstmt.setInt(2, regionId);
            pstmt.executeUpdate();
            System.out.println("Geography region updated successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Delete
    public void deleteGeographyRegion(int regionId) {
        String sql = "DELETE FROM region_injection WHERE region_id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, regionId);
            pstmt.executeUpdate();
            System.out.println("Geography region deleted successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}