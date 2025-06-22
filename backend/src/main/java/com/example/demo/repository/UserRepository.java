package com.example.demo.repository;

import com.example.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT DISTINCT u FROM User u LEFT JOIN FETCH u.properties")
    List<User> findAllWithProperties();

    @Query("SELECT DISTINCT u FROM User u LEFT JOIN FETCH u.lands")
    List<User> findAllWithLands();

    Optional<User> findByname(String username);
    //


    
}
