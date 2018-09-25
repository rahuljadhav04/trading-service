package com.jpmorgan.trader.dao;

import java.util.List;

import com.jpmorgan.trader.domain.IncomingEntityRank;

public interface IncomingEntityRankDao {
	List<IncomingEntityRank> fetchAll();

	void saveAll(List<IncomingEntityRank> incomingEntityRankList);
}
