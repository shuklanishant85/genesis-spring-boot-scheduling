package com.genesis.scheduling.cron;

import java.text.SimpleDateFormat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class TimeGenerator {

	private static final Logger LOGGER = LoggerFactory.getLogger(TimeGenerator.class);
	private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("HH:mm:ss");

	/**
	 * method to log current time
	 */
	public void printCurrentTime() {
		LOGGER.info("Current time is: {}", DATE_FORMAT.format(new java.util.Date()));
	}
}
