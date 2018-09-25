package com.jpmorgan.trader.dao;

import java.util.List;

import com.jpmorgan.trader.domain.IncomingAmount;
import com.jpmorgan.trader.domain.IncomingEntityRank;
import com.jpmorgan.trader.domain.OutgoingAmount;
import com.jpmorgan.trader.domain.OutgoingEntityRank;

public interface ReportDao {
	List<OutgoingAmount> retrieveOutgoingAmountEveryDay();

	List<IncomingAmount> retrieveIncomingAmountEveryDay();

	List<IncomingEntityRank> retrieveIncomingEntityRankEveryDay();

	List<OutgoingEntityRank> retrieveOutgoingEntityRankEveryDay();

}
