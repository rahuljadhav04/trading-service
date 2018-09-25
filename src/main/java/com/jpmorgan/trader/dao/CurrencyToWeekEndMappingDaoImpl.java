package com.jpmorgan.trader.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.jpmorgan.trader.domain.CurrencyToWeekEndMapping;
import com.jpmorgan.trader.mockdata.MockData;

public class CurrencyToWeekEndMappingDaoImpl implements CurrencyToWeekEndMappingDao {

	@Override
	public Map<String, String> getCurrencyToWeekEndMap() {
		Map<String, String> currencyToWeekEndMap = new HashMap<>();
		// Use spring jpa repository and its fetchAll() to get the master data from
		// table CurrencyToWeekEndMapping
		List<CurrencyToWeekEndMapping> currencyToWeekEndMappingList = MockData.getCurrencyToWeekEndMap();
		currencyToWeekEndMap = currencyToWeekEndMappingList.stream().collect(
				Collectors.toMap(CurrencyToWeekEndMapping::getCurrenncy, CurrencyToWeekEndMapping::getWeekEnd));
		return currencyToWeekEndMap;
	}
}
