package com.jpmorgan.trader.dao;

import org.springframework.stereotype.Repository;

import com.jpmorgan.trader.domain.Trade;
import com.jpmorgan.trader.mockdata.MockDataBase;

@Repository
public class TradeDaoImpl implements TradeDao {
	@Override
	public Trade saveTrade(Trade trade) {
		return MockDataBase.saveTrade(trade);
	}

}
