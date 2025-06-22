package com.example.demo.controller;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UserPostController {
  @Autowired
  private UserService userService;
 @CrossOrigin(origins = {"http://localhost:4200/", "https://real-estate-8i16.vercel.app"})
  @PostMapping("/saveuser")
  public ResponseEntity<String> saveUser(@RequestBody User user) {
   String message= userService.save(user);
    return ResponseEntity.ok(message);
  }



}
