/*
 * 
 */
package com.jpmorgan.trader.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

/**
 * The Class TradingCalendarTest.
 */
public class TradingCalendarTest {
	private static Logger LOGGER = LoggerFactory.getLogger(TradingCalendarTest.class);

	/**
	 * Test get day from date retrun day in three letter format.
	 *
	 * @throws ParseException the parse exception
	 */
	@Test
	public void testGetDayFromDateRetrunDayInThreeLetterFormat() throws ParseException {

		String day = TradingCalendar
				.getDayFromDate(new SimpleDateFormat("yyyy/MM/dd", Locale.ENGLISH).parse("2018/09/21"));
		Assert.isTrue("FRI".equals(day));
	}

	@Test
	public void testGetTPlusTwoDate() throws ParseException {
		Date date = TradingCalendar.getTPlusOneWorkingDay(
				new SimpleDateFormat("yyyy/MM/dd", Locale.ENGLISH).parse("2018/09/21"), "SAT,SUN");
		Assert.isTrue(date.compareTo(new SimpleDateFormat("yyyy/MM/dd", Locale.ENGLISH).parse("2018/09/24")) == 0);
	}

	@Test(expected = ParseException.class)
	public void testGetDateYYYYMMDDThrowExceptionWhenInvalidDate() throws ParseException {
		TradingCalendar.getDateYYYYMMDD("2018/09/40");
		LOGGER.info("date returned");
	}

	@Test
	public void testGetDateYYYYMMDDDoNotThrowExceptionWhenValidDate() throws ParseException {
		TradingCalendar.getDateYYYYMMDD("2018/09/21");
		LOGGER.info("date returned");
	}

	/**
	 * Test return same date if it is already working date.
	 *
	 * @throws ParseException the parse exception
	 */
	@Test
	public void testReturnTPlusTwoWorkingDate() throws ParseException {
		Date date = new SimpleDateFormat("yyyy/MM/dd", Locale.ENGLISH).parse("2018/09/21");
		Date workingDate = TradingCalendar.getSettlementDate(date, "SAT,SUN");
		Assert.isTrue(
				workingDate.compareTo(new SimpleDateFormat("yyyy/MM/dd", Locale.ENGLISH).parse("2018/09/25")) == 0);
	}

	/**
	 * Test return next working date if it is not weekend.
	 *
	 * @throws ParseException the parse exception
	 */
	@Test
	public void testReturnNextWorkingDateIfItIsWeekend() throws ParseException {
		Date date = new SimpleDateFormat("yyyy/MM/dd", Locale.ENGLISH).parse("2018/09/23");
		Date workingDate = TradingCalendar.getSettlementDate(date, "SAT,SUN");
		Assert.isTrue(
				workingDate.compareTo(new SimpleDateFormat("yyyy/MM/dd", Locale.ENGLISH).parse("2018/09/25")) == 0);
	}
}
