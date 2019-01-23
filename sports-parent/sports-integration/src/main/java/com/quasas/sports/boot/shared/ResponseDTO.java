package com.quasas.sports.boot.shared;

import java.io.Serializable;

public class ResponseDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5428751645851374005L;
	
	
	private ResponseStatusDTO status;
	private Object data;
	
	public ResponseDTO(StatusCode customCode,String customMessage, Object data) {

		this.status = new ResponseStatusDTO(customCode,customMessage);
		this.data = data;
	}
	
	
	public ResponseStatusDTO getStatus() {
		return status;
	}
	public void setStatus(ResponseStatusDTO status) {
		this.status = status;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}

}
