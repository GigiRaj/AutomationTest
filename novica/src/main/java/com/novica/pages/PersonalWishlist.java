package com.novica.pages;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import com.novica.base.BasePageObject;

public class PersonalWishlist extends BasePageObject {
	
	
	public PersonalWishlist(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	private static final By productPlate = By.xpath("//*[@id='main-page']/div/div[2]/div");
	private static final By Okbutton = By.xpath("//*[@class='modal-content']/div/div/button");
	private static final By addThisItemButton= By.xpath("//*[@class='modal-content']/div/div[2]/form/div[3]/div/button[1]"); 
	private By gotowishlist= By.id("globalnav-lists");
	private By wishlistPage= By.className("wishlist-item");
	private By yesRemoveButton= By.xpath("//*[@id='novicamodal']/div/div/div/div[2]/div/div[1]/a");
	
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
		 By currentproductPlateField = By.xpath("//*[@id='main-page']/div/div[2]/div[" + randomeWishlistProductNumber + "]/div[1]/div/div[1]");
		 click(currentproductPlateField);
		 return new ItemDetailPage(driver);
	}
	
	/* click on wish list add to bag button */
	public void WishlistAddtoBag(Integer randomnumber)throws Exception{
		
		
	
		By addtoBag = By.xpath("//*[@id='main-page']/div/div[2]/div["+randomnumber+"]/div[2]/div[2]/div[1]/button");
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
	
	/* switch to child pop up choose wishlist */
	public void chooseWishlist(Integer randomnumber)throws Exception{

		Thread.sleep(5000);
		By wishlist = By.xpath("//*[@class='modal-content']/div/div[2]/form/div[2]/div/div/p["+randomnumber+"]/label");
		click(wishlist);	
		System.out.println("selected first item");
		click(addThisItemButton);
		System.out.println("Clicked on add button in pop up");
		Thread.sleep(5000);
		click(Okbutton);
		System.out.println("Clicked on OK button in pop up");
		
	}
	
	/* to remove an item from wishlist page */
	public void removeItemWishlist(Integer randomnumber)throws Exception{
		
		By removeItem = By.xpath("//*[@id='main-page']/div/div[2]/div["+randomnumber+"]/div/div/div[2]/div/div/a[1]");
		click(removeItem);
		Thread.sleep(5000);
		click(yesRemoveButton);
		System.out.println("item removed from wishlist");
		
	}
	
	


	
	
	

}
