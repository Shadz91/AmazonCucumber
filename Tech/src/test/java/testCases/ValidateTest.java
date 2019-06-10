package testCases;

import org.testng.annotations.Test;

import pageObjects.HomePage;
import resources.Base;

public class ValidateTest extends Base {

	@Test
	public void xyz() throws Exception {

		driver = initializeBrowser();
		driver.get(prop.getProperty("url"));

		HomePage homePage = new HomePage(driver);
		System.out.println(homePage.grabText().getText());

	}

}
