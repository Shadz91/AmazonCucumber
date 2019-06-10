package demo;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class RemoteTestNG {

	WebDriver driver;
	DesiredCapabilities dc;

	@Test
	public void x() throws Exception {
		dc = new DesiredCapabilities();
		dc.setBrowserName("chrome");
		dc.setPlatform(Platform.WINDOWS);
		// dc.setVersion(null);

		driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), dc);

		driver.get("https://google.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println(driver.getTitle());
		driver.close();
	}

	@Test
	public void y() throws Exception {
		dc = new DesiredCapabilities();
		dc.setBrowserName("firefox");
		dc.setPlatform(Platform.WINDOWS);
		// dc.setVersion(null);

		driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), dc);

		driver.get("https://bing.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println(driver.getTitle());
		driver.close();
	}

}
