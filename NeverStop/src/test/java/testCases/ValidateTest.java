package testCases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import resources.Base;

public class ValidateTest extends Base {

	@Test(dataProvider = "pullData")
	public void x(String username, String password) {
		System.out.println(username + "      " + password);
	}

	@DataProvider(name = "pullData")
	public Object[][] getData() throws Exception {
		Object[][] data = fetchData("C:\\Users\\M1036018\\Documents\\Selenium_Udemy\\TestData.xlsx", "Sheet1");
		return data;
	}

}