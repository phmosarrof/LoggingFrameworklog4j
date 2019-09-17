package HelperClass;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {

	public static WebDriver webDriver ;

	//public  static WebDriver webDriver1;
	
	@Before
	public void  initialize(Scenario scenario) throws Exception {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		webDriver = new ChromeDriver();
		webDriver.get("http://www.health.holyworld.org");
		webDriver.manage().window().maximize();
	}
	
	@After
	public void  close(Scenario scenario)throws Exception {
		scenario.write("Finished scenario");
		if (scenario.isFailed())
				{
					scenario.embed(((TakesScreenshot)webDriver).getScreenshotAs(OutputType.BYTES),"image/png");
				}
		System.out.println("Test Environment Destroyed ");
		webDriver.close();
	}
	
}
