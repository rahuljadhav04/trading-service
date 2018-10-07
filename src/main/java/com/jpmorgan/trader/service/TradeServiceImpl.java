/*
 * 
 */
package com.jpmorgan.trader.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpmorgan.trader.dao.TradeDao;
import com.jpmorgan.trader.domain.Order;
import com.jpmorgan.trader.domain.Trade;
import com.jpmorgan.trader.enums.TradeStatus;
import com.jpmorgan.trader.util.TradingCalendar;

/**
 * The Class TradeServiceImpl.
 */
@Service
public class TradeServiceImpl implements TradeService {
	
	/** The trade dao. */
	@Autowired
	private TradeDao tradeDao;
	
	/** The cache service. */
	@Autowired
	private CacheService cacheService;

	/* (non-Javadoc)
	 * @see com.jpmorgan.trader.service.TradeService#saveTrade(com.jpmorgan.trader.domain.Order)
	 */
	@Override
	public Trade saveTrade(Order order) {
		Trade trade = new Trade();
		trade.setAction(order.getAction());
		trade.setOrderId(order.getOrderId());
		trade.setPricePerUnit(order.getPricePerUnit());
		String weekEndForThisTrade = cacheService.getCurrencyToWeekEndMap().get(order.getInstruction().getCurrency());
		trade.setSettlementDate(TradingCalendar.getSettlementDate(order.getOrderDate(), weekEndForThisTrade));
		trade.setUnits(order.getUnits());
		trade.setTradeStatus(TradeStatus.SETTLEMENT_DONE);
		trade.setAmountOfTradeInUSD(calculateAmountOfTradeInUSD(order));
		trade.setOrder(order);
		return tradeDao.saveTrade(trade);
	}

	/**
	 * Calculate amount of trade in USD.
	 *
	 * @param order the order
	 * @return the big decimal
	 */
	private BigDecimal calculateAmountOfTradeInUSD(Order order) {
		return order.getInstruction().getAgreedFx().multiply(order.getPricePerUnit())
				.multiply(new BigDecimal(order.getUnits()));
	}
}
