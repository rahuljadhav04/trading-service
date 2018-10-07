/*
 * 
 */
package com.jpmorgan.trader.enums;

import org.springframework.util.StringUtils;

import com.jpmorgan.trader.exception.InvalidActionException;

/**
 * The Enum Action.
 */
public enum Action {
	
	/** The buy. */
	BUY("B"), 
 /** The sell. */
 SELL("S");
	
	/** The action type. */
	private String actionType;

	/**
	 * Gets the action type.
	 *
	 * @return the action type
	 */
	public String getActionType() {
		return this.actionType;
	}

	/**
	 * Instantiates a new action.
	 *
	 * @param actionType the action type
	 */
	private Action(String actionType) {
		this.actionType = actionType;
	}

	/**
	 * Gets the action.
	 *
	 * @param actionType the action type
	 * @return the action
	 * @throws InvalidActionException the invalid action exception
	 */
	public static Action getAction(String actionType) throws InvalidActionException {
		for (Action action : Action.values()) {
			if (action.getActionType().equalsIgnoreCase(StringUtils.trimWhitespace(actionType))) {
				return action;
			}
		}
		throw new InvalidActionException("Invalid action type " + actionType);
	}
}
