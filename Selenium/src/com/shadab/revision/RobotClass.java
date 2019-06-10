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
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RobotClass {
	WebDriver driver;

	@BeforeMethod(groups = { "Regression", "Sanity" })
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.google.com/");
		driver.findElement(By.name("q")).sendKeys("Selenium");
	}

	@Test(groups = { "Regression" })
	public void usingRobot() throws AWTException, InterruptedException {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(5000);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_T);
		robot.keyRelease(KeyEvent.VK_T);
		robot.keyRelease(KeyEvent.VK_CONTROL);
	}

	@Test(groups = { "Sanity" })
	public void usingChord() throws InterruptedException {
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		Thread.sleep(5000);
		String clickontab = Keys.chord(Keys.CONTROL, "t");
		driver.findElement(By.cssSelector("body")).sendKeys(clickontab);
	}

	@Test(groups = { "Sanity" })
	public void usingBuilder() throws InterruptedException {
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		Thread.sleep(5000);
		Actions builder = new Actions(driver);
		// builder.keyDown(Keys.ENTER).keyUp(Keys.ENTER).build().perform();
		builder.keyDown(Keys.CONTROL).sendKeys("t").keyUp(Keys.CONTROL).build().perform();
	}

	@AfterMethod(groups = { "Regression", "Sanity" })
	public void tearDown() throws InterruptedException {
		Thread.sleep(5000);
		driver.quit();
	}
}