package com.example.demo.repository;
import com.example.demo.model.Land;
import com.example.demo.model.Property;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LandRepository extends JpaRepository<Land, Long>  {
    @Query("SELECT p.id FROM Land p ORDER BY p.id DESC")
    List<Long> findTop4LandsIds(Pageable pageable);
    @Query("SELECT p FROM Land p " +
            "LEFT JOIN FETCH p.user " +
            "LEFT JOIN FETCH p.photos " +
            "WHERE p.id IN :ids")
    List<Land> findLandsWithDetails(@Param("ids") List<Long> ids);
}
