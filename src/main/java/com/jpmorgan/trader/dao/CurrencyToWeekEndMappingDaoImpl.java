/*
 * 
 */
package com.jpmorgan.trader.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.jpmorgan.trader.domain.CurrencyToWeekEndMapping;
import com.jpmorgan.trader.mockdata.MockDataBase;

//Separate DAO Interface is created. In real time it would be extending Spring JPA Repository interface.
//Separate DAO IMPL would not be required as we would be using Spring JPA Repository
//Spring JSP Repository add its own implementation runtime with methods like...save(),fetch(),getBy<PropertyName>() etc
//So this IMPL won't be required.
//Here it is added as we are not using spring jpa repository for now and we are getting the mock data
/**
 * The Class CurrencyToWeekEndMappingDaoImpl.
 */
/*
 * This will get Currency to weekend mapping from database.The rteuned map would in the format 
 * {"RUPEE", "SAT,SUN"},{"DOLLAR","SAT,SUN"}
 */
@Repository
public class CurrencyToWeekEndMappingDaoImpl implements CurrencyToWeekEndMappingDao {

	/* (non-Javadoc)
	 * @see com.jpmorgan.trader.dao.CurrencyToWeekEndMappingDao#getCurrencyToWeekEndMap()
	 */
	@Override
	public Map<String, String> getCurrencyToWeekEndMap() {
		Map<String, String> currencyToWeekEndMap = new HashMap<>();
		// Use spring jpa repository and its fetchAll() to get the master data from
		// table CurrencyToWeekEndMapping
		List<CurrencyToWeekEndMapping> currencyToWeekEndMappingList = MockDataBase.getCurrencyToWeekEndMap();
		currencyToWeekEndMap = currencyToWeekEndMappingList.stream().collect(
				Collectors.toMap(CurrencyToWeekEndMapping::getCurrenncy, CurrencyToWeekEndMapping::getWeekEnd));
		return currencyToWeekEndMap;
	}
}
