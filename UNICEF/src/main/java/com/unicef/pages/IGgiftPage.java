package com.unicef.pages;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.unicef.base.BasePageObject;

public class IGgiftPage extends BasePageObject {
	
	public IGgiftPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	
	
	private By IGAddToCartButtonField= By.id("btn-addtocart");
	private By createCardButton= By.xpath("//*[@id='gifts-completeoptions']/div[1]/a");
	private By printedCardButton= By.id("print-card");
	private By goBackButton= By.xpath("//*[@id='novicamodal']/div/div/div/div/div[2]/button");
	private By egreetingCardButton= By.id("e-greeting");
	private By printAtHomeButton= By.id("print-at-home");
	private By noCardButton= By.id("no-card");
	private By yesSureButton= By.xpath("//*[@id='novicamodal']/div/div/div/div/div[3]/div[1]/a");
	private By editImageButton= By.xpath("//*[@id='card-recipient']/div[1]/div/div[2]/a");
	private By receipientName= By.id("recipientname");
	private By receipientEmail= By.id("recipientemail");
	private By greetMessage= By.id("messagegreeting");
	private By messageDetail= By.id("messagebody");
	private By senderName= By.id("messagesignoff");
	private By saveContinueButton1= By.xpath("//*[@id='carddetail-recipient']/div[5]/div/a");
	private By saveContinueButton2= By.xpath("//*[@id='carddelivery-address']/div[7]/div/button");
	private By addtoMyBagWithCardButton= By.xpath("//*[@id='carddetail']/div/div/div[2]/div/div[2]/div[2]/a");
	private By editCardButton= By.xpath("//*[@id='carddetail']/div/div/div[2]/div/div[2]/div[1]/button");
	private By editEmailButton= By.xpath("//*[@id='delivery']/div/div/div[2]/div/div/div[1]/div[2]/button");
	private By continueToBagButton= By.xpath("//*[@id='delivery']/div/div/div[2]/div/div/div[2]/div[2]/a");
	
	


	
	/* to click on choose IG according to index from the list */
	public void chooseIGItems(Integer randomIGItemNumber) throws Exception{
		
		 By chooseDifferentIG = By.xpath("//*[@id='IG-morewaysToHelp']/div[2]/div[" + randomIGItemNumber + "]/a");
		click(chooseDifferentIG);
		scrollToBottom();
		
		
	}
	
	
	/* to click random products under IG product list page */
	public void clickIGProductPlateRandom(Integer randomeProductPlateNumber) throws Exception {
		 By currentproductPlateField = By.xpath("//*[@id='IG-allGifts']/div/div[2]/div/ul/li[" + randomeProductPlateNumber + "]/div/a");
		click(currentproductPlateField);
	}
	
	
	
	 /* to add IG gift to cart */
	
	public void addIGtocart() throws Exception{
		
		waitForClickabilityOf(IGAddToCartButtonField, 10);
		Thread.sleep(3000);
		click(IGAddToCartButtonField);
		scrollToBottom();
		
	}
	
	/* to click on create card button */
	public void createCard() throws Exception{
		
		waitForClickabilityOf(createCardButton, 10);
		click(createCardButton);
	}
	
	/* to create printed ecard */
	public void printedCard() throws Exception{
		
		waitForClickabilityOf(printedCardButton, 10);
		click(printedCardButton);
		Thread.sleep(5000);
		click(goBackButton);
	}
	
	/* to create E-greeting card */
	public void EgreetingCard() throws Exception{
		
		waitForClickabilityOf(egreetingCardButton, 10);
		click(egreetingCardButton);
		scrollToBottom();
	
	}
	
	/* to create Print at home card */
	public void printatHomeCard() throws Exception{
		
		waitForClickabilityOf(printAtHomeButton, 10);
		click(printAtHomeButton);
		scrollToBottom();
	
	}
	
	/* to click on No card */
	public void noCard() throws Exception{
		
		waitForClickabilityOf(noCardButton, 10);
		click(noCardButton);
		Thread.sleep(5000);
		click(yesSureButton);
	}
	
	
	/* to select image for card using index */
	public void selectImage(Integer randomnumber) throws Exception{
		
		By clickImage = By.xpath("//*[@id='card-coverimage']/div[3]/div["+randomnumber+"]/a");
		click(clickImage);	
	}
	
	/* to edit image in card using edit image button */
	public void editImage() throws Exception{
		
		waitForClickabilityOf(editImageButton, 10);
		click(editImageButton);
		
	}
	
	/* to write card message and details */
	public void cardMessage() throws Exception{
		
		type(receipientName,"Test User");
		type(greetMessage,"Test greet message");
		type(messageDetail,"detailed test message");
		type(senderName,"jiji");
		click(saveContinueButton1);
	}
	
	/* details related with sending information using e-greeting card */
	public void sendDetails() throws Exception{
		
		waitForVisibilityOf(receipientName, 10);
		type(receipientName,"test user");
		type(receipientEmail,"testuser@gmail.com");
		click(saveContinueButton2);
		
	}
	
	/* to edit delivery email address by clicking edit button */
	public void editDeliverEmail() throws Exception{
		
		waitForVisibilityOf(editEmailButton, 10);
		click(editEmailButton);
		sendDetails();
		
	}
	
	/* to click on continue button in delivery address page */
	public void continueToBag() throws Exception{
		
		waitForVisibilityOf(continueToBagButton, 10);
		click(continueToBagButton);
		
	}
	
	/* to click on Add to my bag button in create card section */
	public void addtoMyBagWithCard() throws Exception{
		
		waitForClickabilityOf(addtoMyBagWithCardButton, 10);
		click(addtoMyBagWithCardButton);
		
	}
	
	/* to click on edit button in create card section */
	public void editCard() throws Exception{
		
		waitForClickabilityOf(editCardButton, 10);
		click(editCardButton);
	}

}
