package com.unicef.pages;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.unicef.base.BasePageObject;

public class PersonalWishlist extends BasePageObject {
	
	
	public PersonalWishlist(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	private static final By productPlate = By.xpath("//*[@id='shop']/div[2]/div[2]");
	private static final By Okbutton = By.xpath("//*[@id='novicamodal']/div/div/div/div/button");
	private static final By addThisItemButton= By.xpath("//*[@class='modal-content']/div/div[2]/form/div[3]/div/button[1]");
	private By gotowishlist= By.id("header-wishlist");
	private By wishlistPage= By.className("wishlist-item");
	private By yesRemove=By.xpath("//*[@id='novicamodal']/div/div/div/div[2]/div/div/a");
	private By shareIcon= By.xpath("//*[@class='profile-wishlist-hdr']/div/a");
	private By copyButton= By.xpath("//*[@class='modal-content']/div/div[2]/div/div[1]/span/button");
	private By fbIconButton= By.xpath("//*[@class='modal-content']/div/div[2]/div/div[2]/a[1]/i");
	private By twitterIconButton= By.xpath("//*[@class='modal-content']/div/div[2]/div/div[2]/a[2]/i");
	private By shareWishlistClosebutton= By.xpath("//*[@class='modal-content']/a");
	private By addWishlist= By.xpath("//*[@id='shop']/div[2]/div[1]/div[1]/div/a");
	private By wishlistName= By.id("eventName");
	private By wishlistDescrpn= By.id("note");
	private By saveButton= By.xpath("//*[@id='shop']/div[2]/div[2]/div/form/div[4]/div[1]/button");
	private By cancelButton= By.xpath("//*[@id='shop']/div[2]/div[2]/div/form/div[4]/div[2]/a");
	private By selectAddressButton= By.xpath("//*[@id='shop']/div[2]/div[2]/div/form/div[3]/div/div/div[2]/div[2]/a[1]");
	private By createAddressButton= By.xpath("//*[@id='shop']/div[2]/div[3]/div/form/div[3]/div/div/div[2]/div[2]/a[2]");
	private By firstName= By.id("firstName");
	private By lastName= By.id("lastName");
	private By companyName= By.id("companyName");
	private By addressLine1=By.id("addressLine1");
	private By addressLine2= By.id("addressLine2");
	private By city= By.id("city");
	private By country= By.xpath("//*[@id='wishlistaddressbookcreate']/div[1]/div[7]/div/div/button");
	private By countryUSA= By.xpath("//*[@id='wishlistaddressbookcreate']/div[1]/div[7]/div/div/ul/div[2]/li[2]");
	private By state= By.xpath("//*[@id='usStateList']/button");
	private By stateCalifornia= By.xpath("//*[@id='usStateList']/ul/div[2]/li[9]");
	private By zipCode= By.id("zipCode");
	private By phoneNumber= By.id("phoneNumber");
	private By check1= By.xpath("//*[@id='wishlistaddressbookcreate']/div[2]/div/label[1]");
	private By check2= By.xpath("//*[@id='wishlistaddressbookcreate']/div[2]/div/label[2]");
	private By check3= By.xpath("//*[@id='wishlistaddressbookcreate']/div[2]/div/label[3]");
	private By continueButton= By.xpath("//*[@id='wishlistaddressbookcreate']/div[3]/div[1]/button");
	private By cancelButton2= By.className("btn-light");
	private By saveChangesButton= By.xpath("//*[@id='shop']/div[2]/div[3]/div/form/div[4]/div[1]/button");
	private By headerAccountButton= By.id("myaccount-header");
	
	
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
	
	/* click on OK button in Wishlist Pop up*/
	public void wishlistOk() throws Exception{
		click(Okbutton);
		
	}
	
	/* click on Account Button on Header */
	public void accountMenu() throws Exception{
		click(headerAccountButton);
		
	}
	
	/* click on each wishlist item in wishlist page */
	
	public ItemDetailPage clickWishlistProductRandom(Integer randomeWishlistProductNumber) throws Exception {
		 By currentproductPlateField = By.xpath("//*[@id='shop']/div[2]/div[2]/div[" + randomeWishlistProductNumber + "]");
		 Thread.sleep(5000);
		click(currentproductPlateField);
		return new ItemDetailPage(driver);
	}
	
	/* click on wish list add to bag button */
	public void WishlistAddtoBag(Integer randomnumber)throws Exception{
		
		
	
		By addtoBag = By.xpath("//*[@id='shop']/div[2]/div[2]/div["+randomnumber+"]/div[2]/div[2]/div[1]");
		click(addtoBag);
		System.out.println("item added to bag");
		
	}
	
	
	
	/* switch to child pop up wishlist OK button */
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
		String parentWindowHandler = driver.getWindowHandle(); // Store your parent window
		String subWindowHandler = null;

		Set<String> handles = driver.getWindowHandles(); // get all window handles
		Iterator<String> iterator = handles.iterator();
//		while (iterator.hasNext()){
		    subWindowHandler = iterator.next();
//		}
		driver.switchTo().window(subWindowHandler); // switch to popup window
		Thread.sleep(5000);
		By wishlist = By.xpath("//*[@class='modal-content']/div/div[2]/form/div[2]/div/label["+randomnumber+"]/span/span[2]");
		click(wishlist);
		Thread.sleep(3000);
		scrollToBottom();
		click(addThisItemButton);
		System.out.println("Clicked on add button in pop up");
		Thread.sleep(5000);
		click(Okbutton);
		System.out.println("Clicked on OK button in pop up");
		driver.switchTo().window(parentWindowHandler); // switch to parent window
		System.out.println("Go to parent window");
		Thread.sleep(5000);
	}
	
	
	
	
	
