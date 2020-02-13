package com.healthebay.pages;
import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.Keys;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.healthebay.base.BasePageObject;
import com.healthebay.base.BaseTest;

public class HomePage extends BasePageObject{

	private static final String URL = "https://shop.healthebay.org/";
	private By searchField = By.id("search_query_adv");
	private By searchClickfield = By.id("headersearchbutton");
	
	

	public HomePage(WebDriver driver) {
		super(driver);
	}

	/* Open Home Page */
	public void openHomePage() throws Exception {
		getPage(URL);
		waitForHomePageLoad();
		closemonetate();
	}
	
	public void waitForHomePageLoad() throws Exception {
		waitForJavascripttoLoad();
	}

	/* Get Home page Link */
	public String getHomepageLink() {
		return URL;
	}
	
	/* Type and submit search keyword */
	public   void typeAndSubmitKeyword(String keyword) throws Exception {
		
		explicitWait(searchField);
		type(searchField,keyword);
		pressEnterKey(searchField);		
	}
	
	
	
	
	
	/* to change shipping address to US */
//	public void shipToUs() throws Exception{
//		
//		click(shipToHeaderButton);
////		Thread.sleep(10000);
//		 By shiptotheUSIcon= By.xpath("//*[@id='shippingCountries']/div/div[2]/div[2]/a[1]/i");
//		 explicitWait(shiptotheUSIcon);
//		click(shiptotheUSIcon);
//		Thread.sleep(10000);
//		
//	}
}
