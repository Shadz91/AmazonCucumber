package testCases;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import resources.Base;

public class Practice extends Base {

	@Parameters({ "urlName" })
	@Test(groups = { "Smoke" })
	public void gr(String urlName) throws Exception {
		System.out.println(urlName);
	}

	@Test(priority = 1)
	public void pr(String urlName) throws Exception {
		System.out.println(urlName);
	}

	@Test()
	public void rem() throws Exception {
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setBrowserName("chrome");
		dc.setPlatform(Platform.WINDOWS);
	}

	@Test(enabled = false)
	public void x() throws Exception {
		driver = initializeBrowser();
		driver.findElement(By.name("q")).sendKeys("Selenium");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", driver.findElement(By.name("btnK")));

		js.executeScript("window.scrollBy(0,500)");
	}

	@Test(enabled = false)
	public void y() throws Exception {
		driver = initializeBrowser();
		driver.get("https://www.bing.com/");
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("return document.getElementById('scpl1').click();");
	}

	@Test(enabled = false)
	public void z() throws Exception {
		driver = initializeBrowser();
		driver.navigate().to("https://www.bing.com/");
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("return arguments[0].setAttribute('style','visibility:visible;')",
				driver.findElement(By.id("scpc1")));

		js.executeScript("return document.getElementById('scpc1').setAttribute('style','visibility:visible;')");
	}

	@Test(enabled = false)
	public void robo() throws Exception {
		Robot robot = new Robot();

		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
	}

	@Test(enabled = false)
	public void act() throws Exception {
		driver = initializeBrowser();

		Actions builder = new Actions(driver);
		builder.moveToElement(null).keyDown(Keys.SHIFT).sendKeys("hello").keyUp(Keys.SHIFT).build().perform();
		builder.keyDown(Keys.ENTER).build().perform();
		builder.moveToElement(null).doubleClick().contextClick().build().perform();
	}

	@Test(enabled = false)
	public void sel() throws Exception {
		driver = initializeBrowser();

		Select dropDown = new Select(driver.findElement(By.id("")));
		dropDown.selectByValue(null);
		dropDown.selectByVisibleText(null);
		dropDown.selectByIndex(0);
	}

	@Test(enabled = false)
	public void ale() throws Exception {
		driver = initializeBrowser();

		driver.switchTo().alert().accept();
		driver.switchTo().alert().dismiss();
		driver.switchTo().alert().sendKeys(null);
		driver.switchTo().alert().getText();
	}

	@Test(enabled = false)
	public void fra() throws Exception {
		driver = initializeBrowser();

		driver.switchTo().frame(0);
		driver.switchTo().frame("");
		driver.switchTo().frame(driver.findElement(By.id("")));
		driver.switchTo().defaultContent();
	}

	@Test(enabled = false)
	public void win() throws Exception {
		driver = initializeBrowser();

		String parentId = driver.getWindowHandle();
		Set<String> ids = driver.getWindowHandles();
		Iterator<String> it = ids.iterator();

		while (it.hasNext()) {
			driver.switchTo().window(it.next());
		}

	}

	@Test(enabled = false)
	public void key() throws Exception {
		driver = initializeBrowser();

		driver.findElement(By.id("")).sendKeys(Keys.ENTER);
		driver.findElement(By.id("")).sendKeys(Keys.SHIFT);
		String clickOnNewTab = Keys.chord(Keys.CONTROL, Keys.ENTER);

	}

	@Test()
	public void url() throws Exception {
		driver = initializeBrowser();
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("Total number of links on the page = " + links.size());
		verifyBrokenLinks(links);
	}

	public void verifyBrokenLinks(List<WebElement> links) throws Exception {

		for (int i = 0; i < links.size(); i++) {
			URL url = new URL(links.get(i).getAttribute("href"));
			HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
			httpURLConnection.setConnectTimeout(3000);
			httpURLConnection.connect();

			if (httpURLConnection.getResponseCode() == 200) {
				System.out.println(links.get(i).getAttribute("href") + "   " + httpURLConnection.getResponseMessage());
			}
			if (httpURLConnection.getResponseCode() == httpURLConnection.HTTP_NOT_FOUND) {
				System.out.println(links.get(i).getAttribute("href") + "   " + httpURLConnection.getResponseMessage());
			}
		}

	}

}