	/* to remove an item from wishlist page */
	public void removeItemWishlist(Integer randomnumber)throws Exception{
		
		By removeItem = By.xpath("//*[@id='shop']/div[2]/div[2]/div["+randomnumber+"]/div[1]/div[1]/div[2]/div[1]/div/a[1]");
		click(removeItem);
		Thread.sleep(5000);
		click(yesRemove);
		System.out.println("item removed from wishlist");
		
	}
	
	
	
	/* to view the details of product by clicking on view details button */
	public void viewItemWishlist(Integer randomnumber)throws Exception{
		
		By viewItem = By.xpath("//*[@id='shop']/div[2]/div[2]/div["+randomnumber+"]/div/div/div[2]/div/div/a[2]");
		By placeBackOrderButton= By.xpath("//*[@id='shop']/div[2]/div[2]/div["+randomnumber+"]/div[2]/div[2]/div/button");
		if(driver.findElements(placeBackOrderButton).size()==0)
		{
			click(viewItem);
			System.out.println("view item detail from wishlist");
			
		}
		else
		{
			System.out.println("there is no details to show");
		}
		
	}
	
	/* to  copy wishlist link */
	public void shareCopyWishlist()throws Exception{
		
		click(shareIcon);
		Thread.sleep(5000);
		click(copyButton);
		click(shareWishlistClosebutton);
		
	}
	
	/* to  share wishlist link  via fb*/
	public void shareFbWishlist()throws Exception{
		
		click(shareIcon);
		Thread.sleep(5000);
		click(fbIconButton);
		click(shareWishlistClosebutton);
		driver.quit();
		
	}
	
	/* to  share wishlist link  via twitter*/
	public void shareTwitterWishlist()throws Exception{
		
		click(shareIcon);
		Thread.sleep(5000);
		click(twitterIconButton);
		click(shareWishlistClosebutton);
		driver.quit();
		
	}
	
	/* to create new wishlist */
	public void createNewWishlist(String wishlistname)throws Exception{
		
		click(addWishlist);
		waitForJavascripttoLoad();
		type(wishlistName,wishlistname);
		type(wishlistDescrpn,"test description");
		scrollToBottom();
		createAddressWishlist();
//		selectAddressWishlist(2);
//		scrollToBottom();
//		click(saveButton);
	}
	
	/* select address in create new wishlist page */
	public void selectAddressWishlist(Integer randomnumber)throws Exception{
		
		
		waitForJavascripttoLoad();
		click(selectAddressButton);
		Thread.sleep(5000);
		By useAddress = By.xpath("//*[@id='wishlistaddressbook']/div/div["+randomnumber+"]//a");
		click(useAddress);
	}
	
	/* create address in create new wishlist page */
	public void createAddressWishlist()throws Exception{
		
		
		waitForJavascripttoLoad();
		click(createAddressButton);
		Thread.sleep(5000);
		type(firstName,"sam");
		type(lastName,"test");
		type(companyName,"abc company");
		type(addressLine1,"test address 1");
		type(addressLine2,"test address 2");
		type(city,"california");
		click(country);
		click(countryUSA);
		System.out.println("dsgfydysgfyugdsuygf");
		click(state);
		scrollToBottom();
		click(stateCalifornia);
		System.out.println("states");
		type(zipCode,"56876567");
		type(phoneNumber,"457876869866");
		click(check1);
		click(check2);
		click(check3);
		scrollToBottom();
		click(continueButton);
		scrollToTop();
		scrollToTop();
		click(saveChangesButton);
	}
	
	/* to delete address from address book */
	public void removeAddress(Integer randomnumber)throws Exception{
		
		accountMenu();
		scrollToBottom();
		WebElement hoverAddressMenu= driver.findElement(By.className("settings"));
		WebElement addressBook= driver.findElement(By.xpath("//*[@id='shop']/div[2]/div[2]/div[7]/div/span/div/ul/li[2]"));
		HoverAndClick(driver,hoverAddressMenu,addressBook);
		By delete = By.xpath("//*[@id='shop']/div[3]/div[2]/div["+randomnumber+"]/p/a[2]");
		click(delete);
		Thread.sleep(3000);
		click(By.xpath("//*[@id='novicamodal']/div/div/div/div[2]/div/div/a"));	
		Thread.sleep(3000);
		click(By.xpath("//*[@id='novicamodal']/div/div/div/div/button"));
	}

}
