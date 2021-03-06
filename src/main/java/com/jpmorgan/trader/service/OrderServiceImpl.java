/*
 * 
 */
package com.jpmorgan.trader.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpmorgan.trader.dao.OrderDao;
import com.jpmorgan.trader.domain.Instruction;
import com.jpmorgan.trader.domain.Order;
import com.jpmorgan.trader.mockdata.MockDataBase;

/**
 * The Class OrderServiceImpl.
 */
@Service
public class OrderServiceImpl implements OrderService {

	/** The order dao. */
	@Autowired
	private OrderDao orderDao;

	/** The count. */
	private static int count = 0;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jpmorgan.trader.service.OrderService#executeOrder(com.jpmorgan.trader.
	 * domain.Instruction)
	 */
	@Override
	// In real world, it can be some external service which will execute order
	public Order executeOrder(Instruction instruction) {
		Order order = new Order();
		order.setAction(instruction.getAction());
		order.setOrderDate(instruction.getInstructionDate());
		order.setPricePerUnit(instruction.getPricePerUnit());
		order.setOrderStatus(MockDataBase.getOrderStatus());
		order.setUnits(instruction.getUnits());
		order.setInstruction(instruction);

		return orderDao.saveOrder(order);
	}

}
