package com.example.demo.Dtos;

import com.example.demo.model.Property;
import com.example.demo.model.Photo;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import com.example.demo.model.Feature;

public class PropertyListDTO {
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
    private List<String> photos;
    private List<String> features;
    private SellerDTO seller;
    private LocalDateTime auctionEnd;


    // No-args constructor (required by Jackson)
    public PropertyListDTO() {
    }

    public PropertyListDTO(Property property) {
        this.id = property.getId();
        this.street = property.getStreet();
        this.city = property.getCity();
        this.state = property.getState();
        this.postalCode = property.getPostalCode();
        this.country = property.getCountry();
        this.price = property.getPrice();
        this.type = property.getType();
        this.listingDate = property.getListingDate();
        this.bedrooms = property.getBedrooms();
        this.bathrooms = property.getBathrooms();
        this.landSize = property.getLandSize();
        this.squareFootage = property.getSquareFootage();
        this.yearBuilt = property.getYearBuilt();
        this.garage = property.getGarage();
        this.description = property.getDescription();
        this.photos = property.getPhotos().stream()
                .map(Photo::getPhotoUrl)
                .collect(Collectors.toList());
        this.features = property.getFeatures().stream()
                .map(Feature::getFeature)
                .collect(Collectors.toList());
        this.seller = new SellerDTO(property.getUser());
        this.auctionEnd = property.getEndTime();
        // ← map the auction end time
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getStreet() { return street; }
    public void setStreet(String street) { this.street = street; }

    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }

    public String getState() { return state; }
    public void setState(String state) { this.state = state; }

    public String getPostalCode() { return postalCode; }
    public void setPostalCode(String postalCode) { this.postalCode = postalCode; }

    public String getCountry() { return country; }
    public void setCountry(String country) { this.country = country; }

    public Double getPrice() { return price; }
    public void setPrice(Double price) { this.price = price; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public Date getListingDate() { return listingDate; }
    public void setListingDate(Date listingDate) { this.listingDate = listingDate; }

    public Integer getBedrooms() { return bedrooms; }
    public void setBedrooms(Integer bedrooms) { this.bedrooms = bedrooms; }

    public Integer getBathrooms() { return bathrooms; }
    public void setBathrooms(Integer bathrooms) { this.bathrooms = bathrooms; }

    public String getLandSize() { return landSize; }
    public void setLandSize(String landSize) { this.landSize = landSize; }

    public Integer getSquareFootage() { return squareFootage; }
    public void setSquareFootage(Integer squareFootage) { this.squareFootage = squareFootage; }

    public Integer getYearBuilt() { return yearBuilt; }
    public void setYearBuilt(Integer yearBuilt) { this.yearBuilt = yearBuilt; }

    public Integer getGarage() { return garage; }
    public void setGarage(Integer garage) { this.garage = garage; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public List<String> getPhotos() { return photos; }
    public void setPhotos(List<String> photos) { this.photos = photos; }
    public List<String> getFeatures() { return features; }
    public void setFeatures(List<String> features) { this.features = features; }


    public SellerDTO getSeller() { return seller; }
    public void setSeller(SellerDTO seller) { this.seller = seller; }

    public void setAuctionEnd(LocalDateTime auctionEnd) {
        this.auctionEnd = auctionEnd;
    }

    public LocalDateTime getAuctionEnd() {
        return auctionEnd;
    }
}