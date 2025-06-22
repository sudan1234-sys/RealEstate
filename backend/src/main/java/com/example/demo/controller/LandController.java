package com.example.demo.controller;

import com.example.demo.model.Land;
import com.example.demo.model.Property;
import com.example.demo.service.LandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:4200/", "https://real-estate-8i16.vercel.app"})
@RequestMapping("/property")
public class LandController {
    @Autowired
    private LandService landService;

    @PostMapping
@CrossOrigin(origins = {"http://localhost:4200/", "https://real-estate-8i16.vercel.app"})
    @RequestMapping("/saveLand/{userId}")

    public ResponseEntity<String> addLand(@PathVariable Long userId, @RequestBody Land land) {
        landService.addLand(userId,land); // Call service to save property
        return ResponseEntity.ok("Property added and linked with user!");
    }
   @CrossOrigin(origins = {"http://127.0.0.1:5500", "https://real-estate-8i16.vercel.app"})
    @GetMapping
    @RequestMapping("/getLands")
    public ResponseEntity<List<Land>> getLands(){
        List<Land> obj= landService.getLands();
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }
}
