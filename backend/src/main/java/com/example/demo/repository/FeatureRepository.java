package com.example.demo.repository;

import com.example.demo.model.Feature;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeatureRepository extends JpaRepository<Feature, Long> {
}
