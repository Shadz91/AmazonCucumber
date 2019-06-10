package testCases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Rough3 {

	@Test(enabled = false)
	public void x() {

	}

	@Test(groups = { "Smoke" })
	public void y() {
		System.out.println("NO");
	}

	@Parameters({ "url", "val" })
	@Test(groups = { "Smoke" })
	public void z(String url, String val) {
		System.out.println("YES");
		System.out.println(url);
		System.out.println(val);
	}

	/*@Test(dependsOnMethods = { "x", "y" })
	public void a() {
		System.out.println("YES");
	}*/

	@Test(timeOut = 40000)
	public void b() {
		System.out.println("YES");
	}

	@Test(dataProvider = "data")
	public void k(String user, String pw) {
		System.out.println(user);
		System.out.println(pw);
	}

	@DataProvider
	public Object[][] data() {
		Object[][] data = new Object[2][2];
		data[0][0] = "user1";
		data[0][0] = "pw1";
		data[0][0] = "user2";
		data[0][0] = "pw2";
		return data;
	}
}
