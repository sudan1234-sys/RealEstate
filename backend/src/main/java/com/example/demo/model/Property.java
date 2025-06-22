package com.example.demo.model;



import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
public class Property {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String street;
    private String city;
    private String state;
    private String postalCode;
    private String country;


    private Double price;
    private String type;
    private Date listingDate;
    private Integer bedrooms;
    private Integer bathrooms;
    private String landSize;
    private Integer squareFootage;
    private Integer yearBuilt;
    private Integer garage;
    private String description;

    @OneToMany(fetch = FetchType.EAGER ,mappedBy = "property", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Photo> photos;

    @OneToMany(fetch = FetchType.EAGER,mappedBy = "property", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Feature> features;
    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    @Column(name = "current_bid")
    private Double currentBid;
    @Column(name = "is_active")
    private Boolean isActive = true; // Default to active

    @Column(name = "end_time")
    private LocalDateTime endTime; // Auction end date/time
    // Getters and Setters
    public Long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getListingDate() {
        return listingDate;
    }

    public void setListingDate(Date listingDate) {
        this.listingDate = listingDate;
    }

    public Integer getBedrooms() {
        return bedrooms;
    }

    public void setBedrooms(Integer bedrooms) {
        this.bedrooms = bedrooms;
    }

    public Integer getBathrooms() {
        return bathrooms;
    }

    public void setBathrooms(Integer bathrooms) {
        this.bathrooms = bathrooms;
    }

    public String getLandSize() {
        return landSize;
    }

    public void setLandSize(String landSize) {
        this.landSize = landSize;
    }

    public Integer getSquareFootage() {
        return squareFootage;
    }

    public void setSquareFootage(Integer squareFootage) {
        this.squareFootage = squareFootage;
    }

    public Integer getYearBuilt() {
        return yearBuilt;
    }

    public void setYearBuilt(Integer yearBuilt) {
        this.yearBuilt = yearBuilt;
    }

    public Integer getGarage() {
        return garage;
    }

    public void setGarage(Integer garage) {
        this.garage = garage;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Photo> getPhotos() {
        return photos;
    }

    public void setPhotos(List<Photo> photos) {
        this.photos = photos;

    }

    public List<Feature> getFeatures() {
        return features;
    }

    public void setFeatures(List<Feature> features) {
        this.features = features;

    }
    public Double getCurrentBid() {
        return currentBid;
    }

    public void setCurrentBid(Double currentBid) {
        this.currentBid = currentBid;
    }
    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

}
