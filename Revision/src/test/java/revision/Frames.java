package revision;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.Test;

public class Frames {
	public static WebDriver driver;

	@Test
	public void x() {

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.google.co.in/");

	}

	public static int findFrameNumber(By by_xpath) {

		int frameCount = driver.findElements(By.tagName("iframe")).size();
		int i;
		int count;

		for (i = 0; i < frameCount; i++) {

			driver.switchTo().frame(i);
			count = driver.findElements(by_xpath).size();
			driver.switchTo().defaultContent();

			if (count > 0)
				break;

		}

		return i;

	}

}
