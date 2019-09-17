package JdbcConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DataBaseConnection {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {

		String host = "localhost";

		String port = "3306";

		Connection con = DriverManager.getConnection("jdbc:mssql://" + host + ":" + port + "/MyTestDB", "root", "root");

		Statement s = con.createStatement();

		ResultSet rs = s.executeQuery("select * from credentials where scenario ='rewardscard'");

		while (rs.next())

		{
			System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");

			WebDriver driver = new ChromeDriver(); // You can use any other web browser.

			driver.get("https://login.salesforce.com");

			driver.findElement(By.xpath(".//*[@id='username']")).sendKeys(rs.getString("username"));

			driver.findElement(By.xpath(".//*[@id='password']")).sendKeys(rs.getString("password"));

		}

	}
}
