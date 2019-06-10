package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RediffHomePage {

	WebDriver driver;

	public RediffHomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[@id='srchword']")
	private WebElement search;

	@FindBy(xpath = "//*[@value='Search']")
	private WebElement submit;

	public WebElement SearchBox() {
		return search;
	}

	public WebElement SubmitButton() {
		return submit;
	}

}