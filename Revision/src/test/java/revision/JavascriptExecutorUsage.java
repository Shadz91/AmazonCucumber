package revision;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

public class JavascriptExecutorUsage {

	@Test
	public void x() throws Exception {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://ksrtc.in/oprs-web/");

		JavascriptExecutor js = (JavascriptExecutor) driver;
		String script = "return document.getElementById('fromPlaceName').value='Shadab';";
		System.out.println(script);

		String text = (String) js.executeScript(script);
		System.out.println(text);

		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);

		ChromeOptions c = new ChromeOptions();
		c.merge(cap);

		Robot robot = new Robot();

		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);

		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);

		driver.manage().deleteAllCookies();
		driver.manage().addCookie(null);
		driver.manage().deleteCookieNamed(null);

	}

}
