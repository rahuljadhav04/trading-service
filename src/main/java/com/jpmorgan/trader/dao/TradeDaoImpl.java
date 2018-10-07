/*
 * 
 */
package com.jpmorgan.trader.dao;

import org.springframework.stereotype.Repository;

import com.jpmorgan.trader.domain.Trade;
import com.jpmorgan.trader.mockdata.MockDataBase;

/**
 * The Class TradeDaoImpl.
 */
@Repository
public class TradeDaoImpl implements TradeDao {
	
	/* (non-Javadoc)
	 * @see com.jpmorgan.trader.dao.TradeDao#saveTrade(com.jpmorgan.trader.domain.Trade)
	 */
	@Override
	public Trade saveTrade(Trade trade) {
		return MockDataBase.saveTrade(trade);
	}

}
