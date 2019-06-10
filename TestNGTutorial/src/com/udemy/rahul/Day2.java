package com.udemy.rahul;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Day2 {
	@Test(groups = { "Smoke" })
	public void personalLoan() {
		System.out.println("Like!!!");
	}

	@BeforeTest
	public void preRequisite() {
		System.out.println("I will Execute First");
	}
}
