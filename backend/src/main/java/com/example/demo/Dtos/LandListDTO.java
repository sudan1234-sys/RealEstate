package com.example.demo.Dtos;

import com.example.demo.model.Land;
import com.example.demo.model.LandFeature;
import com.example.demo.model.LandPhoto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LandListDTO {
    private Long id;

    private double size; // Size of the land (e.g., in square meters)
    private String type; // Type of land (e.g., residential, commercial, agricultural)
    private String street;
    private String city;
    private String state;
    private String postalCode;
    private String country; // Location of the land (e.g., coordinates or address)
    private boolean hasUtilities; // Whether the land has utilities (e.g., water, electricity)
    private String zoning; // Zoning information (e.g., residential, industrial)
    private double price; // Price of the land
    private String description; // Description
    private List<String> landphotos;
    private List<String> features;
    private SellerDTO seller;

    //no-args constructor
    public LandListDTO() {};
    //parameterized constructor
    public LandListDTO(Land lands){
        this.id = lands.getId();
        this.size = lands.getSize();
        this.type = lands.getType();
        this.street = lands.getStreet();
        this.city = lands.getCity();
        this.state = lands.getState();
        this.postalCode = lands.getPostalCode();
        this.country = lands.getCountry();
        this.hasUtilities = lands.isHasUtilities();
        this.zoning = lands.getZoning();
        this.price = lands.getPrice();
        this.description = lands.getDescription();
        this.landphotos = lands.getPhotos().stream().map(
                (LandPhoto::getPhotoUrl)
        ).collect(Collectors.toList());
        this.features= lands.getFeatures().stream().map(
                (LandFeature::getFeature)
        ).collect(Collectors.toList());
        this.seller = new SellerDTO(lands.getUser());


    }
    // getters and setters
    public Long getId() {
        return id;

    }
    public void setId(Long id) {
        this.id = id;
    }
    public double getSize() {
        return size;

    }
    public void setSize(double size) {
        this.size = size;

    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;

    }
    public String getStreet() {
        return street;

    }
    public void setStreet(String street) {
        this.street = street;

    }
    public String getCity() {
        return city;

    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;

    }
    public String getPostalCode() {
        return postalCode;

    }
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    public boolean isHasUtilities() {
        return hasUtilities;

    }
    public void setHasUtilities(boolean hasUtilities) {
        this.hasUtilities = hasUtilities;

    }
    public String getZoning() {
        return zoning;

    }
    public void setZoning(String zoning) {
        this.zoning = zoning;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;

    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public List<String> getLandphotos() {
        return landphotos;
    }
    public void setLandphotos(List<String> landphotos) {
        this.landphotos = landphotos;
    }
    public List<String> getFeatures() { return features; }
    public void setFeatures(List<String> features) { this.features = features; }
    public SellerDTO getSeller() { return seller; }
    public void setSeller(SellerDTO seller) { this.seller = seller; }
}
