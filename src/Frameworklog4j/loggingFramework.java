package Frameworklog4j;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import log4j.log4jFramework;

public class loggingFramework {

	private static Logger log = LogManager.getLogger(log4jFramework.class.getName());
	
	Logger log1 = LogManager.getLogger(log4jFramework.class.getName());

	public static void main(String[] args) {
		
		log.info("I did it successfully");
		log.error("The error is noticed");
		// log.trace("Trace all the log");
		log.debug("Debug message");
		log.fatal("The problem is serious and need to solve as early as possible");
		log.warn("Needs to be attention immediately and resolved the issue");
		log.debug("Debug is done and showed the error message");
		log.fatal("The problem is serious and need to solve as soon as possible");
		log.warn("Need to be attention immediately and resolved the issue");

	}

}
