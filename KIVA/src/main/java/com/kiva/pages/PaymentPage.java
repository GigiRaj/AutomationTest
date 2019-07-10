package com.kiva.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.kiva.base.BasePageObject;

public class PaymentPage extends BasePageObject {
	
	public PaymentPage(WebDriver driver){
		super(driver);
	}
	
	By promocodeTextBox= By.id("promocode");
	By promocodeApplybutton= By.xpath("//*[@id='promocodedisplay']/div[2]/div/div/div/div/span/button");
	By donationSelectBox= By.id("contributionAmount");
	By sameShippingAddressCheckBox= By.xpath("//*[@id='payment_form']/div/div[3]/div[2]/div[1]/div/div[2]/label");
	By firstNameTextBox= By.id("firstName");
	By lastNameTextBox= By.id("lastName");
	By addressLine1TextBox= By.id("addrLine1");
	By addressLine2TextBox= By.id("addrLine2");
	By cityTextBox= By.id("city");
	By zipcodeTextBox= By.id("zipCode");
	By stateSelectBox= By.id("state");
	By phoneTextField= By.id("phoneNum");
	By companyTextField= By.id("addrLine3");
	By paypalButton= By.className("paypal-button");
	
			
			
	
	public void waitForPaymentPageToLoad() throws Exception {
		waitForJavascripttoLoad();
	}
	
	/* to apply promocode */
	public void applyPromocode() throws Exception{
		
		explicitWait(promocodeTextBox);
		type(promocodeTextBox,"PROMOCODE");
		click(promocodeApplybutton);	
	}
	
	/* choose donation */
	public void chooseDonation() throws Exception{
		
		select(donationSelectBox,3);
		scrollToBottom();
		
	}
	
	/* to click same as shipping address checkbox */
	public void sameShipAddress() {
		
		click(sameShippingAddressCheckBox);
	}
	
	/* create new address */
	public void createBillingAddress() throws Exception{
		
		type(firstNameTextBox,"bob");
		type(lastNameTextBox,"test");
		type(addressLine1TextBox,"2716 Ocean  Park Blvd Suite 1030");
		type(addressLine2TextBox,"test house");
		type(cityTextBox,"Santa Monica");
		type(zipcodeTextBox,"90405");
		select(stateSelectBox,8);
		type(phoneTextField,"6666654686");
		type(companyTextField,"test company");
	
	}
	
	/* to click on paypal button */
	public void clickPaypal() {
		
		click(paypalButton);
	}

}
