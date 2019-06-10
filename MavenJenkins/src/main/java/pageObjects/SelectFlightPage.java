package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SelectFlightPage {

	public WebDriver driver;

	public SelectFlightPage(WebDriver driver) {
		this.driver = driver;
	}

	By continueButton = By.cssSelector("#air-booking-product-2");
	By error = By.xpath("//*[@class='message message_alert message_error']");

	public WebElement getContinue() {
		return driver.findElement(continueButton);
	}

	public WebElement getError() {
		return driver.findElement(error);
	}

}
