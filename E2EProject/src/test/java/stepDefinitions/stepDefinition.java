package stepDefinitions;

import org.junit.Assert;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import pageObjects.PortalHomePage;
import resources.Base;

public class stepDefinition extends Base {

	@Given("^Initialize the browser with chrome$")
	public void initialize_the_browser_with_chrome() throws Throwable {
		driver = initializeBrowser();
	}

	@Given("^Navigate to \"([^\"]*)\" Site$")
	public void navigate_to_Site(String arg1) throws Throwable {
		driver.get(arg1);
	}

	@Given("^Click on Login link in home page to land on Secure sign in page$")
	public void click_on_Login_link_in_home_page_to_land_on_Secure_sign_in_page() throws Throwable {
		LandingPage l = new LandingPage(driver);
		if (l.getPopUpSize() > 0) {
			l.getPopUp().click();
		}
		l.getLogin().click();
	}

	@When("^User enters (.+) and (.+) and logs in$")
	public void user_enters_and_and_logs_in(String username, String password) throws Throwable {
		LoginPage lp = new LoginPage(driver);
		lp.getEmail().sendKeys(username);
		lp.getPassword().sendKeys(password);
		lp.getLogin().click();
	}

	@Then("^Verify that user is successfully logged in$")
	public void verify_that_user_is_successfully_logged_in() throws Throwable {
		PortalHomePage p = new PortalHomePage(driver);
		Assert.assertTrue(p.getsearchBox().isDisplayed());
	}

	@And("^close browsers$")
	public void close_browsers() throws Throwable {
		driver.quit();
	}

}
