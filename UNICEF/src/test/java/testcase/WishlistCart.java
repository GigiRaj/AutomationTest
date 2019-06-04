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
import com.unicef.pages.ShippingAddressPage;
import com.unicef.pages.SignIn;

public class WishlistCart extends BaseTest {
	
	@Parameters("browser")
	
	/* test case for choosing products from wish list using index value */
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
	
	/* test case for choosing products from wish list and add to cart */	
	@Test(priority=0)
	public void Wishlisttocart()throws Exception{
		
		C3category c3 = new C3category(driver);
		ItemDetailPage itdetail = new ItemDetailPage(driver);
		HomePage homePage = new HomePage(driver);
		Cart cat = new Cart(driver);
		SignIn sign = new SignIn(driver);
		PersonalWishlist perWish= new PersonalWishlist(driver);	
		ShippingAddressPage shipAddr= new ShippingAddressPage(driver);
		
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
		 
		perWish.WishlistAddtoBag(1);
		
		Thread.sleep(5000);
		itdetail.Gotocart();
		driver.findElement(By.id("hasdonation")).click();
		Reporter.log("Uncheck the donation");

		perWish.scrollToBottom();
		Thread.sleep(5000);
		cat.clickcheckout();
		System.out.println("checkout the item");
		sign.EntersignInDet();
		
//		shipAddr.sameAddress();
		shipAddr.newAddress();
		System.out.println("click on new address");
		shipAddr.createShipAddress();		
		shipAddr.continueButton1();
		System.out.println("success creating shipping address");
		shipAddr.topContinueBtnShipOptPage();		
		System.out.println("go to payment options");
		

		
		
		/* need to write choose wishlist with if condition*/
		


	}

}
