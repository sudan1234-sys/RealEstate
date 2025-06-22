package com.example.demo.repository;

import com.example.demo.model.Bid;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

// BidRepository.java
public interface BidRepository extends JpaRepository<Bid, Long> {
    // Find the highest bid for a property
    @Query("SELECT b FROM Bid b WHERE b.property.id = :propertyId ORDER BY b.amount DESC")
    List<Bid> findTopByPropertyIdOrderByAmountDesc(@Param("propertyId") Long propertyId, Pageable pageable);

    // Find all bids for a property (sorted by highest first)
    List<Bid> findByPropertyIdOrderByAmountDesc(Long propertyId);
}
