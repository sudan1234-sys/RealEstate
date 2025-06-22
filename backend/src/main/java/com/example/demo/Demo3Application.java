package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication

public class Demo3Application extends SpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(Demo3Application.class, args);
	}

}
