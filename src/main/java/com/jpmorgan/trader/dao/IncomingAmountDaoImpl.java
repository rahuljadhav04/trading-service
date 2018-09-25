package com.jpmorgan.trader.dao;

import java.util.List;

import com.jpmorgan.trader.domain.IncomingAmount;
import com.jpmorgan.trader.mockdata.MockData;

public class IncomingAmountDaoImpl implements IncomingAmountDao {
	@Override
	public List<IncomingAmount> fetchAll() {
		return MockData.getIncomingAmountEveryDay();
	}

	@Override
	public void saveAll(List<IncomingAmount> incomingAmountList) {
		MockData.saveIncomingAmountEveryDay(incomingAmountList);
	}
}
