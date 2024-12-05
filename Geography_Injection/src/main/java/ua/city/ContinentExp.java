package ua.city;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ContinentExp {
    // Insert (Create)
    public void insertContinent(String continentName) {
        String sql = "INSERT INTO continent_injection (continentName) VALUES (?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, continentName);
            pstmt.executeUpdate();
            System.out.println("Continent inserted successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Select all (Read)
    public void getAllContinents() {
        String sql = "SELECT * FROM continent_injection";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("continent_id") +
                        ", Name: " + rs.getString("continentName"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Update
    public void updateContinent(int continentId, String newContinentName) {
        String sql = "UPDATE continent_injection SET continentName = ? WHERE continent_id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, newContinentName);
            pstmt.setInt(2, continentId);
            pstmt.executeUpdate();
            System.out.println("Continent updated successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Delete
    public void deleteContinent(int continentId) {
        String sql = "DELETE FROM continent_injection WHERE continent_id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, continentId);
            pstmt.executeUpdate();
            System.out.println("Continent deleted successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}