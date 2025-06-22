package com.example.demo;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataSeeder implements CommandLineRunner {
boolean seed = false;
    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        List<User> listObj = userRepository.findAll();
        User user = new User();
        user.setName("John Doe");
        user.setEmail("john@example.com");
        listObj.forEach(user1 ->{
            if(user1.getEmail().equals(user.getEmail())){
              seed = true;
            }


        } );


        if (seed) {
            System.out.println("User already exists!");
            return;
        }
      else {
          userRepository.save(user);
          System.out.println("User saved successfully!");
        }
    }
}
