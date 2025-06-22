package com.example.demo.service;

import com.example.demo.Dtos.PropertyListDTO;
import com.example.demo.model.Property;
import com.example.demo.model.User;

import java.util.List;

public interface PropertyService2 {
    void addProperty(Long userId, Property property);
    List<Property> getProperties();

    List<User> getUsers();

    List<PropertyListDTO> getActiveProperties();
}

