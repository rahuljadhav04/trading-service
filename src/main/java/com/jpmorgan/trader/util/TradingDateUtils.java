package com.jpmorgan.trader.util;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * Date util methods specific to this project
 * 
 * 
 * @author Administrative
 *
 */
public class TradingDateUtils {
	/*
	 * It would return day in three letter..e.g. SUN, MON etc.
	 */
	public static String getDayFromDate(Date date) {
		Format formatter = new SimpleDateFormat("EEE");
		return formatter.format(date).toUpperCase();
	}
}
