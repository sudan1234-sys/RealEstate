package com.example.demo.Dtos;

import com.example.demo.model.User;

public class SellerDTO {
    private Long id;
    private String name;
    private String email;
    private String phone;

    // No-args constructor
    public SellerDTO() {
    }

    public SellerDTO(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();

    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
}