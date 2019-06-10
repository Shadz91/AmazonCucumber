package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SelectFlightPage {

	public WebDriver driver;

	public SelectFlightPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	@FindBy(css = "#air-booking-product-2")
	private WebElement continueButton;

	@FindBy(xpath = "//*[@class='message message_alert message_error']")
	private WebElement error;

	public WebElement getContinue() {
		return continueButton;
	}

	public WebElement getError() {
		return error;
	}
}