package com.firstspringapp;

import com.firstspringapp.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class App {

	public static void main(String[] args) {

		SpringApplication.run(App.class, args);

		System.out.println("Hello World");
	}
	@Bean
	CommandLineRunner run(UserService userService) {
		return args -> userService.print();
	}

}
