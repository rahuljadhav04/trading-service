/*
 * 
 */
package com.jpmorgan.trader.dao;

import org.springframework.stereotype.Repository;

import com.jpmorgan.trader.domain.Order;
import com.jpmorgan.trader.mockdata.MockDataBase;

/**
 * The Class OrderDaoImpl.
 */
@Repository
public class OrderDaoImpl implements OrderDao {
	
	/* (non-Javadoc)
	 * @see com.jpmorgan.trader.dao.OrderDao#saveOrder(com.jpmorgan.trader.domain.Order)
	 */
	@Override
	public Order saveOrder(Order order) {
		return MockDataBase.saveOrder(order);
	}
}
