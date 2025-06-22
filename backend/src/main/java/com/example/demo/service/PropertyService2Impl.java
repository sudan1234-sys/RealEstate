package com.example.demo.service;

import com.example.demo.Dtos.PropertyListDTO;
import com.example.demo.model.Feature;
import com.example.demo.model.Photo;
import com.example.demo.model.Property;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.repository.PropertyRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PropertyService2Impl implements PropertyService2 {
     @Autowired
    private  PropertyRepository propertyRepository;
    @Autowired
     private UserRepository userRepository;

    @Override
    public void addProperty(Long userId,Property property) {

        List<Property> listObj = propertyRepository.findAll();
        listObj.forEach(property1 ->{
            if(property1.getStreet().equals(property.getStreet()) && property1.getCity().equals(property.getCity()) && property1.getPostalCode().equals(property.getPostalCode()) && property1.getState().equals(property.getState())){
                throw new RuntimeException("Property already exists!");

            }
        });
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        // Link the property to the user
        property.setUser(user);
        // Ensure photos and features are linked to the property
        if (property.getPhotos() != null) {
            for (Photo photo : property.getPhotos()) {
                photo.setProperty(property); // Link the photo to the property
            }
        }

        if (property.getFeatures() != null) {
            for (Feature feature : property.getFeatures()) {
                feature.setProperty(property); // Link the feature to the property
            }


        }
        propertyRepository.save(property);

    }



    @Override
    public List<Property> getProperties() {
        return propertyRepository.findAll();
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }
    @Override
    public List<PropertyListDTO> getActiveProperties() {
        return propertyRepository
                .findByIsActiveTrue()
                .stream()
                .map(PropertyListDTO::new)
                .collect(Collectors.toList());
    }
}
