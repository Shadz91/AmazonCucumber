package demo;

import java.io.FileInputStream;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ValidateE2EFlow {

	public WebDriver driver;
	public Properties prop;
	public JavascriptExecutor js;

	@BeforeTest
	public void setUp() throws Exception {
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setBrowserName("chrome");
		dc.setPlatform(Platform.WINDOWS);
		// dc.setVersion(null);

		driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), dc);

		FileInputStream fis = new FileInputStream(
				"C:\\Users\\M1036018\\oxygen-workspace\\AtomTest\\src\\main\\java\\resources\\data.properties");
		prop = new Properties();
		prop.load(fis);
		// driver = new ChromeDriver();
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void grabSuccessMessage() throws Exception {
		js = (JavascriptExecutor) driver;
		Actions builder = new Actions(driver);

		driver.findElement(By.className("jss64")).sendKeys(prop.getProperty("username"));
		driver.findElement(By.xpath("//*[@class='jss64 jss67']")).sendKeys(prop.getProperty("password"));
		driver.findElement(By.xpath("//*[@class='jss133']")).click(); // LOGIN

		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.elementToBeClickable((By.xpath("//*[text()='Keep Going']")))).click();
		wait.until(ExpectedConditions.elementToBeClickable((By.xpath("//*[text()='PRACTICE']")))).click();
		driver.findElement(By.xpath("//*[@class='fal fa-paste']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[text()='Copy']")).click();

		driver.findElement(By.xpath("(//*[text()='print']/following-sibling::span[1])[2]")).click();
		builder.moveToElement(driver.findElement(By.xpath("//*[text()='print']/following-sibling::span[1]")))
				.sendKeys(Keys.RIGHT).sendKeys("'Shadab',").build().perform();
		driver.findElement(By.xpath("//*[text()='TRY IT']")).click();

		String id = driver.findElement(By.xpath("//*[@id='modalContainer']/div[2]")).getAttribute("id");
		String message = wait.until(
				ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='" + id + "']/div/div/div/div/div[2]")))
				.getText();
		System.out.println("Success Message = " + message);
		String expected = "Yess!! Code-run successful.";
		System.out.println("OUTPUT:\nRESULT\n" + driver
				.findElement(By.xpath("//*[text()='Shadab [10, 20, 30, 40, 50, 60, 70, 80, 90, 100]']")).getText());
		Assert.assertEquals(expected, message);
	}

	@AfterTest
	public void tearDown() {
		// driver.quit();
	}

}