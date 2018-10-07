package com.jpmorgan.trader.dao;

import org.springframework.stereotype.Repository;

import com.jpmorgan.trader.domain.Order;
import com.jpmorgan.trader.mockdata.MockDataBase;

@Repository
public class OrderDaoImpl implements OrderDao {
	@Override
	public Order saveOrder(Order order) {
		return MockDataBase.saveOrder(order);
	}
}
