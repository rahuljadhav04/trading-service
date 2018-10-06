package com.jpmorgan.trader.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.jpmorgan.trader.dao.ReportDao;
import com.jpmorgan.trader.dao.ReportDaoImpl;
import com.jpmorgan.trader.domain.AmountReport;
import com.jpmorgan.trader.domain.EntityRankReport;
import com.jpmorgan.trader.domain.Trade;
import com.jpmorgan.trader.domain.TradeDetails;

/**
 * It would save instruction, trade, settlement data into Report format. This
 * avoid JOINs required to get the report data while displaying report.
 * 
 * It would also have method to fetch the report data saved in report format
 * 
 * @author Administrative
 *
 */
public class ReportServiceImpl implements ReportService {
	ReportDao reportDao = new ReportDaoImpl();

	private static final String DATE_DISPLAY_FORMAT = "dd-MMM-yy";

	@Override
	public void saveReport() {

		// save trade data in report format in database. This will help in easy
		// retrieval without joins

		List<Trade> tradeList = reportDao.retrieveTrades();
		List<TradeDetails> tradeDetailsList = new ArrayList<>();
		for (Trade trade : tradeList) {
			TradeDetails tradeDetails = new TradeDetails();
			tradeDetails.setTradeId(trade.getTradeId());
			tradeDetails.setOrderId(trade.getOrderId());
			tradeDetails.setInstructionId(trade.getOrder().getInstructionId());
			tradeDetails.setEntityName(trade.getOrder().getInstruction().getEntityName());
			tradeDetails.setCurrency(trade.getOrder().getInstruction().getCurrency());
			tradeDetails.setAgreedFx(trade.getOrder().getInstruction().getAgreedFx());
			tradeDetails.setPricePerUnit(trade.getPricePerUnit());
			tradeDetails.setAction(trade.getAction());
			tradeDetails.setUnits(trade.getUnits());
			tradeDetails.setTradeStatus(trade.getTradeStatus());
			tradeDetails.setSettlementDate(trade.getSettlementDate());
			tradeDetails.setAmountOfTradeInUSD(trade.getAmountOfTradeInUSD());
			tradeDetails.setSettlementMessage(trade.getSettlementMessage());
			tradeDetailsList.add(tradeDetails);
		}
		reportDao.saveTradeDetails(tradeDetailsList);
	}

	@Override
	public void generateReport() {

		// Retrieve data in report format by applying group by, sun etc.
		List<AmountReport> tradeAmountIncomingValueList = reportDao.retrieveIncomingAmountEveryDay();
		List<AmountReport> tradeAmountOutgoingValueList = reportDao.retrieveOutgoingAmountEveryDay();
		List<EntityRankReport> entityRankIncomingList = reportDao.retrieveIncomingEntityRankEveryDay();
		List<EntityRankReport> entityRankOutgoingList = reportDao.retrieveOutgoingEntityRankEveryDay();

		// Now above objects can be converted into 4 sheets of one excel file using POI
		// package
		// the file can be saved to filesystem or directly written to
		// HttpServletResponse so that can be opened in browser

		// here we will just print values

		// INCOMING AMOUNT
		tradeAmountIncomingValueList.stream().forEach(i -> System.out.println("Settlement Date:"
				+ new SimpleDateFormat(DATE_DISPLAY_FORMAT).format(i.getDate()) + ", Total Incoming:" + i.getAmount()));

		// OUTGOING AMOUNT
		tradeAmountOutgoingValueList.stream().forEach(i -> System.out.println("Settlement Date:"
				+ new SimpleDateFormat(DATE_DISPLAY_FORMAT).format(i.getDate()) + ", Total Outgoing:" + i.getAmount()));

		// INCOMING ENTITY RANK
		entityRankIncomingList.stream()
				.forEach(e -> System.out.println("Incoming Entity Name:" + e.getEntityname() + ", Settlement Date:"
						+ new SimpleDateFormat(DATE_DISPLAY_FORMAT).format(e.getDate()) + ", Rank:" + e.getRank()));

		// OUTGOING ENTITY RANK
		entityRankOutgoingList.stream()
				.forEach(e -> System.out.println("Outgoing Entity Name:" + e.getEntityname() + ", Settlement Date:"
						+ new SimpleDateFormat(DATE_DISPLAY_FORMAT).format(e.getDate()) + ", Rank:" + e.getRank()));

	}

}
