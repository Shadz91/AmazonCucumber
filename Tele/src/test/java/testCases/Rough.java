package testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Rough {

	@Test
	public static void x() {

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_select");

		Select dropDown = new Select(null);

		dropDown.selectByIndex(0);
		dropDown.selectByValue(null);
		dropDown.selectByVisibleText(null);

		Assert.assertTrue(2 > 1);
		Assert.assertFalse(1 > 2);
		Assert.assertEquals("", "");

	}

}
