package ua.city;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StateExp {

    // Метод для додавання держави
    public int addState(State state) {
        String sql = "INSERT INTO state (stateName, stateArea) VALUES (?, ?)";
        try (Connection conn = DatabaseControl.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setString(1, state.getStateName());
            pstmt.setDouble(2, Double.parseDouble(state.getStateArea()));
            pstmt.executeUpdate();
            ResultSet rs = pstmt.getGeneratedKeys();
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    // Метод для отримання всіх держав
    public List<State> getAllStates() {
        List<State> states = new ArrayList<>();
        String sql = "SELECT * FROM state";
        try (Connection conn = DatabaseControl.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                State state = new State();
                state.setStateId(rs.getInt("state_id"));
                state.setStateName(rs.getString("stateName"));
                state.setStateArea(rs.getString("stateArea"));
                states.add(state);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return states;
    }

    // Метод для оновлення держави
    public void updateState(State state) {
        String sql = "UPDATE state SET stateName = ?, stateArea = ? WHERE state_id = ?";
        try (Connection conn = DatabaseControl.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, state.getStateName());
            pstmt.setString(2, state.getStateArea());
            pstmt.setInt(3, state.getStateId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Метод для видалення держави за ID
    public void deleteState(int id) {
        String sql = "DELETE FROM state WHERE state_id = ?";
        try (Connection conn = DatabaseControl.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
