package com.shadab.revision;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class RefreshPage {

	WebDriver driver;

	@BeforeTest(groups = { "Smoke" })
	public void setUp() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.google.com/");
	}

	@Test(groups = { "Methods" })
	public void usingGetCurrentUrl() {
		driver.get(driver.getCurrentUrl());
	}

	@Test(groups = { "Methods" })
	public void usingNavigate() {
		driver.navigate().refresh();
	}

	@Test(groups = { "Methods" })
	public void usingsendKeysF5() {
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.F5);
	}

	@Test(groups = { "Methods" })
	public void usingsendKeysControlR() {
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, "r");
	}

	@Test(groups = { "Methods" })
	public void usingsendKeysChord() {
		String refresh = Keys.chord(Keys.CONTROL, "r");
		driver.findElement(By.cssSelector("body")).sendKeys(refresh);
	}

	@Test(groups = { "Actions" })
	public void usingActionsClass() {
		Actions builder = new Actions(driver);
		builder.keyDown(Keys.CONTROL).sendKeys("r").keyUp(Keys.CONTROL).build().perform();
	}

	@Test(groups = { "Action" })
	public void usingActionsClassF5() {
		Actions builder = new Actions(driver);
		builder.keyDown(Keys.F5).keyUp(Keys.F5).build().perform();
	}

	@Test(groups = { "Robot" })
	public void usingRobotClass() throws AWTException {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_R);
		robot.keyRelease(KeyEvent.VK_R);
		robot.keyRelease(KeyEvent.VK_CONTROL);
	}

	@Test(groups = { "Robot" })
	public void usingRobotClassF5() throws AWTException {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_F5);
		robot.keyRelease(KeyEvent.VK_F5);
	}

	@AfterTest(groups = { "Smoke" })
	public void tearDown() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
	}
}
