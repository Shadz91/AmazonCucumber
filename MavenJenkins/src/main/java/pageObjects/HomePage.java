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

	public WebElement getDepart() {
		return driver.findElement(depart);
	}

	public WebElement getArrive() {
		return driver.findElement(arrive);
	}

	public WebElement getSearch() {
		return driver.findElement(search);
	}

}
