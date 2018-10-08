/*
 * 
 */
package com.jpmorgan.trader.service;

import java.lang.reflect.Field;

import org.junit.Test;
import org.springframework.util.Assert;
import org.springframework.util.ReflectionUtils;

import com.jpmorgan.trader.dao.OrderDaoImpl;
import com.jpmorgan.trader.domain.Instruction;
import com.jpmorgan.trader.domain.Order;

/**
 * The Class OrderServiceTest.
 */
public class OrderServiceTest {
	OrderService orderService = new OrderServiceImpl();

	@Test
	public void testExecuteOrder() {
		Field field = ReflectionUtils.findField(OrderServiceImpl.class, "orderDao");
		ReflectionUtils.makeAccessible(field);
		ReflectionUtils.setField(field, orderService, new OrderDaoImpl());
		Instruction instruction = new Instruction();
		instruction.setUnits(12);
		Order order = orderService.executeOrder(instruction);
		Assert.isTrue(order.getUnits() == instruction.getUnits());

	}
}
