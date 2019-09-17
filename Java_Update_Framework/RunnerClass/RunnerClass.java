package RunnerClass;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.reporters.Files;

import HelperClass.Hooks;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@RunWith(Cucumber.class)
@CucumberOptions(
		  features = "classpath:features/"
		, glue = {"stepDefinitions","HelperClass","runnerClass"}
		, tags= {"~@wip", "@Smoke, @Functional, @Regression"}
		, dryRun = false
		, monochrome=true
		, plugin = {"pretty", "html:target/selenium-report.html","com.cucumber.listener.ExtentCucumberFormatter:Extendreport.html"}
		
		)


public class RunnerClass extends AbstractTestNGCucumberTests{
	
	public static WebDriver driver;
	
	@BeforeSuite
	public static void initializeSuite(ITestContext xmlSuite) throws FileNotFoundException, IOException {	
		System.out.println("Before Suite....");

		// String suiteName = xmlSuite.getSuite().getName();
		// ExtentReporter.startExtentReport(suiteName);

	}   
	@AfterClass
    public static void reportSetup() 
 	{/*
        Reporter.loadXMLConfig(new File("C:\\Users\\Mosarrof Hossain\\workspace\\BDDFrameWork\\Properties\\confiq.xml"));
        Properties p = System.getProperties();
        p.list(System.out);
    
        Reporter.setSystemInfo("User Name",System.getProperty("user.name"));
        Reporter.setSystemInfo("Time Zone", System.getProperty("user.timezone"));
        Reporter.setSystemInfo("64 Bit", 	"Windows 10");
        Reporter.setSystemInfo("2.53.0", "Selenium");
        Reporter.setSystemInfo("3.3.9", "Maven");
        Reporter.setSystemInfo("1.8.0_66", "Java Version");
        Reporter.setTestRunnerOutput("Cucumber JUnit Test Runner");*/
 	}

	@AfterSuite
	public static void afterSuite() throws Throwable{
		driver=Hooks.webDriver;
		System.out.println("After Suite....");
		driver.close();

	}

}
