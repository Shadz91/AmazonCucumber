package revision;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class AllMethods {

	@Test
	public void x() {

		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.google.co.in/");

		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		driver.getPageSource();

		driver.navigate().forward();
		driver.navigate().back();
		driver.navigate().refresh();

		driver.findElement(By.id("123"));

		driver.close();
		driver.quit();

	}
}
