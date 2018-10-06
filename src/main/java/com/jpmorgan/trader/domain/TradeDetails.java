package com.jpmorgan.trader.domain;

import java.math.BigDecimal;
import java.util.Date;

import com.jpmorgan.trader.enums.TradeStatus;

public class TradeDetails {

	private long tradeId;
	private long orderId;
	private long instructionId;
	private String entityName;
	private String action;
	private BigDecimal agreedFx;
	private String currency;
	private long units;
	private BigDecimal pricePerUnit;
	private TradeStatus tradeStatus;
	private Date settlementDate;
	private String settlementMessage;
	private Date instructionDate;
	private BigDecimal amountOfTradeInUSD;

	public long getTradeId() {
		return tradeId;
	}

	public void setTradeId(long tradeId) {
		this.tradeId = tradeId;
	}

	public long getInstructionId() {
		return instructionId;
	}

	public void setInstructionId(long instructionId) {
		this.instructionId = instructionId;
	}

	public String getEntityName() {
		return entityName;
	}

	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}

	public TradeStatus getTradeStatus() {
		return tradeStatus;
	}

	public void setTradeStatus(TradeStatus tradeStatus) {
		this.tradeStatus = tradeStatus;
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

	public long getOrderId() {
		return orderId;
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

	public Date getInstructionDate() {
		return instructionDate;
	}

	public void setInstructionDate(Date instructionDate) {
		this.instructionDate = instructionDate;
	}

	public BigDecimal getAmountOfTradeInUSD() {
		return amountOfTradeInUSD;
	}

	public void setAmountOfTradeInUSD(BigDecimal amountOfTradeInUSD) {
		this.amountOfTradeInUSD = amountOfTradeInUSD;
	}

}
