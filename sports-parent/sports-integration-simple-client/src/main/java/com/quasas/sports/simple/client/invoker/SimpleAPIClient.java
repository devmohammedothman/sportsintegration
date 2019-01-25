package com.quasas.sports.simple.client.invoker;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class SimpleAPIClient {
	
	
	private String grantType;

	private String clientId;

	private String clientSecret;

	private String accessTokenUri;

	private String code;


	private HttpEntity<String> request;

	private HttpHeaders headers;

	private RestTemplate restTemplate;

	private TokenDetails tokenObj;

	public SimpleAPIClient(String grantType, String clientId, String clientSecret, String accessTokenUri, String code) {
		
		this.grantType = grantType;
		this.clientId = clientId;
		this.clientSecret = clientSecret;
		this.accessTokenUri = accessTokenUri;
		this.code = code;
		
		headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		headers.set("Accept", "application/json");

		try {
			buildApiClientToken();

			buildRestTemplate();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void buildApiClientToken() throws Exception {
		try {

			RestTemplate restTempGetAccessCode = new RestTemplate();

			//String params = "client_id=31769&client_secret=5088c7ea25210b9835c5797fc279edd7745ed243&code=964db11814b0f245384299f02057f56998ac790b&grant_type=authorization_code";

			StringBuilder params = new StringBuilder();
			params.append("client_id=" + this.clientId);
			params.append("&client_secret=" + this.clientSecret);
			params.append("&code=" + this.code);
			params.append("&grant_type=" + this.grantType);
			
			request = new HttpEntity<String>(params.toString(), headers);

			HttpEntity<TokenDetails> tokenResponse = restTempGetAccessCode
					.exchange("https://www.strava.com/oauth/token", HttpMethod.POST, request, TokenDetails.class);

			tokenObj = tokenResponse.getBody();
			

		} catch (Exception ex) {
			throw new Exception("Exception when get Api Client Token with Message ---------------->" + ex.getMessage());
		}
	}

	public void buildRestTemplate() throws Exception {

		try {

			restTemplate = new RestTemplate();

			// This allows us to read the response more than once - Necessary for debugging.
			restTemplate.setRequestFactory(new BufferingClientHttpRequestFactory(new SimpleClientHttpRequestFactory()));
			
			List<ClientHttpRequestInterceptor> interceptors = new ArrayList<>();
			interceptors.add(new LoggingRequestInterceptor());
			restTemplate.setInterceptors(interceptors);

			headers = new HttpHeaders();
			
			headers.add(HttpHeaders.AUTHORIZATION, "Bearer " + tokenObj.getAccessToken());
			headers.add("User-Agent", "Java-SDK");
			request = new HttpEntity<String>(headers);
	
		} catch (Exception ex) {
			throw new Exception("Exception when Build Rest Template with Message ---------------->" + ex.getMessage());
		}
	}

	public RestTemplate getRestTemplate() {
		return restTemplate;
	}

	public void setRestTemplate(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	public HttpEntity<String> getRequest() {
		
		return request;
	}

	public void setRequest(HttpEntity<String> request) {
		this.request = request;
	}
	
	public String getGrantType() {
		return grantType;
	}

	public void setGrantType(String grantType) {
		this.grantType = grantType;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getClientSecret() {
		return clientSecret;
	}

	public void setClientSecret(String clientSecret) {
		this.clientSecret = clientSecret;
	}

	public String getAccessTokenUri() {
		return accessTokenUri;
	}

	public void setAccessTokenUri(String accessTokenUri) {
		this.accessTokenUri = accessTokenUri;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public TokenDetails getTokenObj() {
		return tokenObj;
	}

	public void setTokenObj(TokenDetails tokenObj) {
		this.tokenObj = tokenObj;
	}
}

