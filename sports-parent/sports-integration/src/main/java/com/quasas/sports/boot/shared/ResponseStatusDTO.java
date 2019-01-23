package com.quasas.sports.boot.shared;

import java.io.Serializable;

public class ResponseStatusDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5302023044088320796L;
	
	
	
	
	private int customCode;
	
	private String customMessage;
	
	public ResponseStatusDTO(StatusCode customCode,String customMessage)
	{
		
		this.customCode = customCode.getValue();
		this.customMessage = customMessage;
	}

	public int getCustomCode() {
		return customCode;
	}

	public void setCustomCode(int customCode) {
		this.customCode = customCode;
	}

	public String getCustomMessage() {
		return customMessage;
	}

	public void setCustomMessage(String customMessage) {
		this.customMessage = customMessage;
	}

		
	

}
