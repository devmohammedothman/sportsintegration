package com.quasas.sports.simple.client.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.quasas.sports.simple.client.invoker.SimpleAPIClient;

@Service
public class ActivityApiService {
	
	private static final String baseUrl = "https://www.strava.com/api/v3/activities/";

	@Autowired
	private SimpleAPIClient simpleApiClient;
	
	public ActivityApiService()
	{

	}

	public ResponseEntity<Activity> getActivityById(Long id) {
		RestTemplate restTemplate = simpleApiClient.getRestTemplate();

		ResponseEntity<Activity> response = restTemplate.exchange(baseUrl + id.toString(), HttpMethod.GET,
				simpleApiClient.getRequest(), Activity.class);
		
		System.out.println(response);

		return response;
		
		
	}

}
