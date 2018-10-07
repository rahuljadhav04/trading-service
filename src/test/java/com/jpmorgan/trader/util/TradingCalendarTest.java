/*
 * 
 */
package com.jpmorgan.trader.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

import junit.framework.TestCase;

/**
 * The Class TradingCalendarTest.
 */
public class TradingCalendarTest extends TestCase {

	/**
	 * Test get day from date retrun day in three letter format.
	 *
	 * @throws ParseException the parse exception
	 */
	public void testGetDayFromDateRetrunDayInThreeLetterFormat() throws ParseException {

		String day = TradingCalendar
				.getDayFromDate(new SimpleDateFormat("yyyy/MM/dd", Locale.ENGLISH).parse("2018/09/21"));
		assertTrue("FRI".equals(day));
	}
}
