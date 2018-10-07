/*
 * 
 */
package com.jpmorgan.trader.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.jpmorgan.trader.enums.Action;
import com.jpmorgan.trader.enums.TradeStatus;

/**
 * The Class Trade.
 */
public class Trade implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -8408591587721247725L;
	
	/** The trade id. */
	private long tradeId;
	
	/** The order id. */
	private long orderId;
	
	/** The units. */
	private long units;
	
	/** The price per unit. */
	private BigDecimal pricePerUnit;
	
	/** The trade status. */
	private TradeStatus tradeStatus;
	
	/** The settlement date. */
	private Date settlementDate;
	
	/** The settlement message. */
	private String settlementMessage;
	
	/** The action. */
	private Action action;
	
	/** The amount of trade in USD. */
	private BigDecimal amountOfTradeInUSD;

	/** The order. */
	// can be lazily loaded when required by hibernate
	private Order order;

	/**
	 * Gets the trade id.
	 *
	 * @return the trade id
	 */
	public long getTradeId() {
		return tradeId;
	}

	/**
	 * Sets the trade id.
	 *
	 * @param tradeId the new trade id
	 */
	public void setTradeId(long tradeId) {
		this.tradeId = tradeId;
	}

	/**
	 * Gets the order id.
	 *
	 * @return the order id
	 */
	public long getOrderId() {
		return orderId;
	}

	/**
	 * Gets the action.
	 *
	 * @return the action
	 */
	public Action getAction() {
		return action;
	}

	/**
	 * Sets the action.
	 *
	 * @param action the new action
	 */
	public void setAction(Action action) {
		this.action = action;
	}

	/**
	 * Sets the order id.
	 *
	 * @param orderId the new order id
	 */
	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	/**
	 * Gets the units.
	 *
	 * @return the units
	 */
	public long getUnits() {
		return units;
	}

	/**
	 * Sets the units.
	 *
	 * @param units the new units
	 */
	public void setUnits(long units) {
		this.units = units;
	}

	/**
	 * Gets the price per unit.
	 *
	 * @return the price per unit
	 */
	public BigDecimal getPricePerUnit() {
		return pricePerUnit;
	}

	/**
	 * Sets the price per unit.
	 *
	 * @param pricePerUnit the new price per unit
	 */
	public void setPricePerUnit(BigDecimal pricePerUnit) {
		this.pricePerUnit = pricePerUnit;
	}

	/**
	 * Gets the trade status.
	 *
	 * @return the trade status
	 */
	public TradeStatus getTradeStatus() {
		return tradeStatus;
	}

	/**
	 * Sets the trade status.
	 *
	 * @param tradeStatus the new trade status
	 */
	public void setTradeStatus(TradeStatus tradeStatus) {
		this.tradeStatus = tradeStatus;
	}

	/**
	 * Gets the settlement date.
	 *
	 * @return the settlement date
	 */
	public Date getSettlementDate() {
		return settlementDate;
	}

	/**
	 * Sets the settlement date.
	 *
	 * @param settlementDate the new settlement date
	 */
	public void setSettlementDate(Date settlementDate) {
		this.settlementDate = settlementDate;
	}

	/**
	 * Gets the settlement message.
	 *
	 * @return the settlement message
	 */
	public String getSettlementMessage() {
		return settlementMessage;
	}

	/**
	 * Sets the settlement message.
	 *
	 * @param settlementMessage the new settlement message
	 */
	public void setSettlementMessage(String settlementMessage) {
		this.settlementMessage = settlementMessage;
	}

	/**
	 * Gets the order.
	 *
	 * @return the order
	 */
	public Order getOrder() {
		return order;
	}

	/**
	 * Sets the order.
	 *
	 * @param order the new order
	 */
	public void setOrder(Order order) {
		this.order = order;
	}

	/**
	 * Gets the amount of trade in USD.
	 *
	 * @return the amount of trade in USD
	 */
	public BigDecimal getAmountOfTradeInUSD() {
		return amountOfTradeInUSD;
	}

	/**
	 * Sets the amount of trade in USD.
	 *
	 * @param amountOfTradeInUSD the new amount of trade in USD
	 */
	public void setAmountOfTradeInUSD(BigDecimal amountOfTradeInUSD) {
		this.amountOfTradeInUSD = amountOfTradeInUSD;
	}

}
