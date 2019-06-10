package testCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ValidateTableSum {

	int columnIndex;
	double dataDouble;
	double sum;

	@Test
	public void x() {

		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://demo.guru99.com/test/web-table-element.php");

		int rows = driver.findElements(By.xpath("//*[@class='dataTable']/tbody/tr")).size();
		int cols = driver.findElements(By.xpath("//*[@class='dataTable']/thead/tr/th")).size();

		for (int i = 1; i <= cols; i++) {
			String columnName = driver.findElement(By.xpath("//*[@class='dataTable']/thead/tr/th[" + i + "]"))
					.getText();
			if (columnName.equalsIgnoreCase("Prev Close (Rs)")) {
				columnIndex = i;
			}
		}

		for (int i = 1; i <= rows; i++) {
			String data = driver
					.findElement(By.xpath("//*[@class='dataTable']/tbody/tr[" + i + "]" + "/td[" + columnIndex + "]"))
					.getText();
			dataDouble = Double.parseDouble(data);
			sum = sum + dataDouble;
		}

		System.out.println("Total Prev Close (Rs) = " + sum);

	}
}