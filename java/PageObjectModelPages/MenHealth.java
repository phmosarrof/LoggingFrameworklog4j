package PageObjectModelPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import HelperClass.Hooks;

//import HelperClass.Hooks;

public class MenHealth extends Vitamins {
	public MenHealth() {

	}

	private static WebDriver driver;

	public static By menMenu = By.xpath("//*[@id='menu-item-47']/a");

	public static WebElement menhealthmenu() {

	

		return driver.findElement(menMenu);
	}

}
