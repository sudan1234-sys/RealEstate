package com.example.demo.Dtos;

public class BidMessage {
    private Long propertyId;
    private Double amount;
    private Long userId;

    public Long getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(Long propertyId) {
        this.propertyId = propertyId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Double getAmount() {
        return amount;
    }

    public Long getUserId() {
        return userId;
    }
// Getters and Setters
}
