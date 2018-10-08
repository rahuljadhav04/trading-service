/*
 * 
 */
package com.jpmorgan.trader.dao;

import org.junit.Test;
import org.springframework.util.Assert;

import com.jpmorgan.trader.domain.Trade;

/**
 * The Class TradeDaoTest.
 */
public class TradeDaoTest {
	TradeDao tradeDao = new TradeDaoImpl();

	@Test
	public void testSaveTrade() {
		Trade trade = new Trade();
		trade.setUnits(12);
		trade = tradeDao.saveTrade(trade);
		Assert.isTrue(trade.getTradeId() != 0);// new id generated

	}
}
