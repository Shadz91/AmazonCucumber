package testCases;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ActionsClassUsageRobotClass {

	@Test
	public void x() throws Exception {

		WebDriver driver = new ChromeDriver();

		Actions builder = new Actions(driver);

		builder.moveToElement(null).click().contextClick().doubleClick().build().perform();

		builder.keyDown(Keys.SHIFT).sendKeys("hello").keyUp(Keys.SHIFT).build().perform();

		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);

		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);

	}

}
