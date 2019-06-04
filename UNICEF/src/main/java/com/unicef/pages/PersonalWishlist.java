package com.unicef.pages;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import com.unicef.base.BasePageObject;

public class PersonalWishlist extends BasePageObject {
	
	
	public PersonalWishlist(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	private static final By productPlate = By.xpath("//*[@id='shop']/div[2]/div[2]");
	private static final By Okbutton = By.xpath("//*[@id='novicamodal']/div/div/div/div/button");
	private By gotowishlist= By.id("header-wishlist");
	private By wishlistPage= By.className("wishlist-item");
	
	/* Open wishlist page given link*/
	public void openWishlistpageURL( String Wishlistlink ) {
		System.out.println("Opening c3 page : " + Wishlistlink);
		getPage(Wishlistlink);
	}
	
	/* click on Wishlist header menu*/
	public void wishlistMenu(){
	
		waitForClickabilityOf(gotowishlist,10);
		click(gotowishlist);
		System.out.println("go to wishlist page");
	}
	
	/* wait for wishlist page to load */
	public void waitForWishlisttoLoad() throws Exception {
		waitForJavascripttoLoad();
	}
	
	/* Get product count */
	public int getproductCount() {
		return getFieldCount(productPlate);
	}
	
	/* click on OK button */
	public void wishlistOk() throws Exception{
		click(Okbutton);
		
	}
	
	/* click on each wishlist item */
	
	public ItemDetailPage clickWishlistProductRandom(Integer randomeWishlistProductNumber) throws Exception {
		 By currentproductPlateField = By.xpath("//*[@id='shop']/div[2]/div[2]/div[" + randomeWishlistProductNumber + "]");
		 System.out.println("test3");
		 Thread.sleep(5000);
		click(currentproductPlateField);
		System.out.println("test4");
		return new ItemDetailPage(driver);
	}
	
	/* click on wish list add to bag button */
	public void WishlistAddtoBag(Integer randomnumber)throws Exception{
		
		
	
		By addtoBag = By.xpath("//*[@id='shop']/div[2]/div[2]/div["+randomnumber+"]/div[2]/div[2]/div[1]");
		click(addtoBag);
		System.out.println("item added to bag");
		
	}
	
	
	
	/* switch to child pop up */
	public void switchWindow()throws Exception{
		String parentWindowHandler = driver.getWindowHandle(); // Store your parent window
		String subWindowHandler = null;

		Set<String> handles = driver.getWindowHandles(); // get all window handles
		Iterator<String> iterator = handles.iterator();
//		while (iterator.hasNext()){
		    subWindowHandler = iterator.next();
//		}
		driver.switchTo().window(subWindowHandler); // switch to popup window
		Thread.sleep(5000);
		click(Okbutton);	
		System.out.println("Clicked on OK button in pop up");
		driver.switchTo().window(parentWindowHandler); // switch to parent window
		System.out.println("Go to parent window");
		Thread.sleep(5000);
	}

	
	
	

}
