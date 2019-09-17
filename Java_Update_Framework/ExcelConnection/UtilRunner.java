package ExcelConnection;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class UtilRunner {
	static String ProjectPath;
	static String excelPath;
	static Object[][] excelData;
	static Object cellValue;
	static ExcelUtils excel;

	public static void main(String[] args) throws IOException {

		ProjectPath = System.getProperty("user.dir");
		excelPath = ProjectPath + "/Excel/data.xlsx";

	/*	excel = new ExcelUtils(excelPath, "data");

		cellData(excelPath, "data");*/
	}

	// This method is to retrive the string value from the excel sheet

	public static Object[][] cellData(String excelPathName, String sheetName) throws IOException {

		int rowCount = excel.getrowCount();
		int colCount = excel.getColCount();

		excelData = new Object[rowCount-1][colCount];

		for (int i = 1; i < rowCount; i++) {
			for (int j = 0; j < colCount; j++) {

				cellValue = excel.getExcellCellData(i,j);

				excelData[i-1][j] = cellValue;

				System.out.print(excelData[i-1][j] + " | ");
			}

			System.out.println();
		}
		return excelData;

	}

}
