package beta;

import org.apache.logging.log4j.*;

public class Demo1 {

	private static Logger log = LogManager.getLogger(Demo1.class.getName());

	public static void main(String[] args) {

		log.debug("I have clicked on this button");
		log.info("Button is displayed");
		log.error("Button is not displayed");
		log.fatal("Button is missing");

	}

}