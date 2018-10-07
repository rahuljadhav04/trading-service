/*
 * 
 */
package com.jpmorgan.trader.value;

import java.util.Date;

/**
 * This is key of hashmp where we are calculating rank of entity in java.
 * 
 * In real project, this class would not be present as we can have SQL query
 * like rank over (partitioned by amount) which would give us rank. since we
 * would be using in map, equals(), hashcode() etc. methods overriden
 * 
 * @author Administrative
 *
 */
public final class EntityRankKey {

	/** The entity name. */
	private final String entityName;
	
	/** The date. */
	private final Date date;

	/**
	 * Instantiates a new entity rank key.
	 *
	 * @param entityName the entity name
	 * @param date the date
	 */
	public EntityRankKey(String entityName, Date date) {
		super();
		this.entityName = entityName;
		this.date = date;
	}

	/**
	 * Gets the entity name.
	 *
	 * @return the entity name
	 */
	public String getEntityName() {
		return entityName;
	}

	/**
	 * Gets the date.
	 *
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((entityName == null) ? 0 : entityName.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EntityRankKey other = (EntityRankKey) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (entityName == null) {
			if (other.entityName != null)
				return false;
		} else if (!entityName.equals(other.entityName))
			return false;
		return true;
	}

}
