package com.unicef.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.unicef.base.BasePageObject;

public class IGShippingBag extends BasePageObject {
	
	public IGShippingBag(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	private By keepShoppingButton= By.xpath("//*[@id='shop']/div[2]/div/div[1]/div[2]/div[1]/a");
	private By checkOutTopButton= By.xpath("//*[@id='btn-gotocheckout-top']");
	private By updateIGgiftButton= By.xpath("//*[@id='giftitem-34314']/div[3]/p/small/a");
	private By editCardButton= By.xpath("//*[@id='carditem-10676763']/div[2]/div[1]/p[1]/a");
	private By duplicateCardButton= By.xpath("//*[@id='carditem-10676763']/div[2]/div[1]/p[2]/a");
	private By checkOutBottomButton= By.id("btn-gotocheckout-bottom");
	private By removeGiftPopupButton= By.xpath("//*[@id='novicamodal']/div/div/div/div/div[3]/div[1]/a");
	private By previewCardButton= By.xpath("//*[@id='carditem-10676796']/div[2]/div[1]/p[1]/a[1]");
	
	/* wait for IG shipping page to load */
	public void waitForIGShipPagetoLoad() throws Exception {
		waitForJavascripttoLoad();
	}
	
	
	 /* to click keep shopping button */
	public void keepShopping() throws Exception{
			
			waitForClickabilityOf(keepShoppingButton, 10);
			click(keepShoppingButton);
		}
	/* to remove the IG gift using index*/
	public void removeIGGift(Integer randomnumber)throws Exception{
		By removeIGgiftButton = By.xpath("//*[@class='cart-body']/form/div[2]/div["+randomnumber+"]/div/div[2]/div[1]/div[1]/div[2]/a");
		click(removeIGgiftButton);
		Thread.sleep(5000);
		click(removeGiftPopupButton);
	}
	
	/* to click update button */
	public void updateQuantity() throws Exception{
		
		waitForClickabilityOf(updateIGgiftButton, 10);
		click(updateIGgiftButton);
	}
	
	/* to give update value */
	public void typeUpdateValue(Integer randomnumber,String value ) throws Exception{
		
		By updateTextField= By.xpath("//*[@class='cart-body']/form/div[2]/div["+randomnumber+"]/div/div[2]/div[1]/div[3]/input");
		waitForVisibilityOf(updateTextField, 10);
		type(updateTextField,value);
	}
	
	/* to click on preview button */
	public void previewCardDetails() throws Exception{
		
		waitForClickabilityOf(previewCardButton, 10);
		click(previewCardButton);
	}
	
	
	/* to click on edit button */
	public void editCardDetails() throws Exception{
		
		waitForClickabilityOf(editCardButton, 10);
		click(editCardButton);
	}
	
	/* to click on duplicate card button */
	public void duplicateCard() throws Exception{
		
		waitForClickabilityOf(duplicateCardButton, 10);
		click(duplicateCardButton);
	}
	
	/* to  click on personalize button on duplicated card */
	public void personalizeDuplicateCard(Integer randomnumber) throws Exception{
		
		By personalizeCardButton= By.xpath("//*[@class='cart-body']/form/div[2]/div["+randomnumber+"]/div/div[2]/div[2]/div[1]/a");
		waitForClickabilityOf(personalizeCardButton, 10);
		click(personalizeCardButton);
	}
	
	/* to click on top checkout button */
	public void topCheckOut() throws Exception{
		
		waitForClickabilityOf(checkOutTopButton, 10);
		click(checkOutTopButton);
	}
	
	/* to click on bottom checkout button */
	public void bottomCheckOut() throws Exception{
		
		scrollToBottom();
		waitForClickabilityOf(checkOutBottomButton, 10);
		click(checkOutBottomButton);
	}
	

}
