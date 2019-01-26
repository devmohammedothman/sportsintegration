package com.quasas.sports.boot.exception;


/**
 * Deine Custom Exception Class to represent application Exceptions
 * @author <a href="mailto:dev.mohammed.othman@gmail.com">Mohammed Othman</a>
 *
 */
public class SportsApplicationException extends Exception {

	/**
	 * Generated Serial ID
	 */
	private static final long serialVersionUID = 2021607970483973511L;

	/**
	 * Constructor
	 * @param message that will be displayed in Exception and passed to super Exception class
	 */
	public SportsApplicationException(String message) {
		super(message);

	}

}
