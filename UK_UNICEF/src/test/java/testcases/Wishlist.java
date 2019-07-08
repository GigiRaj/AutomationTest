package testcases;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.unicefuk.pages.C3category;
import com.unicefuk.pages.Cart;
import com.unicefuk.pages.HomePage;
import com.unicefuk.pages.ItemDetailPage;
import com.unicefuk.pages.PersonalWishlist;
import com.unicefuk.pages.SignIn;
import com.unicefuk.pages.PaymentPage;
import com.unicefuk.pages.ShippingAddressPage;
import com.unicefuk.base.BaseTest;

public class Wishlist extends BaseTest {
	
	
	/* test case for choosing products from wish list using index value */
	@Test(priority=0)
	public void wishlistProduct()throws Exception{
		
		C3category c3 = new C3category(driver);
		ItemDetailPage itdetail = new ItemDetailPage(driver);
		HomePage homePage = new HomePage(driver);
		Cart cat = new Cart(driver);
		SignIn sign = new SignIn(driver);
		PersonalWishlist perWish= new PersonalWishlist(driver);
		
		homePage.openHomePage();
		homePage.clickAcceptCookie();
		sign.clickSignin();
		sign.directLogin();
		perWish.wishlistMenu();
		sign.waitForSignIntoload();
		perWish.clickWishlistProductRandom(1);
		
	} 
	
	/* test case for choosing products from wish list and add to cart and checkout the item */	
	@Test(priority=1)
	public void WishlisttocartCheckOut()throws Exception{
		
		HomePage homePage = new HomePage(driver);
		C3category c3 = new C3category(driver);
		ItemDetailPage itdetail = new ItemDetailPage(driver);
		Cart cat = new Cart(driver);
		SignIn sign = new SignIn(driver);
		ShippingAddressPage shipAddr= new ShippingAddressPage(driver);
		PaymentPage pay= new PaymentPage(driver);
		PersonalWishlist perWish= new PersonalWishlist(driver);	
		
		
		homePage.openHomePage();
		homePage.clickAcceptCookie();
		String Key = "rings";
		homePage.typeAndSubmitKeyword(Key);
		Reporter.log("Searched for"+ Key);
		
		c3.waitForC3toLoad();
	    String productid = c3.getProductID(4);
	    c3.clickProductPlateRandom(4);
	    
	    itdetail.waitForItemDetailLoad();
		String productPrice = itdetail.getProductPrice();
		System.out.println(productPrice);
		itdetail.clickAddToWishlistButton();
		Thread.sleep(5000);
		System.out.println("added product to Wishlist");
		Thread.sleep(3000);
		sign.directLogin();
		perWish.clickOk();
		Thread.sleep(3000);
		perWish.wishlistMenu(); 
		System.out.println("go to Wishlist page");
		Thread.sleep(3000);
		perWish.WishlistAddtoBag(1);	
		System.out.println("click on first item in wishlist");
		Thread.sleep(5000);
		itdetail.Gotocart();

		cat.clickcheckout();
	    shipAddr.waitForShippingPageToload();
	    shipAddr.sameAddress(1);
	    Thread.sleep(3000);
	    shipAddr.dispatchShipping();
	    pay.chooseDonation(3);
	    pay.applyPromoCode("saduysg");
	    pay.sameShippAddress();
	    pay.cardPayment();
	    pay.saveAndContinue();

	}
	
	/* test case for choosing products from wish list and add to cart using create or edit shipping address */	
	@Test(priority=2)
	public void WishlisttocartUsingGuest()throws Exception{
		
		HomePage homePage = new HomePage(driver);
		C3category c3 = new C3category(driver);
		ItemDetailPage itdetail = new ItemDetailPage(driver);
		Cart cat = new Cart(driver);
		SignIn sign = new SignIn(driver);
		ShippingAddressPage shipAddr= new ShippingAddressPage(driver);
		PaymentPage pay= new PaymentPage(driver);
		PersonalWishlist perWish= new PersonalWishlist(driver);	
		
		
		homePage.openHomePage();
		homePage.clickAcceptCookie();
		String Key = "rings";
		homePage.typeAndSubmitKeyword(Key);
		Reporter.log("Searched for"+ Key);
		
		c3.waitForC3toLoad();
	    String productid = c3.getProductID(4);
	    c3.clickProductPlateRandom(4);
	    
	    itdetail.waitForItemDetailLoad();
		String productPrice = itdetail.getProductPrice();
		System.out.println(productPrice);
		itdetail.clickAddToWishlistButton();
		Thread.sleep(5000);
		System.out.println("added product to Wishlist");
		Thread.sleep(3000);
		sign.directLogin();
		perWish.clickOk();
		Thread.sleep(3000);
		perWish.wishlistMenu(); 
		System.out.println("go to Wishlist page");
		Thread.sleep(3000);
		perWish.WishlistAddtoBag(1);	
		System.out.println("click on first item in wishlist");
		Thread.sleep(5000);
		itdetail.Gotocart();

		cat.clickcheckout();
	    shipAddr.waitForShippingPageToload();
	    shipAddr.createAddress();
	    Thread.sleep(3000);
	    shipAddr.dispatchShipping();
	    pay.chooseDonation(3);
	    pay.applyPromoCode("saduysg");
	    pay.sameShippAddress();
	    pay.cardPayment();
	    pay.saveAndContinue();
	}
	
}
