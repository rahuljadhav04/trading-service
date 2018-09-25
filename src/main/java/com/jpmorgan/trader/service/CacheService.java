package com.jpmorgan.trader.service;

import java.util.Map;

public interface CacheService {

	Map<String, String> getCurrencyToWeekEndMap();

	void initializeCache();

	void refreshCache();

}
