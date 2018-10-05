package com.jpmorgan.trader.dao;

import com.jpmorgan.trader.domain.Trade;
import com.jpmorgan.trader.mockdata.MockDataBase;

public class TradeDaoImpl implements TradeDao {
	@Override
	public Trade saveTrade(Trade trade) {
		return MockDataBase.saveTrade(trade);
	}

}
