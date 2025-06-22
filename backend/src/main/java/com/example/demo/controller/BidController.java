package com.example.demo.controller;

import com.example.demo.model.Bid;
import com.example.demo.service.BidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// BidController.java
// https://real-estate-8i16.vercel.app
@RestController
@CrossOrigin(origins = "http://localhost:4200/")
@CrossOrigin(origins = "https://real-estate-8i16.vercel.app")
@RequestMapping("/api/bids")
public class BidController {

    @Autowired
    private BidService bidService;

    // Place a bid (using path variables or request parameters)
    @CrossOrigin(origins = "http://localhost:4200/")
    @CrossOrigin(origins = "https://real-estate-8i16.vercel.app")
    @PostMapping("/place")
    public ResponseEntity<Bid> placeBid(
            @RequestParam Long propertyId,
            @RequestParam Double amount,
            @RequestParam Long userId // Identifier for user (e.g., name, email, etc.)
    ) {
        Bid bid = bidService.placeBid(propertyId, amount, userId);
        return ResponseEntity.ok(bid);
    }

    // Get all bids for a property
    @CrossOrigin(origins = "http://localhost:4200/")
    @CrossOrigin(origins = "https://real-estate-8i16.vercel.app")
    @GetMapping("/property/{propertyId}")
    public ResponseEntity<List<Bid>> getBidsForProperty(@PathVariable Long propertyId) {
        List<Bid> bids = bidService.getBidsForProperty(propertyId);
        return ResponseEntity.ok(bids);
    }
}