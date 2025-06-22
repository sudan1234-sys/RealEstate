package com.example.demo.repository;

import com.example.demo.model.Property;
import com.example.demo.model.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import java.util.List;

public interface PropertyRepository extends JpaRepository<Property, Long>, JpaSpecificationExecutor<Property> {

    @Query("SELECT p.id FROM Property p ORDER BY p.id DESC")
    List<Long> findTop4PropertyIds(Pageable pageable);
    @Query("SELECT p FROM Property p " +
            "LEFT JOIN FETCH p.user " +
            "LEFT JOIN FETCH p.photos " +
            "WHERE p.id IN :ids")

    List<Property> findPropertiesWithDetails(@Param("ids") List<Long> ids);
    @Query("SELECT p FROM Property p WHERE p.isActive = true AND p.endTime < CURRENT_TIMESTAMP")
    List<Property> findExpiredActiveProperties();
    List<Property> findByIsActiveTrue();

}
