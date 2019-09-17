package ExcelConnection;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.FileNotFoundException;

import java.util.Iterator;

public class DataDriven {

	static String ProjectPath;
	static String excelPath;
	static FileInputStream file;
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;
	static int sheetCount;

	public static void main(String[] args) throws IOException {

		ProjectPath = System.getProperty("user.dir");
		excelPath = ProjectPath + "/Excel/data.xlsx";

		file = new FileInputStream(excelPath);
		workbook = new XSSFWorkbook(file);
		sheetCount = workbook.getNumberOfSheets();

		for (int i = 0; i < sheetCount; i++) {

			if (workbook.getSheetName(i).equalsIgnoreCase("data")) {

				sheet = workbook.getSheetAt(i);

				Iterator<Row> rows = sheet.iterator();

				Row firstRow = rows.next();

				Iterator<Cell> cell = firstRow.cellIterator();

				int j = 0;
				int column = 0;

				while(cell.hasNext()) {

					Cell value = cell.next();
					{
						if (value.getStringCellValue().equalsIgnoreCase("ntame")){
							column = j;
						}
						j++;
					}
					System.out.println(column);
				}
			}
		}
	}
}