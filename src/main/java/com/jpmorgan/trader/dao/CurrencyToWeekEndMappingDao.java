/*
 * 
 */
package com.jpmorgan.trader.dao;

import java.util.Map;

/**
 * The Interface CurrencyToWeekEndMappingDao.
 */
public interface CurrencyToWeekEndMappingDao {
	
	/**
	 * Gets the currency to week end map.
	 *
	 * @return the currency to week end map
	 */
	Map<String, String> getCurrencyToWeekEndMap();
}
