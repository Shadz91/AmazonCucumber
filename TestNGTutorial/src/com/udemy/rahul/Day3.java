package com.udemy.rahul;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Day3 {
	@BeforeClass
	public void befoClas() {
		// Selenium
		System.out.println("Before executing any method in the class");
	}

	@Parameters({ "URL" })
	@Test
	public void webLoginCarLoan(String urlName) {
		// Selenium
		System.out.println("WebLoginCarLoan");
		System.out.println(urlName);
	}

	@BeforeMethod
	public void beforeEvery() {
		// Selenium
		System.out.println("I will execute Before Every Test Method in Day 3 class");
	}

	@AfterMethod
	public void afterEvery() {
		// Selenium
		System.out.println("I will execute After Every Test Method in Day 3 class");
	}

	@AfterClass
	public void afterClas() {
		// Selenium
		System.out.println("After executing all methods in the class");
	}

	@Test(groups = { "Smoke" })
	public void mobileLoginCarLoan() {
		// Appium
		System.out.println("MobileLoginCarLoan");
	}

	@BeforeSuite
	public void bfSuite() {
		System.out.println("I am the No 1");
	}

	@Test(enabled = false)
	public void mobileSigninCarLoan() {
		// Appium
		System.out.println("MobileSigninCarLoan");
	}

	@Test(dataProvider = "getData")
	public void mobileSignoutCarLoan(String username, String password) {
		// Appium
		System.out.println("MobileSignoutCarLoan");
		System.out.println(username);
		System.out.println(password);
	}

	@Test(dependsOnMethods = { "webLoginCarLoan", "mobileSignoutCarLoan" })
	public void apiCarLoan() {
		// REST API Automation
		System.out.println("LoginAPICarLoan");
	}

	@DataProvider
	public Object[][] getData() {
		Object data[][] = new Object[3][2];
		// 1st set
		data[0][0] = "firstUserName";
		data[0][1] = "firstPassword";

		// 2nd set
		data[1][0] = "secondUserName";
		data[1][1] = "secondPassword";

		// 3rd set
		data[2][0] = "thirdUserName";
		data[2][1] = "thirdPassword";
		return data;
	}

}
