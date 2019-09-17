package PageObjectModelPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import HelperClass.Hooks;

//import HelperClass.Hooks;

public class Medecines {

	public static WebDriver driver;

	public Medecines() {
		driver = Hooks.webDriver;

	}

	// private static WebDriver driver;

	static By medicine = By.xpath("//*[@id='menu-item-48']/a");

	public static WebElement medicine() {

		return driver.findElement(medicine);

	}

	static By readMore = By.xpath("//*[@id='main-content']/div[1]/div[3]/article/div[2]/p/a");

	public WebElement readMore() {
		return driver.findElement(readMore);

	}

}
