package stepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import pageObjects.HomePage;
import resources.Base;
import cucumber.api.java.en.Then;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import cucumber.api.java.en.And;

public class stepDefinition extends Base {

	public HomePage hp;

	@Given("^I have Initialized the Browser with Chrome$")
	public void i_have_initialized_the_browser_with_chrome() throws Throwable {
		driver = initializeBrowser();
	}

	@When("^I enter (.+) in the searchBox$")
	public void i_enter_in_the_searchbox(String stringQuery) throws Throwable {
		hp = new HomePage(driver);
		hp.searchBoxBing().sendKeys(stringQuery);
	}

	@Then("^I get results$")
	public void i_get_results() throws Throwable {
		System.out.println("Success");
	}

	@And("^I navigate to (.+) Site$")
	public void navigate_to_site(String site) throws Throwable {
		driver.get(site);
	}

	@And("^Click on the Search button$")
	public void click_on_the_search_button() throws Throwable {
		hp.searchBoxBing().sendKeys(Keys.ENTER);
	}

	@And("^I quit browser$")
	public void i_quit_browser() throws Throwable {
		driver.quit();
	}
}
