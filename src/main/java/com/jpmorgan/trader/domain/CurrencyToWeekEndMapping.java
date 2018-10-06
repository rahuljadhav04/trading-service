package com.jpmorgan.trader.domain;

import java.io.Serializable;

//Use @Table, @Column annotations to define mapping to database tables using JPA/Hibernate
public class CurrencyToWeekEndMapping implements Serializable {
	private static final long serialVersionUID = -6789399513277610498L;
	private String currenncy;
	private String weekEnd;

	public CurrencyToWeekEndMapping(String currenncy, String weekEnd) {
		super();
		this.currenncy = currenncy;
		this.weekEnd = weekEnd;
	}

	public String getCurrenncy() {
		return currenncy;
	}

	public void setCurrenncy(String currenncy) {
		this.currenncy = currenncy;
	}

	public String getWeekEnd() {
		return weekEnd;
	}

	public void setWeekEnd(String weekEnd) {
		this.weekEnd = weekEnd;
	}

}
