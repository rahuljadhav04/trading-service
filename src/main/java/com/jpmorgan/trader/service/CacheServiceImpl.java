/*
 * 
 */
package com.jpmorgan.trader.service;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpmorgan.trader.dao.CurrencyToWeekEndMappingDao;

/**
 * Some data like currency to weekend mapping can be cached and refreshed on
 * demand.
 * 
 * This would improve performance and avoid unnecessary DB calls
 * 
 * @author Administrative
 *
 */
@Service
public class CacheServiceImpl implements CacheService {

	/** The currency to week end map. */
	private static Map<String, String> currencyToWeekEndMap = new HashMap<String, String>();
	
	/** The currency to week end mapping dao. */
	@Autowired
	private CurrencyToWeekEndMappingDao currencyToWeekEndMappingDao;

	/* (non-Javadoc)
	 * @see com.jpmorgan.trader.service.CacheService#getCurrencyToWeekEndMap()
	 */
	@Override
	public Map<String, String> getCurrencyToWeekEndMap() {
		return currencyToWeekEndMap;
	}

	// Use spring @CacheBuilder, @EnableCache annotation here to run automatically
	/* (non-Javadoc)
	 * @see com.jpmorgan.trader.service.CacheService#initializeCache()
	 */
	// on spring boot start
	@Override
	@PostConstruct
	public void initializeCache() {
		// User Redis cache, Gemfire Or Oracle Coherance
		currencyToWeekEndMap = currencyToWeekEndMappingDao.getCurrencyToWeekEndMap();

	}

	/* (non-Javadoc)
	 * @see com.jpmorgan.trader.service.CacheService#refreshCache()
	 */
	@Override
	public void refreshCache() {
		// refresh as batch job daily or by admin page on request
		currencyToWeekEndMap = currencyToWeekEndMappingDao.getCurrencyToWeekEndMap();

	}
}
