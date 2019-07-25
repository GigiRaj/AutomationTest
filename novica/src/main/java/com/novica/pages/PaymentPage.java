package com.novica.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.novica.base.BasePageObject;
import com.novica.pages.ShippingAddressPage;

public class PaymentPage extends BasePageObject {
	
	public PaymentPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	private By promoCode= By.id("promocode");
	private By promocodeApplyButton= By.xpath("//*[@class='control-promocode']/div/div/span/button");
	private By donateSelectBox= By.id("contributionAmount");
	private By cardNumber= By.id("card_number");
	private By cardName= By.id("cardHolderName");
	private By expireMonth= By.id("exp_month");
	private By expireYear= By.id("exp_year");
	private By cvcCode= By.id("card_cvc");
	private By checkDebit= By.id("isDebitCard");
	private By firstName= By.id("firstName");
	private By lastName= By.id("lastName");
	private By country= By.id("lastName");
	private By addressLine1= By.id("addrLine1");
	private By addressLIne2= By.id("addrLine2");
	private By city= By.id("city");
	private By state= By.id("state");
	private By zipcode= By.id("zipCode");
	private By phoneNumber= By.id("phoneNum");
	private By continueButton= By.id("submitPayment");
	private By shippingButton= By.className("shipping-item");
	private By useThisAddressButton= By.className("useaddress");
	
	
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
	
	/* to click on Continue button */
	public void clickContinueButton() throws Exception{
		
		waitForClickabilityOf(continueButton,10);
		click(continueButton);
	}
	
	/* to click on shipping Tab */
	public void clickShippingTab() throws Exception{
		
		waitForClickabilityOf(shippingButton,10);
		click(shippingButton);
	}
	
	/* to click on use same address button */
	public void clickSameAddess() throws Exception{
		
		waitForClickabilityOf(useThisAddressButton,10);
		click(useThisAddressButton);
	}
	
	/* select address from Address Book using index */
	public void selectFromAddressBook(Integer value)throws Exception{
		
		scrollToBottom();
		By selectAddressBookButton= By.id("addresstype-selector-2");
		click(selectAddressBookButton);
		By selectAddress= By.xpath("//*[@id='addresstype-2']/div[2]/div/p["+value+"]");
		click(selectAddress);
	}
	
	/* to create new billing address */
	public void createBillingAddress() throws Exception{
		
		scrollToBottom();
		By addBillingAddressButton= By.id("addresstype-selector-3");
		click(addBillingAddressButton);		
	}
	
	public void paymentPageFunctionalities() throws Exception{
		
		ShippingAddressPage shipAddr= new ShippingAddressPage(driver);
		
		By paymentButton= By.xpath("//*[@id='progress-payment']/a[1]");
		if(driver.findElements(paymentButton).size()!=0)
		{
			System.out.println("test");
			applyPromoCode("QWERTY");
			chooseDonation(5);
			cardPayment();
			clickContinueButton();
			
		}
		
		else
		{
			
			
			System.out.println("no payment page");
			shipAddr.shippingAddressPageFunctionalities();
		}
			
	}
	
	
}
