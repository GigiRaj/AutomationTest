package com.novica.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.novica.base.BasePageObject;
import com.novica.base.BaseTest;

public class HomePage extends BasePageObject {
	
		private static final String URL = "https://www.novica.com/";
		private By searchField = By.id("keywordSearchHeader");
		private By searchClickfield = By.xpath("//button[@name='keywordsubmit2']");
		
		

		public HomePage(WebDriver driver) {
			super(driver);
		}

		/* Open Home Page */
		public void openHomePage() throws Exception {
			getPage(URL);
			waitForHomePageLoad();
			closemonetate();
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

		/* Type and submit productID */
		public ItemDetailPage typeAndSubmitProductID(String productID) {
			type(searchField, productID);
			click(searchClickfield);
			return new ItemDetailPage(driver);
		}

		public void waitForHomePageLoad() throws Exception {
			waitForJavascripttoLoad();
		}

		public ItemDetailPage typeAndSubmitProductID1(String productID) {
			// TODO Auto-generated method stub
			return null;
		}
	}