/*
 * 
 */
package com.jpmorgan.trader.exception;

/**
 * The Class InvalidActionException.
 */
public class InvalidActionException extends Exception {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 5213710411700835321L;

	/**
	 * Instantiates a new invalid action exception.
	 *
	 * @param errorMessage the error message
	 */
	public InvalidActionException(String errorMessage) {
		super(errorMessage);
	}

}
