package stepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.HomePage;
import resources.Base;

public class Steps extends Base {

	public HomePage hp;

	@Given("^Initialize the browser with Chrome$")
	public void initialize_the_browser_with_chrome() throws Throwable {
		System.out.println("hi");
		driver = initializeBrowser();
	}

	@When("^User enters (.+)$")
	public void user_enters(String username) throws Throwable {
		hp = new HomePage(driver);
		hp.emailBox().sendKeys(username);
	}

	@And("^enters (.+)$")
	public void enters(String password) throws Throwable {
		hp.passBox().sendKeys(password);
	}

	@Then("^Verify that User is successfully logged in$")
	public void verify_that_user_is_successfully_logged_in() throws Throwable {
		hp.loginButton().click();
	}

	@And("^Navigate to (.+) Site$")
	public void navigate_to_site(String site) throws Throwable {
		driver.get(site);
	}

	@And("^close all browsers$")
	public void close_all_browsers() throws Throwable {
		driver.quit();
	}
}
