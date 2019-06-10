package revision;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.Test;

public class Radio {

	@Test
	public void x() {

		WebDriver driver = new ChromeDriver();
		driver.get("http://qaclickacademy.com/practice.php");

		List<WebElement> list = driver.findElements(By.name("radioButton"));
		int count = list.size();

		for (int i = 0; i < count; i++) {

			String text = list.get(i).getAttribute("value");

			if (text.equalsIgnoreCase("radio2")) {
				list.get(i).click();
			}

		}

	}
}
