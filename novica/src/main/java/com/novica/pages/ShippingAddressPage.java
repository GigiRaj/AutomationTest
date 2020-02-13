package com.novica.pages;


import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

import com.novica.base.BasePageObject;
import com.novica.pages.PaymentPage;

public class ShippingAddressPage extends BasePageObject {
	
	
	public ShippingAddressPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	
	private By editAddButton= By.className("btn-small");
	private By newAddButton= By.className("btn-top");
	private By conitnueShippingOptionButton1= By.id("submitShippingOptions1");
	private By conitnueShippingOptionButton2= By.id("submitShippingOptions2");
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
		Reporter.log("loading wishlist page <br>");
	}
	
	/* click on same addrees button */
	public void sameAddress(Integer value) throws Exception{
		
		By sameAddButton= By.xpath("//*[@id='page-top']/div[4]/div/div/div["+value+"]/div/div[2]/form/p/button[1]"); 
		waitForClickabilityOf(sameAddButton,10);
		click(sameAddButton);
		Reporter.log("click on same address button <br>");
	}
	
	/* Click on edit address button*/
	public void editAddress() throws Exception{
		waitForClickabilityOf(editAddButton,10);
		click(editAddButton);	
		Reporter.log(" click on edit address button <br>");
	}
	
	/* Click on create new address button*/
	public void newAddress() throws Exception{
		waitForClickabilityOf(newAddButton,10);
		click(newAddButton);
		Reporter.log("click on new address button <br>");
	}
	/* click on top continue button in create new address section */
	public void continueButton1() throws Exception{
		waitForClickabilityOf(continueBottomButton,10);
		click(continueBottomButton);	
		Reporter.log("click on bottom continue button <br>");
	}
	
	/* click on bottom continue button in create new address section */
	public void continueButton2() throws Exception{
		waitForClickabilityOf(continueTopButton,10);
		click(continueTopButton);	
		Reporter.log("click on top continue button <br>");
	}
	
	/* Click on Top Continue button shipping options page */
	public void topContinueBtnShipOptPage() throws Exception{
		waitForClickabilityOf(conitnueShippingOptionButton2,10);
		click(conitnueShippingOptionButton2);	
		Thread.sleep(3000);
		Reporter.log("click on top continue shipping button <br>");
	}
	
	/* Click on Bottom Continue button shipping options page */
	public void bottomContinueBtnShipOptPage() throws Exception{
		waitForClickabilityOf(conitnueShippingOptionButton2,10);
		click(conitnueShippingOptionButton2);		
		Reporter.log("click on bottom continue shipping button <br>");
	}
	
	/* click on radio button free gift wrap option */
	public void giftWrapFree() throws Exception{
		waitForClickabilityOf(freeGiftWrap,10);
		click(freeGiftWrap);	
		System.out.println("radio1");
		Reporter.log("click on free gift wrap radio button <br>");
	}
	
	/* click on radio button premium gift wrap option */
	public void giftWrapPremium() throws Exception{
	
		click(premiumGiftWrap);	
		System.out.println("radio2");
		Reporter.log("click on premium gift wrap radio button <br>");
	}
	
	/* click on radio button standard ship */
	public void stdShipping() throws Exception{
		waitForClickabilityOf(stdShip,10);
		click(stdShip);	
		System.out.println("radio3");
		Reporter.log("click on standard shipping radio button <br>");
	}
	
	/* click on radio button Express ship */
	public void expressShipping() throws Exception{
		waitForClickabilityOf(expressShip,10);
		click(expressShip);	
		System.out.println("radio4");
		Reporter.log("click on express shipping radio button <br>");
	}
	
	/* type gift card message */
	public void giftCardMsg() throws Exception{
		scrollToBottom();
		type(msgField,"test gift card message");
		Reporter.log("type gift card message <br>");
	}
	
	/* to add/create/edit shipping address */
	public void addShippingAddress() throws Exception{
		
		type(firstName,"gigi");
		Reporter.log("type firstname <br>");
		type(lastName,"test");
		Reporter.log("type lastname <br>");
		type(addressLine1,"test address line 1");
		Reporter.log("type addressline 1 <br>");
		type(addressLine2,"test address line 2");
		Reporter.log("type addressline2 <br>");
		type(city,"california");
		Reporter.log("type cityname <br>");
//		select(country,1);
		select(state,9);
		Reporter.log("select the country USA <br>");
		type(zipcode,"90001");
		Reporter.log("type zipcode <br>");
		type(phoneNo,"5548669584");
		Reporter.log("type phone number <br>");
		click(checkPhone);
		Reporter.log("check the default phone box <br>");
		type(companyName,"test company");
		Reporter.log("type company name <br>");
		click(makeDefaultAddress);
		Reporter.log("check default address box <br>");
//		click(checkShipAddress);
		System.out.println("click continue button");
	}
	
	public void shippingAddressPageFunctionalities() throws Exception{
		
		PaymentPage payment=new PaymentPage(driver);
		By recipientFirstName= By.id("firstName"); 
		
		if(driver.findElements(recipientFirstName).size() == 0){
			
			
			System.out.println("tesst11");
			Reporter.log("redirect to shipment page if receipient first name is active <br>");
			sameAddress(1);
			Reporter.log("choose the same address <br>");
			topContinueBtnShipOptPage();
			Thread.sleep(5000);
			Reporter.log("redirect to payment page <br>");
			payment.paymentPageFunctionalities();
			Reporter.log("do the payment functionalities <br>");
					
		}
		
		else
		{
			System.out.println("tesst22");
			Reporter.log("redirect to add shipping address page if receipient first name is not active <br>");
			addShippingAddress();
			Reporter.log("add new shipping address <br>");
			continueButton1();
			Reporter.log("redirect to gift wrap page <br>");
			topContinueBtnShipOptPage();
			Thread.sleep(5000);
			Reporter.log("redirect to payment page <br>");
			payment.paymentPageFunctionalities();
			Reporter.log("do the payment functionalities <br>");
		}
	}
	

}
