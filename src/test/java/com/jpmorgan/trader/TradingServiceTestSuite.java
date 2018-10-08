/*
 * 
 */
package com.jpmorgan.trader;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.jpmorgan.trader.dao.CurrencyToWeekEndMappingDaoTest;
import com.jpmorgan.trader.dao.InstructionDaoTest;
import com.jpmorgan.trader.dao.OrderDaoTest;
import com.jpmorgan.trader.dao.TradeDaoTest;
import com.jpmorgan.trader.service.OrderServiceTest;
import com.jpmorgan.trader.service.TradeServiceTest;
import com.jpmorgan.trader.util.TradingCalendarTest;

/**
 * The test suite for trading service project.
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({ CurrencyToWeekEndMappingDaoTest.class, InstructionDaoTest.class, OrderDaoTest.class,
		TradeDaoTest.class, OrderServiceTest.class, TradeServiceTest.class, TradingCalendarTest.class })
public class TradingServiceTestSuite {

}
