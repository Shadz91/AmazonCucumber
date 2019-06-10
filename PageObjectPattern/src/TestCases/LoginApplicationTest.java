package TestCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import objectRepository.RediffHomePage;
import objectRepository.RediffLoginPage;

public class LoginApplicationTest {

	@Test
	public void login() {

		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");

		RediffLoginPage rd = new RediffLoginPage(driver);

		rd.emailId().sendKeys("hello");
		rd.passwordBox().sendKeys("hi");
		// rd.submit().click();
		rd.homeClick().click();

		RediffHomePage rh = new RediffHomePage(driver);
		rh.SearchBox().sendKeys("rediff");
		rh.SubmitButton().click();
	}
}