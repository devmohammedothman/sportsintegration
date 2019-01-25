package com.quasas.sports.simple.client.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(SimpleAPIClientConfig.class)
public class SimpleClientBootApplication {

	
	@Autowired
	static ActivityApiService activityServiceObj;

	public static void main(String[] args) {
		SpringApplication.run(SimpleClientBootApplication.class, args);
		
	}


}
