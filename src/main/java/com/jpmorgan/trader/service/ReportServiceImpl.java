package com.jpmorgan.trader.service;

import java.text.SimpleDateFormat;
import java.util.List;

import com.jpmorgan.trader.dao.IncomingAmountDao;
import com.jpmorgan.trader.dao.IncomingAmountDaoImpl;
import com.jpmorgan.trader.dao.IncomingEntityRankDao;
import com.jpmorgan.trader.dao.IncomingEntityRankDaoImpl;
import com.jpmorgan.trader.dao.OutgoingAmountDao;
import com.jpmorgan.trader.dao.OutgoingAmountDaoImpl;
import com.jpmorgan.trader.dao.OutgoingEntityRankDao;
import com.jpmorgan.trader.dao.OutgoingEntityRankDaoImpl;
import com.jpmorgan.trader.dao.ReportDao;
import com.jpmorgan.trader.dao.ReportDaoImpl;
import com.jpmorgan.trader.domain.IncomingAmount;
import com.jpmorgan.trader.domain.IncomingEntityRank;
import com.jpmorgan.trader.domain.OutgoingAmount;
import com.jpmorgan.trader.domain.OutgoingEntityRank;

public class ReportServiceImpl implements ReportService {
	ReportDao reportDao = new ReportDaoImpl();
	IncomingAmountDao incomingAmountDao = new IncomingAmountDaoImpl();
	IncomingEntityRankDao incomingEntityRankDao = new IncomingEntityRankDaoImpl();
	OutgoingEntityRankDao outgoingEntityRankDao = new OutgoingEntityRankDaoImpl();
	OutgoingAmountDao outgoingAmountDao = new OutgoingAmountDaoImpl();
	private static final String DATE_DISPLAY_FORMAT = "dd-MMM-yy";

	@Override
	public void saveReport() {
		// Retrieve data in report format by applying group by, sun etc.
		List<IncomingAmount> tradeAmountIncomingValueList = reportDao.retrieveIncomingAmountEveryDay();
		List<OutgoingAmount> tradeAmountOutgoingValueList = reportDao.retrieveOutgoingAmountEveryDay();
		List<IncomingEntityRank> entityRankIncomingList = reportDao.retrieveIncomingEntityRankEveryDay();
		List<OutgoingEntityRank> entityRankOutgoingList = reportDao.retrieveOutgoingEntityRankEveryDay();
		// save report format data in database

		incomingAmountDao.saveAll(tradeAmountIncomingValueList);
		outgoingAmountDao.saveAll(tradeAmountOutgoingValueList);
		incomingEntityRankDao.saveAll(entityRankIncomingList);
		outgoingEntityRankDao.saveAll(entityRankOutgoingList);
	}

	@Override
	public void generateReport() {
		List<IncomingAmount> tradeAmountIncomingValueList = incomingAmountDao.fetchAll();
		List<OutgoingAmount> tradeAmountOutgoingValueList = outgoingAmountDao.fetchAll();
		List<IncomingEntityRank> entityRankIncomingList = incomingEntityRankDao.fetchAll();
		List<OutgoingEntityRank> entityRankOutgoingList = outgoingEntityRankDao.fetchAll();

		// Now above objects can be converted into 4 sheets of one excel file using POI
		// package
		// the file can be saved to filesystem or directly written to
		// HttpServletResponse so that can be opened in browser

		// here we will just print values

		// INCOMING AMOUNT
		tradeAmountIncomingValueList.stream().forEach(i -> System.out.println("Actual Settlement Date:"
				+ new SimpleDateFormat(DATE_DISPLAY_FORMAT).format(i.getDate()) + ", Total Incoming:" + i.getAmount()));

		// OUTGOING AMOUNT
		tradeAmountOutgoingValueList.stream().forEach(i -> System.out.println("Actual Settlement Date:"
				+ new SimpleDateFormat(DATE_DISPLAY_FORMAT).format(i.getDate()) + ", Total Outgoing:" + i.getAmount()));

		// INCOMING ENTITY RANK
		entityRankIncomingList.stream()
				.forEach(e -> System.out.println("Incoming Entity Name:" + e.getEntityname()
						+ ", Actual Settlement Date:" + new SimpleDateFormat(DATE_DISPLAY_FORMAT).format(e.getDate())
						+ ", Rank:" + e.getRank()));

		// OUTGOING ENTITY RANK
		entityRankOutgoingList.stream()
				.forEach(e -> System.out.println("Outgoing Entity Name:" + e.getEntityname()
						+ ", Actual Settlement Date:" + new SimpleDateFormat(DATE_DISPLAY_FORMAT).format(e.getDate())
						+ ", Rank:" + e.getRank()));

	}

}
