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
	private By freeGiftWrap= By.xpath("//*[@id='giftwrapselection-10673611']/p[1]");
	private By premiumGiftWrap= By.xpath("//*[@id='giftwrapselection-10673617-2']");
	private By stdShip= By.xpath("//*[@id='shipping']/div[2]/div[3]/div[2]/label[1]");
	private By expressShip= By.xpath("//*[@id='shipping']/div[2]/div[3]/div[2]/label[2]");
	private By msgField= By.id("giftmessage");
	
	
	/* wait for shipping address page to load */
	public void waitForWishlisttoLoad() throws Exception {
		waitForJavascripttoLoad();
	}
	
	/* click on same addrees button */
	public void sameAddress(Integer randomnumber) throws Exception{
		
		By sameAddButton= By.xpath("//*[@id='addressBook']/div/div["+randomnumber+"]/form/p[1]");
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
	/* click on top continue button in create new address section */
	public void continueButton1() throws Exception{
		waitForClickabilityOf(continueBottomButton,10);
		click(continueBottomButton);		
	}
	
	/* click on bottom continue button in create new address section */
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
		System.out.println("radio1");
	}
	
	/* click on radio button premium gift wrap option */
	public void giftWrapPremium() throws Exception{
		System.out.println("radio2fgff");
		click(premiumGiftWrap);	
		System.out.println("radio2");
	}
	
	/* click on radio button standard ship */
	public void stdShipping() throws Exception{
		waitForClickabilityOf(stdShip,10);
		click(stdShip);	
		System.out.println("radio3");
	}
	
	/* click on radio button Express ship */
	public void expressShipping() throws Exception{
		waitForClickabilityOf(expressShip,10);
		click(expressShip);	
		System.out.println("radio4");
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
		select(state,5); 
		type(zipcode,"789456231");
		type(phoneNo,"5548669584");
		click(checkPhone);
		type(companyName,"test company");
//		click(makeDefaultAddress);
//		click(checkShipAddress);
		System.out.println("click continue button");
	}
	

	
	public void shippingAddressPageFunctionalities() throws Exception{
		
		PaymentPage payment=new PaymentPage(driver);
		By recipientFirstName= By.id("firstName"); 
		
		if(driver.findElements(recipientFirstName).size() == 0){
		
			sameAddress(1);
			payment.bottomContinueButton();
			Thread.sleep(5000);
			payment.paymentPageFunctionalities();
		}		
		else
		{
			createShipAddress();
			continueButton1();
			payment.bottomContinueButton();
			Thread.sleep(5000);
			payment.paymentPageFunctionalities();
		}
	}
	

}
