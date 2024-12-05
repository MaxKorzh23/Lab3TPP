package ua.city;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Continent {
    private int continentId;
    private String continentName;

    // Конструктор за замовченням
    public Continent() {
    }

    // Конструктор з параметрами
    public Continent(int continentId, String continentName) {
        this.continentId = continentId;
        this.continentName = continentName;
    }

    // Геттери та сеттери
    public int getContinentId() {
        return continentId;
    }

    public void setContinentId(int continentId) {
        this.continentId = continentId;
    }

    public String getContinentName() {
        return continentName;
    }

    public void setContinentName(String continentName) {
        this.continentName = continentName;
    }

    // Метод для отримання всіх континентів з БД
    public static List<Continent> getAllContinents(Connection connection) throws SQLException {
        List<Continent> continents = new ArrayList<>();
        String query = "SELECT * FROM continent";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                int id = resultSet.getInt("continent_id");
                String name = resultSet.getString("continentName");
                continents.add(new Continent(id, name));
            }
        }
        return continents;
    }

    // Метод для додавання нового континенту
    public static void addContinent(Connection connection, String continentName) throws SQLException {
        String query = "INSERT INTO continent (continentName) VALUES (?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, continentName);
            preparedStatement.executeUpdate();
        }
    }

    // Метод для видалення континенту за ID
    public static void deleteContinentById(Connection connection, int continentId) throws SQLException {
        String query = "DELETE FROM continent WHERE continent_id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, continentId);
            preparedStatement.executeUpdate();
        }
    }

    // Метод для оновлення назви континенту
    public static void updateContinentName(Connection connection, int continentId, String newContinentName) throws SQLException {
        String query = "UPDATE continent SET continentName = ? WHERE continent_id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, newContinentName);
            preparedStatement.setInt(2, continentId);
            preparedStatement.executeUpdate();
        }
    }
}



