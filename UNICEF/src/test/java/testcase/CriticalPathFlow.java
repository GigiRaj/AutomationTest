package testcase;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import com.unicef.base.BasePageObject;
import com.unicef.base.BaseTest;
import com.unicef.pages.C3category;
import com.unicef.pages.Cart;
import com.unicef.pages.HomePage;
import com.unicef.pages.ItemDetailPage;
import com.unicef.pages.PersonalWishlist;
import com.unicef.pages.SignIn;

public class CriticalPathFlow extends BaseTest {
	@Parameters("browser")
//	@Test(priority=0)
//	public void typeandsearch(String keyword) throws Exception {
//		
//		
//		C3category c3 = new C3category(driver);
//		ItemDetailPage itdetail = new ItemDetailPage(driver);
//		HomePage homePage = new HomePage(driver);
//		Cart cat = new Cart(driver);
//		SignIn sign = new SignIn(driver);
//		
//		
//		homePage.openHomePage();
//		Reporter.log("Loading Homepage");
//		//Thread.sleep(60000);
//		String Key = "Blue";
//		homePage.typeAndSubmitKeyword(Key);
//		Reporter.log("Searched for"+ Key);
//		
//		c3.waitForC3toLoad();
//		Reporter.log("Waiting for C3 to load");
//		int productcount = c3.getproductCount();
//		Reporter.log("Total Products found"+ productcount);
//	    String productid = c3.getProductID(3);
//	    Reporter.log("Clicked on product ID"+ productid);
//	    c3.clickProductPlateRandom(3);
//	    
//		itdetail.waitForItemDetailLoad();
//		String productdetid= itdetail.getProductID();
//	    assertEquals(productid, productdetid);
//		String productPrice = itdetail.getProductPrice();
//		System.out.println(productPrice);
//		itdetail.clickAddToCartButton();
//		Reporter.log("Added product with "+ productid + "to cart");
//		itdetail.waitForCartFlyoutToload();
//		Reporter.log("Redirecting to cart page with price" + productPrice);
//		itdetail.Gotocart();
//		driver.findElement(By.id("hasdonation")).click();
//		Reporter.log("Uncheck the donation");
//		Thread.sleep(10000);
//		String actualcartprice = cat.getTotalCartPrice();
//		System.out.println(actualcartprice);
//		assertEquals(productPrice, "$"+actualcartprice);
//		
//		cat.clickcheckout();
//		
//		sign.EntersignInDet();
//	}
//	
	
	@Test(priority=0)
	public void Wishlisttocart()throws Exception{
		
		C3category c3 = new C3category(driver);
		ItemDetailPage itdetail = new ItemDetailPage(driver);
		HomePage homePage = new HomePage(driver);
		Cart cat = new Cart(driver);
		SignIn sign = new SignIn(driver);
		PersonalWishlist perWish= new PersonalWishlist(driver);
		
		
		homePage.openHomePage();
		Reporter.log("Loading Home page");
		String key= "Bags";
		homePage.typeAndSubmitKeyword(key);
		Reporter.log("Searching for" + key);
		
		c3.waitForC3toLoad();
		Reporter.log("Waiting for Category page to Load");
		String productId= c3.getProductID(5);
		c3.clickProductPlateRandom(5);
		Reporter.log("Clicked on Product"+ productId);
		
		itdetail.waitForItemDetailLoad();
		Reporter.log("Waiting for Item Detail page to Load");
		String productdetailId= itdetail.getProductID();
		assertEquals(productdetailId,productId);
		itdetail.clickAddToWishlistButton();
		
		sign.waitForSignIntoload();
		sign.Login();
		
		perWish.switchWindow();
		
		perWish.wishlistMenu();
		
		perWish.WishlistAddtoBag(2);
		
		Thread.sleep(5000);
		itdetail.Gotocart();
		driver.findElement(By.id("hasdonation")).click();
		Reporter.log("Uncheck the donation");
		
//		String actualcartprice = cat.getTotalCartPrice();
//		System.out.println(actualcartprice);
//		String productPrice = itdetail.getProductPrice();
//		assertEquals(productPrice, "$"+actualcartprice);
		perWish.scrollToBottom();
		Thread.sleep(5000);
		cat.clickcheckout();
		System.out.println("checkout the item");
		sign.EntersignInDet();
		
		
		/* need to write choose wishlist with if condition*/
		
//		Reporter.log("Added product with "+ productId + "to cart");
//		itdetail.GotoWishlist();

	}
	
//	@Test(priority=0)
//	public void wishlist()throws Exception{
//		
//		C3category c3 = new C3category(driver);
//		ItemDetailPage itdetail = new ItemDetailPage(driver);
//		HomePage homePage = new HomePage(driver);
//		Cart cat = new Cart(driver);
//		SignIn sign = new SignIn(driver);
//		PersonalWishlist perWish= new PersonalWishlist(driver);
//		
//		homePage.openHomePage();
//		perWish.wishlistMenu();
//		sign.waitForSignIntoload();
//		sign.Login();
//		perWish.clickWishlistProductRandom(1);
//		
//	}
	
}


