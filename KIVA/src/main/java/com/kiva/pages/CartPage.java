package com.kiva.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.kiva.base.BasePageObject;

public class CartPage extends BasePageObject {
	
	
	private static final By checkoutbottom = By.id("submitPayment");
	By keepShoppingButton= By.xpath("//*[@id='shop']/div[1]/div/div/div[1]/div/div[2]/a");
	
	
	public CartPage(WebDriver driver) {
		super(driver);
		}
	
	public void waitForCarttoload() throws Exception {
		waitForJavascripttoLoad();
		}
	
	/* Click Checkout */
	
	public void clickcheckout() throws Exception {
		explicitWait(checkoutbottom);
		waitForClickabilityOf(checkoutbottom, 10);
		click(checkoutbottom);
	}
	
	/* to click keep shpping button */
	
	public void clickKeepShopping() {
		
		waitForClickabilityOf(keepShoppingButton, 10);
		click(keepShoppingButton);
	}
	
	/* to change quantity */
	
	public void addQuantity(){
		
		
	}
	

}
