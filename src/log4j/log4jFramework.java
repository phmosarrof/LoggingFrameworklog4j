package log4j;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class log4jFramework {

	
	private static Logger log = LogManager.getLogger(log4jFramework.class.getName());
	public static void main(String[] args) {
		log.info("I did it successfully");
		log.error("The error is noticed");
		//log.trace("Trace all the log");
		log.debug("Debug message");
		

	}

}
