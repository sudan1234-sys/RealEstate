package com.example.demo.controller;
import com.example.demo.Dtos.ContactFormDto;
import com.example.demo.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/contact")
@CrossOrigin(origins = {"http://localhost:4200/", "https://real-estate-8i16-kkn06gb9w-sudan1234-sys-projects.vercel.app/"})
public class ContactController {

    @Autowired
    private EmailService emailService;
    @CrossOrigin(origins = {"http://127.0.0.1:5500", "https://real-estate-8i16-kkn06gb9w-sudan1234-sys-projects.vercel.app/"})
    @PostMapping
    public ResponseEntity<String> submitContactForm(@RequestBody ContactFormDto contactForm) {
        try {
            emailService.sendEmail(contactForm);
            return ResponseEntity.ok("Message sent successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error sending message: " + e.getMessage());
        }
    }
}
