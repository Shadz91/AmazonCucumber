package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

	public WebDriver driver; // driver --> No Life

	By sigin = By.cssSelector("[href*='sign_in']");
	By title = By.xpath("//*[text()='Featured Courses']");
	By navBar = By.xpath("//*[@class='nav navbar-nav navbar-right']");
	By popup = By.xpath("//*[text()='NO THANKS']");

	public LandingPage(WebDriver driver) // driver --> Has Life--> From TestCase
	{
		this.driver = driver;
	}

	public WebElement getLogin() // This method has this Object
	{
		return driver.findElement(sigin);
	}

	public WebElement getTitle() {
		return driver.findElement(title);
	}

	public WebElement getNavigationBar() {
		return driver.findElement(navBar);
	}

	public int getPopUpSize() {
		return driver.findElements(popup).size();
	}

	public WebElement getPopUp() {
		return driver.findElement(popup);
	}

}