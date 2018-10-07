/*
 * 
 */
package com.jpmorgan.trader.dao;

import com.jpmorgan.trader.domain.Order;

/**
 * The Interface OrderDao.
 */
public interface OrderDao {
	
	/**
	 * Save order.
	 *
	 * @param order the order
	 * @return the order
	 */
	Order saveOrder(Order order);
}
