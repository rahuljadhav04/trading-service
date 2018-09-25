package com.jpmorgan.trader.dao;

import java.util.List;

import com.jpmorgan.trader.domain.IncomingEntityRank;
import com.jpmorgan.trader.mockdata.MockData;

public class IncomingEntityRankDaoImpl implements IncomingEntityRankDao {
	@Override
	public List<IncomingEntityRank> fetchAll() {
		return MockData.getIncomingEntityRankEveryDay();
	}

	@Override
	public void saveAll(List<IncomingEntityRank> incomingEntityRankList) {
		MockData.saveIncomingEntityRankEveryDay(incomingEntityRankList);
	}
}
