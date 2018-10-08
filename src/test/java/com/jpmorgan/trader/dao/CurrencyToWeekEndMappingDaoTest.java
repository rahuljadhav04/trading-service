/*
 * 
 */
package com.jpmorgan.trader.dao;

import java.util.Map;

import org.junit.Test;
import org.springframework.util.Assert;

/**
 * The Class InstructionDaoTest.
 */
public class CurrencyToWeekEndMappingDaoTest {
	CurrencyToWeekEndMappingDao currencyToWeekEndMappingDao = new CurrencyToWeekEndMappingDaoImpl();

	@Test
	public void testGetCurrencyToWeekEndMap() {
		Map<String, String> currencyToWeekEndMap = currencyToWeekEndMappingDao.getCurrencyToWeekEndMap();
		Assert.isTrue(currencyToWeekEndMap.containsKey("AED"));// just test if one currency present as key

	}
}
