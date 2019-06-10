package testCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class RadioButtonsTest {
	@Test
	public void radioTest() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://ksrtc.in/oprs-web/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		WebDriverWait wait = new WebDriverWait(driver, 20);
		// wait.until(ExpectedConditions.elementToBeClickable(By.id("fromPlaceName"))).click();

		JavascriptExecutor js = (JavascriptExecutor) driver;
		// js.executeScript("arguments[0].click()",
		// driver.findElement(By.id("fromPlaceName")));

		System.out.println(js.executeScript("return document.getElementById('fromPlaceName').value;"));
		WebElement element = driver.findElement(By.id("fromPlaceName"));

		Actions builder = new Actions(driver);
		Action action = builder.moveToElement(element).contextClick().build();
		action.perform();

		builder.keyDown(Keys.SHIFT).sendKeys("hello").keyUp(Keys.SHIFT);

		element.sendKeys(Keys.SHIFT, "hello");
		element.sendKeys(Keys.ENTER);

	}
}