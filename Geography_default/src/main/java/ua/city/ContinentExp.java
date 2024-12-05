package ua.city;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContinentExp {

	// Метод для додавання нового континенту
	public int addContinent(Continent continent) {
		String sql = "INSERT INTO continent (continentName) VALUES (?)";
		try (Connection conn = DatabaseControl.getConnection();
			 PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
			pstmt.setString(1, continent.getContinentName());
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

	// Метод для отримання континенту за ID
	public Continent getContinentById(int continentId) throws SQLException {
		String sql = "SELECT * FROM continent WHERE continent_id = ?";
		try (Connection conn = DatabaseControl.getConnection();
			 PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setInt(1, continentId);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				return new Continent(rs.getInt("continent_id"), rs.getString("continentName"));
			}
		}
		return null;
	}

	// Метод для отримання всіх континентів
	public List<Continent> getAllContinents() throws SQLException {
		List<Continent> continents = new ArrayList<>();
		String sql = "SELECT * FROM continent";
		try (Connection conn = DatabaseControl.getConnection();
			 Statement stmt = conn.createStatement();
			 ResultSet rs = stmt.executeQuery(sql)) {
			while (rs.next()) {
				continents.add(new Continent(rs.getInt("continent_id"), rs.getString("continentName")));
			}
		}
		return continents;
	}

	// Метод для видалення континенту за ID
	public boolean deleteContinentById(int continentId) {
		String sql = "DELETE FROM continent WHERE continent_id = ?";
		try (Connection conn = DatabaseControl.getConnection();
			 PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setInt(1, continentId);
			int rowsAffected = stmt.executeUpdate();
			return rowsAffected > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	// Метод для оновлення назви континенту
	public boolean updateContinentName(int continentId, String newContinentName) {
		String sql = "UPDATE continent SET continentName = ? WHERE continent_id = ?";
		try (Connection conn = DatabaseControl.getConnection();
			 PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setString(1, newContinentName);
			stmt.setInt(2, continentId);
			int rowsAffected = stmt.executeUpdate();
			return rowsAffected > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}