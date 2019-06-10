package testCases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import resources.Base;

public class ValidateReadTest extends Base {

	@Test(dataProvider = "testData")
	public void xyz(String user, String pass) throws Exception {
		System.out.println(user + "        " + pass);
	}

	@DataProvider(name = "testData")
	public Object[][] fetchData() throws Exception {
		Object[][] data = getData("Sheet1");
		return data;
	}

}
