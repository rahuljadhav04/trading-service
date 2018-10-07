/*
 * 
 */
package com.jpmorgan.trader.dao;

import org.springframework.stereotype.Repository;

import com.jpmorgan.trader.domain.Instruction;
import com.jpmorgan.trader.mockdata.MockDataBase;

/**
 * This will save the instruction into database with amount and settlement date
 * calculation.
 *
 * @author Administrative
 */
@Repository
public class InstructionDaoImpl implements InstructionDao {
	
	/* (non-Javadoc)
	 * @see com.jpmorgan.trader.dao.InstructionDao#saveInstruction(com.jpmorgan.trader.domain.Instruction)
	 */
	@Override
	public Instruction saveInstruction(Instruction instruction) {
		// Persist instruction in database
		return MockDataBase.addInstruction(instruction);
	}

}
