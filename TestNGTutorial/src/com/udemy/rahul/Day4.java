package com.udemy.rahul;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Day4 {
	@Parameters({ "URL", "username" })
	@Test
	public void webLoginHomeLoan(String urlName, String userName) {
		// Selenium
		System.out.println(urlName);
		System.out.println(userName);
	}

	@Test(groups = { "Smoke" })
	public void mobileLoginHomeLoan() {
		// Appium
		System.out.println("MobileLoginHomeLoan");
	}

	@Test
	public void loginApiHomeLoan() {
		// REST API Automation
		System.out.println("LoginAPIHomeLoan");
	}

}