package com.unicefuk.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.unicefuk.base.BasePageObject;

public class IGCardDetailPage extends BasePageObject {
	
	public IGCardDetailPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	private By createYourCardButton= By.xpath("//*[@id='gifts-completeoptions']/div[1]/a");
	private By NoCardButton= By.xpath("//*[@id='gifts-completeoptions']/div[2]/a");
	private By addmoreGiftsButton= By.id("gifts-addmorelinks");
	private By plusQtyButton= By.className("increase");
	private By minusQtyButton= By.className("decrease ");
	private By viewMyGiftButton= By.xpath("//*[@id='gifts']/div[2]/div/div/a");
	private By printedCardButton= By.xpath("//*[@id='card-deliverymethod']/div/ul/li[1]/a");
	private By eGreetingCardButton= By.xpath("//*[@id='card-deliverymethod']/div/ul/li[2]/a");
	private By printAtHomeButton= By.xpath("//*[@id='card-deliverymethod']/div/ul/li[3]/a");
	private By noCardTwoButton= By.xpath("//*[@id='card-deliverymethod']/div/ul/li[4]/a");
	private By changeImageButton= By.xpath("//*[@id='card-recipient']/div[1]/div/div[2]/a");
	private By recepientNameTextField= By.id("recipientname");
	private By messageTextField= By.id("messagebody");
	private By fromNameTextField= By.id("messagesignoff"); 
	private By saveAndContinueButton= By.xpath("//*[@id='carddetail-recipient']/div[5]/div/a"); 
	private By chooseTitleDropDownField= By.id("salutation");
	private By firstNameTextField= By.id("firstname");
	private By surNameTextField= By.id("lastname");
	private By phoneTextField= By.id("phonenum");
	private By postCodeTextField= By.id("postcode-lookup");
	private By lookUpAddressButton= By.id("addrfinderbtn");
	private By flatNameTextField= By.id("addrLine2");
	private By companyNameTextField= By.id("addrLine3");
	private By saveAndContinueTwoButton= By.xpath("//*[@id='delivery']/div[2]/div/div[3]/div[2]/button");
	private By editDeliveryAddressButton= By.xpath("//*[@id='delivery']/div[2]/div/div[2]/div[1]/div[2]/button");
	private By continueToBasketButton= By.xpath("//*[@id='delivery']/div[2]/div/div[2]/div[2]/div[2]/a");
	private By printAtHomeEditCardButton= By.xpath("//*[@id='carddetail']/div[2]/div/div[2]/div[1]/button");
	private By printAtHomeContinueToBagButton= By.xpath("//*[@id='carddetail']/div[2]/div/div[2]/div[2]/a");
	private By printAtHomeSaveButton= By.xpath("//*[@id='carddetail-recipient']/div[5]/div/a");
	private static By addressTextField= By.id("addrLine1");
	private static By townCityTextField= By.id("city");
	private static By countryTextField= By.id("stateproreg");
	private static By zipCodeTextField= By.id("zipCode");

	
	/* to wait for load card page */
	public void waitCardpage() throws Exception{
		
		waitForJavascripttoLoad();
	}
	
	/* to click on create your card button */
	public void clickCreateCard() throws Exception{
		
		scrollToBottom();
		waitForClickabilityOf(createYourCardButton, 10);
		click(createYourCardButton);
	}
	
	/* to click on no card needed button */
	public void clickNoCard() throws Exception{
		
		scrollToBottom();
		waitForClickabilityOf(NoCardButton, 10);
		click(NoCardButton);
	}
	
	/* to click on Add more Gifts button */
	public void clickAddMoreGifts() throws Exception{
		
		scrollToBottom();
		waitForClickabilityOf(addmoreGiftsButton, 10);
		click(addmoreGiftsButton);
	}
	
	/* to increase IG gifts quantity */
	public void addqtyIG() throws Exception{
		
		waitForClickabilityOf(plusQtyButton, 10);
		click(plusQtyButton);
		
	}
	
	/* to reduce IG gifts quantity */
	public void reduceqtyIG() throws Exception{
		
		waitForClickabilityOf(minusQtyButton, 10);
		click(minusQtyButton);
		
	}
	
	/* to click View My Gift button */
	public void clickViewGift() throws Exception{
		
		waitForJavascripttoLoad();
		waitForClickabilityOf(viewMyGiftButton, 10);
		click(viewMyGiftButton);
	}
	
	/* to click printed card button */
	public void clickprintedCard()throws Exception{
		
		waitForJavascripttoLoad();
		waitForClickabilityOf(printedCardButton, 10);
		click(printedCardButton);
	}
	
	/* to click E-Greeting card button */
	public void clickEgreetingCard()throws Exception{
		
		waitForJavascripttoLoad();
		waitForClickabilityOf(eGreetingCardButton, 10);
		click(eGreetingCardButton);
	}
	
