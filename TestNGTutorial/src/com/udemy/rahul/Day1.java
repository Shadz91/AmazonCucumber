package com.udemy.rahul;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class Day1 {

	@AfterTest
	public void lastExecution() {
		System.out.println("I will Execute Last");
	}

	@Test
	public void testCaseOne() {
		System.out.println("hi");
		Assert.assertTrue(false);
	}

	@AfterSuite
	public void afSuite() {
		System.out.println("I am the No 1 from Last");
	}

	@Test
	public void testCaseTwo() {
		System.out.println("bye");
	}
}