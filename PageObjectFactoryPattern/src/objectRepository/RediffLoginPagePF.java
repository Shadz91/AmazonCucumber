package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RediffLoginPagePF {

	WebDriver driver;

	public RediffLoginPagePF(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[@id='login1']")
	private WebElement username;

	@FindBy(xpath = "//*[@id='password']")
	private WebElement password;

	@FindBy(xpath = "//*[text()='Home']")
	private WebElement home;

	public WebElement emailId() {
		return username;
	}

	public WebElement passwordBox() {
		return password;
	}

	public WebElement homeClick() {
		return home;
	}
}