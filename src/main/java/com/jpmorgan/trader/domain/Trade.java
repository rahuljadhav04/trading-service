package com.jpmorgan.trader.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.jpmorgan.trader.enums.TradeStatus;

public class Trade implements Serializable {
	private static final long serialVersionUID = -8408591587721247725L;
	private long tradeId;
	private long orderId;
	private long units;
	private BigDecimal pricePerUnit;
	private TradeStatus tradeStatus;
	private Date settlementDate;
	private String settlementMessage;
	private String action;
	private BigDecimal amountOfTradeInUSD;

	// can be lazily loaded when required by hibernate
	private Order order;

	public long getTradeId() {
		return tradeId;
	}

	public void setTradeId(long tradeId) {
		this.tradeId = tradeId;
	}

	public long getOrderId() {
		return orderId;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public long getUnits() {
		return units;
	}

	public void setUnits(long units) {
		this.units = units;
	}

	public BigDecimal getPricePerUnit() {
		return pricePerUnit;
	}

	public void setPricePerUnit(BigDecimal pricePerUnit) {
		this.pricePerUnit = pricePerUnit;
	}

	public TradeStatus getTradeStatus() {
		return tradeStatus;
	}

	public void setTradeStatus(TradeStatus tradeStatus) {
		this.tradeStatus = tradeStatus;
	}

	public Date getSettlementDate() {
		return settlementDate;
	}

	public void setSettlementDate(Date settlementDate) {
		this.settlementDate = settlementDate;
	}

	public String getSettlementMessage() {
		return settlementMessage;
	}

	public void setSettlementMessage(String settlementMessage) {
		this.settlementMessage = settlementMessage;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public BigDecimal getAmountOfTradeInUSD() {
		return amountOfTradeInUSD;
	}

	public void setAmountOfTradeInUSD(BigDecimal amountOfTradeInUSD) {
		this.amountOfTradeInUSD = amountOfTradeInUSD;
	}

}
