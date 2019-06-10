package testCases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import resources.Base;

public class ValidateTest extends Base {

	@Test
	public void x() throws Exception {
		driver = initializeBrowser();
		HomePage homePage = new HomePage(driver);
		homePage.departField().sendKeys("DAL");
	}

	@DataProvider(name = "pullData")
	public Object[][] getData() throws Exception {
		Object[][] data = excelData("Sheet1", "C:\\Users\\M1036018\\Documents\\Selenium_Udemy\\TestData.xlsx");
		return data;
	}

	@Test(dataProvider = "pullData")
	public void printConsole(String username, String password) {
		System.out.println(username + "   " + password);
	}

}
