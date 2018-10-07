package com.jpmorgan.trader.configuration;

import java.io.File;

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
import org.springframework.integration.file.filters.SimplePatternFileListFilter;
import org.springframework.messaging.MessageChannel;

@Configuration
@EnableIntegration
public class TradingServiceConfiguration {
	@Value("${instruction.input.path}")
	public String instructionInputPath;

	public String FILE_PATTERN = "*.txt";

	@Bean
	public MessageChannel instructionFileInputChannel() {
		return new DirectChannel();
	}

	@Bean
	@InboundChannelAdapter(value = "instructionFileInputChannel", poller = @Poller(fixedDelay = "1000"))
	public MessageSource<File> fileReadingMessageSource() {
		FileReadingMessageSource sourceReader = new FileReadingMessageSource();
		sourceReader.setDirectory(new File(instructionInputPath));
		sourceReader.setFilter(new SimplePatternFileListFilter(FILE_PATTERN));
		return sourceReader;
	}

	@Bean
	public IntegrationFlow processFileFlow() {
		return IntegrationFlows.from("instructionFileInputChannel")
				.handle("instructionFileProcessor", "processInstruction").get();
	}

}
