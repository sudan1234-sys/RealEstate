package com.example.demo.Dtos;

import com.example.demo.model.Property;

import java.util.List;

// UserWithPropertiesDTO.java
public class UserWithPropertiesDTO {
    private Long id;
    private String name;
    private String email;
    private List<Property> properties;

    // No-arg constructor (required by Jackson)
    public UserWithPropertiesDTO() {}

    // All-args constructor
    public UserWithPropertiesDTO(Long id, String name, String email, List<Property> properties) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.properties = properties;
    }

    // Getters and Setters (required for JSON serialization)
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public List<Property> getProperties() { return properties; }
    public void setProperties(List<Property> properties) { this.properties = properties; }
}