package ExcelConnection;

import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestNGDataProvider {
	static XSSFWorkbook workbook;
	static int rowCount;
	static int colCount;
	static XSSFSheet sheet;
	static Object strData;
	static double numData;
	static DataFormatter formatter;
	static Object strDataObj;
	static XSSFCell cell;
	static String excelPath;
	static String ProjectPath;
	static Object cellValue;
	static ExcelUtils excel;

	@Test(dataProvider = "Test01")
	public void testNgProvider(String Serial, String Name, String location, String Status) {

		//System.out.print(Serial + Name + location + Status);
	}

	@DataProvider(name = "Test01")
	public Object[][] getData() throws IOException {
		
		ProjectPath = System.getProperty("user.dir");
		excelPath = ProjectPath + "/Excel/data.xlsx";

		excel = new ExcelUtils(excelPath, "Sheet1");

		return UtilRunner.cellData(excelPath, "Sheet1");

	}

}
