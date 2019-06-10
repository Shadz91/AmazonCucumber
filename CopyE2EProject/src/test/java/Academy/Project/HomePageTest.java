package Academy.Project;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeMethod;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.Base;

public class HomePageTest extends Base {

	public static Logger log = LogManager.getLogger(Base.class.getName());

	@BeforeMethod
	public void initialize() throws Exception {
		driver = initializeBrowser();
		driver.get(prop.getProperty("url"));
	}

	@Test(dataProvider = "getData")
	public void basePageNavigation(String userName, String password, String text) throws Exception {

		LandingPage l = new LandingPage(driver); // Passing Life
		l.getLogin().click();

		LoginPage lp = new LoginPage(driver); // Passing Life
		lp.getEmail().sendKeys(userName);
		lp.getPassword().sendKeys(password);
		lp.getLogin().click();
		// System.out.println(text);
		log.info(text);
	}

	@AfterMethod()
	public void tearDown() {
		driver.close();
		driver = null;
	}

	@DataProvider
	public Object[][] getData() {
		Object[][] data = new Object[2][3];

		data[0][0] = "non-restricted-user@qw.com";
		data[0][1] = "1234";
		data[0][2] = "Non Restricted User";

		data[1][0] = "restricted-user@qw.com";
		data[1][1] = "5678";
		data[1][2] = "Restricted User";

		return data;
	}

}