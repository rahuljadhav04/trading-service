package com.jpmorgan.trader.dao;

import com.jpmorgan.trader.domain.Instruction;

public interface InstructionDao {
	void saveInstruction(Instruction instruction);
}
