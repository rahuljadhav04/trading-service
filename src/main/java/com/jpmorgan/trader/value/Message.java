package com.jpmorgan.trader.value;
/*
 * Format in which instruction can be received by JMS queue
 * Here it is  string[]. In real world, it can be json or xml
 */

public class Message {

	private String[] jsonString;

	public String[] getJsonString() {
		return jsonString;
	}

	public void setJsonString(String[] jsonString) {
		this.jsonString = jsonString;
	}

}
