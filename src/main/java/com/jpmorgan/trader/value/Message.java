/*
 * 
 */
package com.jpmorgan.trader.value;
/*
 * Format in which instruction can be received by JMS queue
 * Here it is  string[]. In real world, it can be json or xml
 */

/**
 * The Class Message.
 */
public class Message {

	/** The json string. */
	private String[] jsonString;

	/**
	 * Gets the json string.
	 *
	 * @return the json string
	 */
	public String[] getJsonString() {
		return jsonString;
	}

	/**
	 * Sets the json string.
	 *
	 * @param jsonString the new json string
	 */
	public void setJsonString(String[] jsonString) {
		this.jsonString = jsonString;
	}

}
