package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
@Entity
public class LandFeature {



        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String feature;

        @ManyToOne
        @JsonBackReference
        @JoinColumn(name = "Land_id", nullable = false)
        private Land land;

        // Getters and Setters
        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getFeature() {
            return feature;
        }

        public void setFeature(String feature) {
            this.feature = feature;
        }

        public Land getLand() {
            return land;
        }

        public void setLand(Land land) {
            this.land = land;
        }
    }

