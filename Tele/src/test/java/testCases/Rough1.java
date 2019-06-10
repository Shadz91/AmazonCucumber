package testCases;

import java.io.File;

import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

public class Rough1 {

	@Test
	public static void x() throws Exception {

		DesiredCapabilities cap = DesiredCapabilities.chrome();

		cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);

		ChromeOptions c = new ChromeOptions();

		c.merge(cap);

		WebDriver driver = new ChromeDriver(c);

		driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_select");

		driver.switchTo().frame(0);
		driver.switchTo().defaultContent();

		List<WebElement> list = driver.findElements(By.tagName("a"));
		String newTab = Keys.chord(Keys.CONTROL, Keys.ENTER);

		for (int i = 0; i < list.size(); i++) {
			list.get(i).sendKeys(newTab);
		}

		driver.findElement(By.id("")).getAttribute("value");

		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File src = screenshot.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("C://screenshot.png"));

	}
}