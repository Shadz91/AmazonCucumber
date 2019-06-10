package com.udemy.rahul;

import java.io.FileInputStream;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import org.testng.annotations.Test;

public class TestBase {
	WebDriver driver;

	@Test
	public void login() throws Exception {

		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\M1036018\\oxygen-workspace\\TestNGTutorial\\src\\com\\udemy\\rahul\\datadriven.properties");
		prop.load(fis);
		System.out.println(prop.getProperty("username"));

		if (prop.getProperty("browser").equals("chrome")) {
			driver = new ChromeDriver();
		} else if (prop.getProperty("browser").equals("firefox")) {
			driver = new FirefoxDriver();
		} else {
			driver = new InternetExplorerDriver();
		}

		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
	}
}