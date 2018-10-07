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
 * The Class TradeDetails.
 */
public class TradeDetails implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -6255500078578746987L;
	
	/** The trade id. */
	private long tradeId;
	
	/** The order id. */
	private long orderId;
	
	/** The instruction id. */
	private long instructionId;
	
	/** The entity name. */
	private String entityName;
	
	/** The action. */
	private Action action;
	
	/** The agreed fx. */
	private BigDecimal agreedFx;
	
	/** The currency. */
	private String currency;
	
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
	
	/** The instruction date. */
	private Date instructionDate;
	
	/** The amount of trade in USD. */
	private BigDecimal amountOfTradeInUSD;

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
	 * Gets the instruction id.
	 *
	 * @return the instruction id
	 */
	public long getInstructionId() {
		return instructionId;
	}

	/**
	 * Sets the instruction id.
	 *
	 * @param instructionId the new instruction id
	 */
	public void setInstructionId(long instructionId) {
		this.instructionId = instructionId;
	}

	/**
	 * Gets the entity name.
	 *
	 * @return the entity name
	 */
	public String getEntityName() {
		return entityName;
	}

	/**
	 * Sets the entity name.
	 *
	 * @param entityName the new entity name
	 */
	public void setEntityName(String entityName) {
		this.entityName = entityName;
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
	 * Gets the agreed fx.
	 *
	 * @return the agreed fx
	 */
	public BigDecimal getAgreedFx() {
		return agreedFx;
	}

	/**
	 * Sets the agreed fx.
	 *
	 * @param agreedFx the new agreed fx
	 */
	public void setAgreedFx(BigDecimal agreedFx) {
		this.agreedFx = agreedFx;
	}

	/**
	 * Gets the currency.
	 *
	 * @return the currency
	 */
	public String getCurrency() {
		return currency;
	}

	/**
	 * Sets the currency.
	 *
	 * @param currency the new currency
	 */
	public void setCurrency(String currency) {
		this.currency = currency;
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
	 * Gets the instruction date.
	 *
	 * @return the instruction date
	 */
	public Date getInstructionDate() {
		return instructionDate;
	}

	/**
	 * Sets the instruction date.
	 *
	 * @param instructionDate the new instruction date
	 */
	public void setInstructionDate(Date instructionDate) {
		this.instructionDate = instructionDate;
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
