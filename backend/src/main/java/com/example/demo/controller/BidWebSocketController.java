package com.example.demo.controller;

import com.example.demo.Dtos.BidMessage;
import com.example.demo.model.Bid;
import com.example.demo.service.BidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class BidWebSocketController {

    @Autowired
    private BidService bidService;

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @MessageMapping("/placeBid")  // Client sends to /app/placeBid
    public void handleBid(BidMessage bidMessage) {
        Bid savedBid = bidService.placeBid(
                bidMessage.getPropertyId(),
                bidMessage.getAmount(),
                bidMessage.getUserId()
        );

        // Send to specific topic for that property
        messagingTemplate.convertAndSend(
                "/topic/bids/" + bidMessage.getPropertyId(),
                savedBid
        );
    }
}
