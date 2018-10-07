/*
 * 
 */
package com.jpmorgan.trader.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.jpmorgan.trader.enums.Action;
import com.jpmorgan.trader.enums.OrderStatus;

/**
 * The Class Order.
 */
public class Order implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -3642588185817786396L;
	
	/** The order id. */
	private long orderId;
	
	/** The instruction id. */
	private long instructionId;
	
	/** The units. */
	private long units;
	
	/** The price per unit. */
	private BigDecimal pricePerUnit;
	
	/** The order date. */
	private Date orderDate;
	
	/** The order status. */
	private OrderStatus orderStatus;
	
	/** The rejection reason. */
	private String rejectionReason;
	
	/** The action. */
	private Action action;
	
	/** The instruction. */
	// it can be lazily loaded by hibernate as and when accessed
	private Instruction instruction;

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
	 * Gets the order date.
	 *
	 * @return the order date
	 */
	public Date getOrderDate() {
		return orderDate;
	}

	/**
	 * Sets the order date.
	 *
	 * @param orderDate the new order date
	 */
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
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
	 * Gets the order status.
	 *
	 * @return the order status
	 */
	public OrderStatus getOrderStatus() {
		return orderStatus;
	}

	/**
	 * Sets the order status.
	 *
	 * @param orderStatus the new order status
	 */
	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}

	/**
	 * Gets the rejection reason.
	 *
	 * @return the rejection reason
	 */
	public String getRejectionReason() {
		return rejectionReason;
	}

	/**
	 * Sets the rejection reason.
	 *
	 * @param rejectionReason the new rejection reason
	 */
	public void setRejectionReason(String rejectionReason) {
		this.rejectionReason = rejectionReason;
	}

	/**
	 * Gets the instruction.
	 *
	 * @return the instruction
	 */
	public Instruction getInstruction() {
		return instruction;
	}

	/**
	 * Sets the instruction.
	 *
	 * @param instruction the new instruction
	 */
	public void setInstruction(Instruction instruction) {
		this.instruction = instruction;
	}

}
