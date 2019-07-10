package com.kiva.pages;

import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.kiva.base.BasePageObject;
import org.openqa.selenium.Keys;



public class HomePage extends BasePageObject {
	
	private static final String URL = "https://store.kiva.org/";
	private By searchField = By.id("keywordHeader");
	private By searchClickfield = By.id("keywordsubmit");
	private By cookieAcceptButton= By.className("topMessageBarAction");
	private By shipToHeaderButton= By.id("shipToCountry");
	
	
	 /* to close the accept cookie bar */
	public void clickAcceptCookie() throws Exception{
		
		click(cookieAcceptButton);
		waitForJavascripttoLoad();	
	}

	public HomePage(WebDriver driver) {
	super(driver);
	}

	/* Open Home Page */
	public void openHomePage() throws Exception {
	getPage(URL);
	waitForHomePageLoad();
	Thread.sleep(3000);
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
	
	public void waitForHomePageLoad() throws Exception {
		
	waitForJavascripttoLoad();
	}
	
	
	
	/* to change shipping address to US */
	public void shipToUs() throws Exception{
		
		click(shipToHeaderButton);
//		Thread.sleep(10000);
		 By shiptotheUSIcon= By.xpath("//*[@id='shippingCountries']/div/div[2]/div[2]/a[1]/i");
		 explicitWait(shiptotheUSIcon);
		click(shiptotheUSIcon);
		Thread.sleep(10000);
		
	}


}
