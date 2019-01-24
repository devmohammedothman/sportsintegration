package com.quasas.sports.boot.shared;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.quasas.sports.boot.exception.SportsApplicationException;

@ControllerAdvice
public class RestGlobalExceptionHandler {

	
		@ExceptionHandler
		public ResponseEntity<ResponseError> handleException(SportsApplicationException ex)
		{
			ResponseError resError = new ResponseError(StatusCode.BADREQUEST,ex.getMessage(),System.currentTimeMillis());
			return new ResponseEntity<>(resError,HttpStatus.BAD_REQUEST);
		}
		
		
		@ExceptionHandler
		public ResponseEntity<ResponseError> handleException(Exception ex)
		{
			ResponseError resError = new ResponseError(StatusCode.BADREQUEST,ex.getMessage(),System.currentTimeMillis());
			return new ResponseEntity<>(resError,HttpStatus.BAD_REQUEST);
		}
}
