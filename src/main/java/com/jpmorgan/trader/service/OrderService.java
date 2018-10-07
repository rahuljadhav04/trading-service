/*
 * 
 */
package com.jpmorgan.trader.service;

import com.jpmorgan.trader.domain.Instruction;
import com.jpmorgan.trader.domain.Order;

/**
 * The Interface OrderService.
 */
public interface OrderService {
	
	/**
	 * Execute order.
	 *
	 * @param instruction the instruction
	 * @return the order
	 */
	Order executeOrder(Instruction instruction);

}
