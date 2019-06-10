package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {

	public WebDriver driver;

	public WebDriver initializeBrowser() throws Exception {

		FileInputStream fis = new FileInputStream(
				"C:\\Users\\M1036018\\oxygen-workspace\\Just\\src\\main\\java\\resources\\data.properties");
		Properties prop = new Properties();
		prop.load(fis);

		String browserName = prop.getProperty("browser");
		if (browserName.equalsIgnoreCase("chrome"))
			driver = new ChromeDriver();

		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;

	}

	public void getScreenshot(String result) throws Exception {
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File src = screenshot.getScreenshotAs(OutputType.FILE);
		File dest = new File("C://test//" + result + "//screenshot.png");
		FileUtils.copyFile(src, dest);
	}

	@SuppressWarnings("resource")
	public Object[][] excelData(String sheetName, String sheetPath) throws Exception {

		FileInputStream fis = new FileInputStream(
				"C:\\\\Users\\\\M1036018\\\\Documents\\\\Selenium_Udemy\\\\TestData.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = null;
		Object[][] data = null;

		int n = workbook.getNumberOfSheets();

		for (int i = 0; i < n; i++) {
			if (workbook.getSheetName(i).equalsIgnoreCase(sheetName)) {
				sheet = workbook.getSheetAt(i);

				int rows = sheet.getLastRowNum();
				rows = rows + 1;
				int cols = sheet.getRow(0).getLastCellNum();

				data = new Object[rows][cols];

				for (int x = 0; x < rows; x++) {
					for (int y = 0; y < cols; y++) {

						Cell cell = sheet.getRow(x).getCell(y);

						switch (cell.getCellTypeEnum()) {
						case STRING:
							data[x][y] = cell.getStringCellValue();
							break;
						case NUMERIC:
							data[x][y] = NumberToTextConverter.toText(cell.getNumericCellValue());
							break;
						default:
						}

					}
				}

			}
		}

		return data;

	}

}
