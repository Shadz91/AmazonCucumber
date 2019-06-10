package testCases;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class WindowHandles {

	@Test
	public void x() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("");

		driver.getWindowHandle();

		Set<String> ids = driver.getWindowHandles();

		Iterator<String> it = ids.iterator();

		while (it.hasNext()) {
			it.next();
		}
	}

}
