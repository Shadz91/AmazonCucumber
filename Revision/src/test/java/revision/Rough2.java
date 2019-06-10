package revision;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Rough2 {

	@Test
	public void x() {

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://www.google.co.in/");

		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(null)).click();

		driver.switchTo().frame(0);
		driver.switchTo().defaultContent();

		String click = Keys.chord(Keys.CONTROL, Keys.ENTER);

		driver.switchTo().alert().accept();
		driver.switchTo().alert().dismiss();
		driver.switchTo().alert().getText();
		driver.switchTo().alert().sendKeys(null);

		driver.switchTo().window(null);
		String parentWindow = driver.getWindowHandle();

		Set<String> ids = driver.getWindowHandles();
		Iterator<String> it = ids.iterator();

		while (it.hasNext()) {
			it.next();
		}

	}
}
