package com.healthebay.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.healthebay.base.BasePageObject;


public class CartPage extends BasePageObject {

	public CartPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	private static final By checkoutbottom = By.xpath("//div[@class='cart-actions']/a[1]");
	By keepShoppingButton= By.xpath("//div[@class='cart-actions']/a[2]");
	
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

}
