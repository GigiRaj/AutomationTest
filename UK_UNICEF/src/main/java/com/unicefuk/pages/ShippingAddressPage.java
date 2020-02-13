package com.unicefuk.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.unicefuk.pages.PaymentPage;
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
		scrollToBottom();
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
		
		Thread.sleep(3000);
		select(chooseTitleDropDownField,2);
		type(firstNameTextField,"jiji");
		type(surNameTextField,"test");
		type(phoneTextField,"12345678912");
//		select(countrySelectField,1);
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
	
	/* click on same addrees button */
	public void sameAddress(Integer randomnumber) throws Exception{
		
		By sameAddButton= By.xpath("//*[@id='addressBook']/div["+randomnumber+"]/form/button");
		waitForClickabilityOf(sameAddButton,10);
		click(sameAddButton);
	}
	
	/* to create new address */
	public void createAddress() throws Exception{
		
		By createAddressButton=By.xpath("//*[@id='shippingAddressForm']/div[2]/div[2]/a");
		click(createAddressButton);
		Thread.sleep(5000);
		addLookUpAddress();
	}
	
	/* click on Address book header menu*/
	public void addressBookMenu() throws Exception{
	
		
		WebElement yourAccountButton= driver.findElement(By.id("account-menu"));
		WebElement gotoAddressButton= driver.findElement(By.xpath("//*[@id='cart-account-flyout']/li[2]/div/ul/li/ul/li[5]/a"));
		HoverAndClick(driver,yourAccountButton,gotoAddressButton);
		System.out.println("go to address book page");
	}
	
	/*to remove address from address book */
	public void RemoveAddressBook(Integer randomnumber) throws Exception{
		
		Thread.sleep(3000);
		By removeAddressButton=By.xpath("//*[@id='shop']/div[1]/div/div[1]/div[2]/div/div[1]/div["+randomnumber+"]/a[2]");
		click(removeAddressButton);
		Thread.sleep(3000);
		By yesdeleteButton= By.xpath("//*[@id='novicamodal']/div/div/div/div[2]/div/div[1]/a");
		click(yesdeleteButton);
		Thread.sleep(3000);
		By okDeleteButton= By.xpath("//*[@id='novicamodal']/div/div/div/div/button");
		click(okDeleteButton);
		
	}
	
	/* to do shipping functionality */
	public void shippingFunctionality() throws Exception{
		
		PaymentPage pay= new PaymentPage(driver);
		By recipientFirstName= By.id("firstName"); 
		
		if(driver.findElements(recipientFirstName).size() == 0){
			
			createAddress();
			sameAddress(1);
			dispatchShipping();
			Thread.sleep(5000);
			pay.paymentFunctionality();
			
		}		
		else
		{
			
			waitForShippingPageToload();
			manualAddress();
			dispatchShipping();
			Thread.sleep(5000);
			pay.paymentFunctionality();
		}
	}
	

}
