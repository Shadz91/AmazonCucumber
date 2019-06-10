package testCases;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ValidateTest {

	XSSFWorkbook workbook;

	@Test
	public void x() throws Exception {

		FileInputStream fis = new FileInputStream("C:\\Users\\M1036018\\Documents\\Selenium_Udemy\\TestData.xlsx");
		workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(3);

		Row row = sheet.createRow(1);
		row.createCell(0).setCellValue("go");
		sheet.getRow(1).createCell(6).setCellValue("oioi");

		FileOutputStream fout = new FileOutputStream(
				"C:\\\\Users\\\\M1036018\\\\Documents\\\\Selenium_Udemy\\\\new.xlsx");
		workbook.write(fout);

	}
}
