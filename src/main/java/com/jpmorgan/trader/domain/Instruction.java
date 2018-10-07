/*
 * 
 */
package com.jpmorgan.trader.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.jpmorgan.trader.enums.Action;

/**
 * The Class Instruction.
 */
//Use @Table, @Column annotations to define mapping to database tables using JPA/Hibernate
public class Instruction implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -2795125739069473256L;
	
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
	
	/** The instruction date. */
	private Date instructionDate;
	
	/** The settlement date. */
	private Date settlementDate;
	
	/** The units. */
	private long units;
	
	/** The price per unit. */
	private BigDecimal pricePerUnit;

	// added two properties here..so while saving these can be added..so that
	/** The actual settlement date. */
	// performance cost is reduced to calculate later in loop
	private Date actualSettlementDate;
	
	/** The amount of trade in USD. */
	private BigDecimal amountOfTradeInUSD;

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
	 * Gets the actual settlement date.
	 *
	 * @return the actual settlement date
	 */
	public Date getActualSettlementDate() {
		return actualSettlementDate;
	}

	/**
	 * Sets the actual settlement date.
	 *
	 * @param actualSettlementDate the new actual settlement date
	 */
	public void setActualSettlementDate(Date actualSettlementDate) {
		this.actualSettlementDate = actualSettlementDate;
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
