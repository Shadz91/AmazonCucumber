package demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class DynamicWebTableHandle {

	@Test
	public void xyz() {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://www.freecrm.com/index.html");
		driver.findElement(By.name("username")).sendKeys("ShadabAhmed1991");
		driver.findElement(By.name("password")).sendKeys("Houston2020");

		WebElement login = driver.findElement(By.xpath("//*[@class='btn btn-small']"));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", login);

		driver.switchTo().frame("mainpanel");

		driver.findElement(By.xpath("//*[text()='Contacts']")).click();

		String before_xpath = "//*[@id='vContactsForm']/table/tbody/tr[";
		String after_xpath = "]/td[2]/a";

		// Using Loop
		for (int i = 4; i <= 7; i++) {
			String name = driver.findElement(By.xpath(before_xpath + i + after_xpath)).getText();
			System.out.println(name);
			if (name.equalsIgnoreCase("test2 test2")) {
				System.out.println(i);
				driver.findElement(By.xpath("//*[@id='vContactsForm']/table/tbody/tr[" + i + "]/td[1]/input")).click();
			}
		}

		// Customized xpath
		driver.findElement(By.xpath("//*[text()='test2 test2']/parent::td/preceding-sibling::td/input")).click();

	}

}
