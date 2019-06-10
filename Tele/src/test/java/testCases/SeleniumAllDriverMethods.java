package testCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class SeleniumAllDriverMethods {

	@Test
	public void x() {

		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("");
		driver.getPageSource();
		driver.getTitle();
		driver.getCurrentUrl();
		driver.getWindowHandle();
		driver.getWindowHandles();

		driver.navigate().forward();
		driver.navigate().back();
		driver.navigate().refresh();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.manage().deleteCookieNamed("");
		driver.manage().addCookie(null);

		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(null)).click();

		driver.switchTo().window(null);
		driver.switchTo().frame(0);
		driver.switchTo().alert();

		driver.findElement(By.id(null)).sendKeys(Keys.ENTER);
		driver.findElement(By.id(null)).sendKeys(Keys.SHIFT);

		driver.close();
		driver.quit();

	}
}
