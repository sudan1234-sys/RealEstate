package com.example.demo.controller;
import com.example.demo.Dtos.PropertyListDTO;
import com.example.demo.model.Property;
import com.example.demo.model.User;
import com.example.demo.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.service.PropertyService2;

import java.util.List;

@RestController
@RequestMapping("/property")
public class PropertyController {

    @Autowired
    private PropertyService2 propertyService2;
    @Autowired

    private PropertyService propertyService;

    @CrossOrigin(origins = "http://localhost:4200/")
    @CrossOrigin(origins = "https://real-estate-8i16.vercel.app")
    @PostMapping
    @RequestMapping("/saveProperty/{userId}")
    public ResponseEntity<String> saveProperty(@PathVariable Long userId, @RequestBody Property property) {
        propertyService2.addProperty(userId, property); // Call service to save property
        return ResponseEntity.ok("Property added and linked with user!");
    }

    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @CrossOrigin(origins = "https://real-estate-8i16.vercel.app")
    @GetMapping
    @RequestMapping("/getProperties")
    public ResponseEntity<List<Property>> getProperty() {
        List<Property> obj = propertyService2.getProperties();
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @CrossOrigin(origins = "https://real-estate-8i16.vercel.app")
    @GetMapping
    @RequestMapping("/getUsers")
    public ResponseEntity<List<User>> getUsers() {
        List<User> obj = propertyService2.getUsers();
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }
    @PostMapping
    public Property createProperty(@RequestBody Property property) {
        property.setIsActive(true); // Ensure new properties are active
        return propertyService.saveProperty(property);
    }
    @CrossOrigin(origins = "http://localhost:4200/")
    @CrossOrigin(origins = "https://real-estate-8i16.vercel.app")
    @GetMapping("/active")
    public List<PropertyListDTO> getActiveProperties() {
        return propertyService2.getActiveProperties();
    }

}



