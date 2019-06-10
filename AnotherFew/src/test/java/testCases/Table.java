package testCases;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import resources.Base;

public class Table extends Base {

	@Test
	public void x() throws Exception {

		driver = initializeBrowser();
		driver.get("http://demo.guru99.com/test/web-table-element.php");

		int rows = driver.findElements(By.xpath("//*[@class='dataTable']/tbody/tr")).size();
		int cols = driver.findElements(By.xpath("//*[@class='dataTable']/thead/tr/th")).size();

		System.out.println("Rows = " + rows);
		System.out.println("Cols = " + cols);

		int rowIndex = 0;
		for (int i = 1; i <= rows; i++) {
			String company = driver.findElement(By.xpath("//*[@class='dataTable']/tbody/tr[" + i + "]" + "/td[1]"))
					.getText();
			if (company.equalsIgnoreCase("NCC")) {
				rowIndex = i;
				System.out.println("RowIndex = " + rowIndex);
			}
		}

		System.out.println("% Change = "
				+ driver.findElement(By.xpath("//*[@class='dataTable']/tbody/tr[" + rowIndex + "]/td[5]")).getText());

	}

}
