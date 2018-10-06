package com.jpmorgan.trader.application;

import java.text.ParseException;

import com.jpmorgan.trader.listener.InstructionListner;
import com.jpmorgan.trader.mockdata.MockDataBase;
import com.jpmorgan.trader.service.CacheService;
import com.jpmorgan.trader.service.CacheServiceImpl;
import com.jpmorgan.trader.service.ReportService;
import com.jpmorgan.trader.service.ReportServiceImpl;
import com.jpmorgan.trader.value.Message;

/**
 * This class is acting as 4 components. Calling JMS listener component as we
 * won't have JMS here. It would get Mock instructions from Mockdatabase and
 * send to instruction listener where instruction listener would save
 * instructions to database. Instruction converted to order. And order converted
 * to Trade if it is successful. It would then call Report saver component to
 * save data into report format.(to avoid JOIN queries to fetch report) It real
 * world it can be batch job which would daily save data into report format.
 * 
 * Then it would call report generator, which would simply get data from report
 * format database and convert it in excel format. Here it is just printing to
 * console.
 * 
 * It would also call cache initializer to initialize cache like currency to
 * weekend mapping
 * 
 * @author Administrative
 *
 */
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
		for (Message message : MockDataBase.getInputMessages()) {
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
