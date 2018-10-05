package com.jpmorgan.trader.dao;

import com.jpmorgan.trader.domain.Order;

public interface OrderDao {
	Order saveOrder(Order order);
}
