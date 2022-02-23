package com.example.spring_boot_news;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class SpringBootNewsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootNewsApplication.class, args);
	}

}
