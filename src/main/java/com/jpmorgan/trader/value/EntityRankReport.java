package com.jpmorgan.trader.value;

import java.util.Date;

public class EntityRankReport {
	private String entityname;
	private long rank;
	private Date date;

	public EntityRankReport(String entityname, Date date, long rank) {
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
