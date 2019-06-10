package demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class StaleElementReferenceExceptionHandle {

	public static void main(String args[]) {

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://www.freecrm.com/index.html");

		WebElement username = driver.findElement(By.name("username"));
		username.sendKeys("ShadabAhmed1991");

		WebElement password = driver.findElement(By.name("password"));
		password.sendKeys("Houston2020");

	}

}
