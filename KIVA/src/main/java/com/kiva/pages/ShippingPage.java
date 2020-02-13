package com.kiva.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.kiva.base.BasePageObject;

public class ShippingPage extends BasePageObject {
	
	public ShippingPage(WebDriver driver){
		super(driver);
	}
	
	By giftForSomeoneSelectBox= By.xpath("//*[@id='giftindicator']/div[1]/label");
	By chooseDonationSelectBox= By.id("contributionAmount");
	By giftMessageTextBox= By.id("giftmessage");
	By saveaAndContinueButton= By.id("submitShippingOptions2");
	By giftForMeOption= By.xpath("//*[@id='giftindicator']/div[2]/label");
	By dedicateDonationOption= By.xpath("//*[@id='donorselect']/div[1]/label/span[1]");
	
	
	public void waitForShippingPagetoload() throws Exception{
		waitForJavascripttoLoad();
		}
	

	
	/* to select order for gift someone */
	
	public void GiftforSomeone() throws Exception{
		
		explicitWait(giftForSomeoneSelectBox);
		
		click(giftForSomeoneSelectBox);
		scrollToBottom();
		explicitWait(chooseDonationSelectBox);
		select(chooseDonationSelectBox,3);
		click(dedicateDonationOption);
		type(giftMessageTextBox,"Happy birth day user");
		scrollToBottom();
		
	}
	
	/* to select gift for me option */
	public void GiftForMe() throws Exception {
		explicitWait(giftForMeOption);
		click(giftForMeOption);
		
	}
	/* to click save and continue button */
	
	public void clickSaveandContinue()throws Exception{
		
		explicitWait(saveaAndContinueButton);
		click(saveaAndContinueButton);
		
	}

}
