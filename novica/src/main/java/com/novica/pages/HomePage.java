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
		
		/* to click header account button */
		public void headeraccount() {
			
			By AccountMenu= By.id("globalnav-account");
			waitForClickabilityOf(AccountMenu,10);
			click(AccountMenu);
		}
		
		/* to click on whole sale footer menu */
		public void clickWholeSaleMenu() throws Exception{
			
			scrollToBottom();
			scrollToBottom();
			scrollToBottom();
			scrollToBottom();
			scrollToBottom();
			scrollToBottom();
			scrollToBottom();
			scrollToBottom();
			scrollToBottom();
			scrollToBottom();
			scrollToBottom();
			scrollToBottom();
			By bottomBanner= By.xpath("//*[@id='bottom_mobile']");
			By closeIcon= By.xpath("//*[@id='bottom_mobile']/p/span[3]");
			By wholeSaleButton= By.xpath("//*[@id='footer-links']/div/div[1]/ul/li[3]/a");
			if(driver.findElements(bottomBanner).size() == 0)
			{
				scrollToBottom();
				scrollToBottom();
				Thread.sleep(5000);
				click(wholeSaleButton);
				
			}
			else
			{
				
				Thread.sleep(5000);
				click(closeIcon);
				scrollToBottom();
				scrollToBottom();
				Thread.sleep(5000);
				click(wholeSaleButton);
	
			}
			
		}
	}
