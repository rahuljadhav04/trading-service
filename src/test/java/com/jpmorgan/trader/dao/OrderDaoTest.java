/*
 * 
 */
package com.jpmorgan.trader.dao;

import org.junit.Test;
import org.springframework.util.Assert;

import com.jpmorgan.trader.domain.Order;

/**
 * The Class OrderDaoTest.
 */
public class OrderDaoTest {
	OrderDao orderDao = new OrderDaoImpl();

	@Test
	public void testSaveInstruction() {
		Order order = new Order();
		order.setUnits(12);
		order = orderDao.saveOrder(order);
		Assert.isTrue(order.getOrderId() != 0);// new id generated

	}
}
