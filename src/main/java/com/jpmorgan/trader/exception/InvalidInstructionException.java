/*
 * 
 */
package com.jpmorgan.trader.exception;

/**
 * The Class InvalidInstructionException.
 */
public class InvalidInstructionException extends Exception {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 5213710411700835321L;

	/**
	 * Instantiates a new invalid instruction exception.
	 *
	 * @param errorMessage the error message
	 */
	public InvalidInstructionException(String errorMessage) {
		super(errorMessage);
	}

}
