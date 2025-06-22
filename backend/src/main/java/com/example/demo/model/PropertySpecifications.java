package com.example.demo.model;
import com.example.demo.Dtos.PropertyFilterRequest;
import org.springframework.data.jpa.domain.Specification;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.List;

public class PropertySpecifications {

    public static Specification<Property> withFilters(PropertyFilterRequest filters) {
        return (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();

            // 1. Location Filters (ignore empty/blank strings)
            if (filters.getCity() != null && !filters.getCity().isBlank()) {
                predicates.add(cb.equal(root.get("city"), filters.getCity()));
            }
            if (filters.getState() != null && !filters.getState().isBlank()) {
                predicates.add(cb.equal(root.get("state"), filters.getState()));
            }
            if (filters.getCountry() != null && !filters.getCountry().isBlank()) {
                predicates.add(cb.equal(root.get("country"), filters.getCountry()));
            }

            // 2. Property Type (ignore empty/blank)
            if (filters.getType() != null && !filters.getType().isBlank()) {
                predicates.add(cb.equal(root.get("type"), filters.getType()));
            }

            // 3. Price Range (ignore null)
            if (filters.getMinPrice() != null) {
                predicates.add(cb.greaterThanOrEqualTo(root.get("price"), filters.getMinPrice()));
            }
            if (filters.getMaxPrice() != null) {
                predicates.add(cb.lessThanOrEqualTo(root.get("price"), filters.getMaxPrice()));
            }

            // 4. Bedrooms/Bathrooms (ignore null)
            if (filters.getMinBedrooms() != null) {
                predicates.add(cb.greaterThanOrEqualTo(root.get("bedrooms"), filters.getMinBedrooms()));
            }
            if (filters.getMinBathrooms() != null) {
                predicates.add(cb.greaterThanOrEqualTo(root.get("bathrooms"), filters.getMinBathrooms()));
            }

            // 5. Garage/Year Built (ignore null)
            if (filters.getMinGarage() != null) {
                predicates.add(cb.greaterThanOrEqualTo(root.get("garage"), filters.getMinGarage()));
            }
            if (filters.getMinYearBuilt() != null) {
                predicates.add(cb.greaterThanOrEqualTo(root.get("yearBuilt"), filters.getMinYearBuilt()));
            }



            // Combine all predicates with AND
            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }
}