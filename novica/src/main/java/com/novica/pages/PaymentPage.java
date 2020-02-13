package com.novica.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

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
	private By cardNumber= By.name("credit-card-number");
	private By cardName= By.name("cardHolderName");
	private By expireMonth= By.id("expiration-month");
	private By expireYear= By.id("expiration-year");
	private By cvcCode= By.id("cvv");
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
		Reporter.log("wait for payment page to load <br>");
	}
	
	/* apply promo code */
	public void applyPromoCode(String value) throws Exception{
		type(promoCode,value);
		click(promocodeApplyButton);
		Reporter.log("click on apply promocode button <br>");
	}
	
	/* choose donation amount */
	public void chooseDonation(Integer value) throws Exception{
		select(donateSelectBox,value);
		Reporter.log("select donation from select box <br>");
	}
	
	/* card payment section */
	public void cardPayment() throws Exception{
		
		scrollToBottom();
		driver.switchTo().frame("braintree-hosted-field-number");
		Reporter.log("go to card payment section <br>");
		type(cardNumber,"4012888888881881");
		Reporter.log("give card number <br>");
		driver.switchTo().parentFrame();
		
		type(cardName,"test");
		Reporter.log("give card name <br>");
		driver.switchTo().frame("braintree-hosted-field-expirationMonth");
		select(expireMonth,5);
		Reporter.log("select card expiration month <br>");
		driver.switchTo().parentFrame();
		driver.switchTo().frame("braintree-hosted-field-expirationYear");
		select(expireYear,8);
		Reporter.log("select card expiration year <br>");
		driver.switchTo().parentFrame();
		driver.switchTo().frame("braintree-hosted-field-cvv");
		type(cvcCode, "1234");
		Reporter.log("give card cvc code <br>");
		driver.switchTo().parentFrame();
		click(checkDebit);
		Reporter.log("check on debit check box <br>");
//		click(checkSaveforLater);
	}
	
	/* to click on Continue button */
	public void clickContinueButton() throws Exception{
		
		waitForClickabilityOf(continueButton,10);
		click(continueButton);
		Reporter.log("click on continue button <br>");
	}
	
	/* to click on shipping Tab */
	public void clickShippingTab() throws Exception{
		
		waitForClickabilityOf(shippingButton,10);
		click(shippingButton);
		Reporter.log("click on shipping button <br>");
	}
	
	/* to click on use same address button */
	public void clickSameAddess() throws Exception{
		
		waitForClickabilityOf(useThisAddressButton,10);
		click(useThisAddressButton);
		Reporter.log("click on same address button <br>");
	}
	
	/* select address from Address Book using index */
	public void selectFromAddressBook(Integer value)throws Exception{
		
		scrollToBottom();
		By selectAddressBookButton= By.id("addresstype-selector-2");
		click(selectAddressBookButton);
		Reporter.log("click on select address button <br>");
		By selectAddress= By.xpath("//*[@id='addresstype-2']/div[2]/div/p["+value+"]");
		click(selectAddress);
		Reporter.log("choose different address <br>");
	}
	
	/* to create new billing address */
	public void createBillingAddress() throws Exception{
		
		scrollToBottom();
		By addBillingAddressButton= By.id("addresstype-selector-3");
		click(addBillingAddressButton);		
		Reporter.log("click on add billing address button <br>");
	}
	
	public void paymentPageFunctionalities() throws Exception{
		
		ShippingAddressPage shipAddr= new ShippingAddressPage(driver);
	
		By paymentButton= By.xpath("//*[@id='progress-payment']/a[1]");
		if(driver.findElements(paymentButton).size()!=0)
		{
			Reporter.log("redirect to payment page if the payment button is active <br>");
			applyPromoCode("QWERTY");
			Reporter.log("apply promocode <br>");
			chooseDonation(5);
			Reporter.log("choose donation <br>");
			cardPayment();
			Reporter.log("choose cardpayment <br>");
			selectFromAddressBook(1);
			Reporter.log("choose billing address <br>");
			clickContinueButton();
			Reporter.log("click on confirm order button <br>");
			
		}
		
		else
		{
			
			
			System.out.println("no payment page");
			Reporter.log("redirect to shipment page if the payment button is not active <br>");
			shipAddr.shippingAddressPageFunctionalities();
			Reporter.log("redirect to shipment page <br>");
		}
			
	}
	
	
}
