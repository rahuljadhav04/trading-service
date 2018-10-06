package com.jpmorgan.trader;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TradingServiceApplication {
	public static void main(String[] args) throws IOException, InterruptedException {
		SpringApplication.run(TradingServiceApplication.class, args);
	}
}
