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
import com.unicef.pages.PaymentPage;
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
//	
	/* test case for choosing products from wish list and add to cart */	
	@Test(priority=1)
	public void Wishlisttocart()throws Exception{
		
		C3category c3 = new C3category(driver);
		ItemDetailPage itdetail = new ItemDetailPage(driver);
		HomePage homePage = new HomePage(driver);
		Cart cat = new Cart(driver);
		SignIn sign = new SignIn(driver);
		PersonalWishlist perWish= new PersonalWishlist(driver);	
		ShippingAddressPage shipAddr= new ShippingAddressPage(driver);
		PaymentPage payment=new PaymentPage(driver);
		
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
		perWish.chooseWishlist(1);
//		perWish.switchWindow();
		
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
		payment.applyPromoCode("QWERTY");
		payment.chooseDonation(5);
		payment.cardPayment();
//		payment.sameShippingAddr();
		payment.newBillingAddr();
		payment.bottomContinueButton();
		/* need to write choose wishlist with if condition*/
	}
	
	/* test case for remove an item from wishlist */
//	@Test(priority=0)
//	public void removeWishlist()throws Exception{
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
//		perWish.removeItemWishlist(10);
//		
//		
//	}
	
	/* test case for view product details from wishlist */
	
//	@Test(priority=0)
//	public void viewProductWishlist()throws Exception{
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
//		perWish.viewItemWishlist(5);
//		
//	}
	
	/* test case for share and copy personal wishlist link */
//	@Test(priority=0)
//	public void shareWishlist()throws Exception{
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
//		perWish.shareCopyWishlist();
//		
//	}
	
	/* test case for share  personal wishlist link via facebook */
//	@Test(priority=0)
//	public void fbShareWishlist()throws Exception{
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
//		perWish.shareFbWishlist();
//		
//	}
	
	/* test case for share  personal wishlist link via facebook */
//	@Test(priority=0)
//	public void twitterShareWishlist()throws Exception{
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
//		perWish.shareTwitterWishlist();
//		
//	}
//	
	/* test case for create new wishlist */
//	@Test(priority=0)
//	public void createWishlist()throws Exception{
//		
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
//		perWish.createNewWishlist("wishlist2");
//		
//	}
	 

}
