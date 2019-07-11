package com.novica.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.novica.base.BasePageObject;

public class AddressBookPage extends BasePageObject {
	
	public AddressBookPage(WebDriver driver) {
		super(driver);
	}
	
	
	/* to click on address book option */
	public void clickAddressBook() throws Exception{
		
		WebElement hoverAccountSettingsMenu= driver.findElement(By.xpath("//*[@id='main-page']/div/div[2]/div[8]"));
		WebElement addressBookButton= driver.findElement(By.xpath("//*[@id='main-page']/div/div[2]/div[8]/div/span/div/ul/li[3]/a"));
		HoverAndClick(driver,hoverAccountSettingsMenu,addressBookButton);
	}
	
	/* to remove address from address book */
	public void removeAddress(Integer value) throws Exception{
		
		By deleteButton= By.xpath("//*[@id='main-page']/div[2]/div[2]/div["+value+"]/p/a[2]");
		explicitWait(deleteButton);
		click(deleteButton);
		By yesDeleteButtton= By.xpath("//*[@id='novicamodal']/div/div/div/div[2]/div/div[1]/a");
		explicitWait(yesDeleteButtton);
		click(yesDeleteButtton);
		By okButton= By.xpath("//*[@id='novicamodal']/div/div/div/div/button");
		explicitWait(okButton);
		click(okButton);
		
	}


}
