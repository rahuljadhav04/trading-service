/*
 * 
 */
package com.jpmorgan.trader.util;

import java.math.BigDecimal;
import java.text.ParseException;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.jpmorgan.trader.enums.Action;
import com.jpmorgan.trader.exception.InvalidActionException;
import com.jpmorgan.trader.exception.InvalidInstructionException;

/**
 * The Class InstructionValidator.
 */
@Component
public class InstructionValidator {

	/**
	 * Validate instruction.
	 *
	 * @param instructionMessage the instruction message
	 * @throws InvalidInstructionException the invalid instruction exception
	 */
	public void validateInstruction(String instructionMessage) throws InvalidInstructionException {
		String[] instructionMessageArray = StringUtils.tokenizeToStringArray(instructionMessage, ",", true, false);
		StringBuilder exceptionMessage = new StringBuilder();
		if (instructionMessageArray.length != 8) {
			exceptionMessage.append("The number of values in a row must be 8. " + instructionMessage);
		}
		try {
			Action.getAction(instructionMessageArray[1]);
		} catch (InvalidActionException e) {
			exceptionMessage.append("Action " + instructionMessageArray[1] + " is invalid.");
		}
		try {
			new BigDecimal(instructionMessageArray[2]);
		} catch (Exception e1) {
			exceptionMessage.append("AgreedFx " + instructionMessageArray[2] + " is invalid.");
		}
		try {
			TradingCalendar.getDateYYYYMMDD(instructionMessageArray[4]);
		} catch (ParseException e) {
			exceptionMessage.append("InstructionDate " + instructionMessageArray[4] + " is invalid. Correct format is "
					+ TradingCalendar.INSTRUCTION_INPUT_DATE_FORMAT);
		}
		try {
			TradingCalendar.getDateYYYYMMDD(instructionMessageArray[5]);
		} catch (ParseException e) {
			exceptionMessage.append("SettlementDate " + instructionMessageArray[5] + " is invalid. Correct format is "
					+ TradingCalendar.INSTRUCTION_INPUT_DATE_FORMAT);
		}
		try {
			new Long(instructionMessageArray[6]);
		} catch (NumberFormatException e2) {
			exceptionMessage.append("Units " + instructionMessageArray[6] + " is invalid.");
		}
		try {
			new BigDecimal(instructionMessageArray[7]);
		} catch (Exception e1) {
			exceptionMessage.append("PricePerUnit " + instructionMessageArray[7] + " is invalid.");
		}
		if (StringUtils.hasText(exceptionMessage.toString())) {
			throw new InvalidInstructionException(exceptionMessage.toString());
		}

	}

}
