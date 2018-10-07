/*
 * 
 */
package com.jpmorgan.trader.processor;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.jpmorgan.trader.exception.InvalidActionException;
import com.jpmorgan.trader.exception.InvalidInstructionException;
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

	/** The report service. */
	@Autowired
	private ReportService reportService;

	/** The instruction done path. */
	@Value("${instruction.done.path}")
	public String instructionDonePath;
	
	/** The instruction error path. */
	@Value("${instruction.error.path}")
	public String instructionErrorPath;
	
	/** The instruction success path. */
	@Value("${instruction.success.path}")
	public String instructionSuccessPath;
	
	/** The instruction input file pattern. */
	@Value("${instruction.input.pattern}")
	private String instructionInputFilePattern;

	/** The instruction processor. */
	@Autowired
	private InstructionProcessor instructionProcessor;

	/** The Constant CHAR_ENCODING. */
	private static final String CHAR_ENCODING = "UTF-8";

	/**
	 * Creates the directories.
	 *
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	@PostConstruct
	public void createDirectories() throws IOException {
		Files.createDirectories(Paths.get(instructionDonePath));
		Files.createDirectories(Paths.get(instructionErrorPath));
	}

	/**
	 * Process instruction.
	 *
	 * @param msg the msg
	 * @throws Exception the exception
	 */
	public void processInstruction(Message<File> msg) throws Exception {
		System.out.println("Inside processInstruction");
		File file = msg.getPayload();
		if (!deleteFileIfInValidExtention(file)) {
			List<String> instructionMessageList = FileUtils.readLines(file, CHAR_ENCODING);
			if (!deleteFileIfEmptyContent(file, instructionMessageList)) {
				procesFile(file, instructionMessageList);
				saveAndDisplayReport();

			}
		}
	}

	/**
	 * Save and display report.
	 */
	private void saveAndDisplayReport() {
		// save data in report format based upon instructions in database
		// this is to generate report quickly
		// There would be batch job running daily to store data in report format
		reportService.saveReport();
		System.out.println("Report data saved");
		// Retrieve the data stored in report format
		System.out.println("Generating report");
		reportService.generateReport();
		System.out.println("Report generated and displayed");
	}

	/**
	 * Delete file if in valid extention.
	 *
	 * @param file the file
	 * @return true, if successful
	 */
	private boolean deleteFileIfInValidExtention(File file) {
		if (!FilenameUtils.wildcardMatch(file.getName(), instructionInputFilePattern, IOCase.INSENSITIVE)) {
			System.out.println("File with invalid extention uploaded. Deleting file. Accepted extention is "
					+ instructionInputFilePattern);
			file.delete();
			return true;
		}
		return false;
	}

	/**
	 * Delete file if empty content.
	 *
	 * @param file the file
	 * @param instructionMessageList the instruction message list
	 * @return true, if successful
	 */
	private boolean deleteFileIfEmptyContent(File file, List<String> instructionMessageList) {
		if (CollectionUtils.isEmpty(instructionMessageList)) {
			System.out.println("Empty file received. Deleting file");
			file.delete();
			return true;
		}
		return false;
	}

	/**
	 * Proces file.
	 *
	 * @param file the file
	 * @param instructionMessageList the instruction message list
	 * @throws InvalidInstructionException the invalid instruction exception
	 * @throws ParseException the parse exception
	 * @throws InvalidActionException the invalid action exception
	 * @throws Exception the exception
	 */
	private void procesFile(File file, List<String> instructionMessageList)
			throws InvalidInstructionException, ParseException, InvalidActionException, Exception {
		List<String> erroroneousInstructions = new ArrayList<>();
		List<String> proccesedInstructions = new ArrayList<>();

		instructionProcessor.processInstructions(instructionMessageList, proccesedInstructions,
				erroroneousInstructions);

		afterInstructionProcessing(proccesedInstructions, erroroneousInstructions, file);
	}

	/**
	 * After instruction processing.
	 *
	 * @param proccesedInstructions the proccesed instructions
	 * @param erroroneousInstructions the erroroneous instructions
	 * @param file the file
	 * @throws Exception the exception
	 */
	private void afterInstructionProcessing(List<String> proccesedInstructions, List<String> erroroneousInstructions,
			File file) throws Exception {
		if (!CollectionUtils.isEmpty(proccesedInstructions)) {
			System.out.println("Writing processed instructions to success file");
			FileUtils.writeLines(new File(instructionSuccessPath, file.getName() + ".success"), proccesedInstructions,
					"\r\n");
		}
		if (!CollectionUtils.isEmpty(erroroneousInstructions)) {
			System.out.println("Writing erroneous instructions to error file");
			FileUtils.writeLines(new File(instructionErrorPath, file.getName() + ".error"), erroroneousInstructions,
					"\r\n");
		}

		copyFileToDoneFolder(file);
	}

	/**
	 * Copy file to done folder.
	 *
	 * @param file the file
	 */
	private void copyFileToDoneFolder(File file) {
		boolean isFileRenamed = file.renameTo(new File(instructionDonePath, file.getName()));
		if (isFileRenamed) {
			System.out.println("File moved to done folder");
		} else {
			isFileRenamed = file
					.renameTo(new File(instructionDonePath, file.getName() + "_" + System.currentTimeMillis()));
			if (isFileRenamed) {
				System.out.println("File moved to done folder");
			}
		}
	}

}
