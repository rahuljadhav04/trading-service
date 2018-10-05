package com.jpmorgan.trader.dao;

import com.jpmorgan.trader.domain.Trade;

public interface TradeDao {
	Trade saveTrade(Trade trade);

}
