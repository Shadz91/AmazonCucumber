package testCases;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Practice {

	WebElement element = null;
	

	@Test(groups = { "Smoke" })
	public void x() throws Exception {

		DesiredCapabilities cap = DesiredCapabilities.chrome();
		cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);

		ChromeOptions c = new ChromeOptions();
		c.merge(cap);

		WebDriver driver = new ChromeDriver(c);
		driver.get("https://www.google.co.in/");

		driver.manage().deleteAllCookies();
		driver.manage().addCookie(null);
		driver.manage().deleteCookieNamed(null);

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		// js.executeScript("arguments[0].click();", element);
		js.executeScript("document.getElementById('1').click();");

		WebDriverWait wait = new WebDriverWait(driver, 10);
		// wait.until(ExpectedConditions.elementToBeClickable(element)).click();

		Actions builder = new Actions(driver);
		// builder.moveToElement(element).build().perform();

		driver.findElement(By.xpath("//*[@name='q']")).sendKeys(Keys.SHIFT, "hello");
		builder.keyDown(Keys.SHIFT).sendKeys("hello").keyUp(Keys.SHIFT);

		By id=By.id("");
		
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);

		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcFile, new File("C://test.png"));

		String arr[] = { "one", "two", "three" };
		List<String> list = Arrays.asList(arr);
		Set<String> s = new HashSet<String>(list);

		FileInputStream fis = new FileInputStream("");
		Properties prop = new Properties();
		prop.load(fis);
		prop.getProperty("");

	}

	@Test(enabled = false)
	public void y() {

	}

	@Test(dependsOnMethods = { "y" })
	public void z() {

	}

	@Parameters("x")
	@Test
	public void xyz(String x) {
		System.out.println(x);
	}

}
