package com.jpmorgan.trader.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

import junit.framework.TestCase;

public class TradingCalendarTest extends TestCase {

	public void testGetDayFromDateRetrunDayInThreeLetterFormat() throws ParseException {

		String day = TradingCalendar
				.getDayFromDate(new SimpleDateFormat("yyyy/MM/dd", Locale.ENGLISH).parse("2018/09/21"));
		assertTrue("FRI".equals(day));
	}
}
