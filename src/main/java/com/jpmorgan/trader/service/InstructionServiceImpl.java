/*
 * 
 */
package com.jpmorgan.trader.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpmorgan.trader.dao.InstructionDao;
import com.jpmorgan.trader.domain.Instruction;

/**
 * This class would save the instruction into database. IF the trade is
 * successful it would save it with the settlement date and trade amount
 * 
 * @author Administrative
 *
 */
@Service
public class InstructionServiceImpl implements InstructionService {
	
	/** The instruction dao. */
	@Autowired
	private InstructionDao instructionDao;

	/* (non-Javadoc)
	 * @see com.jpmorgan.trader.service.InstructionService#saveInstruction(com.jpmorgan.trader.domain.Instruction)
	 */
	@Override
	public Instruction saveInstruction(Instruction instruction) {
		return instructionDao.saveInstruction(instruction);
	}

}
