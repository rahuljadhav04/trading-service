/*
 * 
 */
package com.jpmorgan.trader.service;

import java.util.Map;

/**
 * The Interface CacheService.
 */
public interface CacheService {

	/**
	 * Gets the currency to week end map.
	 *
	 * @return the currency to week end map
	 */
	Map<String, String> getCurrencyToWeekEndMap();

	/**
	 * Initialize cache.
	 */
	void initializeCache();

	/**
	 * Refresh cache.
	 */
	void refreshCache();

}
