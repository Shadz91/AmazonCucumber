import java.io.FileInputStream;

import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataDriven {

	public static ArrayList<String> getData(String testCaseName) throws Exception {

		ArrayList<String> list = new ArrayList<String>();
		FileInputStream fis = new FileInputStream("C:\\Users\\M1036018\\Documents\\Selenium_Udemy\\DataDemo.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);

		int sheets = workbook.getNumberOfSheets();

		for (int i = 0; i < sheets; i++) {
			if (workbook.getSheetName(i).equalsIgnoreCase("TestData")) {

				XSSFSheet sheet = workbook.getSheetAt(i);

				Iterator<Row> rows = sheet.iterator(); // sheet --> collection
														// of
														// rows

				Row firstRow = rows.next();

				Iterator<Cell> cell = firstRow.cellIterator(); // row-->collection
																// of
																// cells

				int k = 0;
				int column = 0;

				while (cell.hasNext()) {

					Cell value = cell.next();

					if (value.getStringCellValue().equalsIgnoreCase("TestCases")) {
						column = k;
					}
					k++;

				}
				// System.out.println(column);

				while (rows.hasNext()) {

					Row r = rows.next();

					if (r.getCell(column).getStringCellValue().equalsIgnoreCase(testCaseName)) {

						Iterator<Cell> cellValue = r.cellIterator();

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
