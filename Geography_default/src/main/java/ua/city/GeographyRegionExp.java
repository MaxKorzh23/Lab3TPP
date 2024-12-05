package ua.city;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GeographyRegionExp {



	// Метод для отримання музичної групи за ID
	public GeographyRegion getGeographyRegionById(int regionId) throws SQLException {
		String sql = "SELECT * FROM region WHERE region_id = ?";

		try (Connection conn = DatabaseControl.getConnection();
			 PreparedStatement stmt = conn.prepareStatement(sql)) {

			stmt.setInt(1, regionId); // Встановлюємо значення region_id
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				return new GeographyRegion(rs.getInt("region_id"), rs.getString("regionName"));
			}
		}
		return null;
	}

	// Метод для оновлення назви регіону
	public boolean updateGeographyRegion(int regionId, String newRegionName) throws SQLException {
		String sql = "UPDATE region SET regionName = ? WHERE region_id = ?";

		try (Connection conn = DatabaseControl.getConnection();
			 PreparedStatement stmt = conn.prepareStatement(sql)) {

			stmt.setString(1, newRegionName);
			stmt.setInt(2, regionId);
			int rowsAffected = stmt.executeUpdate();

			return rowsAffected > 0; // Повертаємо true, якщо оновлення успішне
		}
	}

	// Метод для отримання всіх регіону
	public List<GeographyRegion> getAllGeographyRegions() throws SQLException {
		List<GeographyRegion> geographyRegions = new ArrayList<>();
		String sql = "SELECT * FROM region";

		try (Connection conn = DatabaseControl.getConnection();
			 Statement stmt = conn.createStatement();
			 ResultSet rs = stmt.executeQuery(sql)) {

			while (rs.next()) {
				geographyRegions.add(new GeographyRegion(rs.getInt("region_id"), rs.getString("regionName")));
			}
		}
		return geographyRegions;
	}

	// Метод для видалення регіону за ID
	public boolean deleteGeographyRegion(int regionId) throws SQLException {
		String sql = "DELETE FROM region WHERE region_id = ?";

		try (Connection conn = DatabaseControl.getConnection();
			 PreparedStatement stmt = conn.prepareStatement(sql)) {

			stmt.setInt(1, regionId);
			int rowsAffected = stmt.executeUpdate();

			return rowsAffected > 0; // Повертаємо true, якщо видалення успішне
		}
	}
}
