package com.jpmorgan.trader.service;

import com.jpmorgan.trader.domain.Order;
import com.jpmorgan.trader.domain.Trade;

public interface TradeService {
	Trade saveTrade(Order order);

}
