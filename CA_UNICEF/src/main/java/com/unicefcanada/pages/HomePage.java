package com.unicefcanada.pages;

import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.Keys;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.unicefcanada.base.BasePageObject;
import com.unicefcanada.base.BaseTest;

public class HomePage extends BasePageObject {

	public HomePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	private static final String URL ="https://market.unicef.ca/";
	private By searchField = By.id("search_query_adv");
	private By searchClickfield = By.id("headersearchbutton");
	
	
	/* to open Home page */
	public void openHomepage() throws Exception{
		getPage(URL);
		waitForHomePageLoad();
	}


	public void waitForHomePageLoad() throws Exception {
		// TODO Auto-generated method stub
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

}
