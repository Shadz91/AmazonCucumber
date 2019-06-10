package testCases;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GoogleTest {

	@Test
	public void radioTest() throws InterruptedException, AWTException {

		List<Integer> l = Arrays.asList(1, 2);

		// List<String> l = new ArrayList<>();

		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://www.google.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// driver.findElement(By.name("q")).sendKeys(Keys.SHIFT, "Selenium");

		Actions builder = new Actions(driver);
		builder.moveToElement(driver.findElement(By.name("q"))).keyDown(Keys.SHIFT).sendKeys("Selenium")
				.keyUp(Keys.SHIFT).build().perform();

		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		int c = driver.findElements(By.tagName("a")).size();
		System.out.println(c);

		Assert.assertEquals(driver.findElements(By.tagName("a")).size(), 187);
		Assert.assertTrue(true);
		Assert.assertFalse(false);

		Set<String> ids = driver.getWindowHandles();
		Iterator<String> x = ids.iterator();

		while (x.hasNext()) {
			x.next();
		}

		String p = x.next();
		String ch = x.next();

		driver.switchTo().window(p);
		driver.switchTo().frame(0);
		driver.switchTo().defaultContent();
/*
		// List<WebElement> l = driver.findElements(By.tagName("a"));
		for (int i = 0; i < l.size(); i++) {
			l.get(i).click();
		}

		String clk = Keys.chord(Keys.CONTROL, Keys.ENTER);
		for (int i = 0; i < l.size(); i++) {
			l.get(i).sendKeys(clk);
		}
*/
	}
}