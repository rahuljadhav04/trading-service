package com.jpmorgan.trader.service;

import java.math.BigDecimal;

import com.jpmorgan.trader.dao.TradeDao;
import com.jpmorgan.trader.dao.TradeDaoImpl;
import com.jpmorgan.trader.domain.Order;
import com.jpmorgan.trader.domain.Trade;
import com.jpmorgan.trader.enums.TradeStatus;
import com.jpmorgan.trader.util.TradingCalendar;

public class TradeServiceImpl implements TradeService {
	private TradeDao tradeDao = new TradeDaoImpl();
	private CacheService cacheService = new CacheServiceImpl();

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

	private BigDecimal calculateAmountOfTradeInUSD(Order order) {
		return order.getInstruction().getAgreedFx().multiply(order.getPricePerUnit())
				.multiply(new BigDecimal(order.getUnits()));
	}
}
