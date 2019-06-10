package TestCases;

import org.apache.logging.log4j.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import resources.Base;

public class HomePageTest extends Base {

	public static Logger log = LogManager.getLogger(Base.class.getName());

	@BeforeMethod
	public void setUp() throws Exception {
		driver = initializeBrowser();
		driver.get(prop.getProperty("url"));
	}

	@Test
	public void initialize() {

		HomePage hp = new HomePage(driver);
		hp.getDepart().sendKeys("DAL");
		hp.getArrive().sendKeys("HOU");
		hp.getSearch().click();

	}

	@AfterMethod
	public void tearDown() {
		driver.close();
	}

}