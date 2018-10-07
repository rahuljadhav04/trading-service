/*
 * 
 */
package com.jpmorgan.trader;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The Class TradingServiceApplication.
 */
@SpringBootApplication
public class TradingServiceApplication {
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws InterruptedException the interrupted exception
	 */
	public static void main(String[] args) throws IOException, InterruptedException {
		SpringApplication.run(TradingServiceApplication.class, args);
	}
}
