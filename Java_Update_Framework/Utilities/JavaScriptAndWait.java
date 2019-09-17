package Utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class JavaScriptAndWait {
	static WebDriver driver;

	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.ie.driver", "C:/Users/Mosarrof Hossain/Utilities/MicrosoftWebDriver.exe");

		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get("https://www.freecrm.com");
		driver.manage().window().maximize();
		// Thread.sleep(2000);
		// driver.findElement(By.linkText("Features")).click();
		// Thread.sleep(4000);

		// WebDriverWait wait = new WebDriverWait(driver, 15);
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//font[@color='red']")));
		// JavascriptExecutor js = (JavascriptExecutor) driver;
		// js.executeScript("arguments[0].click();",
		// driver.findElement(By.xpath("//font[@color='red']")));

		// driver.findElement(By.xpath("//font[@color='red']")).click();
		/*
		 * try { driver.findElement(By.xpath("//font[@color='red']")).click(); }
		 * catch(Exception e)
		  { System.out.println("Erron Message: "+e); }
		 */

		driver.findElement(By.xpath("/html/body/div[1]/header/div/nav/div[2]/div/div[3]/ul/li[1]/a")).click();
		driver.findElement(By.xpath("//*[@id='email']")).sendKeys("phmosharaf@gmail.com");

		Thread.sleep(4000);
		String inputtext = driver.findElement(By.xpath("//*[@id='email']")).getAttribute("value");
		System.out.println(inputtext);

		driver.quit();

	}

}