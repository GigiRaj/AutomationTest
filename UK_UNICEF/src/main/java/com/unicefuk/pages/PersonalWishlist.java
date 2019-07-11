package com.unicefuk.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.unicefuk.pages.ItemDetailPage;
import com.unicefuk.base.BasePageObject;

public class PersonalWishlist extends BasePageObject {
	
	public PersonalWishlist(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	private static final By productPlate = By.xpath("//*[@id='shop']/div[1]/div/div[1]/div[2]/div/div[2]/div");
	
	
	/* Get product count */
	public int getproductCount() {
		return getFieldCount(productPlate);
	}
	
	public void waitForWishlisttoLoad()throws Exception{
		
		waitForJavascripttoLoad();
	}
	
	/* Open wishlist page given link*/
	public void openWishlistpageURL( String Wishlistlink ) {
		System.out.println("Opening c3 page : " + Wishlistlink);
		getPage(Wishlistlink);
	}
	
	/* click on Wishlist header menu*/
	public void wishlistMenu(){
	
		
		WebElement yourAccountButton= driver.findElement(By.id("account-menu"));
		WebElement gotowishlistButton= driver.findElement(By.xpath("//*[@id='cart-account-flyout']/li[2]/div/ul/li/ul/li[2]/a"));
		HoverAndClick(driver,yourAccountButton,gotowishlistButton);
		System.out.println("go to wishlist page");
	}
	
	/* to click random product in wishlist page */
	public ItemDetailPage clickWishlistProductRandom(Integer randomeWishlistProductNumber) throws Exception {
		 By currentproductPlateField = By.xpath("//*[@id='shop']/div[1]/div/div[1]/div[2]/div/div[2]/div[" + randomeWishlistProductNumber + "]/div/div/div/div");
		 Thread.sleep(3000);
		 click(currentproductPlateField);
		 return new ItemDetailPage(driver);
	}
	
	/* to click on Add to wishlist Pop up OK button */
	public void clickOk()throws Exception{
		Thread.sleep(3000);
		By okButton= By.xpath("//*[@id='novicamodal']/div/div/div/div/button");
		click(okButton);
	}
	
	/* click on wish list add to bag button */
	public void WishlistAddtoBag(Integer randomnumber)throws Exception{
		
		By addtoBag = By.xpath("//*[@id='shop']/div[1]/div/div[1]/div[2]/div/div[2]/div[" + randomnumber + "]/div[2]/div[2]/div/button");
		click(addtoBag);
		System.out.println("item added to bag");		
	}

}
