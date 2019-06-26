package com.unicefuk.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.unicefuk.base.BasePageObject;

public class IGgiftPage extends BasePageObject {
	
	public IGgiftPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	
	/* to open IG gifts according to category from header menu */
	public void IGgiftCategory(Integer categoryNo)throws Exception{
		
		WebElement hoverIGHeaderMenu= driver.findElement(By.id("inspired-gifts"));
		WebElement clickIGCateogry= driver.findElement(By.xpath("//*[@id='header-main-flyout']/li/ul/li/div/ul/li/ul/li["+categoryNo+"]/a"));
		HoverAndClick(driver,hoverIGHeaderMenu,clickIGCateogry);
	}
	

}
