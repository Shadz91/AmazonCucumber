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

	public static WebDriver driver;
	public Properties prop;

	public WebDriver initializeBrowser() throws Exception {

		FileInputStream fis = new FileInputStream(
				"C:\\Users\\M1036018\\oxygen-workspace\\Tech\\src\\main\\java\\resources\\data.properties");
		prop = new Properties();
		prop.load(fis);

		String browserName = prop.getProperty("browser");
		if (browserName.equalsIgnoreCase("chrome"))
			driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		return driver;

	}

	public void getScreenshot(String result) throws Exception {
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcFile, new File("C:\\test\\" + result + "screenshot.png"));
	}
}
