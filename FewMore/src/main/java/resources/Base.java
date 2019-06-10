package resources;

import java.io.File;
import java.io.FileInputStream;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {

	public WebDriver driver;

	public WebDriver initializeBrowser() throws Exception {

		FileInputStream fis = new FileInputStream(
				"C:\\Users\\M1036018\\oxygen-workspace\\FewMore\\src\\main\\java\\resources\\data.properties");
		Properties prop = new Properties();
		prop.load(fis);

		String browserName = prop.getProperty("browser");
		if (browserName.equalsIgnoreCase("chrome"))
			driver = new ChromeDriver();

		driver.get(prop.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		return driver;

	}

	public void getScreenshot(String result) throws Exception {
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File src = screenshot.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("C://test//" + result + "screenshot.png"));
	}

}
