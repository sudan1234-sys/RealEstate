package com.example.demo.Dtos;

// PropertyFilterRequest.java
public class PropertyFilterRequest {
    private String type;
    private String city;
    private String state;
    private String country;
    private Double minPrice;
    private Double maxPrice;
    private Integer minBedrooms;
    private Integer minBathrooms;
    private Integer minGarage;
    private Integer minYearBuilt;

    // Getters and Setters
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }

    public String getState() { return state; }
    public void setState(String state) { this.state = state; }

    public String getCountry() { return country; }
    public void setCountry(String country) { this.country = country; }

    public Double getMinPrice() { return minPrice; }
    public void setMinPrice(Double minPrice) { this.minPrice = minPrice; }

    public Double getMaxPrice() { return maxPrice; }
    public void setMaxPrice(Double maxPrice) { this.maxPrice = maxPrice; }

    public Integer getMinBedrooms() { return minBedrooms; }
    public void setMinBedrooms(Integer minBedrooms) { this.minBedrooms = minBedrooms; }

    public Integer getMinBathrooms() { return minBathrooms; }
    public void setMinBathrooms(Integer minBathrooms) { this.minBathrooms = minBathrooms; }

    public Integer getMinGarage() { return minGarage; }
    public void setMinGarage(Integer minGarage) { this.minGarage = minGarage; }

    public Integer getMinYearBuilt() { return minYearBuilt; }
    public void setMinYearBuilt(Integer minYearBuilt) { this.minYearBuilt = minYearBuilt; }
}