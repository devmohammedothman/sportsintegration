package com.quasas.sports.gen.client.api;


import org.springframework.web.client.RestClientException;

import com.quasas.sports.gen.client.model.DetailedActivity;

public class ApiMainRun {
	
	
	public static void main(String[] args) {
		
//		 ClientCredentialsResourceDetails details = new ClientCredentialsResourceDetails();
//
//		    details.setId("oauth2server");
//		    details.setTokenName("oauth_token");
//		    details.setClientId("clientadmin");
//		    details.setClientSecret("123");
//		    details.setAccessTokenUri("http://localhost:8080/oauth/token");
//		    details.setScope(Arrays.asList("admin"));
//
//		    details.setClientAuthenticationScheme(AuthenticationScheme.header);
		
		ActivitiesApi activityApi = new ActivitiesApi();
		//ApiClient client = activityApi.getApiClient();
		
		
//		OAuth sportAuth = (OAuth) client.getAuthentication("strava_oauth");
//		
//		sportAuth.setAccessToken("15f5f2088fdc63b3692aca8ebfffcc395fc10482");
		
		// client.setAccessToken("15f5f2088fdc63b3692aca8ebfffcc395fc10482");
		
		Boolean includeAllEfforts = false;
		Long id = (long) 2084377508;
		try 
		{
			
			DetailedActivity resultActivity =  activityApi.getActivityById(id, includeAllEfforts);
			
			System.out.println(resultActivity.getName());
		}
		catch(RestClientException ex)
		{
			ex.printStackTrace();
		}
		

	}

}
