package testCases;

import org.testng.annotations.Test;

public class PriorityTest {

	@Test(priority = -1)
	public void abc() {
		System.out.println(-1);
	}

	@Test
	public void def() {
		System.out.println(0);
	}

	@Test(priority = -4)
	public void ghi() {
		System.out.println(-4);
	}

	@Test(priority = 5)
	public void jkl() {
		System.out.println(5);
	}
}