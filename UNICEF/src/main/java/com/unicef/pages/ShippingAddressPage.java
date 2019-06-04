package com.unicef.pages;


import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.unicef.base.BasePageObject;

public class ShippingAddressPage extends BasePageObject {
	
	
	public ShippingAddressPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	private By sameAddButton= By.id("useAddr-199011");
	private By editAddButton= By.className("btn-small");
	private By newAddButton= By.className("btn-top");
	private By conitnueShippingOptionButton1= By.className("btn-top");
	private By conitnueShippingOptionButton2= By.className("btn-bottom");
	private By firstName= By.id("firstName");
	private By lastName= By.id("lastName");
	private By country= By.id("country");
	private By addressLine1= By.id("addrLine1");
	private By addressLine2= By.id("addrLine2");
	private By city= By.id("city");
	private By province= By.id("province-other");
	private By state= By.id("state");
	private By zipcode= By.id("zipCode");
	private By phoneNo= By.id("phoneNum");
	private By checkPhone= By.id("isBusiness");
	private By companyName= By.id("addrLine3");
	private By makeDefaultAddress= By.id("makedefault");
	private By checkShipAddress= By.id("applyToOrder");
	private By continueTopButton= By.id("submitReturnLogin");
	private By continueBottomButton= By.xpath("//*[@id='submitAddress2']");
	private By freeGiftWrap= By.id("giftwrapselection-10673595-1");
	private By premiumGiftWrap= By.id("giftwrapselection-10673595-2");
	private By stdShip= By.id("selectedShipping27-3");
	private By expressShip= By.id("selectedShipping27-1");
	private By msgField= By.id("giftmessage");
	
	/* wait for shipping address page to load */
	public void waitForWishlisttoLoad() throws Exception {
		waitForJavascripttoLoad();
	}
	
	/* click on same addrees button */
	public void sameAddress() throws Exception{
		waitForClickabilityOf(sameAddButton,10);
		click(sameAddButton);
	}
	
	/* Click on edit address button*/
	public void editAddress() throws Exception{
		waitForClickabilityOf(editAddButton,10);
		click(editAddButton);		
	}
	
	/* Click on create new address button*/
	public void newAddress() throws Exception{
		waitForClickabilityOf(newAddButton,10);
		click(newAddButton);		
	}
	/* click on continue button create new address section */
	public void continueButton1() throws Exception{
		waitForClickabilityOf(continueBottomButton,10);
		click(continueBottomButton);		
	}
	
	public void continueButton2() throws Exception{
		waitForClickabilityOf(continueTopButton,10);
		click(continueTopButton);		
	}
	
	/* Click on Top Continue button shipping options page */
	public void topContinueBtnShipOptPage() throws Exception{
		waitForClickabilityOf(conitnueShippingOptionButton1,10);
		click(conitnueShippingOptionButton1);		
	}
	
	/* Click on Bottom Continue button shipping options page */
	public void bottomContinueBtnShipOptPage() throws Exception{
		waitForClickabilityOf(conitnueShippingOptionButton2,10);
		click(conitnueShippingOptionButton2);		
	}
	
	/* click on radio button free gift wrap option */
	public void giftWrapFree() throws Exception{
		waitForClickabilityOf(freeGiftWrap,10);
		click(freeGiftWrap);		
	}
	
	/* click on radio button premium gift wrap option */
	public void giftWrapPremium() throws Exception{
		waitForClickabilityOf(premiumGiftWrap,10);
		click(premiumGiftWrap);		
	}
	
	/* click on radio button standard ship */
	public void stdShipping() throws Exception{
		waitForClickabilityOf(stdShip,10);
		click(stdShip);		
	}
	
	/* click on radio button Express ship */
	public void expressShipping() throws Exception{
		waitForClickabilityOf(expressShip,10);
		click(expressShip);		
	}
	
	/* type gift card message */
	public void giftCardMsg() throws Exception{
		scrollToBottom();
		type(msgField,"testmessage loreum ipsum");
	}
	
	/* editing the shipping address */
	public void createShipAddress() throws Exception{
		
		type(firstName,"gigi");
		type(lastName,"test");
		type(addressLine1,"test address line 1");
		type(addressLine2,"test address line 2");
		type(city,"california");
		select(country,1);
//		WebElement element=driver.findElement(country);
//		Select se=new Select(element);
//		
//		List<WebElement> allOptions=se.getOptions();
//		int size=allOptions.size();
//		for(int i=0;i<size;i++)
//		{
////			if(allOptions.get(i).getText().equalsIgnoreCase(se.selectByVisibleText("USA"));
//			if(i==1)
//			{
//				System.out.println("testtstydhs");
//				System.out.println(allOptions.get(i).getText());				
//				scrollToBottom();
				select(state,5); 
//			}
//			else if(i==0||i==2){
//				
//				System.out.println(allOptions.get(i).getText());
//				se.selectByIndex(i);
//				scrollToBottom();
//				type(province,"test province");
//			}
//		}

		type(zipcode,"789456231");
		type(phoneNo,"5548669584");
		click(checkPhone);
		type(companyName,"test company");
		click(makeDefaultAddress);
//		click(checkShipAddress);
		System.out.println("click continue button");
	}
	

}
