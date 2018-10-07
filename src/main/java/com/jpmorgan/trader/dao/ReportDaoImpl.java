package com.jpmorgan.trader.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.jpmorgan.trader.domain.Trade;
import com.jpmorgan.trader.domain.TradeDetails;
import com.jpmorgan.trader.mockdata.MockDataBase;
import com.jpmorgan.trader.value.AmountReport;
import com.jpmorgan.trader.value.EntityRankReport;

@Repository
public class ReportDaoImpl implements ReportDao {

	@Override
	public List<AmountReport> retrieveOutgoingAmountEveryDay() {
		// Run query to get total outgoing amount everyday SUM()
		// Group by BuyOrSellFlag, Actual Settlement Date
		// Having buyOrSell Flag is "B"
		return MockDataBase.retrieveOutgoingAmountEveryDay();
	}

	@Override
	public List<AmountReport> retrieveIncomingAmountEveryDay() {
		// Run query to get total outgoing amount everyday SUM()
		// Group by BuyOrSellFlag, Actual Settlement Date
		// Having buyOrSell Flag is "S"
		return MockDataBase.retrieveIncomingAmountEveryDay();
	}

	@Override
	public List<EntityRankReport> retrieveIncomingEntityRankEveryDay() {
		// Run query to get rank of entity everyday based upon amount in USD
		// Group by BuyOrSellFlag, Actual Settlement Date
		// Having buyOrSell Flag is "B"
		// rank over partition by total amount
		return MockDataBase.retrieveIncomingEntityRankEveryDay();
	}

	@Override
	public List<EntityRankReport> retrieveOutgoingEntityRankEveryDay() {
		// Run query to get rank of entity everyday based upon amount in USD
		// Group by BuyOrSellFlag, Actual Settlement Date
		// Having buyOrSell Flag is "S"
		// rank over partition by total amount
		return MockDataBase.retrieveOutgoingEntityRankEveryDay();
	}

	@Override
	public List<Trade> retrieveTrades() {
		// Run query to get Report data by applying JOIN etc. query
		// Here it is just getting from MockDatabase
		return MockDataBase.getTradeList();
	}

	@Override
	public void saveTradeDetails(List<TradeDetails> tradeDetailsList) {
		MockDataBase.saveTradeDetails(tradeDetailsList);
	}

}