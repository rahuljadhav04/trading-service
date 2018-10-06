package com.jpmorgan.trader.dao;

import java.util.List;

import com.jpmorgan.trader.domain.Trade;
import com.jpmorgan.trader.domain.TradeDetails;
import com.jpmorgan.trader.value.AmountReport;
import com.jpmorgan.trader.value.EntityRankReport;

public interface ReportDao {
	List<AmountReport> retrieveOutgoingAmountEveryDay();

	List<AmountReport> retrieveIncomingAmountEveryDay();

	List<EntityRankReport> retrieveIncomingEntityRankEveryDay();

	List<EntityRankReport> retrieveOutgoingEntityRankEveryDay();

	List<Trade> retrieveTrades();

	void saveTradeDetails(List<TradeDetails> tradeDetailsList);

}
