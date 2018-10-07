/*
 * 
 */
package com.jpmorgan.trader.service;

import com.jpmorgan.trader.domain.Instruction;

/**
 * The Interface InstructionService.
 */
public interface InstructionService {
	
	/**
	 * Save instruction.
	 *
	 * @param instruction the instruction
	 * @return the instruction
	 */
	Instruction saveInstruction(Instruction instruction);

}
