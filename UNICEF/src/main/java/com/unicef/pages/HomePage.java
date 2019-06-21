package com.unicef.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.unicef.base.BasePageObject;
import com.unicef.base.BaseTest;

public class HomePage extends BasePageObject {
	
		private static final String URL = "https://www.market.unicefusa.org/";
		private By searchField = By.id("keywordHeader");
		private By searchClickfield = By.cssSelector("button.btn.btn-primary.keywordButton");
		private By IGplateField = By.xpath("//div[@class='container page m-nopad']/div[2]/div[2]/div/a");
		private By IGheaderMenu= By.id("inspired-gifts");
		private By CardGiftheaderMenu= By.id("card-and-gifts");
		private By giftFinderHeaderMenu= By.id("gift-finder");
		private By jewelryHeaderMenu= By.id("jewelry");
		private By accessoriesHeaderMenu= By.id("accessories");
		private By homeDecorHeaderMenu= By.id("home-decor");
		private By newHeaderMenu= By.id("newarrivals"); 
		private By homeHeaderMenu= By.xpath("//*[@id='header-top']/div/ul/li[1]");
		private By donateHeaderMenu= By.xpath("//*[@id='header-top']/div/ul/li[2]");
		private By aboutUsHeaderMenu= By.xpath("//*[@id='header-top']/div/ul/li[3]");
		private By catalogHeaderMenu= By.xpath("//*[@id='header-top']/div/ul/li[4]");
		private By loginHeaderMenu= By.xpath("//*[@id='header-top']/div/ul/li[5]");
		private By helpHeaderMenu= By.xpath("//*[@id='header-top']/div/ul/li[6]");
		private By shipToHeaderMenu= By.xpath("//*[@id='header-top']/div/ul/li[7]"); 
		
		
		
		
		
		public HomePage(WebDriver driver) {
			super(driver);
		}

		/* Open Home Page */
		public void openHomePage() throws Exception {
			getPage(URL);
			waitForHomePageLoad();
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
		
		/*public IGHomePage clickIGplate() {
			click(IGplateField);
			return new IGHomePage(driver);
		}*/

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
		
		/* to click inspired gifts in Header menu */
		public void clickIGHeaderMenu()throws Exception{
			
			click(IGheaderMenu);
			waitForJavascripttoLoad();
			scrollToBottom();	
		}
		
		/* to click card gifts in Header menu */
		public void clickCardGiftsHeaderMenu()throws Exception{
			
			click(CardGiftheaderMenu);
			waitForJavascripttoLoad();			
		}
		
		/* to click gift finder in Header menu */
		public void clickGiftFinderHeaderMenu()throws Exception{
			
			click(giftFinderHeaderMenu);
			waitForJavascripttoLoad();
		}
		
		/* to click jewelry in Header menu */
		public void clickJewelryHeaderMenu()throws Exception{
			
			click(jewelryHeaderMenu);
			waitForJavascripttoLoad();		
		}
		
		/* to click accessories in Header menu */
		public void clickAccessoriesHeaderMenu()throws Exception{
			
			click(accessoriesHeaderMenu);
			waitForJavascripttoLoad();		
		}
		
		/* to click home decor in Header menu */
		public void clickHomeDecorHeaderMenu()throws Exception{
			
			click(homeDecorHeaderMenu);
			waitForJavascripttoLoad();		
		}
		
		/* to click new in Header menu */
		public void clickNewHeaderMenu()throws Exception{
			
			click(newHeaderMenu);
			waitForJavascripttoLoad();		
		}
		
		/* to click Home in Header menu */
		public void clickHomeHeaderMenu()throws Exception{
			
			click(homeHeaderMenu);
			waitForJavascripttoLoad();		
		}
		
		/* to click Donate in Header menu */
		public void clickDonateHeaderMenu()throws Exception{
			
			click(donateHeaderMenu);
			waitForJavascripttoLoad();		
		}
		
		/* to click About us in Header menu */
		public void clickAboutUsHeaderMenu()throws Exception{
			
			click(aboutUsHeaderMenu);
			waitForJavascripttoLoad();		
		}
		
		/* to click catalog in Header menu */
		public void clickCatalogHeaderMenu()throws Exception{
			
			click(catalogHeaderMenu);
			waitForJavascripttoLoad();		
		}
		
		/* to click Login in Header menu */
		public void clickLoginHeaderMenu()throws Exception{
			
			click(loginHeaderMenu);
			waitForJavascripttoLoad();		
		}
		
		/* to click Help in Header menu */
		public void clickHelpHeaderMenu()throws Exception{
			
			click(helpHeaderMenu);
			waitForJavascripttoLoad();		
		}
		
		/* to click ship to in Header menu */
		public void clickShipToHeaderMenu()throws Exception{
			
			click(shipToHeaderMenu);
			waitForJavascripttoLoad();		
		}
	
	}
