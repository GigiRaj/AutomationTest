package com.kiva.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.kiva.base.BasePageObject;

public class DeliveryAddressPage extends BasePageObject {
	
	
	public DeliveryAddressPage(WebDriver driver){
				super(driver);
	}
	
	By emailAddressTextBox= By.id("email");
	By firstNameTextBox= By.id("firstName");
	By lastNameTextBox= By.id("lastName");
	By addressTextBox= By.id("addrLine1");
	By addressLine2TextBox= By.id("addrLine2");
	By addressCityTextBox= By.id("city");
	By zipcodeTextBox= By.id("zipCode");
	By stateSelectBox= By.id("state");
	By phoneTextBox= By.id("phoneNum");
	By companyTextBox= By.id("addrLine3");
	By continueButton= By.id("submitAddress2");
	
	
	public void waitForDeliverAddresstoload() throws Exception{
		waitForJavascripttoLoad();
		}
	
	/* to input delivery address */
	public void createAddress() throws Exception{
		
		explicitWait(emailAddressTextBox);
		type(emailAddressTextBox,"jijitest.sprcn@gmail.com");
		type(firstNameTextBox,"gigi");
		type(lastNameTextBox,"test");
		type(addressTextBox,"2716 Ocean  Park Blvd Suite 1030");
		scrollToBottom();
		type(addressLine2TextBox,"testhouse");
		type(addressCityTextBox,"Santa Monica");
		type(zipcodeTextBox,"90405");
		select(stateSelectBox,8);
		type(phoneTextBox, "9856231245");
		type(companyTextBox,"test company");
	}
	
	/* to click continue button */
	public void clickContinue() {
		waitForClickabilityOf(continueButton, 10);
		click(continueButton);
	}

}
