/*
 * 
 */
package com.jpmorgan.trader.dao;

import java.util.List;

import com.jpmorgan.trader.domain.Trade;
import com.jpmorgan.trader.domain.TradeDetails;
import com.jpmorgan.trader.value.AmountReport;
import com.jpmorgan.trader.value.EntityRankReport;

/**
 * The Interface ReportDao.
 */
public interface ReportDao {
	
	/**
	 * Retrieve outgoing amount every day.
	 *
	 * @return the list
	 */
	List<AmountReport> retrieveOutgoingAmountEveryDay();

	/**
	 * Retrieve incoming amount every day.
	 *
	 * @return the list
	 */
	List<AmountReport> retrieveIncomingAmountEveryDay();

	/**
	 * Retrieve incoming entity rank every day.
	 *
	 * @return the list
	 */
	List<EntityRankReport> retrieveIncomingEntityRankEveryDay();

	/**
	 * Retrieve outgoing entity rank every day.
	 *
	 * @return the list
	 */
	List<EntityRankReport> retrieveOutgoingEntityRankEveryDay();

	/**
	 * Retrieve trades.
	 *
	 * @return the list
	 */
	List<Trade> retrieveTrades();

	/**
	 * Save trade details.
	 *
	 * @param tradeDetailsList the trade details list
	 */
	void saveTradeDetails(List<TradeDetails> tradeDetailsList);

}
