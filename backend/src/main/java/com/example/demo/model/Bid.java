package com.example.demo.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;


@Entity
    @Table(name = "bids")
    public class Bid {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(nullable = false)
        private Double amount;

        @Column(nullable = false)
        private LocalDateTime timestamp = LocalDateTime.now();

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "property_id", nullable = false)
        private Property property;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "user_id", nullable = false)
        private User user;

        // Getters, setters, constructors (use Lombok if needed)

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public Property getProperty() {
        return property;
    }

    public void setProperty(Property property) {
        this.property = property;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

