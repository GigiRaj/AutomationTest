package com.healthebay.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.healthebay.base.BasePageObject;

public class CheckOutPage extends BasePageObject {

	public CheckOutPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	By customerEmailAddress = By.id("email");
	By customerPassword= By.id("password");
	By continueasGuestButton = By.id("checkout-customer-continue");
	By SigninNowLinkButton = By.id("checkout-customer-login");
	By cancelButton= By.id("checkout-customer-cancel");
	By shippingFirstName = By.id("firstNameInput");
	By shippingLastName = By.id("lastNameInput");
	By shippingCompanyName = By.id("companyInput");
	By shippingPhoneNumber = By.id("phoneInput");
	By shippingAddressLine1 = By.id("addressLine1Input");
	By shippingAddressLine2 = By.id("addressLine2Input");
	By shippingCity = By.id("cityInput");
	By shippingCountry = By.id("countryCodeInput");
	By shippingState = By.id("provinceCodeInput");
	By shippingPostalCode = By.id("postCodeInput");
	By shippingOrderComments = By.name("orderComment");
	By sameasShippingCheckbox= By.xpath("//div[@class='checkout-form']/div[2]/div/form/fieldset[1]/div/div/div/label");
	By shippingContinueButton = By.id("checkout-shipping-continue");
	By shipcontinueCustomerButton= By.xpath("//div[@class='checkout-form']/div[2]/div/form/div/button");
	By paymentCreditCardNumber = By.id("ccNumber");
	By paymentExpirationDate = By.id("ccExpiry");
	By paymentCardName = By.id("ccName");
	By paymentCardCVV = By.id("ccCvv");
	By placeOrderButton = By.id("checkout-payment-continue");

	public void guestLogin(String email) throws Exception {
		explicitWait(continueasGuestButton);
		type(customerEmailAddress, email);
		click(continueasGuestButton);
		Thread.sleep(1000);
	}

	public void customerSignIn() throws Exception {
		Thread.sleep(3000);
		click(SigninNowLinkButton);
		type(customerEmailAddress,"jijitest.sprcn@gmail.com");
		type(customerPassword,"spark007");
		click(continueasGuestButton);	
		Thread.sleep(5000);
//		click(sameasShippingCheckbox);
		scrollToBottom();
		Thread.sleep(5000);
		click(shippingContinueButton);
		Thread.sleep(8000);
	}

	public void shipppingDetails() throws Exception {
		explicitWait(shippingFirstName);
		type(shippingFirstName, "Gigi");
		type(shippingLastName, "test");
		type(shippingCompanyName, "abcd company");
		type(shippingPhoneNumber, "789456123");
		type(shippingAddressLine1, "2716 Ocean  Park Blvd Suite 1030");
		type(shippingAddressLine2, "test");
		type(shippingCity, "Santa Monica");
		select(shippingCountry, 1);
		Thread.sleep(1000);
		select(shippingState, 12);
		type(shippingPostalCode, "90405");
		Thread.sleep(1000);
		type(shippingOrderComments, "test comment");
		Thread.sleep(3000);
		click(shippingContinueButton);
		Thread.sleep(5000);
	}

	public void paymentDetails() throws Exception {
		type(paymentCreditCardNumber, "4012888888881881");
		type(paymentExpirationDate, "0822");
		type(paymentCardName, "test");
		type(paymentCardCVV, "1234");
	}

}
