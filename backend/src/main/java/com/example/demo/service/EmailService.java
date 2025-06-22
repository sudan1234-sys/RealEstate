package com.example.demo.service;

import com.example.demo.Dtos.ContactFormDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendEmail(ContactFormDto contactForm) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(contactForm.getEmail());
        message.setTo("sudanrawat59@gmail.com");
        message.setSubject("New Contact Form Submission from " + contactForm.getName());
        message.setText(
                "Sender Email: " + contactForm.getEmail() + "\n\n" +
                        "Message:\n" + contactForm.getMessage()
        );

        mailSender.send(message);
    }
}
