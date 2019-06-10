package revision;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class StaticDropDown {

	@Test
	public void x() {

		WebDriver driver = new ChromeDriver();
		driver.get("http://qaclickacademy.com/practice.php");

		Select dropDown = new Select(driver.findElement(By.cssSelector("#dropdown-class-example")));

		//dropDown.selectByIndex(1);
		//dropDown.selectByValue("option2");
		dropDown.selectByVisibleText("Option3");

	}

}
