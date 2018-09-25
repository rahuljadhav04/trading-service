package com.jpmorgan.trader.dao;

import java.util.List;

import com.jpmorgan.trader.domain.OutgoingEntityRank;

public interface OutgoingEntityRankDao {
	List<OutgoingEntityRank> fetchAll();

	void saveAll(List<OutgoingEntityRank> outgoingEntityRankList);
}
