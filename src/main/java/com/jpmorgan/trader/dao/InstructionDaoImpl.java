package com.jpmorgan.trader.dao;

import com.jpmorgan.trader.domain.Instruction;
import com.jpmorgan.trader.mockdata.MockData;

public class InstructionDaoImpl implements InstructionDao {
	@Override
	public void saveInstruction(Instruction instruction) {
		// Persist instruction in database
		MockData.addInstruction(instruction);
	}

}
