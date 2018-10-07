package com.jpmorgan.trader.upload;

import java.io.File;
import java.io.IOException;

import javax.annotation.PostConstruct;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

/**
 * This class uploads files into instruction input folder for polling purpose.
 * This is used for testing purpose where manual upload of file is avoided.
 * 
 * By using @Profiles feature of Spring, this class only loaded into dev
 * environment. In PROD environment this class will not be loaded by spring. So
 * it will not upload files into input folder.
 * 
 * 
 * @author Administrative
 *
 */
@Component
@Profile("dev")
public class InstructionInputLoader {

	@Value("${instruction.input.path}")
	public String instructionInputPath;

	@Value("${instruction.upload.path}")
	public String instructionUploadPath;

	@PostConstruct
	public void uploadInstructionsForPolling() throws IOException {
		FileUtils.copyDirectory(new File(instructionUploadPath), new File(instructionInputPath));
	}

}
