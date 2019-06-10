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

	@FindBy(name = "q")
	private WebElement searchBox;

	@FindBy(name = "btnK")
	private WebElement GoogleSearchBox;

	public WebElement type() {
		return searchBox;
	}

	public WebElement clickButton() {
		return GoogleSearchBox;
	}

}
