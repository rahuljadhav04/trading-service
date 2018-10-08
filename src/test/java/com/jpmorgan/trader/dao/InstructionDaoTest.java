/*
 * 
 */
package com.jpmorgan.trader.dao;

import org.junit.Test;
import org.springframework.util.Assert;

import com.jpmorgan.trader.domain.Instruction;

/**
 * The Class InstructionDaoTest.
 */
public class InstructionDaoTest {
	InstructionDao instructionDao = new InstructionDaoImpl();

	@Test
	public void testSaveInstruction() {
		Instruction instruction = new Instruction();
		instruction.setUnits(12);
		instruction = instructionDao.saveInstruction(instruction);
		Assert.isTrue(instruction.getInstructionId() != 0);// new id generated

	}
}
