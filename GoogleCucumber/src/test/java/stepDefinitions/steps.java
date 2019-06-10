package stepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.HomePage;
import resources.Base;

public class steps extends Base {
	@Given("^Initialize the browser with chrome browser$")
	public void initialize_the_browser_with_chrome_browser() throws Throwable {
		driver = initializeBrowser();
	}

	@Then("^Click on Search button$")
	public void click_on_search_button() throws Throwable {
		HomePage homePage = new HomePage(driver);
		homePage.clickButton();
	}

	@And("^close browser$")
	public void close_browser() throws Throwable {
		driver.quit();
	}

	@When("^Navigate to (.+) Sites$")
	public void navigate_to_site(String site) throws Throwable {
		driver.get(site);
	}

	@And("^Type in Field$")
	public void type_in_field() throws Throwable {
		HomePage homePage = new HomePage(driver);
		homePage.type().sendKeys("hi");
	}
}
