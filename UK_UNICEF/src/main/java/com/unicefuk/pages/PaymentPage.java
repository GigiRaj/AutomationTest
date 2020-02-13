	package com.unicefuk.pages;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import com.unicefuk.base.BasePageObject;

public class PaymentPage extends BasePageObject {
	
	
	private By donationSelectField= By.id("contributionAmount");
	private By promoCodeTextField= By.id("promocode");
	private By promocodeApplyButton= By.xpath("//*[@id='promocodedisplay']/div[2]/div/div/div/div/span/button");
	private By checkSameShippingAddress= By.xpath("//*[@id='payment_form']/div/div[3]/div[2]/div[1]/div/div[2]/label/span/span[2]");
	private By checkPaypalButton= By.id("paymenttype-6");
	private By checkCardPayment= By.className("paymenttype1");
	private By cardNumberTextField= By.id("card_number");
	private By cardNameTextField= By.id("cardHolderName");
	private By expireMonthSelect= By.id("exp_month");
	private By expireYearSelect= By.id("exp_year");
	private By cvcCodeTextField= By.id("card_cvc");
	private By checkSavePaymentDetails= By.xpath("//*[@id='cardDetailNew']/div[5]/div/label/span/span[2]");
	private By saveAndContinueButton= By.id("submitPayment");
	private By chooseTitleDropDownField= By.id("salutation");
	private By firstNameTextField= By.id("firstName");
	private By surNameTextField= By.id("lastName");
	private By phoneTextField= By.id("phoneNum");
	private By countrySelectField= By.id("country");
	private static By postCodeTextField= By.id("postcode-lookup");
	private static By lookUpAddressButton= By.id("addrfinderbtn");
	private static By flatNameTextField= By.id("addrLine2");
	private static By companyNameTextField= By.id("addrLine3");
	private static By addressTextField= By.id("addrLine1");
	private static By townCityTextField= By.id("city");
	private static By countryTextField= By.id("stateproreg");
	private static By zipCodeTextField= By.id("zipCode");
	 
	
	
	public PaymentPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	/* wait for Payment page to load */
	public void waitForPaymentPagetoLoad() throws Exception {
		waitForJavascripttoLoad();
	}
	
	/* to give donation on payment page */
	public void chooseDonation(Integer Value) throws Exception{
		select(donationSelectField,Value);
	}
	
	/* apply promo code */
	public void applyPromoCode(String value) throws Exception{
		type(promoCodeTextField,value);
		click(promocodeApplyButton);	
		scrollToBottom();
	}
	
	/* to click on same shipping address */
	public void sameShippAddress() throws Exception{
		
		scrollToBottom();
		Thread.sleep(3000);
		click(checkSameShippingAddress);
	}
	
	
	
	
	/* card payment section */
	public void cardPayment() throws Exception{
		
		scrollToBottom();
		scrollToBottom();
		type(cardNumberTextField,"4012888888881881");
		type(cardNameTextField,"test");
		select(expireMonthSelect,5);
		select(expireYearSelect,8);
		type(cvcCodeTextField, "1234");
		scrollToBottom();
		click(checkSavePaymentDetails);
	}
	
	/* to click on Save and continue button  */
	public void saveAndContinue() throws Exception{
		
		waitForClickabilityOf(saveAndContinueButton,10);
		click(saveAndContinueButton);	
	}
	
	/* payment billing address */
	public void billingAddress() throws Exception{
		
		scrollToBottom();
		select(chooseTitleDropDownField,2);
		type(firstNameTextField,"jiji");
		type(surNameTextField,"test");
		type(phoneTextField,"12345678912");
		type(postCodeTextField,"9028");
		scrollToBottom();
		click(lookUpAddressButton);
		Thread.sleep(5000);
		find(addressTextField).clear();
		type(addressTextField,"2716 Ocean  Park Blvd Suite 1030");
		scrollToBottom();
		find(townCityTextField).clear();
		type(townCityTextField,"testcity");
		find(countryTextField).clear();
		type(countryTextField,"testcountry");
		find(zipCodeTextField).clear();
		type(zipCodeTextField,"90405");
		scrollToBottom();
	}
	
	/* payment functionalities */
	public void paymentFunctionality() throws Exception{
		
		ShippingAddressPage shipAddr= new ShippingAddressPage(driver);
		By paymentTab= By.xpath("//*[@id='progress-payment']/a");
		if(driver.findElements(paymentTab).size()!=0)
		{
			chooseDonation(3);
		    applyPromoCode("saduysg");
		    billingAddress();

		    
//		    pay.sameShippAddress();
		    cardPayment();
		    saveAndContinue();
		}
		
		else
		{
			
			System.out.println("no payment page");
			shipAddr.shippingFunctionality();
		}
	}

	
}
