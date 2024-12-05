package ua.city;

public class GeographyRegion {
    private int regionId;
    private String regionName;

    // Конструктор за замовченням
    public GeographyRegion() {
    }

    // Конструктор з параметрами
    public GeographyRegion(int regionId, String regionName) {
        this.regionId = regionId;
        this.regionName = regionName;
    }

    // Геттери та сеттери
    public int getRegionId() {
        return regionId;
    }

    public void setRegionId(int regionId) {
        this.regionId = regionId;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }
}



