package com.jpmorgan.trader.service;

import com.jpmorgan.trader.dao.OrderDaoImpl;
import com.jpmorgan.trader.domain.Instruction;
import com.jpmorgan.trader.domain.Order;
import com.jpmorgan.trader.mockdata.MockDataBase;

public class OrderServiceImpl implements OrderService {

	OrderDaoImpl orderDao = new OrderDaoImpl();
	private static int count = 0;

	@Override
	// In real world, it can be some external service which will execute order
	public Order executeOrder(Instruction instruction) {
		Order order = new Order();
		order.setAction(instruction.getAction());
		order.setOrderDate(instruction.getInstructionDate());
		order.setPricePerUnit(instruction.getPricePerUnit());
		order.setOrderStatus(MockDataBase.getOrderStatus());
		order.setInstruction(instruction);
		return orderDao.saveOrder(order);
	}

}
