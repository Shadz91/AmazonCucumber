package testCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ValidateTable {

	int columnIndex;

	@Test
	public void x() {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://demo.guru99.com/test/web-table-element.php");

		int cols = driver.findElements(By.xpath("//*[@class='dataTable']/thead/tr/th")).size();
		int rows = driver.findElements(By.xpath("//*[@class='dataTable']/tbody/tr")).size();
		System.out.println("Rows=" + rows);
		System.out.println("Columns=" + cols);

		for (int i = 1; i < cols; i++) {
			String col = driver.findElement(By.xpath("//*[@class='dataTable']/thead/tr/th[" + i + "]")).getText();
			if (col.equalsIgnoreCase("Company")) {
				columnIndex = i;
			}
		}

		for (int i = 1; i <= rows; i++) {
			String text = driver
					.findElement(By.xpath("//*[@class='dataTable']/tbody/tr[" + i + "]/td[" + columnIndex + "]"))
					.getText();
			if (text.equalsIgnoreCase("IDFC Bank")) {
				System.out.println(text);
				System.out.println(
						driver.findElement(By.xpath("//*[@class='dataTable']/tbody/tr[" + i + "]/td[5]")).getText());
				break;
			}
		}

	}

}
