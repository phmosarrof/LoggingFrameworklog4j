package Utilities;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Dynamic_Table_Handle {
	public static WebDriver driver = null;

	@BeforeTest
	public void setup() throws Exception {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Mosarrof Hossain\\Utilities\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	@Test(priority = 1)
	public void handle_Dynamic_Webtable() throws InterruptedException {

		driver.get("http://only-testing-blog.blogspot.in/2014/05/form.html");
		WebElement mytable = driver.findElement(By.xpath("//table[@border='1']"));

		// To locate rows of the table
		List<WebElement> rows_table = mytable.findElements(By.tagName("tr"));

		// To count no of rows in table.
		int rows_count = rows_table.size();

		// Loop will execute till the last row of table.
		for (int row = 0; row < rows_count; row++) {

			// To locate columns(cells) of that specific row.
			List<WebElement> Columns_row = rows_table.get(row).findElements(By.tagName("td"));

			// To count no of columns(cells) in that specific row.
			int columns_count = Columns_row.size();

			System.out.println("Number of cells in Row " + row + " are " + columns_count);

			// Loop will execute till the last cell of that specific row.

			for (int column = 0; column < columns_count; column++) {
				// To retrieve text from that specific cell.
				String celltext = Columns_row.get(column).getText();
				System.out.println(
						"Cell Value Of row number " + row + " and column number " + column + " Is " + celltext);
			}
			System.out.println("--------------------------------------");
		}
	}

	@AfterTest
	public void tearDown() throws Exception {
		driver.quit();
	}
}