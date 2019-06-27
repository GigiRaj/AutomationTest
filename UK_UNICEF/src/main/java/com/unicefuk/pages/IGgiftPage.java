package com.unicefuk.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

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
	
	/* to select different categories from drop down */
	public void chooseCategory(Integer value) throws Exception{
		
		By categoryitem= By.id("ig-sort-category");
		select(categoryitem, value);
	}
	
	/* to select different prize range from drop down */
	public void choosePrize(Integer value) throws Exception{
		
		By prizeItem= By.id("ig-sort-price");
		select(prizeItem, value);
	}
	
	/* to choose different IG gifts */
	
	public void chooseIGGifts(Integer randomeProductPlateNumber) throws Exception{
		
		 Thread.sleep(3000);
		 By currentproductPlateField = By.xpath("//*[@class='IG-allGifts-list']/div/ul/li[" + randomeProductPlateNumber + "]/div/a");
		 click(currentproductPlateField);
	}
	
	/* to select quantity of IG gifts */
	
	public void selectQty(Integer value)throws Exception{
		
		By qty= By.id("quantityselectbox");
		select(qty, value);
		
	}
	
	/* to click add to bag button in IG Gift detail page */
	public void IGAddtoCart() throws Exception{
		
		By addtoBagButton= By.id("btn-addtocart");
		click(addtoBagButton);

	}

}
