package com.example.demo.Dtos;

import com.example.demo.model.Land;

import java.util.List;

// UserWithLandsDTO.java
public class UserWithLandsDTO {
    private Long id;
    private String name;
    private String email;
    private List<Land> lands;

    public UserWithLandsDTO() {} // No-arg constructor

    public UserWithLandsDTO(Long id, String name, String email, List<Land> lands) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.lands = lands;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public List<Land> getLands() { return lands; }
    public void setLands(List<Land> lands) { this.lands = lands; }
}

