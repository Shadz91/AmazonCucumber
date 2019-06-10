package Academy.Project;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeMethod;

import org.testng.annotations.Test;

import pageObjects.LandingPage;
import resources.Base;

public class ValidateNavigationBarTest extends Base {

	public static Logger log = LogManager.getLogger(Base.class.getName());

	@BeforeMethod
	public void initialize() throws Exception {
		driver = initializeBrowser();
		driver.get(prop.getProperty("url"));
	}

	@Test
	public void validateAppNavigationBar() {

		LandingPage l = new LandingPage(driver);
		Assert.assertTrue(l.getNavigationBar().isDisplayed());
		log.info("NavigationBar is displayed");

	}

	@AfterMethod
	public void tearDown() {
		driver.close();
		driver = null;
		// Memory will not get wasted
		// All these objects will be on Heap Memory
	}
}