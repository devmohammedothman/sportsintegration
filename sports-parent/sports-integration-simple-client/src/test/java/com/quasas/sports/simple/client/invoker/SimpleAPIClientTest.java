package com.quasas.sports.simple.client.invoker;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Ignore;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SimpleAPIClientTest {
	
	SimpleAPIClient simpleApiClient;

	@BeforeEach
	void setUp() throws Exception {
		
		
	}

	@Ignore
	@Test
	void testBuildApiClientToken() throws Exception {
		
		
		simpleApiClient = new SimpleAPIClient("authorization_code", "31769", "5088c7ea25210b9835c5797fc279edd7745ed243",
				"https://www.strava.com/oauth/token", "964db11814b0f245384299f02057f56998ac790b");
		
		assertNotNull(simpleApiClient.getTokenObj());
	}

}
