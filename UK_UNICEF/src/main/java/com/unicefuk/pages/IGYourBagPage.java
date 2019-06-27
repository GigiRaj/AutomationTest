package com.unicefuk.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.unicefuk.base.BasePageObject;

public class IGYourBagPage extends BasePageObject {

	public IGYourBagPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	private By keepShoppingButton= By.xpath("//*[@id='shop']/div[1]/div/div/div[1]/div/div[2]/a");
	
	
	/* to click preview card button */
	public void clickPreviewcard(Integer randomvalue)throws Exception{
		
		By previewCardButton= By.xpath("//*[@id='updateCart']/div[2]/div["+randomvalue+"]/div/div[2]/div[2]/div/p/a[1]");
		waitForClickabilityOf(previewCardButton, 10);
		click(previewCardButton);
	}
	
	/* to edit the card */
	public void clickEditcard(Integer randomvalue)throws Exception{
		
		By editCardButton= By.xpath("//*[@id='updateCart']/div[2]/div["+randomvalue+"]/div/div[2]/div[2]/div/p/a[2]");
		waitForClickabilityOf(editCardButton, 10);
		click(editCardButton);
	}
	
	/* to duplicate the card */
	public void clickDuplicateCard(Integer randomvalue)throws Exception{
		
		By duplicateCardButton= By.xpath("//*[@id='updateCart']/div[2]/div["+randomvalue+"]/div/div[2]/div[2]/div/p[2]/a");
		waitForClickabilityOf(duplicateCardButton, 10);
		click(duplicateCardButton);
	}
	
	/* to remove the gift from the basket */
	
	public void clickRemove(Integer randomvalue )throws Exception{
		
		By removeGiftButton= By.xpath("//*[@id='updateCart']/div[2]/div["+randomvalue+"]/div/div[2]/div[1]/div[1]/div/a");
		waitForClickabilityOf(removeGiftButton, 10);
		click(removeGiftButton);
	}
	
	/* to click on Remove Ok button in pop up */
	
	public void clickRemoveOkButton()throws Exception{
		
		By removeOkButton= By.xpath("//*[@id='novicamodal']/div/div/div/div/div[3]/div[1]/a");
		Thread.sleep(3000);
		waitForClickabilityOf(removeOkButton, 10);
		click(removeOkButton);
	}
	
}
