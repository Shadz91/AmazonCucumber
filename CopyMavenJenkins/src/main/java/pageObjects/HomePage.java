package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

	public WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	By depart = By.cssSelector("#air-city-departure");
	By arrive = By.cssSelector("#air-city-arrival");
	By search = By.cssSelector("#jb-booking-form-submit-button");
	By textDepart = By.xpath("//*[text()='Depart']");
	By textArrive = By.xpath("//*[text()='Arrive']");

	public WebElement getDepart() {
		return driver.findElement(depart);
	}

	public WebElement getArrive() {
		return driver.findElement(arrive);
	}

	public WebElement getSearch() {
		return driver.findElement(search);
	}

	public WebElement getDepartText() {
		return driver.findElement(textDepart);
	}

	public WebElement getArriveText() {
		return driver.findElement(textArrive);
	}
}

/*
 * 1. Empty driver 2. Constructor 3. Locators 4. Methods
 */