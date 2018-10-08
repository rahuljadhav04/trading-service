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
	 * It has logic to get next working date if settlement day fall on weekend. It
	 * would return T + 2 working date from trade date.
	 * 
	 * @param tradeDate the trade date
	 * @param weekEnd   the week end
	 * @return the settlement date
	 */
	public static Date getSettlementDate(Date tradeDate, String weekEnd) {
		Date tradeDatePlusOneWorking = getTPlusOneWorkingDay(tradeDate, weekEnd);
		Date tradeDatePlusTwoWorking = getTPlusOneWorkingDay(tradeDatePlusOneWorking, weekEnd);
		return tradeDatePlusTwoWorking;
	}

	/**
	 * It would return T + 1 working date from trade date.
	 *
	 * @param tradeDate the trade date
	 * @return the t plus two date
	 */
	public static Date getTPlusOneWorkingDay(Date tradeDate, String weekEnd) {
		tradeDate = getTPlusOneDay(tradeDate);
		String day = TradingCalendar.getDayFromDate(tradeDate);
		while (weekEnd.contains(day)) {
			tradeDate = getTPlusOneDay(tradeDate);
			day = TradingCalendar.getDayFromDate(tradeDate);
		}
		return tradeDate;
	}

	public static Date getTPlusOneDay(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DATE, 1);
		date = calendar.getTime();
		return date;
	}

	/**
	 * Gets the date YYYYMMDD.
	 *
	 * @param strDate the str date
	 * @return the date YYYYMMDD
	 * @throws ParseException the parse exception
	 */
	public static Date getDateYYYYMMDD(String strDate) throws ParseException {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(INSTRUCTION_INPUT_DATE_FORMAT, Locale.ENGLISH);
		simpleDateFormat.setLenient(false);// will not do rounding for invalid dates
		return simpleDateFormat.parse(strDate);
	}
}
