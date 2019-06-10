package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;
import resources.Base;

public class GoogleNthPageNthLink extends Base {

	@Test
	public void abc() throws Exception {
		int n = 14;
		int l = 2;
		clickNthPageNthLink(n, l);
	}

	public void clickNthPageNthLink(int n, int l) throws Exception {
		driver = initializeBrowser();
		driver.findElement(By.name("q")).sendKeys("Selenium");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", driver.findElement(By.name("btnK")));

		if (n <= 10) {
			driver.findElements(By.xpath("//*[@valign='top']/td")).get(n).click();
			driver.findElements(By.tagName("h3")).get(l - 1).click();
		} else {
			while (!(driver.findElements(By.xpath("//*[text()='" + n + "']")).size() > 0)) {
				driver.findElement(By.xpath("//*[text()='Next']")).click();
			}

			driver.findElement(By.xpath("//*[text()='" + n + "']")).click();
			driver.findElements(By.tagName("h3")).get(l - 1).click();
		}
	}

}
