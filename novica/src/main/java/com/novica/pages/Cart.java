package com.novica.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

import com.novica.base.BasePageObject;
import com.novica.base.WebPageUtility;

public class Cart extends BasePageObject{
	private static final String URL = "";
	private static final By totalCartPriceField = By.xpath("//*[@id='cart-main-content']/div[2]/table/tbody/tr/td[3]/p/span[2]");
	private static final By firstRemoveItemClickField = By.xpath("(//a[@data-actiontype='basket-removeitem'])[1]");
	private static final By checkoutbottom = By.id("submitPayment2");

	public Cart(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public void waitForCarttoload() throws Exception {
	waitForJavascripttoLoad();
	}
	/* Open C3 page */
	public void openCartpage() throws Exception {
		getPage(URL);
		waitForJavascripttoLoad();
	}
	
	/* Click Checkout */
	
	public void clickcheckout() {
		waitForClickabilityOf(checkoutbottom, 30);
		click(checkoutbottom);
	}
	
	/* Get Total Cart Price */
	public String getTotalCartPrice() {
		waitForVisibilityOf(totalCartPriceField, 30);
		return find(totalCartPriceField).getText();
	}
	
	public void clickRemoveItembutton() throws Exception {
		waitForVisibilityOf(firstRemoveItemClickField, 10);
		Thread.sleep(5000);
		click(firstRemoveItemClickField);
	}
	
	/* to click keep shopping button */
	
	public void clickKeepShopping() throws Exception{
		
		int cartTotal=0;
		while(cartTotal <= 250)
		{
			
			String actualcartprice = getTotalCartPrice();
			System.out.println(actualcartprice);
			double cartPrize= Double.parseDouble(actualcartprice);
			System.out.println(cartPrize);
			cartTotal = (int)cartPrize;
			System.out.println(cartTotal);
			By keepShoppingButton= By.xpath("//*[@id='cart-main-content']/div[2]/div[2]/div[2]/a");
			By continueShoppingButton= By.xpath("//*[@id='keepshopping']");
			if(driver.findElements(keepShoppingButton).size() != 0)
			{
				click(keepShoppingButton);
			}
			else
			{
				click(continueShoppingButton);
			}
			
			C3category c3 = new C3category(driver);
			HomePage homePage = new HomePage(driver);
			ItemDetailPage itdetail = new ItemDetailPage(driver);
			WebPageUtility wpu = new WebPageUtility();
			
			String Key = "oil paintings";
			homePage.typeAndSubmitKeyword(Key);
			Reporter.log("Searched for"+ Key);
			c3.waitForC3toLoad();
			Reporter.log("Waiting for C3 to load");
			int productcount = c3.getproductCount();
			Reporter.log("Total Products found "+ productcount);
			System.out.println("Total Products found "+ productcount);
			int gennum = wpu.getRandomNumberInts(1, productcount);
			System.out.println(gennum);
			
			
		   String productid = c3.getProductID(gennum);
		   Reporter.log("Clicked on product ID"+ productid); 
		   System.out.println("Clicked on product ID"+ productid);
		   c3.clickProductPlateRandom(gennum);
		    
			itdetail.waitForItemDetailLoad();
			itdetail.clickAddToCartButton();
			Reporter.log("Added product with "+ productid + "to cart");
			
			itdetail.Gotocart();
			
		}
		clickcheckout();
		
		}
	


}
