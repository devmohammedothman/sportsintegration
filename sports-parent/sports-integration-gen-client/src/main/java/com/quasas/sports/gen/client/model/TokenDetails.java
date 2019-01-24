package com.quasas.sports.gen.client.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;


public class TokenDetails implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -827749213151491543L;
	
	@JsonProperty("token_type")
	private String tokenType;
	
	@JsonProperty("access_token")
	private String accessToken;

	@JsonProperty("expires_at")
	private String expiresAt;
	
	@JsonProperty("expires_in")
	private String expiresIn;
	
	@JsonProperty("refresh_token")
	private String refreshToken;
	
	@JsonProperty("athlete")
	private DetailedAthlete athlete;
	
	

	public TokenDetails() {
	}

	public String getTokenType() {
		return tokenType;
	}

	public void setTokenType(String tokenType) {
		this.tokenType = tokenType;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public String getExpiresAt() {
		return expiresAt;
	}

	public void setExpiresAt(String expiresAt) {
		this.expiresAt = expiresAt;
	}

	public String getExpiresIn() {
		return expiresIn;
	}

	public void setExpiresIn(String expiresIn) {
		this.expiresIn = expiresIn;
	}

	public String getRefreshToken() {
		return refreshToken;
	}

	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}

	public DetailedAthlete getAthlete() {
		return athlete;
	}

	public void setAthlete(DetailedAthlete athlete) {
		this.athlete = athlete;
	}

	@Override
	public String toString() {
		return "TokenDetils [tokenType=" + tokenType + ", accessToken=" + accessToken + ", expiresAt=" + expiresAt
				+ ", expiresIn=" + expiresIn + ", refreshToken=" + refreshToken + "]";
	} 
	
	
	
	
}