package com.jpmorgan.trader.processor;

import java.io.File;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.jpmorgan.trader.domain.Instruction;
import com.jpmorgan.trader.listener.InstructionListner;
import com.jpmorgan.trader.service.ReportService;

/**
 * This class is acting as 4 components. Calling Instruction listener component
 * instruction listener would save instructions to database. Instruction
 * converted to order. And order converted to Trade if it is successful. It
 * would then call Report saver component to save data into report format.(to
 * avoid JOIN queries to fetch report) It real world it can be batch job which
 * would daily save data into report format.
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
@Component("instructionFileProcessor")
public class InstructionFileProcessor {
	@Autowired
	private InstructionListner instructionListner;
	@Autowired
	private ReportService reportService;

	@Value("${instruction.done.path}")
	public String instructionDonePath;
	@Value("${instruction.error.path}")
	public String instructionErrorPath;

	public void processInstruction(Message<File> msg) throws Exception {
		System.out.println("Inside processInstruction");
		File file = msg.getPayload();
		List<String> instructionMessageList = FileUtils.readLines(file, "UTF-8");
		for (String instructionMessage : instructionMessageList) {
			Instruction instruction = getInstruction(instructionMessage);
			instructionListner.onMessage(instruction);
		}
		afterInstructionProcessing(file);
		// save data in report format based upon instructions in database
		// this is to generate report quickly
		// There would be batch job running daily to store data in report format
		reportService.saveReport();

		// Retrieve the data stored in report format
		reportService.generateReport();

	}

	private Instruction getInstruction(String instructionMessage) throws ParseException {
		String[] instructionMessageArray = StringUtils.tokenizeToStringArray(instructionMessage, ",", true, false);
		Instruction instruction = new Instruction();
		instruction.setEntityName(instructionMessageArray[0]);
		instruction.setAction(instructionMessageArray[1]);
		instruction.setAgreedFx(new BigDecimal(instructionMessageArray[2]));
		instruction.setCurrency(instructionMessageArray[3]);
		instruction.setInstructionDate(
				new SimpleDateFormat("yyyy/MM/dd", Locale.ENGLISH).parse(instructionMessageArray[4]));
		instruction.setSettlementDate(
				new SimpleDateFormat("yyyy/MM/dd", Locale.ENGLISH).parse(instructionMessageArray[5]));
		instruction.setUnits(new Long(instructionMessageArray[6]));
		instruction.setPricePerUnit(new BigDecimal(instructionMessageArray[7]));
		return instruction;
	}

	private void afterInstructionProcessing(File file) throws Exception {
		try {
			copyFileToDoneFolder(file);

		} catch (Exception e) {
			copyFileToErrorFolder(file);
			throw e;
		}
	}

	private void copyFileToErrorFolder(File file) {
		file.renameTo(new File(instructionErrorPath, file.getName()));
		System.out.println("File moved to error directory after failure");
	}

	private void copyFileToDoneFolder(File file) {
		boolean isFileRenamed = file.renameTo(new File(instructionDonePath, file.getName()));
		if (isFileRenamed) {
			System.out.println("File moved to output directory after success");
		} else {
			file.renameTo(new File(instructionDonePath, file.getName() + "_" + System.currentTimeMillis()));
		}
	}

}
