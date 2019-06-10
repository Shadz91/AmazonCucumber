package testCases;

import java.awt.AWTException;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Ca {

	@Parameters({ "url" })
	@Test
	public void radioTest(String url) throws InterruptedException, AWTException, IOException {

		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

		DesiredCapabilities cap = DesiredCapabilities.chrome();
		cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);

		ChromeOptions c = new ChromeOptions();
		c.merge(cap);

		WebDriver driver = new ChromeDriver(c);
		driver.get("https://www.google.com/");

		/*
		 * TakesScreenshot screenshot = (TakesScreenshot) driver; File src =
		 * screenshot.getScreenshotAs(OutputType.FILE); FileUtils.copyFile(src,
		 * new File("C://scrn.png"));
		 */
		System.out.println(url);
	}

	@DataProvider
	public Object[][] xsc() {

		Object[][] data = new Object[2][2];

		data[0][0] = "us";
		data[0][1] = "pw";
		return data;

	}

	@Test(dataProvider = "getData")
	public void xc(String u, String pw) {
		System.out.println(u);
		System.out.println(pw);
	}

}
