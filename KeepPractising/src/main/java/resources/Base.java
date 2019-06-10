package resources;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Base {

	XSSFWorkbook workbook;
	XSSFSheet sheet;
	Object[][] data;
	int row;
	int col;

	public void writeData(String pathToExcel) throws Exception {

		workbook = new XSSFWorkbook();
		sheet = workbook.createSheet("Sheet_1");
		Row r1 = sheet.createRow(0);
		r1.createCell(0).setCellValue("one");
		r1.createCell(1).setCellValue("two");
		r1.createCell(2).setCellValue("three");
		r1.createCell(3).setCellValue("four");
		r1.createCell(4).setCellValue("five");

		FileOutputStream fos = new FileOutputStream(pathToExcel);
		workbook.write(fos);

	}

	public void writeListDataVertical(String pathToExcel) throws Exception {

		String arr[] = { "six", "seven", "eight", "nine", "ten" };
		List<String> list = Arrays.asList(arr);
		Iterator<String> it = list.iterator();

		workbook = new XSSFWorkbook();
		sheet = workbook.createSheet("Sheet_2");
		int rowNum = 2;

		while (it.hasNext()) {
			Row r2 = sheet.createRow(rowNum);
			rowNum = rowNum + 1;
			r2.createCell(0).setCellValue(it.next());
		}

		FileOutputStream fos = new FileOutputStream(pathToExcel);
		workbook.write(fos);

	}

	public void writeListDataHorizontal(String pathToExcel) throws Exception {

		String arr[] = { "eleven", "twelve", "thirteen", "fourteen", "fifteen" };
		List<String> list = Arrays.asList(arr);
		Iterator<String> it = list.iterator();

		workbook = new XSSFWorkbook();
		sheet = workbook.createSheet("Sheet_3");
		Row r3 = sheet.createRow(8);
		int colNum = 0;

		while (it.hasNext()) {
			r3.createCell(colNum).setCellValue(it.next());
			colNum = colNum + 1;
		}

		FileOutputStream fos = new FileOutputStream(pathToExcel);
		workbook.write(fos);

	}

	public Object[][] getData(String sheetName) throws Exception {

		FileInputStream fis = new FileInputStream("C:\\Users\\M1036018\\Documents\\Selenium_Udemy\\TestData.xlsx");
		workbook = new XSSFWorkbook(fis);

		int count = workbook.getNumberOfSheets();
		System.out.println("Total number of Sheets = " + count);

		for (int i = 0; i < count; i++) {

			sheet = workbook.getSheetAt(i);

			if (sheet.getSheetName().equalsIgnoreCase(sheetName)) {
				row = sheet.getLastRowNum();
				row = row + 1;
				col = sheet.getRow(0).getLastCellNum();

				System.out.println("Total number of Rows = " + row);
				System.out.println("Total number of Columns = " + col);
				System.out.println();

				data = new Object[row][col];

				for (int x = 0; x < row; x++) {
					for (int y = 0; y < col; y++) {
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
