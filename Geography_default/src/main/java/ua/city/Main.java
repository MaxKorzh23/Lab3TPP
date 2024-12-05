package ua.city;

import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
        // Создание объектов DAO
        ContinentExp continentExp = new ContinentExp();
        GeographyRegionExp geographyRegionExp = new GeographyRegionExp();
        StateExp stateExp = new StateExp();

        // Приклад додавання континенту
        Continent continent = new Continent();
        continent.setContinentName("Africa");
        int continentId = continentExp.addContinent(continent);
        continent.setContinentId(continentId);

        if (continentId > 0) {
            System.out.println("Континент додано: " + continent);
        } else {
            System.out.println("Помилка: не вдалося додати континент.");
        }

        // Приклад додавання держави
        State state = new State();
        state.setStateName("Egypt");
        state.setStateArea("1002000");
        int stateId = stateExp.addState(state);
        state.setStateId(stateId);

        if (stateId > 0) {
            System.out.println("Державу додано: " + state);
        } else {
            System.out.println("Помилка: не вдалося додати державу.");
        }

        // Виведення всіх континентів
        System.out.println("\nСписок континентів:");
        List<Continent> continents = continentExp.getAllContinents();
        for (Continent g : continents) {
            System.out.println("ID: " + g.getContinentId() + ", Назва: " + g.getContinentName());
        }

        // Виведення всіх ргіонів
        System.out.println("\nСписок регіонів:");
        List<GeographyRegion> geographyRegions = geographyRegionExp.getAllGeographyRegions();
        for (GeographyRegion g : geographyRegions) {
            System.out.println("ID: " + g.getRegionId() + ", Назва: " + g.getRegionName());
        }

        // Виведення всіх держав
        System.out.println("\nСписок держав:");
        List<State> states = stateExp.getAllStates();
        for (State s : states) {
            System.out.println("ID: " + s.getStateId() + ", Назва: " + s.getStateName() + ", Площа: " + s.getStateArea());
        }
    }
}
