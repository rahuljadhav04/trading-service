package com.jpmorgan.trader.service;

import java.util.Date;

import com.jpmorgan.trader.domain.Instruction;

public interface InstructionService {
	void saveInstruction(Instruction instruction);

	Date getActualSettlementDate(Date settlementDate, String weekEnd);

}
