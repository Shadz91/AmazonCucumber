package revision;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class DragAndDrop {

	@Test
	public void x() {

		WebDriver driver = new ChromeDriver();
		driver.get("http://demo.guru99.com/test/drag_drop.html");

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		Actions builder = new Actions(driver);

		WebElement source = driver.findElement(By.xpath("//*[@id='credit2']/a"));
		WebElement target = driver.findElement(By.xpath("//*[@id='bank']/li"));

		builder.dragAndDrop(source, target).build().perform();

	}
}
