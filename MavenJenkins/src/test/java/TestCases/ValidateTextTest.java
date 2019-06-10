package TestCases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.SelectFlightPage;
import resources.Base;

public class ValidateTextTest extends Base {

	public static Logger log = LogManager.getLogger(Base.class.getName());

	@BeforeMethod
	public void setUp() throws Exception {
		driver = initializeBrowser();
		driver.get(prop.getProperty("url"));
	}

	@Test
	public void validateText() {

		HomePage hp = new HomePage(driver);
		hp.getDepart().sendKeys("DAL");
		log.info("Entered Departure City successfully");

		hp.getArrive().sendKeys("HOU");
		log.info("Entered Arrival City successfully");

		hp.getSearch().click();
		log.debug("Clicked on Search button");

		SelectFlightPage sf = new SelectFlightPage(driver);
		sf.getContinue().click();
		log.debug("Clicked on Continue button");

		String expected = "Sorry, we found some errors...\n" + "No outbound flight selected.\n"
				+ "No inbound flight selected.";

		Assert.assertEquals(sf.getError().getText(), expected);
		log.info("Validated correct error message is displayed successfully");

	}

	@AfterMethod
	public void tearDown() {
		driver.close();
	}
}
