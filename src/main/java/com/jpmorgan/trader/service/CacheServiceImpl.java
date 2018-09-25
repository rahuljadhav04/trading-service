package com.jpmorgan.trader.service;

import java.util.HashMap;
import java.util.Map;

import com.jpmorgan.trader.dao.CurrencyToWeekEndMappingDao;
import com.jpmorgan.trader.dao.CurrencyToWeekEndMappingDaoImpl;

public class CacheServiceImpl implements CacheService {

	private static Map<String, String> currencyToWeekEndMap = new HashMap<String, String>();
	private CurrencyToWeekEndMappingDao currencyToWeekEndMappingDao = new CurrencyToWeekEndMappingDaoImpl();

	@Override
	public Map<String, String> getCurrencyToWeekEndMap() {
		return currencyToWeekEndMap;
	}

	// Use spring @CacheBuilder, @EnableCache annotation here to run automatically
	// on spring boot start
	@Override
	public void initializeCache() {
		// User Redis cache, Gemfire Or Oracle Coherance
		currencyToWeekEndMap = currencyToWeekEndMappingDao.getCurrencyToWeekEndMap();

	}

	@Override
	public void refreshCache() {
		// refresh as batch job daily or by admin page on request
		currencyToWeekEndMap = currencyToWeekEndMappingDao.getCurrencyToWeekEndMap();

	}
}
