package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	public WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "email")
	private WebElement email;

	@FindBy(id = "pass")
	private WebElement pass;

	@FindBy(xpath = "//*[@value='Log In']")
	private WebElement login;

	public WebElement emailBox() {
		return email;
	}

	public WebElement passBox() {
		return pass;
	}

	public WebElement loginButton() {
		return login;
	}

}
