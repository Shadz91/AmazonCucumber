package Academy.Project;

import org.apache.logging.log4j.*;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeMethod;

import org.testng.annotations.Test;

import pageObjects.LandingPage;
import resources.Base;

public class ValidateTitle extends Base {

	public static Logger log = LogManager.getLogger(Base.class.getName()); // In
																			// each
																			// Test
																			// Case

	@BeforeMethod
	public void initialize() throws Exception {
		driver = initializeBrowser();
		log.info("driver is initialized");

		driver.get(prop.getProperty("url"));
		log.info("Navigated to Home Page");
	}

	@Test
	public void validateAppTitle() throws Exception {

		LandingPage l = new LandingPage(driver);

		// Asserts that two Strings are equal.
		// If they are not, an AssertionError is thrown.
		Assert.assertEquals(l.getTitle().getText(), "FEAxTURED COURSES");
		log.info("Successfully validated Text message");
	}

	@AfterMethod()
	public void tearDown() {
		driver.close();
		driver = null;
	}
}
