package com.kiva.pages;

import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.kiva.base.BasePageObject;



public class HomePage extends BasePageObject {
	
	private static final String URL = "https://store.kiva.org/";
	private By searchField = By.id("keywordHeader");
	private By searchClickfield = By.id("keywordsubmit");
	private By cookieAcceptButton= By.className("topMessageBarAction");
	
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
	public   void typeAndSubmitKeyword(String keyword) {
	type(searchField, keyword);
	click(searchClickfield);
	
	}
	public void waitForHomePageLoad() throws Exception {
	waitForJavascripttoLoad();
	}


}
