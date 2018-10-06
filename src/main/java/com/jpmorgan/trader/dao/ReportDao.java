package com.jpmorgan.trader.dao;

import java.util.List;

import com.jpmorgan.trader.domain.AmountReport;
import com.jpmorgan.trader.domain.EntityRankReport;
import com.jpmorgan.trader.domain.Trade;
import com.jpmorgan.trader.domain.TradeDetails;

public interface ReportDao {
	List<AmountReport> retrieveOutgoingAmountEveryDay();

	List<AmountReport> retrieveIncomingAmountEveryDay();

	List<EntityRankReport> retrieveIncomingEntityRankEveryDay();

	List<EntityRankReport> retrieveOutgoingEntityRankEveryDay();

	List<Trade> retrieveTrades();

	void saveTradeDetails(List<TradeDetails> tradeDetailsList);

}
