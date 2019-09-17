package Utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenShotAndWindowHandle {

	public static WebDriver driver;

	public ScreenShotAndWindowHandle(WebDriver driver) {
		//this.driver = driver;
	}

	static String windowNum = null;

	public static void windowHandles(int index) {

		Set<String> childWindows = driver.getWindowHandles();

		Iterator<String> childs = childWindows.iterator();

		for (int i = 1; i <= index; i++) {
			
			windowNum = childs.next();
		}
		driver.switchTo().window(windowNum);
	}

	public static void screenShotCapture(String screentshotName) throws IOException {

		SimpleDateFormat dateformat = new SimpleDateFormat("dd-MM-yyyy-HH-MM-ss");
		Date date = new Date();
		String ScreenShotformat = screentshotName + " " + dateformat.format(date);

		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File(".\\WebAutomationWeb\\ScreenShot\\" + ScreenShotformat + ".png"));

	}

	// Alternative method for screenshot
	public static void captureScreenshot() throws IOException {

		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		Date d = new Date();
		String screenshotName = d.toString().replace(":", "_").replace(" ", "_") + ".jpg";

		FileUtils.copyFile(scrFile,
				new File(System.getProperty("user.dir") + "\\target\\surefire-reports\\html\\" + screenshotName));

	}
}
