package ua.city;

public class State {
    private int stateId;
    private String stateName;
    private String stateArea; // Час у форматі HH:mm:ss

    // Конструктор за замовченням
    public State() {}

    // Конструктор із параметрами
    public State(int stateId, String stateName, String stateArea) {
        this.stateId = stateId;
        this.stateName = stateName;
        this.stateArea = stateArea;
    }

    // Геттери та сеттери
    public int getStateId() {
        return stateId;
    }

    public void setStateId(int stateId) {
        this.stateId = stateId;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public String getStateArea() {
        return stateArea;
    }

    public void setStateArea(String stateArea) {
        this.stateArea = stateArea;
    }

    @Override
    public String toString() {
        return "State{" +
                "stateId=" + stateId +
                ", stateName='" + stateName + '\'' +
                ", stateArea='" + stateArea + '\'' +
                '}';
    }
}

