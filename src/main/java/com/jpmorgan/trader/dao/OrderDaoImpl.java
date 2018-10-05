package com.jpmorgan.trader.dao;

import com.jpmorgan.trader.domain.Order;
import com.jpmorgan.trader.mockdata.MockDataBase;

public class OrderDaoImpl implements OrderDao {
	@Override
	public Order saveOrder(Order order) {
		return MockDataBase.saveOrder(order);
	}
}
