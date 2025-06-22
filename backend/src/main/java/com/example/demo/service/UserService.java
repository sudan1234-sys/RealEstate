package com.example.demo.service;

import com.example.demo.Dtos.UserWithLandsDTO;
import com.example.demo.Dtos.UserWithPropertiesDTO;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


    @Service
    public class UserService {
        private final UserRepository userRepository;

        public UserService(UserRepository userRepository) {
            this.userRepository = userRepository;
        }

        public List<UserWithPropertiesDTO> getUsersWithProperties() {
            List<User> users = userRepository.findAllWithProperties();
            return users.stream()
                    .map(user -> new UserWithPropertiesDTO(
                            user.getId(),
                            user.getName(),
                            user.getEmail(),
                            user.getProperties()))
                    .collect(Collectors.toList());
        }


        public List<UserWithLandsDTO> getUsersWithLands() {
            List<User> users = userRepository.findAllWithLands();
            return users.stream()
                    .map(user -> new UserWithLandsDTO(
                            user.getId(),
                            user.getName(),
                            user.getEmail(),
                            user.getLands()))
                    .collect(Collectors.toList());
        }
        public String save(User user) {
            List<User> users = userRepository.findAll();
            for(User u : users) {
                if(u.getEmail().contains(user.getEmail())) {
                 return "user already exists!";
                }
            }
            userRepository.save(user);
            return "User saved successfully!";
        }

    }

