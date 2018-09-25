package com.jpmorgan.trader.dao;

import java.util.List;

import com.jpmorgan.trader.domain.OutgoingAmount;
import com.jpmorgan.trader.mockdata.MockData;

public class OutgoingAmountDaoImpl implements OutgoingAmountDao {
	@Override
	public List<OutgoingAmount> fetchAll() {
		return MockData.getOutgoingAmountEveryDay();
	}

	@Override
	public void saveAll(List<OutgoingAmount> outgoingAmountList) {
		MockData.saveOutgoingAmountEveryDay(outgoingAmountList);
	}
}
