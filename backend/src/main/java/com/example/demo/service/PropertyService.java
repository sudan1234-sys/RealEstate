package com.example.demo.service;

// PropertyService.java
import com.example.demo.Dtos.PropertyFilterRequest;
import com.example.demo.model.Property;
import com.example.demo.model.PropertySpecifications;
import com.example.demo.repository.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PropertyService {
    private final PropertyRepository propertyRepository;

    @Autowired
    public PropertyService(PropertyRepository propertyRepository) {
        this.propertyRepository = propertyRepository;
    }

    // Get all filtered properties
    public List<Property> filterProperties(PropertyFilterRequest filters) {
        return propertyRepository.findAll(PropertySpecifications.withFilters(filters));
    }

    // Paginated version (optional)
    public Page<Property> filterPropertiesPaginated(PropertyFilterRequest filters, Pageable pageable) {
        return propertyRepository.findAll(PropertySpecifications.withFilters(filters), pageable);
    }
    public Property saveProperty(Property property) {
        return propertyRepository.save(property);
    }
    public List<Property> findExpiredActiveProperties() {
        return propertyRepository.findExpiredActiveProperties();
    }
}
