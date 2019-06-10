package testCases;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class ValidateErrorTest {

	@Test
	public void setUp() {

		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get(null);
		driver.getTitle();
		driver.getPageSource();
		driver.getCurrentUrl();

		driver.navigate().forward();
		driver.navigate().back();
		driver.navigate().refresh();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.manage().deleteCookieNamed("");
		driver.manage().addCookie(null);

		driver.switchTo().window(null);
		driver.switchTo().frame(0);

		driver.close();
		driver.quit();

		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.presenceOfElementLocated(null));

	}

}
