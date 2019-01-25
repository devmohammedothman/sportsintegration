package com.quasas.sports.simple.client.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.quasas.sports.simple.client.invoker.SimpleAPIClient;

@Configuration
@PropertySource("classpath:application.properties")
public class SimpleAPIClientConfig {
	
	
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
	public SimpleAPIClient  simpleClient()
	{
		SimpleAPIClient simpleApiClient = new SimpleAPIClient(grantType,clientId,clientSecret,accessTokenUri,code);
		return simpleApiClient;
	}

}
