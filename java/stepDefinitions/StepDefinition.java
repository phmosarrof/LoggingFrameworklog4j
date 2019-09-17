package stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import HelperClass.Hooks;
import PageObjectModelPages.ChildrenHealth;
import PageObjectModelPages.Medecines;
import PageObjectModelPages.MenHealth;
import PageObjectModelPages.Vitamins;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.List;

public class StepDefinition {
	private static WebDriver driver;

	public StepDefinition() throws Exception {
		//super();
		driver = Hooks.webDriver;

	}

	@Given("^I want to go to Home Page of my blog$")
	public void i_want_to_go_to_Home_Page_of_my_blog() throws Throwable {

	}

	@When("^I Click the Children Health Menu$")
	public void i_Click_the_Children_Health_Menu() throws Throwable {

		driver.findElement(ChildrenHealth.childmenu).click();

		Thread.sleep(3000);
		//driver.findElement(ChildrenHealth.menMenu).click();
		/*
		 * Thread.sleep(3000); MenHealth.menhealthmenu().click(); Thread.sleep(3000);
		 * Vitamins.vitaminMenu().click(); Thread.sleep(3000);
		 * Medecines.medMenu().click();
		 */
		int atn = driver.findElements(By.tagName("a")).size();
		System.out.println("Total Links in the page = " + atn);
		Thread.sleep(3000);
		List<WebElement> links = driver.findElements(By.tagName("a"));

		for (WebElement el : links)

		{
			if (el.isDisplayed() == false) {
				System.out.println("Link is displayed ");
			} else if(el.isDisplayed()==false) {
				System.out.println("Link is not displayed");
			}
			
			else{
				System.out.println("Link is not displayed" + el.getText());
			}
			 System.out.println(el.getText());
			 System.out.println(el.getAttribute("href"));

		}
		Thread.sleep(3000);
	}

	@Then("^I can navigate to the Children Health page sucessfully$")
	public void i_can_navigate_to_the_Children_Health_page_sucessfully() throws Throwable {

		Assert.assertFalse(driver.getPageSource().contains("The major international health"));
	}

	@When("^I Click the first \"([^\"]*)\" of the recent post$")
	public void i_Click_the_first_of_the_recent_post(String link) throws Throwable {

		//driver.findElement(ChildrenHealth.menMenu).click();
		System.out.println("It is menMenu");
	}

	@Then("^I can navigate to the first recent \"([^\"]*)\" sucessfully$")
	public void i_can_navigate_to_the_first_recent_sucessfully(String post_page) throws Throwable {

		Thread.sleep(5000);
		Assert.assertTrue(driver.getPageSource().contains(post_page));
	}

}
