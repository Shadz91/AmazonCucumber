package resources;

import java.io.File;
import java.io.FileInputStream;
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
				"C:\\Users\\M1036018\\oxygen-workspace\\AnotherFew\\src\\main\\java\\resources\\data.properties");
		Properties prop = new Properties();
		prop.load(fis);

		String browserName = prop.getProperty("browser");
		String url = prop.getProperty("url");

		if (browserName.equalsIgnoreCase("chrome"))
			driver = new ChromeDriver();

		driver.get(url);
		driver.manage().window().maximize();
		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		return driver;

	}

	public void getScreenshot(String result) throws Exception {
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File src = screenshot.getScreenshotAs(OutputType.FILE);
		File destn = new File("C://test/screenshot.png");
		FileUtils.copyFile(src, destn);
	}

	public Object[][] fetchData(String sheetName, String sheetpath) throws Exception {

		FileInputStream fis = new FileInputStream(sheetpath);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = null;
		Object[][] data = null;

		int n = workbook.getNumberOfSheets();

		for (int i = 0; i < n; i++) {
			sheet = workbook.getSheetAt(i);
			if (sheet.getSheetName().equalsIgnoreCase(sheetName)) {

				int rows = sheet.getLastRowNum();
				rows = rows + 1;
				int cols = sheet.getRow(0).getLastCellNum();

				data = new Object[rows][cols];

				for (int r = 0; r < rows; r++) {
					for (int c = 0; c < cols; c++) {
						Cell cell = sheet.getRow(r).getCell(c);
						switch (cell.getCellTypeEnum()) {
						case STRING:
							data[r][c] = cell.getStringCellValue();
							break;
						case NUMERIC:
							data[r][c] = NumberToTextConverter.toText(cell.getNumericCellValue());
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
