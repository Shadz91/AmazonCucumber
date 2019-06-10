package demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ValidateDataBase {

	private Connection connection;
	public WebDriver driver;

	@BeforeClass
	public void setUp() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/epic", "root", "root");
	}

	@Test
	public void getData() throws SQLException {
		int id;
		String name = "";
		String country = "";
		Statement statement = connection.createStatement();

		int rows = statement.executeUpdate("Update country set name='Amit' where id = 10");
		System.out.println("Rows impacted : " + rows);

		ResultSet rs = statement.executeQuery("select * from country");

		while (rs.next()) {
			id = rs.getInt(1);
			name = rs.getString(2);
			country = rs.getString(3);
			System.out.println(id + "\t" + name + "\t" + country);
		}

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.google.co.in/");
		driver.findElement(By.name("q")).sendKeys(name);

	}

	@AfterClass
	public void tearDown() throws SQLException {
		connection.close();
		driver.close();
	}

}
