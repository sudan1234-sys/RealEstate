package com.example.demo.controller;

import com.example.demo.Dtos.PropertyFilterRequest;
import com.example.demo.Dtos.PropertyListDTO;
import com.example.demo.model.Property;
import com.example.demo.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController

@RequestMapping("/api/properties")
@CrossOrigin(origins = {"http://localhost:4200/", "https://real-estate-8i16.vercel.app"})
public class PropertyFilterController {
    private final PropertyService propertyService;

    @Autowired


    public PropertyFilterController(PropertyService propertyService) {
        this.propertyService = propertyService;
    }


    @GetMapping("/filter")
@CrossOrigin(origins = {"http://localhost:4200/", "https://real-estate-8i16.vercel.app"})
        public ResponseEntity<List<PropertyListDTO>> filterProperties(
                @RequestParam(required = false) String type,
                @RequestParam(required = false) String city,
                @RequestParam(required = false) String state,
                @RequestParam(required = false) String country,
                @RequestParam(required = false) Double minPrice,
                @RequestParam(required = false) Double maxPrice,
                @RequestParam(required = false) Integer minBedrooms,
                @RequestParam(required = false) Integer minBathrooms,
                @RequestParam(required = false) Integer minGarage,
                @RequestParam(required = false) Integer minYearBuilt
        ) {
            PropertyFilterRequest filters = new PropertyFilterRequest();
            filters.setType(type);
            filters.setCity(city);
            filters.setState(state);
            filters.setCountry(country);
            filters.setMinPrice(minPrice);
            filters.setMaxPrice(maxPrice);
            filters.setMinBedrooms(minBedrooms);
            filters.setMinBathrooms(minBathrooms);
            filters.setMinGarage(minGarage);
            filters.setMinYearBuilt(minYearBuilt);

            return ResponseEntity.ok(propertyService.filterProperties(filters).stream()
                    .map(PropertyListDTO::new)
                    .collect(Collectors.toList()));
        }

        // Paginated endpoint (optional)
        @GetMapping("/filter/paginated")
       @CrossOrigin(origins = {"http://localhost:4200/", "https://real-estate-8i16.vercel.app"})
        public ResponseEntity<Page<Property>> filterPropertiesPaginated(
                @RequestParam(required = false) String type,
                @RequestParam(required = false) String city,
                @RequestParam(required = false) String state,
                @RequestParam(required = false) String country,
                @RequestParam(required = false) Double minPrice,
                @RequestParam(required = false) Double maxPrice,
                @RequestParam(required = false) Integer minBedrooms,
                @RequestParam(required = false) Integer minBathrooms,
                @RequestParam(required = false) Integer minGarage,
                @RequestParam(required = false) Integer minYearBuilt,
                @PageableDefault(size = 10, sort = "price") Pageable pageable
        ) {
            // Build filters
            PropertyFilterRequest filters = new PropertyFilterRequest();
            filters.setType(type);
            filters.setCity(city);
            filters.setState(state);
            filters.setCountry(country);
            filters.setMinPrice(minPrice);
            filters.setMaxPrice(maxPrice);
            filters.setMinBedrooms(minBedrooms);
            filters.setMinBathrooms(minBathrooms);
            filters.setMinGarage(minGarage);
            filters.setMinYearBuilt(minYearBuilt);

            return ResponseEntity.ok(propertyService.filterPropertiesPaginated(filters, pageable));
        }
}

