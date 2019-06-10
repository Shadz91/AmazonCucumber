package testCases;

import java.awt.AWTException;
import java.util.List;

import javax.print.attribute.standard.Sides;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Frames {
	@Test
	public int radioTest() throws InterruptedException, AWTException {

		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://www.google.com/");

		By x = By.tagName("element");
		int i;
		List<WebElement> list = driver.findElements(By.tagName("iframe"));

		for (i = 0; i < list.size(); i++) {
			driver.switchTo().frame(i);
			if (driver.findElements(x).size() > 0) {
				break;
			}
			driver.switchTo().defaultContent();
		}
		return i;
	}
}