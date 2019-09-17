package Utilities;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Web_Data_Table_Cucumber {

	public static WebDriver driver;

	Web_Data_Table_Cucumber() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Mosarrof Hossain\\Utilities\\chromedriver.exe");
		driver = new ChromeDriver();

	}

	@Given("^I go to ToolsQA page$")
	public void i_go_to_ToolsQA_page() throws Throwable {

		driver.get("https://www.toolsqa.com/selenium-webdriver/handle-dynamic-webtables-in-selenium-webdriver/");
	}

	@When("^I see ToolsQA webtable page$")
	public void i_see_ToolsQA_webtable_page() throws Throwable {
	}

	@Then("^I verified the ToolsQA table default$")
	public void i_verified_the_ToolsQA_table_default(DataTable data) throws Throwable {

		List<List<String>> celldata = data.raw();

		System.out.println(celldata.get(0).get(0));
		System.out.println(driver
				.findElement(
						By.xpath("//*[@id=\"post-2924\"]/div[1]/div/div[2]/div/div/div[1]/div/table/tbody/tr[1]/th[1]"))
				.getText());
		String actualdata = celldata.get(0).get(0);
		String expecteddata = driver
				.findElement(
						By.xpath("//*[@id=\"post-2924\"]/div[1]/div/div[2]/div/div/div[1]/div/table/tbody/tr[1]/th[1]"))
				.getText();

		assertEquals(actualdata, expecteddata, "It is table data");
		System.out.println("Our test Step is finally pass");

		WebElement element = driver
				.findElement(By.xpath("//*[@id=\"post-2924\"]/div[1]/div/div[2]/div/div/div[1]/div/table"));
		System.out.println(element.getText());

		assertEquals(true, element.getText().contains(actualdata));

		for (int i = 0; i < celldata.size(); i++) {

			assertEquals(true, element.getText().contains(celldata.get(i).get(i)));

			System.out.println("Our test Step is passed");
		}

		driver.close();
	}
}
