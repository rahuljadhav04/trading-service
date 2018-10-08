/*
 * 
 */
package com.jpmorgan.trader.service;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.Date;

import org.junit.Test;
import org.springframework.util.Assert;
import org.springframework.util.ReflectionUtils;

import com.jpmorgan.trader.dao.CurrencyToWeekEndMappingDao;
import com.jpmorgan.trader.dao.CurrencyToWeekEndMappingDaoImpl;
import com.jpmorgan.trader.dao.TradeDaoImpl;
import com.jpmorgan.trader.domain.Instruction;
import com.jpmorgan.trader.domain.Order;
import com.jpmorgan.trader.domain.Trade;

/**
 * The Class TradeServiceTest.
 */
public class TradeServiceTest {
	TradeService tradeService = new TradeServiceImpl();

	@Test
	public void testExecuteTrade() {
		Field field = ReflectionUtils.findField(TradeServiceImpl.class, "tradeDao");
		ReflectionUtils.makeAccessible(field);
		ReflectionUtils.setField(field, tradeService, new TradeDaoImpl());

		CurrencyToWeekEndMappingDao currencyToWeekEndMappingDao = new CurrencyToWeekEndMappingDaoImpl();
		CacheService cacheService = new CacheServiceImpl();
		Field currencyToWeekEndMappingDaoField = ReflectionUtils.findField(CacheServiceImpl.class,
				"currencyToWeekEndMappingDao");
		ReflectionUtils.makeAccessible(currencyToWeekEndMappingDaoField);
		ReflectionUtils.setField(currencyToWeekEndMappingDaoField, cacheService, currencyToWeekEndMappingDao);

		Field cacheServiceField = ReflectionUtils.findField(TradeServiceImpl.class, "cacheService");
		ReflectionUtils.makeAccessible(cacheServiceField);
		ReflectionUtils.setField(cacheServiceField, tradeService, cacheService);

		cacheService.initializeCache();

		Order order = new Order();
		order.setUnits(12);
		order.setOrderDate(new Date());
		Instruction instruction = new Instruction();
		instruction.setCurrency("AED");
		instruction.setAgreedFx(new BigDecimal("0.5"));
		order.setPricePerUnit(new BigDecimal("0.5"));
		order.setInstruction(instruction);
		Trade trade = tradeService.saveTrade(order);
		Assert.isTrue(trade.getUnits() == order.getUnits());

	}
}
