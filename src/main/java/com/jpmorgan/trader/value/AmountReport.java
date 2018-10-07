/*
 * 
 */
package com.jpmorgan.trader.value;

import java.math.BigDecimal;
import java.util.Date;

/**
 * The Class AmountReport.
 */
public class AmountReport {

	/** The amount. */
	private BigDecimal amount;
	
	/** The date. */
	private Date date;

	/**
	 * Instantiates a new amount report.
	 *
	 * @param amount the amount
	 * @param date the date
	 */
	public AmountReport(BigDecimal amount, Date date) {
		super();
		this.amount = amount;
		this.date = date;
	}

	/**
	 * Gets the amount.
	 *
	 * @return the amount
	 */
	public BigDecimal getAmount() {
		return amount;
	}

	/**
	 * Sets the amount.
	 *
	 * @param amount the new amount
	 */
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	/**
	 * Gets the date.
	 *
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * Sets the date.
	 *
	 * @param date the new date
	 */
	public void setDate(Date date) {
		this.date = date;
	}
}
