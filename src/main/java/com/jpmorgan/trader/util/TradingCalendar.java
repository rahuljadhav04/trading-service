package com.jpmorgan.trader.util;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Date util methods specific to this project
 * 
 * 
 * @author Administrative
 *
 */
public class TradingCalendar {
	/*
	 * It would return day in three letter..e.g. SUN, MON etc.
	 */
	public static String getDayFromDate(Date date) {
		Format formatter = new SimpleDateFormat("EEE");
		return formatter.format(date).toUpperCase();
	}

	/**
	 * It has logic to get next working date if settlement day fall on weekend
	 */
	public static Date getSettlementDate(Date tradeDate, String weekEnd) {
		Date settlementDate = getTPlusTwoDate(tradeDate);
		String day = TradingCalendar.getDayFromDate(settlementDate);
		while (weekEnd.contains(day)) {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(settlementDate);
			calendar.add(Calendar.DATE, 1);
			settlementDate = calendar.getTime();
			day = TradingCalendar.getDayFromDate(settlementDate);
		}
		return settlementDate;
	}

	/**
	 * It would return T + 2 date from trade date
	 * 
	 * @param tradeDate
	 * @return
	 */
	public static Date getTPlusTwoDate(Date tradeDate) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(tradeDate);
		calendar.add(Calendar.DATE, 2);
		return calendar.getTime();
	}
}
