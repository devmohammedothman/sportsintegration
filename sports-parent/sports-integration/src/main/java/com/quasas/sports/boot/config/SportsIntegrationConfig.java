package com.quasas.sports.boot.config;

import org.springframework.beans.factory.annotation.Value;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.quasas.sports.gen.client.api.ActivitiesApi;
import com.quasas.sports.gen.client.invoker.ApiClient;

/**
 * Sports Integration Class to configure and define required beans of Client API
 * This API client bean will be used to open connection for Rest API Call Also
 * will be responsible for getting access token and give it to Rest Template
 * that will be used for exchanging Information
 * 
 * @author <a href="mailto:dev.mohammed.othman@gmail.com">Mohammed Othman</a>
 *
 */
@Configuration
public class SportsIntegrationConfig {

	/**
	 * Grant Type Value that will passed to API CLient , it is configured to be read
	 * from properties file
	 */
	@Value("${strava.api.grantType}")
	private String grantType;

	/**
	 * Client Id that will passed to API CLient , it is configured to be read from
	 * properties file You can get this Client Id when register to service provider
	 * who support Oauth for authentication
	 */
	@Value("${strava.api.clientId}")
	private String clientId;

	/**
	 * Client Secret that will passed to API CLient , it is configured to be read
	 * from properties file You can get this Client secret when register to service
	 * provider who support Oauth for authentication
	 */
	@Value("${strava.api.clientSecret}")
	private String clientSecret;

	/**
	 * Access Token URI that will passed to API CLient , it is configured to be read
	 * from properties file You can get this Access Token URI from service provider
	 * who support Oauth for authentication
	 */
	@Value("${strava.api.accessTokenUri}")
	private String accessTokenUri;

	/**
	 * Code that will passed to API CLient , it is configured to be read from
	 * properties file You can get this Code firstly by doing below steps after
	 * register to service provider who support Oauth for authentication if your
	 * service provider doesn't support Client Credentials of Oauth Flow so getting
	 * this code by your self will be mandatory. Steps to get this Code : 
	 * 1- Open Your Browser and make Get Request for this URL
	 * <a href="https://www.strava.com/oauth/authorize?client_id=[YOUR CLIENTID]&redirect_uri=http://localhost&response_type=code&approval_prompt=force&scope=read,read_all,profile:read_all,profile:write,activity:read_all,activity:write">GetCode</a> 
	 * 2- this will ask you to authorize this app to get your information
	 * 3- click Authorize "It may ask you to login firstly with your user name and password" 
	 * 4- you will be redirected to another page that has code in browser URL
	 * 5- get this code value and save it in properties file
	 */
	@Value("${strava.api.code}")
	private String code;

	/**
	 * Configure Bean creation for Activities API
	 * 
	 * @return Activities API Bean Object
	 */
	@Bean
	public ActivitiesApi activitiesApi() {
		return new ActivitiesApi(apiClient());
	}

	/**
	 * configure Bean Creation for APIClient This API Client will be responsible for
	 * getting your access token
	 * 
	 * @return APIClient Bean Object
	 */
	@Bean
	public ApiClient apiClient() {
		ApiClient apiClient = new ApiClient(grantType, clientId, clientSecret, accessTokenUri, code);

		return apiClient;
	}

}
