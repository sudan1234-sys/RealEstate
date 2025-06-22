package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
public class LandPhoto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

   // Map to the correct column name in the database
    private String photoUrl;

    @ManyToOne
    @JoinColumn(name = "land_id", nullable = false)
    @JsonBackReference
    private Land land;

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public Land getLand() {
        return land;
    }

    public void setLand(Land land) {
        this.land = land;
    }
}