package testCases;

import org.testng.annotations.Test;

import resources.Base;

public class ValidateWriteListVerticalTest extends Base {

	@Test
	public void def() throws Exception {
		writeListDataVertical("C:\\Users\\M1036018\\Documents\\Selenium_Udemy\\WriteData.xlsx");
	}

}
