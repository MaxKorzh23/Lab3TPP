package ua.city;

import java.sql.*;

public class StateExp {
    // Insert (Create)
    public void insertState(String stateName, String stateArea) {
        String sql = "INSERT INTO state_injection (stateName, stateArea) VALUES (?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, stateName);
            pstmt.setTime(2, Time.valueOf(stateArea));
            pstmt.executeUpdate();
            System.out.println("State inserted successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Select all (Read)
    public void getAllStates() {
        String sql = "SELECT * FROM state_injection";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("state_id") +
                        ", Name: " + rs.getString("stateName") +
                        ", Area: " + rs.getString("stateArea"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Update
    public void updateState(int stateId, String newStateName, String newArea) {
        String sql = "UPDATE state_injection SET stateName = ?, stateArea = ? WHERE state_id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, newStateName);
            pstmt.setTime(2, Time.valueOf(newArea));
            pstmt.setInt(3, stateId);
            pstmt.executeUpdate();
            System.out.println("State updated successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateStateName(int stateId, String newStateName) {
        String sql = "UPDATE state_injection SET stateName = ? WHERE state_id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, newStateName);
            pstmt.setInt(2, stateId);
            pstmt.executeUpdate();
            System.out.println("State name updated successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Delete
    public void deleteState(int stateId) {
        String sql = "DELETE FROM state_injection WHERE state_id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, stateId);
            pstmt.executeUpdate();
            System.out.println("State deleted successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}