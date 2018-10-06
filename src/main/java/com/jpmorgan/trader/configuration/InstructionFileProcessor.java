package com.jpmorgan.trader.configuration;

import java.io.File;

import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Component("instructionFileProcessor")
public class InstructionFileProcessor {
	public String OUTPUT_DIR = "C:\\work\\test1";
	public String OUTPUT_ERROR_DIR = "C:\\work\\error";

	public void processInstruction(Message<File> msg) {
		System.out.println("Hi");
		File file = msg.getPayload();
		try {
			boolean isFileRenamed = file.renameTo(new File(OUTPUT_DIR, file.getName()));
			if (isFileRenamed) {
				System.out.println("File moved to output directory after success");
			} else {
				file.renameTo(new File(OUTPUT_DIR, file.getName() + "_" + System.currentTimeMillis()));
			}

		} catch (Exception e) {
			file.renameTo(new File(OUTPUT_ERROR_DIR, file.getName()));
			System.out.println("File moved to error directory after failure");
			throw e;
		}
	}

}
