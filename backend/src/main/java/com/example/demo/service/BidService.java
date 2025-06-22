package com.example.demo.service;

import com.example.demo.model.Bid;
import com.example.demo.model.Property;
import com.example.demo.model.User;
import com.example.demo.repository.BidRepository;
import com.example.demo.repository.PropertyRepository;
import com.example.demo.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

// BidService.java
@Service
@Transactional
public class BidService {

    @Autowired
    private BidRepository bidRepository;
    @Autowired
    private PropertyRepository propertyRepository;

    @Autowired
    private PropertyService propertyService;

    @Autowired
    private UserRepository userService;
    public Bid placeBid(Long propertyId, Double amount, Long userId) {
        Property property = propertyRepository.findById(propertyId)
                .orElseThrow(() -> new RuntimeException("Property not found"));
        User user = userService.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        validateBid(property, user, amount);

        Bid bid = new Bid();
        bid.setAmount(amount);
        bid.setProperty(property);
        bid.setUser(user);
        Bid savedBid = bidRepository.save(bid);

        property.setCurrentBid(amount);
        propertyService.saveProperty(property);

        return savedBid;
    }

    private void validateBid(Property property, User user, Double amount) {
        // Check if the auction is active
        if (!property.getIsActive() || property.getEndTime().isBefore(LocalDateTime.now()))
        {
            System.out.println(LocalDateTime.now());
            throw new RuntimeException("Auction has ended");
        }

        // Check if bidder is the property owner
        if (property.getUser().getId().equals(user.getId())) {
            throw new RuntimeException("You cannot bid on your own property");
        }

        // Check if bid is higher than current bid
        if (amount <= property.getCurrentBid()) {
            throw new RuntimeException("Bid must be higher than current bid");
        }
    }

    // Get all bids for a property
    public List<Bid> getBidsForProperty(Long propertyId) {
        return bidRepository.findByPropertyIdOrderByAmountDesc(propertyId);
    }
}
