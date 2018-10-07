/*
 * 
 */
package com.jpmorgan.trader.configuration;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.integration.core.MessageSource;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.file.FileReadingMessageSource;
import org.springframework.messaging.MessageChannel;

/**
 * The Class TradingServiceConfiguration.
 */
@Configuration
@EnableIntegration
public class TradingServiceConfiguration {
	
	/** The instruction input path. */
	@Value("${instruction.input.path}")
	private String instructionInputPath;

	/**
	 * Instruction file input channel.
	 *
	 * @return the message channel
	 */
	@Bean
	public MessageChannel instructionFileInputChannel() {
		return new DirectChannel();
	}

	/**
	 * File reading message source.
	 *
	 * @return the message source
	 */
	@Bean
	@InboundChannelAdapter(value = "instructionFileInputChannel", poller = @Poller(fixedDelay = "1000"))
	public MessageSource<File> fileReadingMessageSource() {
		FileReadingMessageSource sourceReader = new FileReadingMessageSource();
		sourceReader.setDirectory(new File(instructionInputPath));
		// sourceReader.setFilter(new AcceptOnceFileListFilter<>());
		return sourceReader;
	}

	/**
	 * Process file flow.
	 *
	 * @return the integration flow
	 */
	@Bean
	public IntegrationFlow processFileFlow() {
		return IntegrationFlows.from("instructionFileInputChannel")
				.handle("instructionFileProcessor", "processInstruction").get();
	}

	/**
	 * Creates the directories.
	 *
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	@PostConstruct
	public void createDirectories() throws IOException {
		Files.createDirectories(Paths.get(instructionInputPath));
	}

}
