/*
 * 
 */
package com.jpmorgan.trader.dao;

import com.jpmorgan.trader.domain.Instruction;

/**
 * The Interface InstructionDao.
 */
public interface InstructionDao {
	
	/**
	 * Save instruction.
	 *
	 * @param instruction the instruction
	 * @return the instruction
	 */
	Instruction saveInstruction(Instruction instruction);
}
