/*
 * 
 */
package com.jpmorgan.trader.service;

import com.jpmorgan.trader.domain.Order;
import com.jpmorgan.trader.domain.Trade;

/**
 * The Interface TradeService.
 */
public interface TradeService {
	
	/**
	 * Save trade.
	 *
	 * @param order the order
	 * @return the trade
	 */
	Trade saveTrade(Order order);

}
