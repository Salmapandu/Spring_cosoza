package com.example.COSOZA.Registration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@RestController
public class CosozaRegistrationApplication implements WebMvcConfigurer{

	public static void main(String[] args) {
		SpringApplication.run(CosozaRegistrationApplication.class, args);
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**")
						.allowedOrigins("http://localhost:4200") // Allow requests only from localhost:4200
						.allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Allow these HTTP methods
						.allowedHeaders("Content-Type", "Authorization") // Allow these headers
						.allowCredentials(true) // Allow credentials like cookies
						.maxAge(3600); // Cache preflight requests for 3600 seconds (1 hour)
			}
		};
	}

}
