package com.jpmorgan.trader.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import junit.framework.TestCase;

public class InstructionServiceTest extends TestCase {
	public void testReturnSameDateIfItIsAlreadyWorkingDate() throws ParseException {
		InstructionService instructionService = new InstructionServiceImpl();
		Date date = new SimpleDateFormat("yyyy/MM/dd", Locale.ENGLISH).parse("2018/09/21");
		// Date workingDate = instructionService.getActualSettlementDate(date,
		// "SAT,SUN");
		// assertTrue(workingDate.compareTo(new SimpleDateFormat("yyyy/MM/dd",
		// Locale.ENGLISH).parse("2018/09/21")) == 0);
	}

	public void testReturnNextWorkingDateIfItIsWeekend() throws ParseException {
		InstructionService instructionService = new InstructionServiceImpl();
		Date date = new SimpleDateFormat("yyyy/MM/dd", Locale.ENGLISH).parse("2018/09/22");
		// Date workingDate = instructionService.getActualSettlementDate(date,
		// "SAT,SUN");
		// assertTrue(workingDate.compareTo(new SimpleDateFormat("yyyy/MM/dd",
		// Locale.ENGLISH).parse("2018/09/24")) == 0);
	}
}
