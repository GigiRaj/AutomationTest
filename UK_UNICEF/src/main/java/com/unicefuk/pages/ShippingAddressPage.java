package com.unicefuk.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.unicefuk.base.BasePageObject;

public class ShippingAddressPage extends BasePageObject {
	
	private static By chooseTitleDropDownField= By.id("salutation");
	private static By firstNameTextField= By.id("firstName");
	private static By surNameTextField= By.id("lastName");
	private static By phoneTextField= By.id("phoneNum");
	private static By countrySelectField= By.id("country");
	private static By postCodeTextField= By.id("postcode-lookup");
	private static By lookUpAddressButton= By.id("addrfinderbtn");
	private static By chooseFirstAddress= By.xpath("//*[@id='addrfinderbtn-container']/div/div[2]/p[1]");
	private static By manualAddressLinkButton= By.id("addrswitch-manual");
	private static By houseNameTextField= By.id("addrLine1");
	private static By flatNameTextField= By.id("addrLine2");
	private static By companyNameTextField= By.id("addrLine3");
	private static By townNameTextField= By.id("city");
	private static By countryNameTextField= By.id("stateproreg");
	private static By manualPostcodeTextField= By.id("zipCode");
	private static By lookUpAddressLinkButton= By.xpath("//*[@id='lookUpAdress']/div[7]/a");
	private static By checkDefaultShippingAddress= By.xpath("//*[@id='aa']/div/div[1]/div[3]/div/label[1]");
	private static By checkUseOrder= By.xpath("//*[@id='aa']/div/div[1]/div[3]/div/label[2]");
	private static By saveAndContinueButton= By.id("submitAddress2");
	private static By dispatchSaveAndContinue= By.id("submitShippingOptions2");
	
	
	public ShippingAddressPage(WebDriver driver) {
		super(driver);
	}
	
	public void waitForShippingPageToload() throws Exception {
		waitForJavascripttoLoad();
	}
	
	/* to create address using look up */
	public void addLookUpAddress() throws Exception{
		
		select(chooseTitleDropDownField,2);
		type(firstNameTextField,"jiji");
		type(surNameTextField,"test");
		type(phoneTextField,"12345678912");
		select(countrySelectField,1);
		type(postCodeTextField,"9028");
		click(lookUpAddressButton);
		Thread.sleep(5000);
		type(flatNameTextField,"test flat address");
		type(companyNameTextField,"test company");
		scrollToBottom();
		click(checkDefaultShippingAddress);
		click(checkUseOrder);
		click(saveAndContinueButton);
	}
	
	/* to create address manually */
	
	public void manualAddress() throws Exception{
		
		select(chooseTitleDropDownField,2);
		type(firstNameTextField,"jiji");
		type(surNameTextField,"test");
		type(phoneTextField,"12345678912");
		select(countrySelectField,1);
		scrollToBottom();
		click(manualAddressLinkButton);
		type(houseNameTextField,"test house name");
		type(flatNameTextField,"test flat address");
		type(companyNameTextField,"test company");
		type(townNameTextField,"test city");
		scrollToBottom();
		type(countryNameTextField,"test country");
		type(manualPostcodeTextField,"456123");
		click(checkDefaultShippingAddress);
		click(checkUseOrder);
		click(saveAndContinueButton);
		
	}
	
	public void dispatchShipping() throws Exception{
		waitForClickabilityOf(dispatchSaveAndContinue,10);
		click(dispatchSaveAndContinue);	
	}

}
