package com.quasas.sports.boot.shared;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.quasas.sports.boot.exception.SportsApplicationException;
/**
 * Helper Class that Handle all controller exceptions
 * @author <a href="mailto:dev.mohammed.othman@gmail.com">Mohammed Othman</a>
 *
 */
@ControllerAdvice
public class RestGlobalExceptionHandler {

	
	/**
	 * Handle Custom Application Exception 
	 * @param ex custom application Exception
	 * @return Custom Response Error
	 */
		@ExceptionHandler
		public ResponseEntity<ResponseError> handleException(SportsApplicationException ex)
		{
			ResponseError resError = new ResponseError(StatusCode.BADREQUEST,ex.getMessage(),System.currentTimeMillis());
			return new ResponseEntity<>(resError,HttpStatus.BAD_REQUEST);
		}
		
		/**
		 * Handle General Exceptions for Controllers
		 * @param ex custom application Exception
		 * @return Custom Response Error
		 */
		@ExceptionHandler
		public ResponseEntity<ResponseError> handleException(Exception ex)
		{
			ResponseError resError = new ResponseError(StatusCode.BADREQUEST,ex.getMessage(),System.currentTimeMillis());
			return new ResponseEntity<>(resError,HttpStatus.BAD_REQUEST);
		}
}
