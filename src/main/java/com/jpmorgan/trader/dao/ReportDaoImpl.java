package com.jpmorgan.trader.dao;

import java.util.List;

import com.jpmorgan.trader.domain.IncomingAmount;
import com.jpmorgan.trader.domain.IncomingEntityRank;
import com.jpmorgan.trader.domain.OutgoingAmount;
import com.jpmorgan.trader.domain.OutgoingEntityRank;
import com.jpmorgan.trader.mockdata.MockDataBase;

public class ReportDaoImpl implements ReportDao {

	@Override
	public List<OutgoingAmount> retrieveOutgoingAmountEveryDay() {
		// Run query to get total outgoing amount everyday SUM()
		// Group by BuyOrSellFlag, Actual Settlement Date
		// Having buyOrSell Flag is "B"
		return MockDataBase.retrieveOutgoingAmountEveryDay();
	}

	@Override
	public List<IncomingAmount> retrieveIncomingAmountEveryDay() {
		// Run query to get total outgoing amount everyday SUM()
		// Group by BuyOrSellFlag, Actual Settlement Date
		// Having buyOrSell Flag is "S"
		return MockDataBase.retrieveIncomingAmountEveryDay();
	}

	@Override
	public List<IncomingEntityRank> retrieveIncomingEntityRankEveryDay() {
		// Run query to get rank of entity everyday based upon amount in USD
		// Group by BuyOrSellFlag, Actual Settlement Date
		// Having buyOrSell Flag is "B"
		// rank over partition by total amount
		return MockDataBase.retrieveIncomingEntityRankEveryDay();
	}

	@Override
	public List<OutgoingEntityRank> retrieveOutgoingEntityRankEveryDay() {
		// Run query to get rank of entity everyday based upon amount in USD
		// Group by BuyOrSellFlag, Actual Settlement Date
		// Having buyOrSell Flag is "S"
		// rank over partition by total amount
		return MockDataBase.retrieveOutgoingEntityRankEveryDay();
	}

}