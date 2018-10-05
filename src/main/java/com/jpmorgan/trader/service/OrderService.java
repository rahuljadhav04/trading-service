package com.jpmorgan.trader.service;

import com.jpmorgan.trader.domain.Instruction;
import com.jpmorgan.trader.domain.Order;

public interface OrderService {
	Order executeOrder(Instruction instruction);

}
