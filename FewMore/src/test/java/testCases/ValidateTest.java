package testCases;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import resources.Base;

public class ValidateTest extends Base {

	@Test
	public void x() throws Exception {
		driver = initializeBrowser();
		HomePage homePage = new HomePage(driver);
		homePage.box().sendKeys("Shadab Ahmed");
	}

	@Test
	public void y() throws Exception {
		HomePage homePage = new HomePage(driver);
		driver = initializeBrowser();
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(homePage.box())).click();
	}

}
