package com.jpmorgan.trader.service;

import com.jpmorgan.trader.dao.InstructionDao;
import com.jpmorgan.trader.dao.InstructionDaoImpl;
import com.jpmorgan.trader.domain.Instruction;

/**
 * This class would save the instruction into database. IF the trade is
 * successful it would save it with the settlement date and trade amount
 * 
 * @author Administrative
 *
 */
public class InstructionServiceImpl implements InstructionService {
	private InstructionDao instructionDao = new InstructionDaoImpl();

	@Override
	public Instruction saveInstruction(Instruction instruction) {
		return instructionDao.saveInstruction(instruction);
	}

}
