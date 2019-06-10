package resources;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Base {

	public Object[][] fetchData(String path, String sheetName) throws Exception {

		FileInputStream fis = new FileInputStream(path);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = null;

		int n = workbook.getNumberOfSheets();

		for (int i = 0; i < n; i++) {
			if (workbook.getSheetName(i).equalsIgnoreCase(sheetName))
				sheet = workbook.getSheetAt(i);
		}

		int rows = sheet.getLastRowNum();
		rows++;
		int cols = sheet.getRow(0).getLastCellNum();
		Object[][] data = new Object[rows][cols];

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

		return data;

	}
}