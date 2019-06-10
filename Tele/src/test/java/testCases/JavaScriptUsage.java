package testCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class JavaScriptUsage {

	@Test
	public void x() {

		WebDriver driver = new ChromeDriver();
		driver.get("https://ksrtc.in/oprs-web/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		JavascriptExecutor js = (JavascriptExecutor) driver;

		String scriptToGetText = "return document.getElementById('fromPlaceName').value;";
		System.out.println("This is just a String ---> " + scriptToGetText);

		String getText = (String) js.executeScript(scriptToGetText);
		System.out.println(getText);

		String scriptToEnterText = "return document.getElementById('fromPlaceName').value='Kolkata';";
		js.executeScript(scriptToEnterText);

		String scriptToClick = "return document.getElementById('fromPlaceName').click();";
		js.executeScript(scriptToClick);

		js.executeScript("window.scrollBy(0,500)");

	}

}
