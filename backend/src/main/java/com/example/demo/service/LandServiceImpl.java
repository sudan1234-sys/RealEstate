package com.example.demo.service;

import com.example.demo.model.*;

import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import com.example.demo.repository.LandRepository;

@Service
public class LandServiceImpl implements LandService {

    @Autowired
    private LandRepository landRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public void addLand(long userId, Land land) {
        List<Land> listObj = landRepository.findAll();
        listObj.forEach(land1 -> {
            if (land1.getStreet().equals(land.getStreet()) &&
                    land1.getCity().equals(land.getCity()) &&
                    land1.getPostalCode().equals(land.getPostalCode()) &&
                    land1.getState().equals(land.getState())) {
                throw new RuntimeException("Land already exists!");
            }
        });

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        land.setUser(user);

        // Handle photos
        if (land.getPhotos() != null) {
            for (LandPhoto photo : land.getPhotos()) {
                photo.setLand(land);
                photo.setId(null); // Prevent ID conflict
            }
        }

        landRepository.save(land);
    }
    @Override
    public List<Land> getLands() {
       return landRepository.findAll();
    }
}
