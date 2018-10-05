package com.jpmorgan.trader.dao;

import com.jpmorgan.trader.domain.Instruction;

public interface InstructionDao {
	Instruction saveInstruction(Instruction instruction);
}
