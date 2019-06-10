package demo;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class RemoteTestNGPractice {

	public WebDriver driver;
	DesiredCapabilities dc;
	String url;

	@BeforeMethod
	public void beforeMethod() {
		url = "http://192.168.1.7:4444/wd/hub";
		dc = new DesiredCapabilities();
	}

	@Parameters("browserName")
	@Test
	public void browserTest(String browserName) throws MalformedURLException {
		dc.setBrowserName(browserName);
		dc.setPlatform(Platform.WINDOWS);
		driver = new RemoteWebDriver(new URL(url), dc);
		driver.get("https://www.google.com/");
		System.out.println(driver.getTitle() + "--->" + browserName);
	}

	@AfterMethod
	public void aftermethod() {
		driver.close();
	}

}
