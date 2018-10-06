package com.jpmorgan.trader.value;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class AmountReport implements Serializable {
	private BigDecimal amount;
	private Date date;

	public AmountReport(BigDecimal amount, Date date) {
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
