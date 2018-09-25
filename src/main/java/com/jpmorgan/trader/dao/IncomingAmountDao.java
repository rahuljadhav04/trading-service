package com.jpmorgan.trader.dao;

import java.util.List;

import com.jpmorgan.trader.domain.IncomingAmount;

public interface IncomingAmountDao {
	List<IncomingAmount> fetchAll();

	void saveAll(List<IncomingAmount> incomingAmountList);
}
