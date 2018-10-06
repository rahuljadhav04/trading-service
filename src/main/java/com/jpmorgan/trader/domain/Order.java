package com.jpmorgan.trader.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.jpmorgan.trader.enums.OrderStatus;

public class Order implements Serializable {
	private static final long serialVersionUID = -3642588185817786396L;
	private long orderId;
	private long instructionId;
	private long units;
	private BigDecimal pricePerUnit;
	private Date orderDate;
	private OrderStatus orderStatus;
	private String rejectionReason;
	private String action;
	// it can be lazily loaded by hibernate as and when accessed
	private Instruction instruction;

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
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

	public long getInstructionId() {
		return instructionId;
	}

	public void setInstructionId(long instructionId) {
		this.instructionId = instructionId;
	}

	public OrderStatus getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}

	public String getRejectionReason() {
		return rejectionReason;
	}

	public void setRejectionReason(String rejectionReason) {
		this.rejectionReason = rejectionReason;
	}

	public Instruction getInstruction() {
		return instruction;
	}

	public void setInstruction(Instruction instruction) {
		this.instruction = instruction;
	}

}
