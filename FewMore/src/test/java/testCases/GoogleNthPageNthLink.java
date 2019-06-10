package testCases;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleNthPageNthLink {

	public static void main(String args[]) throws Exception {
		click_nthPage_nthLink(20, 1);
	}

	public static void click_nthPage_nthLink(int p, int n) throws Exception {

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.co.in/");
		driver.manage().window().maximize();
		driver.findElement(By.name("q")).sendKeys("Selenium");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", driver.findElement(By.name("btnK")));

		List<WebElement> list_Pages = driver.findElements(By.xpath("//*[@valign='top']/td"));
		int count = 0;

		if (p <= 10) {
			list_Pages.get(p - 1).click();
			driver.findElements(By.tagName("h3")).get(n - 1).click();
		} else {
			while (count != 1) {
				driver.findElement(By.xpath("//*[text()='Next']")).click();
				count = driver.findElements(By.xpath("//*[text()='" + (p - 1) + "']")).size();
			}

			driver.findElement(By.xpath("//*[text()='" + (p - 1) + "']")).click();
			driver.findElements(By.tagName("h3")).get(n - 1).click();
		}

	}
}