package objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RediffLoginPage {

	WebDriver driver;

	public RediffLoginPage(WebDriver driver) {
		this.driver = driver;
	}

	By username = By.xpath("//*[@id='login1']");
	By password = By.xpath("//*[@id='password']");
	By go = By.xpath("//*[@title='Sign in']");
	By home = By.xpath("//*[text()='Home']");

	public WebElement emailId() {
		return driver.findElement(username);
	}

	public WebElement passwordBox() {
		return driver.findElement(password);
	}

	public WebElement submit() {
		return driver.findElement(go);
	}

	public WebElement homeClick() {
		return driver.findElement(home);
	}
}
