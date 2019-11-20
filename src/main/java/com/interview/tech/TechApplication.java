package com.interview.tech;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.Collections;

@SpringBootApplication
@EnableJpaRepositories("com.interview.tech")
public class TechApplication {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(TechApplication.class);
		app.setDefaultProperties(Collections.<String, Object>singletonMap("server.port", "8083"));
		app.run(args);
	}

}
