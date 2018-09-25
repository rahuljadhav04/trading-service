package com.jpmorgan.trader.dao;

import java.util.List;

import com.jpmorgan.trader.domain.OutgoingAmount;

public interface OutgoingAmountDao {
	List<OutgoingAmount> fetchAll();

	void saveAll(List<OutgoingAmount> outgoingAmountList);
}
