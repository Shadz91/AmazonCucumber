package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Table {

	@Test
	public void run() {

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.toolsqa.com/automation-practice-table");

		for (int i = 1; i <= 6; i++) {

			String columnHeading = driver
					.findElement(By.xpath("//*[@class='tsc_table_s13']/thead/tr[1]/th" + "[" + i + "]")).getText();

			if (columnHeading.equalsIgnoreCase("Height")) {
				System.out.println(i + "th column");
				for (int j = 1; j <= 4; j++) {
					driver.navigate().refresh();
					String columnValue = driver
							.findElement(By
									.xpath("//*[@class='tsc_table_s13']/tbody/tr[" + j + "]" + "/td[" + (i - 1) + "]"))
							.getText();
					System.out.println(columnValue);
				}
				break;
			}

		}
		driver.close();
	}
}