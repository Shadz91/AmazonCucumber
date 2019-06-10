package testCases;

import org.testng.annotations.Test;

import resources.Base;

public class ValidateWriteTest extends Base {

	@Test
	public void abc() throws Exception {
		writeData("C:\\Users\\M1036018\\Documents\\Selenium_Udemy\\WriteData.xlsx");
	}

}
