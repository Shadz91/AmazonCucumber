package revision;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Rough {

	@Test
	public void x() {

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.co.in/");

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		Actions builder = new Actions(driver);
		builder.moveToElement(null).contextClick().doubleClick().keyDown(Keys.SHIFT).sendKeys("hello").keyUp(Keys.SHIFT)
				.build().perform();

		driver.findElement(By.name("q")).sendKeys(Keys.SHIFT, "hello");

	}
}
