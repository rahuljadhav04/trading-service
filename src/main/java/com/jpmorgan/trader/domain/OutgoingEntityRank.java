package com.jpmorgan.trader.domain;

import java.util.Date;

//Use @Table, @Column annotations to define mapping to database tables using JPA/Hibernate
//Incoming and Outgoing data is saved into different tables just to show that we can combine tables i.e. 
//de-normalize to avoid JOIN QUERIES and improve performance for report generation and display.
public class OutgoingEntityRank {
	private String entityname;
	private long rank;
	private Date date;

	public OutgoingEntityRank(String entityname, Date date, long rank) {
		super();
		this.entityname = entityname;
		this.rank = rank;
		this.date = date;
	}

	public String getEntityname() {
		return entityname;
	}

	public void setEntityname(String entityname) {
		this.entityname = entityname;
	}

	public long getRank() {
		return rank;
	}

	public void setRank(long rank) {
		this.rank = rank;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
