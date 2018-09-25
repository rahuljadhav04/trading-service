package com.jpmorgan.trader.application;

import java.text.ParseException;

import com.jpmorgan.trader.listener.InstructionListner;
import com.jpmorgan.trader.mockdata.MockData;
import com.jpmorgan.trader.service.CacheService;
import com.jpmorgan.trader.service.CacheServiceImpl;
import com.jpmorgan.trader.service.ReportService;
import com.jpmorgan.trader.service.ReportServiceImpl;
import com.jpmorgan.trader.value.Message;

public class Application {
	public static void main(String[] args) throws ParseException {
		// cache initialize to get currency and weekend mapping from database
		// this would be static data cached.
		// it can be refreshed if refresh service called
		CacheService cacheService = new CacheServiceImpl();
		cacheService.initializeCache();

		// receive instructions from different clients in JMD queue and save them in
		// database
		InstructionListner instructionListner = new InstructionListner();
		// Get mock input data and send to listener
		for (Message message : MockData.getInputMessages()) {
			instructionListner.onMessage(message);
		}

		// save data in report format based upon instructions in database
		// this is to generate report quickly
		// There would be batch job running daily to store data in report format
		ReportService reportService = new ReportServiceImpl();
		reportService.saveReport();

		// Retrieve the data stored in report format
		reportService.generateReport();

	}
}
