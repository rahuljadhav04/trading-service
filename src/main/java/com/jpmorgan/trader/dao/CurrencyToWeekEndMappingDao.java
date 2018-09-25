package com.jpmorgan.trader.dao;

import java.util.Map;

public interface CurrencyToWeekEndMappingDao{
	Map<String, String> getCurrencyToWeekEndMap();
}
