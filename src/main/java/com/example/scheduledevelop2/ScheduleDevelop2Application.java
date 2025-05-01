package com.example.scheduledevelop2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class ScheduleDevelop2Application {

	public static void main(String[] args) {
		SpringApplication.run(ScheduleDevelop2Application.class, args);
	}

}
