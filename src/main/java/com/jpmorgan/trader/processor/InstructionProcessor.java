/*
 * 
 */
package com.jpmorgan.trader.processor;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.jpmorgan.trader.domain.Instruction;
import com.jpmorgan.trader.enums.Action;
import com.jpmorgan.trader.exception.InvalidActionException;
import com.jpmorgan.trader.listener.InstructionListner;
import com.jpmorgan.trader.util.InstructionValidator;
import com.jpmorgan.trader.util.TradingCalendar;

/**
 * The Class InstructionProcessor.
 */
@Component
public class InstructionProcessor {
	
	/** The instruction validator. */
	@Autowired
	InstructionValidator instructionValidator;
	
	/** The instruction listner. */
	@Autowired
	private InstructionListner instructionListner;

	/**
	 * Process instructions.
	 *
	 * @param instructionMessageList the instruction message list
	 * @param proccesedInstructions the proccesed instructions
	 * @param erroroneousInstructions the erroroneous instructions
	 */
	public void processInstructions(List<String> instructionMessageList, List<String> proccesedInstructions,
			List<String> erroroneousInstructions) {
		// The instructions can be processed in parallel as they are not dependent upon
		// each other.
		// this will improve performance
		System.out.println("Before parallel processing");
		instructionMessageList.parallelStream()
				.forEach(instructionMessage -> procesInstructionMessageInParallel(instructionMessage,
						proccesedInstructions, erroroneousInstructions));
		System.out.println("parallel processing done");
	}

	/**
	 * Proces instruction message in parallel.
	 *
	 * @param instructionMessage the instruction message
	 * @param proccesedInstructions the proccesed instructions
	 * @param erroroneousInstructions the erroroneous instructions
	 */
	private void procesInstructionMessageInParallel(String instructionMessage, List<String> proccesedInstructions,
			List<String> erroroneousInstructions) {
		try {
			instructionValidator.validateInstruction(instructionMessage);
			Instruction instruction = getInstruction(instructionMessage);
			instructionListner.onMessage(instruction);
			proccesedInstructions.add(instructionMessage);
		} catch (Exception e) {
			System.out.println("ERROR:" + e.getMessage());
			erroroneousInstructions.add(instructionMessage + ", " + e.getMessage());
		}
	}

	/**
	 * Gets the instruction.
	 *
	 * @param instructionMessage the instruction message
	 * @return the instruction
	 * @throws ParseException the parse exception
	 * @throws InvalidActionException the invalid action exception
	 */
	private Instruction getInstruction(String instructionMessage) throws ParseException, InvalidActionException {
		String[] instructionMessageArray = StringUtils.tokenizeToStringArray(instructionMessage, ",", true, false);
		Instruction instruction = new Instruction();
		instruction.setEntityName(instructionMessageArray[0]);
		instruction.setAction(Action.getAction(instructionMessageArray[1]));
		instruction.setAgreedFx(new BigDecimal(instructionMessageArray[2]));
		instruction.setCurrency(instructionMessageArray[3]);
		instruction.setInstructionDate(TradingCalendar.getDateYYYYMMDD(instructionMessageArray[4]));
		instruction.setSettlementDate(TradingCalendar.getDateYYYYMMDD(instructionMessageArray[5]));
		instruction.setUnits(new Long(instructionMessageArray[6]));
		instruction.setPricePerUnit(new BigDecimal(instructionMessageArray[7]));
		return instruction;
	}

}
