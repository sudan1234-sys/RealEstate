package com.example.demo.service;

import com.example.demo.model.Property;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

// AuctionScheduler.java
@Component
public class AuctionScheduler {

    @Autowired
    private PropertyService propertyService;

    @Scheduled(fixedRate = 60000) // Run every minute
    public void closeExpiredAuctions() {
        List<Property> expiredProperties = propertyService.findExpiredActiveProperties();
        expiredProperties.forEach(property -> {
            property.setIsActive(false);
            propertyService.saveProperty(property);
            // Optional: Notify users via WebSocket/email
        });
    }
}
