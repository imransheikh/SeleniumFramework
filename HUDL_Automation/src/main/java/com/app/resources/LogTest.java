package com.app.resources;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LogTest {
	
	
	private static 	Logger log= LogManager.getLogger(LogTest.class);
	//Logger log= Logger.getLogger(LogTest.class);
	
	public static void main(String[] args) {
		//Logger log = LogManager.getLogger(LogTest.class);
		
		log.info("Test info logging");
		log.error("Testing error info");
		log.warn("Testing warn info");
		log.fatal("Testing fatal info");
	}
}