	/* to click print at home card button */
	public void clickPrintAtHomeCard()throws Exception{
		
		waitForJavascripttoLoad();
		waitForClickabilityOf(printAtHomeButton, 10);
		click(printAtHomeButton);
	}
	
	/* to click second No card button */
	public void clickSecondNoCardButton() throws Exception{
		
		waitForJavascripttoLoad();
		waitForClickabilityOf(noCardTwoButton, 10);
		click(noCardTwoButton);
	}
	
	/* to select view By occasion items */
	public void viewByOccasion(Integer value)throws Exception{
		
		By selectViewByOccasion= By.xpath("//*[@id='card-coverimage']/div[2]/div/div[1]/div[1]/select");
		select(selectViewByOccasion,value);
	}
	
	/* to select view By Category items */
	public void viewByCategory(Integer value)throws Exception{
		
		By selectViewByCategory= By.xpath("//*[@id='card-coverimage']/div[2]/div/div[1]/div[2]/select");
		select(selectViewByCategory,value);
	}
	
	
	/* to select Cover Image for card */
	public void chooseCoverImage(Integer randomnumber)throws Exception{
		
		By clickImage = By.xpath("//*[@id='card-coverimage']/div[3]/div["+randomnumber+"]/a");
		click(clickImage);	
	}
	
	/* to click on change Image Button */
	public void clickChangeImage()throws Exception{
		
		waitForClickabilityOf(changeImageButton, 10);
		click(changeImageButton);
	}
	
	/* to give detail of card message */
	public void giveCardMessage()throws Exception{
		
		type(recepientNameTextField,"testuser");
		type(messageTextField,"test message for gift card");
		type(fromNameTextField,"jijitest");
		scrollToBottom();
	}
	
	/* to click on save and continue button */
	public void clickSaveAndContinue()throws Exception{
		
		
		waitForClickabilityOf(saveAndContinueButton, 10);
		click(saveAndContinueButton);
		
	}
	
	/* to click on save and continue button for printed at home card */
	public void clickSavePrintatHome()throws Exception{
		
		
		waitForClickabilityOf(printAtHomeSaveButton, 10);
		click(printAtHomeSaveButton);
		
	}
	
	/* to give address for sending card */
	
	public void deliveryAddress() throws Exception{
		
		waitForJavascripttoLoad();
		select(chooseTitleDropDownField,2);
		type(firstNameTextField,"jiji");
		type(surNameTextField,"test");
		type(phoneTextField,"12345678912");
		scrollToBottom();
		type(postCodeTextField,"9028");
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
		click(saveAndContinueTwoButton);
	}
	
	/* to click on Edit delivery address button */
	public void editDeliveryAddress()throws Exception{
		
		waitForJavascripttoLoad();
		waitForClickabilityOf(editDeliveryAddressButton, 10);
		click(editDeliveryAddressButton);
	}
	 
	/* to click on continue to Bag button */
	public void clickContinueToBag()throws Exception{
		
		waitForJavascripttoLoad();
		waitForClickabilityOf(continueToBasketButton, 10);
		click(continueToBasketButton);
	}
	
	/* to click edit  print at home card button */
	public void printAtHomeEditCard()throws Exception{
		
		waitForJavascripttoLoad();
		waitForClickabilityOf(printAtHomeEditCardButton, 10);
		click(printAtHomeEditCardButton);
		
	}
	
	/* to click on continue to bag button in print at home card */
	public void printAtHomeContinueToBag()throws Exception{
		
		waitForJavascripttoLoad();
		waitForClickabilityOf(printAtHomeContinueToBagButton, 10);
		click(printAtHomeContinueToBagButton);
	}
	
	/* to  enter name and email details for egreeting card */
	public void emailDetailsECard()throws Exception{
		
		By nameRecepient= By.id("recipientname");
		type(nameRecepient,"test user");
		By emailAddressRecepient= By.id("recipientemail");
		type(emailAddressRecepient,"testuser@gmail.com");
		scrollToBottom();
		By saveButton= By.xpath("//*[@id='carddelivery-address']/div[7]/div/button");
		click(saveButton);
		
	}
	
	/* to edit e-card email address */
	public void editEmail()throws Exception{
		
		By emailEditButton= By.xpath("//*[@id='delivery']/div[2]/div/div/div[1]/div[2]/button");
		waitForJavascripttoLoad();
		waitForClickabilityOf(emailEditButton, 10);
		click(emailEditButton);
	}
	
	 /* to click on continue to bag button of E card */
	public void EcardContinueToBag()throws Exception{
		
		By continueEcardButton= By.xpath("//*[@id='delivery']/div[2]/div/div/div[2]/div[2]/a");
		waitForJavascripttoLoad();
		waitForClickabilityOf(continueEcardButton, 10);
		click(continueEcardButton);
	}
	

}
