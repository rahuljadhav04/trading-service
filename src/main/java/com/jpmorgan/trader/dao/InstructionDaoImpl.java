package com.jpmorgan.trader.dao;

import com.jpmorgan.trader.domain.Instruction;
import com.jpmorgan.trader.mockdata.MockData;
/**
 * This will save the instruction into database with amount and settlement date calculation
 * @author Administrative
 *
 */
public class InstructionDaoImpl implements InstructionDao {
	@Override
	public void saveInstruction(Instruction instruction) {
		// Persist instruction in database
		MockData.addInstruction(instruction);
	}

}
