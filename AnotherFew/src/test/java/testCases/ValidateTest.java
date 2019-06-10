package testCases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import resources.Base;

public class ValidateTest extends Base {

	@Test()
	public void x() throws Exception {
		driver = initializeBrowser();
		HomePage homePage = new HomePage(driver);
		homePage.departField().sendKeys("DAL");
		System.out.println("Value = " + homePage.departField().getAttribute("value"));
	}

	@DataProvider(name = "testData")
	public Object[][] readData() throws Exception {
		Object[][] data = fetchData("Sheet1", "C:\\Users\\M1036018\\Documents\\Selenium_Udemy\\TestData.xlsx");
		return data;
	}

	@Test(dataProvider = "testData")
	public void pullData(String username, String password) {
		System.out.println(username + " " + password);
	}

}
