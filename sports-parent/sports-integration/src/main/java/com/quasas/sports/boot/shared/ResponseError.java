package com.quasas.sports.boot.shared;

import java.io.Serializable;

import com.quasas.sports.boot.exception.SportsApplicationException;

public class ResponseError implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1946378664375691245L;

	private int customCode;

	private long timeStamp;

	private String customMessage;

	public ResponseError(StatusCode customCode, String customMessage, long timeStamp) {
		this.customCode = customCode.getValue();
		this.customMessage = customMessage;
		this.timeStamp = timeStamp;
	}

	public int getCustomCode() {
		return customCode;
	}

	public void setCustomCode(int customCode) {
		this.customCode = customCode;
	}

	public long getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(long timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getCustomMessage() {
		return customMessage;
	}

	public void setCustomMessage(String customMessage) {
		this.customMessage = customMessage;
	}

}
