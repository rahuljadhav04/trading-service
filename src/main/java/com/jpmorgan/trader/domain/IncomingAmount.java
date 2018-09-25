package com.jpmorgan.trader.domain;

import java.math.BigDecimal;
import java.util.Date;

//Use @Table, @Column annotations to define mapping to database tables using JPA/Hibernate
public class IncomingAmount {
	private BigDecimal amount;
	private Date date;

	public IncomingAmount(BigDecimal amount, Date date) {
		super();
		this.amount = amount;
		this.date = date;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}
