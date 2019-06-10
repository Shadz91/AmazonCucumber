package testCases;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.testng.annotations.Test;

import com.gargoylesoftware.htmlunit.BrowserVersion;

public class HeadlessBrowser {

	@Test
	public void x() {

		WebDriver driver = new HtmlUnitDriver(BrowserVersion.FIREFOX_52);
		((HtmlUnitDriver) driver).setJavascriptEnabled(true);

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		driver.get("https://www.google.co.in/");
		System.out.println("Before = " + driver.getTitle());

		JavascriptExecutor js = (JavascriptExecutor) driver;

		driver.findElement(By.name("q")).sendKeys("bye");
		js.executeScript("document.getElementsByName('btnK')[0].click()", driver.findElement(By.name("btnK")));

		System.out.println("After = " + driver.getTitle());

		System.out.println("Text = " + driver.findElement(By.linkText("Images")).getText());

	}

}