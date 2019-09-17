package ExcelConnection;

import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	static XSSFWorkbook workbook;
	static int rowCount;
	static int colCount;
	static XSSFSheet sheet;
	static Object strData;
	static double numData;
	static DataFormatter formatter;
	static Object strDataObj;
	static XSSFCell cell;
	static String ProjectPath;

	public ExcelUtils(String excelPath, String sheetName) throws IOException {

		// ProjectPath = System.getProperty("user.dir");
		workbook = new XSSFWorkbook(excelPath);
		sheet = workbook.getSheet(sheetName);
		formatter = new DataFormatter();
	}

	public static void main(String[] args) throws IOException {

		System.out.print(getrowCount());
		System.out.print(getColCount());

	}

	public static int getrowCount() {

		rowCount = sheet.getPhysicalNumberOfRows();
		System.out.println("Row count : " + rowCount);
		return rowCount;
	}

	public static int getColCount() {
	
		colCount = sheet.getRow(0).getPhysicalNumberOfCells();
		System.out.println("Column count : " + colCount);
	
		return colCount;
	}

	// Any type of Data inside the excel sheet can be retrive by the method
	public static Object getExcellCellData(int rowNum, int colNum) {

		cell = sheet.getRow(rowNum).getCell(colNum);
		strDataObj = formatter.formatCellValue(cell);

		return strDataObj;
	}

	public static double getIntCellData(int rowNum, int colNum) {

		try {
			// strData = sheet.getRow(rowNum).getCell(colNum).getRichStringCellValue();
			numData = sheet.getRow(rowNum).getCell(colNum).getNumericCellValue();
			System.out.println("Numeric  Cell value " + numData);

		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		}
		return numData;
	}

}
