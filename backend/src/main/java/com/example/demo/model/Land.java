package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Land {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    private String description; // Description of the land (e.g., "near road", "close to school")

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private User user; // The user who owns the land

    @OneToMany(mappedBy = "land", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<LandPhoto> photos;
    @OneToMany(mappedBy = "land", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<LandFeature> features;
// Photos of the land

    // Getters and setters
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<LandPhoto> getPhotos() {
        return photos;
    }

    public void setPhotos(List<LandPhoto> photos) {
        this.photos = photos;
    }
    public List<LandFeature> getFeatures() {
        return features;
    }

    public void setFeatures(List<LandFeature> features) {
        this.features = features;

    }
}