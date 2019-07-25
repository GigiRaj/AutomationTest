package com.unicef.pages;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import com.unicef.base.BasePageObject;

public class PaymentPage extends BasePageObject {

	public PaymentPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	
	
	private By promoCode= By.id("promocode");
	private By promocodeApplyButton= By.className("btn-code");
	private By donateSelectBox= By.id("contributionAmount");
	private By cardNumber= By.id("card_number");
	private By cardName= By.id("cardHolderName");
	private By expireMonth= By.id("exp_month");
	private By expireYear= By.id("exp_year");
	private By cvcCode= By.id("card_cvc");
	private By checkDebit= By.id("isDebitCard");
	private By checkSaveforLater= By.id("saveCard");
	private By sameShippingAddress= By.id("useShipping");
	private By firstName= By.id("firstName");
	private By lastName= By.id("lastName");
	private By country= By.id("country");
	private By addressLine1= By.id("addrLine1");
	private By addressLine2= By.id("addrLine2");
	private By city= By.id("city");
	private By state= By.id("state");
	private By zipcode= By.id("zipCode");
	private By phoneNumber= By.id("phoneNum");
	private By continuepaymenttopbutton1= By.className("btn-top");
	private By continuepaymentbottombutton2= By.className("btn-bottom");
	private By placeOrderTopButton1= By.className("btn-top");
	private By placeOrderBottomButton2= By.className("btn-bottom");
	private By IGgiftGuestEmail = By.id("guestEmail");
	private By IGgiftGuestFirstName= By.id("guestFirstName");
	private By IGgiftGuestLastName= By.id("guestLastName");
	
	/* wait for Payment page to load */
	public void waitForPaymentPagetoLoad() throws Exception {
		waitForJavascripttoLoad();
	}
	
	/* apply promo code */
	public void applyPromoCode(String value) throws Exception{
		type(promoCode,value);
		click(promocodeApplyButton);	
	}
	
	/* choose donation amount */
	public void chooseDonation(Integer value) throws Exception{
		select(donateSelectBox,value);
	}
	
	/* card payment section */
	public void cardPayment() throws Exception{
		
		scrollToBottom();
		type(cardNumber,"4012888888881881");
		type(cardName,"test");
		select(expireMonth,5);
		select(expireYear,8);
		type(cvcCode, "1234");
		click(checkDebit);
//		click(checkSaveforLater);
	}
	
	/* using same shipping address as billing address */
	public void sameShippingAddr()throws Exception{
		scrollToBottom();
		click(sameShippingAddress);
	}
	
	/* using new billing address */
	public void newBillingAddr() throws Exception{
		scrollToBottom();
		type(firstName,"rose");
		type(lastName,"test");
		selectText(country,"USA");
		type(addressLine1,"testing addressline One");
		type(addressLine2,"testing addressline Two");
		type(city,"California");
		selectText(state,"California ");
		type(zipcode,"12345678");
		type(phoneNumber,"1234567891");		
	}
	
	/* click on top continue button in payment page */
	public void topContinueButton() throws Exception{
		waitForClickabilityOf(continuepaymenttopbutton1,10);
		click(continuepaymenttopbutton1);		
	}
	
	/* click on bottom continue button in payment page */
	public void bottomContinueButton() throws Exception{
		waitForClickabilityOf(continuepaymentbottombutton2,10);
		click(continuepaymentbottombutton2);		
	}
	
	/* to give payment details related with IG gifts */
	public void IGgiftPaymentInfo()throws Exception{
		
		type(IGgiftGuestEmail,"guesttest1@gmail.com");
		type(IGgiftGuestFirstName,"test1");
		type(IGgiftGuestLastName,"test2");
		scrollToBottom();
	}
		
	public void paymentPageFunctionalities() throws Exception{
		ShippingAddressPage shipAddr= new ShippingAddressPage(driver);
		By paymentButton= By.xpath("//*[@id='progress-payment']/a[1]");
		if(driver.findElements(paymentButton).size()!=0)
		{
			
			applyPromoCode("QWERTY");
			chooseDonation(5);
			cardPayment();
			newBillingAddr();
			bottomContinueButton();
			
		}
		
		else
		{
			
			
			System.out.println("no payment page");
			shipAddr.shippingAddressPageFunctionalities();
		}
			
	}
}
