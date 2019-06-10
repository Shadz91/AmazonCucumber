package demo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicTable {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.get("http://demo.guru99.com/test/web-table-element.php");
		driver.manage().window().maximize();

		List<WebElement> rows = driver.findElements(By.xpath("//*[@id='leftcontainer']/table/tbody/tr"));
		List<WebElement> cols = driver.findElements(By.xpath("//*[@id='leftcontainer']/table/thead/tr/th"));

		for (int i = 0; i < cols.size(); i++) {
			if (cols.get(i).getText().equalsIgnoreCase("Company")) {
				for (int j = 1; j <= rows.size(); j++) {
					if (driver
							.findElement(
									By.xpath("//*[@id='leftcontainer']/table/tbody/tr[" + j + "]/td[" + (i + 1) + "]"))
							.getText().equalsIgnoreCase("YES Bank Ltd.")) {
						System.out.println(
								driver.findElement(By.xpath("//*[@id='leftcontainer']/table/tbody/tr[" + j + "]/td[5]"))
										.getText());
					}
				}
			}
		}

	}

}
