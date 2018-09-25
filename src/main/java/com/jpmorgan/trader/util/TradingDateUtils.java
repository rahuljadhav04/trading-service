package com.jpmorgan.trader.util;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TradingDateUtils {
	public static String getDayFromDate(Date date) {
		Format formatter = new SimpleDateFormat("EEE");
		return formatter.format(date).toUpperCase();
	}
}
