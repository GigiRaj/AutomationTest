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
import com.unicefuk.base.WebPageUtility;

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
		WebPageUtility wpu= new WebPageUtility();
		
		homePage.openHomePage();
		homePage.clickAcceptCookie();
		sign.clickSignin();
		sign.directLogin();
		perWish.wishlistMenu();
		sign.waitForSignIntoload();
		int productcount = perWish.getproductCount();
		Reporter.log("Total Products found "+ productcount);
		System.out.println("Total Products found "+ productcount);
		int gennum = wpu.getRandomNumberInts(1, productcount);
		System.out.println(gennum);
		perWish.clickWishlistProductRandom(gennum);
		
	} 
	
	/* test case for choosing products from wish list and add to cart and checkout the item */	
	@Test(priority=2)
	public void WishlisttocartCheckOut()throws Exception{
		
		HomePage homePage = new HomePage(driver);
		C3category c3 = new C3category(driver);
		ItemDetailPage itdetail = new ItemDetailPage(driver);
		Cart cat = new Cart(driver);
		SignIn sign = new SignIn(driver);
		ShippingAddressPage shipAddr= new ShippingAddressPage(driver);
		PaymentPage pay= new PaymentPage(driver);
		PersonalWishlist perWish= new PersonalWishlist(driver);	
		WebPageUtility wpu= new WebPageUtility();
		
		
		homePage.openHomePage();
		homePage.clickAcceptCookie();
		String Key = "Bracelets";
		homePage.typeAndSubmitKeyword(Key);
		Reporter.log("Searched for"+ Key);
		
		c3.waitForC3toLoad();
		Reporter.log("Waiting for Category page to Load");
		int productcount = c3.getproductCount();
		Reporter.log("Total Products found "+ productcount);
		System.out.println("Total Products found "+ productcount);
		int gennum = wpu.getRandomNumberInts(1, productcount);
		System.out.println(gennum);
		
		
	   String productid = c3.getProductID(gennum);
	   Reporter.log("Clicked on product ID"+ productid); 
	   System.out.println("Clicked on product ID"+ productid);
	    c3.clickProductPlateRandom(gennum);
	    
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
		perWish.waitForWishlisttoLoad();
		int productcount1 = perWish.getproductCount();
		Reporter.log("Total Products found "+ productcount1);
		System.out.println("Total Products found "+ productcount1);
		int gennum1 = wpu.getRandomNumberInts(1, productcount1);
		System.out.println(gennum1);
		perWish.WishlistAddtoBag(gennum1);
		Reporter.log("add item to bag from wishlist page");
		Thread.sleep(5000);
		itdetail.Gotocart();

		cat.clickcheckout();
	    shipAddr.waitForShippingPageToload();
	    pay.paymentFunctionality();
//	    shipAddr.sameAddress(1);
//	    Thread.sleep(3000);
//	    shipAddr.dispatchShipping();
//	    pay.chooseDonation(3);
//	    pay.applyPromoCode("saduysg");
//	    pay.sameShippAddress();
//	    pay.cardPayment();
//	    pay.saveAndContinue();

	}
	
	/* test case for choosing products from wish list and add to cart using create or edit shipping address */	
	@Test(priority=1)
	public void WishlisttocartUsingGuest()throws Exception{
		
		HomePage homePage = new HomePage(driver);
		C3category c3 = new C3category(driver);
		ItemDetailPage itdetail = new ItemDetailPage(driver);
		Cart cat = new Cart(driver);
		SignIn sign = new SignIn(driver);
		ShippingAddressPage shipAddr= new ShippingAddressPage(driver);
		PaymentPage pay= new PaymentPage(driver);
		PersonalWishlist perWish= new PersonalWishlist(driver);	
		WebPageUtility wpu= new WebPageUtility();
		
		
		homePage.openHomePage();
		homePage.clickAcceptCookie();
		String Key = "Bracelets";
		homePage.typeAndSubmitKeyword(Key);
		Reporter.log("Searched for"+ Key);
		
		c3.waitForC3toLoad();
		Reporter.log("Waiting for Category page to Load");
		int productcount = c3.getproductCount();
		Reporter.log("Total Products found "+ productcount);
		System.out.println("Total Products found "+ productcount);
		int gennum = wpu.getRandomNumberInts(1, productcount);
		System.out.println(gennum);
		
		
	   String productid = c3.getProductID(gennum);
	   Reporter.log("Clicked on product ID"+ productid); 
	   System.out.println("Clicked on product ID"+ productid);
	    c3.clickProductPlateRandom(gennum);
	    
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
		perWish.waitForWishlisttoLoad();
		int productcount1 = perWish.getproductCount();
		Reporter.log("Total Products found "+ productcount1);
		System.out.println("Total Products found "+ productcount1);
		int gennum1 = wpu.getRandomNumberInts(1, productcount1);
		System.out.println(gennum1);
		perWish.WishlistAddtoBag(gennum1);
		Reporter.log("add item to bag from wishlist page");
		Thread.sleep(5000);
		itdetail.Gotocart();

		cat.clickcheckout();
	    shipAddr.waitForShippingPageToload();
	    pay.paymentFunctionality();
//	    shipAddr.createAddress();
//	    Thread.sleep(3000);
//	    shipAddr.dispatchShipping();
//	    pay.chooseDonation(3);
//	    pay.applyPromoCode("saduysg");
//	    pay.sameShippAddress();
//	    pay.cardPayment();
//	    pay.saveAndContinue();
	}
	
}
