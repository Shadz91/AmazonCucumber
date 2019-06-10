package objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RediffHomePage {

	WebDriver driver;

	public RediffHomePage(WebDriver driver) {
		this.driver = driver;
	}

	By search = By.xpath("//*[@id='srchword']");
	By submit = By.xpath("//*[@value='Search']");

	public WebElement SearchBox() {
		return driver.findElement(search);
	}

	public WebElement SubmitButton() {
		return driver.findElement(submit);
	}

}
