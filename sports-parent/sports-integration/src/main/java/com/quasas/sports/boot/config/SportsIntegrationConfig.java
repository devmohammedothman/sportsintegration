package com.quasas.sports.boot.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.quasas.sports.gen.client.api.ActivitiesApi;
import com.quasas.sports.gen.client.invoker.ApiClient;

@Configuration
public class SportsIntegrationConfig {
	
	
	private static final Logger logger = LogManager.getLogger(SportsIntegrationConfig.class);
	
	 	    
	    @Value("${strava.api.grantType}")
	    private String grantType;
	    
	    @Value("${strava.api.clientId}")
	    private String clientId;
	    
	    @Value("${strava.api.clientSecret}")
	    private String clientSecret;
	    
	    @Value("${strava.api.accessTokenUri}")
	    private String accessTokenUri;
	    
	    @Value("${strava.api.code}")
	    private String code;
	
	@Bean
	public ActivitiesApi activitiesApi()
	{
		return new ActivitiesApi(apiClient());
	}
	
	@Bean
	public ApiClient apiClient()
	{
		ApiClient apiClient = new ApiClient(grantType,clientId,clientSecret,accessTokenUri,code);
		
		//log token details
		logger.info("=================> API Token Details ::{}",apiClient.getTokenDetails());
		
		return apiClient;
	}

}
