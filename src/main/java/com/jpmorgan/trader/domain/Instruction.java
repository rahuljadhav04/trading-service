package com.jpmorgan.trader.domain;

import java.math.BigDecimal;
import java.util.Date;

//Use @Table, @Column annotations to define mapping to database tables using JPA/Hibernate
public class Instruction {

	private String entityName;
	private String action;
	private BigDecimal agreedFx;
	private String currency;
	private Date instructionDate;
	private Date settlementDate;
	private long units;
	private BigDecimal pricePerUnit;

	// added two properties here..so while saving these can be added..so that
	// performance cost is reduced to calculate later in loop
	private Date actualSettlementDate;
	private BigDecimal amountOfTradeInUSD;

	public String getEntityName() {
		return entityName;
	}

	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public BigDecimal getAgreedFx() {
		return agreedFx;
	}

	public void setAgreedFx(BigDecimal agreedFx) {
		this.agreedFx = agreedFx;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public Date getInstructionDate() {
		return instructionDate;
	}

	public void setInstructionDate(Date instructionDate) {
		this.instructionDate = instructionDate;
	}

	public Date getSettlementDate() {
		return settlementDate;
	}

	public void setSettlementDate(Date settlementDate) {
		this.settlementDate = settlementDate;
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

	public Date getActualSettlementDate() {
		return actualSettlementDate;
	}

	public void setActualSettlementDate(Date actualSettlementDate) {
		this.actualSettlementDate = actualSettlementDate;
	}

	public BigDecimal getAmountOfTradeInUSD() {
		return amountOfTradeInUSD;
	}

	public void setAmountOfTradeInUSD(BigDecimal amountOfTradeInUSD) {
		this.amountOfTradeInUSD = amountOfTradeInUSD;
	}

}
