package com.jpmorgan.trader.dao;

import java.util.List;

import com.jpmorgan.trader.domain.OutgoingEntityRank;
import com.jpmorgan.trader.mockdata.MockData;

public class OutgoingEntityRankDaoImpl implements OutgoingEntityRankDao {
	@Override
	public List<OutgoingEntityRank> fetchAll() {
		return MockData.getOutcomingEntityRankEveryDay();
	}

	@Override
	public void saveAll(List<OutgoingEntityRank> outgoingEntityRankList) {
		MockData.saveOutgoingEntityRankEveryDay(outgoingEntityRankList);
	}
}
