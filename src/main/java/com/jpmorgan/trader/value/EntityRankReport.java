/*
 * 
 */
package com.jpmorgan.trader.value;

import java.util.Date;

/**
 * The Class EntityRankReport.
 */
public class EntityRankReport {
	
	/** The entityname. */
	private String entityname;
	
	/** The rank. */
	private long rank;
	
	/** The date. */
	private Date date;

	/**
	 * Instantiates a new entity rank report.
	 *
	 * @param entityname the entityname
	 * @param date the date
	 * @param rank the rank
	 */
	public EntityRankReport(String entityname, Date date, long rank) {
		super();
		this.entityname = entityname;
		this.rank = rank;
		this.date = date;
	}

	/**
	 * Gets the entityname.
	 *
	 * @return the entityname
	 */
	public String getEntityname() {
		return entityname;
	}

	/**
	 * Sets the entityname.
	 *
	 * @param entityname the new entityname
	 */
	public void setEntityname(String entityname) {
		this.entityname = entityname;
	}

	/**
	 * Gets the rank.
	 *
	 * @return the rank
	 */
	public long getRank() {
		return rank;
	}

	/**
	 * Sets the rank.
	 *
	 * @param rank the new rank
	 */
	public void setRank(long rank) {
		this.rank = rank;
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
