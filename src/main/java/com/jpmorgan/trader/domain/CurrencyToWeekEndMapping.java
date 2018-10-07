/*
 * 
 */
package com.jpmorgan.trader.domain;

import java.io.Serializable;

/**
 * The Class CurrencyToWeekEndMapping.
 */
//Use @Table, @Column annotations to define mapping to database tables using JPA/Hibernate
public class CurrencyToWeekEndMapping implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -6789399513277610498L;
	
	/** The currenncy. */
	private String currenncy;
	
	/** The week end. */
	private String weekEnd;

	/**
	 * Instantiates a new currency to week end mapping.
	 *
	 * @param currenncy the currenncy
	 * @param weekEnd the week end
	 */
	public CurrencyToWeekEndMapping(String currenncy, String weekEnd) {
		super();
		this.currenncy = currenncy;
		this.weekEnd = weekEnd;
	}

	/**
	 * Gets the currenncy.
	 *
	 * @return the currenncy
	 */
	public String getCurrenncy() {
		return currenncy;
	}

	/**
	 * Sets the currenncy.
	 *
	 * @param currenncy the new currenncy
	 */
	public void setCurrenncy(String currenncy) {
		this.currenncy = currenncy;
	}

	/**
	 * Gets the week end.
	 *
	 * @return the week end
	 */
	public String getWeekEnd() {
		return weekEnd;
	}

	/**
	 * Sets the week end.
	 *
	 * @param weekEnd the new week end
	 */
	public void setWeekEnd(String weekEnd) {
		this.weekEnd = weekEnd;
	}

}
