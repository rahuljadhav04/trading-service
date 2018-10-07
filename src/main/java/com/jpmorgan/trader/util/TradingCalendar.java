/*
 * 
 */
package com.jpmorgan.trader.util;

import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import org.springframework.stereotype.Component;

/**
 * Date util methods specific to this project.
 *
 * @author Administrative
 */
@Component
public class TradingCalendar {
	
	/** The Constant INSTRUCTION_INPUT_DATE_FORMAT. */
	public static final String INSTRUCTION_INPUT_DATE_FORMAT = "yyyy/MM/dd";

	/**
	 * Gets the day from date.
	 *
	 * @param date the date
	 * @return the day from date
	 */
	/*
	 * It would return day in three letter..e.g. SUN, MON etc.
	 */
	public static String getDayFromDate(Date date) {
		Format formatter = new SimpleDateFormat("EEE");
		return formatter.format(date).toUpperCase();
	}

	/**
	 * It has logic to get next working date if settlement day fall on weekend.
	 *
	 * @param tradeDate the trade date
	 * @param weekEnd the week end
	 * @return the settlement date
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
	 * It would return T + 2 date from trade date.
	 *
	 * @param tradeDate the trade date
	 * @return the t plus two date
	 */
	public static Date getTPlusTwoDate(Date tradeDate) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(tradeDate);
		calendar.add(Calendar.DATE, 2);
		return calendar.getTime();
	}

	/**
	 * Gets the date YYYYMMDD.
	 *
	 * @param strDate the str date
	 * @return the date YYYYMMDD
	 * @throws ParseException the parse exception
	 */
	public static Date getDateYYYYMMDD(String strDate) throws ParseException {
		return new SimpleDateFormat(INSTRUCTION_INPUT_DATE_FORMAT, Locale.ENGLISH).parse(strDate);
	}
}
