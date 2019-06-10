package testCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.SelectFlightPage;
import resources.Base;

public class ValidateErrorTest extends Base {

	@BeforeMethod
	public void setUp() throws Exception {
		driver = initializeBrowser();
		log.info("Driver is initialized successfully");

		driver.get(prop.getProperty("url"));
		log.info("Page is Loaded successfully");
	}

	@Test
	public void getErrorTest() {
		HomePage homePage = new HomePage(driver);

		homePage.getDepart().sendKeys("DAL");
		log.info("Departure City is entered successfully");

		homePage.getArrive().sendKeys("HOU");
		log.info("Arrival City is entered successfully");

		homePage.getSearch().click();
		log.debug("I have clicked on the Search button successfully");

		SelectFlightPage selectFlightPage = new SelectFlightPage(driver);

		selectFlightPage.getContinue().click();
		log.debug("I have clicked on the Continue button successfully");

		selectFlightPage.getError().getText();
		log.debug("I have grabbed the Error message successfully");
	}

	@AfterMethod
	public void tearDown() {
		driver.close();
	}
}
