/*
 * 
 */
package com.jpmorgan.trader.dao;

import com.jpmorgan.trader.domain.Trade;

/**
 * The Interface TradeDao.
 */
public interface TradeDao {
	
	/**
	 * Save trade.
	 *
	 * @param trade the trade
	 * @return the trade
	 */
	Trade saveTrade(Trade trade);

}
