package com.quasas.sports.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@ComponentScan("com.quasas.sports.boot")
@EntityScan("com.quasas.sports.boot.entity")
public class SportsIntegrationApplication {

	public static void main(String[] args) {
		SpringApplication.run(SportsIntegrationApplication.class, args);
	}

}

