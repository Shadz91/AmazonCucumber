import java.io.FileInputStream;

import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class CopyDataDriven {
	public static ArrayList<String> getData(String sheetName, String TestCase) throws Exception {

		ArrayList<String> list = new ArrayList<String>();
		FileInputStream fis = new FileInputStream("C:\\Users\\M1036018\\Documents\\Selenium_Udemy\\DataDemo.xlsx");

		XSSFWorkbook workbook = new XSSFWorkbook(fis);

		int count = workbook.getNumberOfSheets();

		for (int i = 0; i < count; i++) {

			if (workbook.getSheetName(i).equalsIgnoreCase(sheetName)) {

				XSSFSheet sheet = workbook.getSheetAt(i);

				Iterator<Row> rows = sheet.iterator(); // Traverse rows
				Row firstRow = rows.next();

				int k = 0;
				int column = 0;
				Iterator<Cell> cell = firstRow.cellIterator(); // Traverse cells
				Cell ce = cell.next();

				if (ce.getStringCellValue().equalsIgnoreCase("TestCases")) // Identify_TestCases_Column
				{
					column = k;
				}
				k++;

				while (rows.hasNext()) {

					Row row = rows.next();

					if (row.getCell(column).getStringCellValue().equalsIgnoreCase(TestCase)) {
						Iterator<Cell> cellValue = row.cellIterator();

						while (cellValue.hasNext()) {

							Cell c = cellValue.next();

							if (c.getCellTypeEnum() == CellType.STRING) {
								list.add(c.getStringCellValue());
							} else {
								list.add(NumberToTextConverter.toText(c.getNumericCellValue()));
							}
						}
						break;
					}

				}

			}

		}

		return list;

	}
}
