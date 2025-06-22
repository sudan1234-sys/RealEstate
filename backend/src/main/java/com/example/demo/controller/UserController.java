package com.example.demo.controller;

import com.example.demo.Dtos.LandListDTO;
import com.example.demo.Dtos.PropertyListDTO;
import com.example.demo.Dtos.UserWithLandsDTO;
import com.example.demo.Dtos.UserWithPropertiesDTO;
import com.example.demo.model.Property;
import com.example.demo.repository.LandRepository;
import com.example.demo.repository.PropertyRepository;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private PropertyRepository propertyRepository;
    private final UserService userService;
    @Autowired
    private LandRepository landRepository;


    public UserController(UserService userService) {
        this.userService = userService;
    }
    @CrossOrigin(origins = "http://localhost:4200/")
    @CrossOrigin(origins = "https://real-estate-8i16.vercel.app")
    @GetMapping("/with-properties")
    public List<UserWithPropertiesDTO> getUsersWithProperties() {
        return userService.getUsersWithProperties();
    }

    @GetMapping("/with-lands")
    public List<UserWithLandsDTO> getUsersWithLands() {
        return userService.getUsersWithLands();
    }
    @CrossOrigin(origins = "http://localhost:4200/")
    @CrossOrigin(origins = "https://real-estate-8i16.vercel.app")
    @GetMapping("/all-properties")
    public List<PropertyListDTO> getAllProperties() {
        // Get top 5 IDs first (with proper ordering)
        List<Long> top4Ids = propertyRepository.findTop4PropertyIds(PageRequest.of(0, 4));

        // Get full details for these 5 IDs
        List<Property> properties = propertyRepository.findPropertiesWithDetails(top4Ids);

        // Convert to DTO
        return properties.stream()
                .map(PropertyListDTO::new)
                .collect(Collectors.toList());
    }
    @GetMapping( "/all-lands")
    @CrossOrigin(origins = "http://localhost:4200/")
    @CrossOrigin(origins = "https://real-estate-8i16.vercel.app")
    public List<LandListDTO> getAlLands() {
        List<Long> top4Ids = landRepository.findTop4LandsIds(PageRequest.of(0, 4));
        return landRepository.findLandsWithDetails(top4Ids).stream()
                .map(LandListDTO::new)
                .collect(Collectors.toList());
    }



}
