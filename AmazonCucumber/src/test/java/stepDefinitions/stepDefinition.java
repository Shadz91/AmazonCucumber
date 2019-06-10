package stepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import pageObjects.HomePage;
import resources.Base;
import cucumber.api.java.en.Then;

import org.openqa.selenium.Keys;

import cucumber.api.java.en.And;

public class stepDefinition extends Base {
	@Given("^I initialize the browser with Chrome$")
	public void i_initialize_the_browser_with_chrome() throws Throwable {
		driver = initializeBrowser();
	}

	@When("^I enter (.+) in the search field$")
	public void i_enter_in_the_search_field(String search) throws Throwable {
		HomePage hp = new HomePage(driver);
		hp.searchtextboxAmazon().sendKeys(search);
		hp.searchtextboxAmazon().sendKeys(Keys.ENTER);
	}

	@Then("^the search is successful$")
	public void the_search_is_successful() throws Throwable {
		System.out.println("Successful");
	}

	@And("^I navigate to (.+) site$")
	public void i_navigate_to_site(String site) throws Throwable {
		driver.get(site);
	}

	@And("^i quit the browser$")
	public void i_quit_the_browser() throws Throwable {
		driver.quit();
	}
}
