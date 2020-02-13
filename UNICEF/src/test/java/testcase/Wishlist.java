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
import com.unicef.base.WebPageUtility;
import com.unicef.pages.C3category;
import com.unicef.pages.Cart;
import com.unicef.pages.HomePage;
import com.unicef.pages.ItemDetailPage;
import com.unicef.pages.PaymentPage;
import com.unicef.pages.PersonalWishlist;
import com.unicef.pages.ShippingAddressPage;
import com.unicef.pages.SignIn;

public class Wishlist extends BaseTest {
	
	@Parameters("browser")
	
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
		Reporter.log("Redirecting to home page <br>");
		perWish.wishlistMenu();
		Reporter.log("click on header wishlist link <br>");
		sign.waitForSignIntoload();
		Reporter.log("wait for sign in page to load <br>");
		sign.Login();
		Reporter.log("Enter signin details <br>");
		perWish.clickWishlistProductRandom(1);
		Reporter.log("click on product in wishlist <br>");
		
	} 
	
	/* test case for choosing products from wish list and add to cart using Guest checkout */	
	@Test(priority=1)
	public void WishlisttocartUsingGuest()throws Exception{
		
		C3category c3 = new C3category(driver);
		ItemDetailPage itdetail = new ItemDetailPage(driver);
		HomePage homePage = new HomePage(driver);
		WebPageUtility wpu = new WebPageUtility();
		Cart cat = new Cart(driver);
		SignIn sign = new SignIn(driver);
		PersonalWishlist perWish= new PersonalWishlist(driver);	
		ShippingAddressPage shipAddr= new ShippingAddressPage(driver);
		PaymentPage payment=new PaymentPage(driver);
		
		homePage.openHomePage();
		Reporter.log("Loading Homepage <br>");
		//Thread.sleep(60000);
		String Key = "Blue";
		homePage.typeAndSubmitKeyword(Key);
		Reporter.log("Searched for"+ Key + "<br>");
		
		c3.waitForC3toLoad();
		Reporter.log("Waiting for C3 to load");
		int productcount = c3.getproductCount();
		Reporter.log("Total Products found"+ productcount + "<br>");
		System.out.println("Total Products found "+ productcount);
		int gennum = wpu.getRandomNumberInts(1, productcount);
		System.out.println(gennum);
		Reporter.log("generate random product number <br>");
		
	    String productid = c3.getProductID(gennum);
	    Reporter.log("Clicked on product ID"+ productid);
	    System.out.println("Clicked on product ID"+ productid + "<br>");
	    c3.clickProductPlateRandom(gennum);
	    Reporter.log("click on random product <br>");
	    
		itdetail.waitForItemDetailLoad();
		Reporter.log("wait for item detail  page to load <br>");
		String productdetid= itdetail.getProductID();
		Reporter.log("get product id <br>");
		System.out.println(productid);
		Reporter.log("get product detail id <br>");
		System.out.println(productdetid);
	    assertEquals(productid, productdetid);
		String productPrice = itdetail.getProductPrice();
		System.out.println(productPrice);
		Reporter.log("get product price" + productPrice +  "<br>");
		itdetail.clickAddToWishlistButton();
		Reporter.log("click on add to wishlist button <br>");
		sign.waitForSignIntoload();
		Reporter.log("wait for sign in page to Load <br>");
		sign.Login();
		Reporter.log("enter the sign in details <br>");
		perWish.chooseWishlist(1);
		Reporter.log("choose a product from wishlist item <br>");
//		perWish.switchWindow();
		
		perWish.wishlistMenu();
		Reporter.log("click on each wishlist item <br>"); 
		perWish.WishlistAddtoBag(1);
		Reporter.log("click on add to bag button <br>");
		Thread.sleep(5000);
		itdetail.Gotocart();
		Reporter.log("go to cart page <br>");
		driver.findElement(By.id("hasdonation")).click();
		Reporter.log("Uncheck the donation");

		perWish.scrollToBottom();
		Thread.sleep(5000);
		cat.clickcheckout();
		Reporter.log("check out the item <br>");
		System.out.println("checkout the item");
		sign.guestChekOut();
		Reporter.log("enter guest checkout details <br>");
		shipAddr.continueButton1();
		Reporter.log("go to shipping page <br>");
		System.out.println("success creating shipping address");
		shipAddr.topContinueBtnShipOptPage();
		Reporter.log("go to payment options <br>");
		System.out.println("go to payment options");
		payment.applyPromoCode("QWERTY");
		Reporter.log("give the promocode <br>");
		payment.chooseDonation(5);
		Reporter.log("choose donation amount <br>");
		payment.cardPayment();
		Reporter.log("give the card details <br>");
		payment.sameShippingAddr();
		Reporter.log("click on same shipping address option <br>");
		payment.bottomContinueButton();
		Reporter.log("click on confirm order button <br>");

	}
	
	/* test case for choosing products from wish list and add to cart using create or edit shipping address */	
	@Test(priority=2)
	public void WishlisttocartDiffShipAddress()throws Exception{
		
		C3category c3 = new C3category(driver);
		ItemDetailPage itdetail = new ItemDetailPage(driver);
		HomePage homePage = new HomePage(driver);
		WebPageUtility wpu = new WebPageUtility();
		Cart cat = new Cart(driver);
		SignIn sign = new SignIn(driver);
		PersonalWishlist perWish= new PersonalWishlist(driver);	
		ShippingAddressPage shipAddr= new ShippingAddressPage(driver);
		PaymentPage payment=new PaymentPage(driver);
		
		homePage.openHomePage();
		Reporter.log("Loading Homepage <br>");
		//Thread.sleep(60000);
		String Key = "Blue";
		homePage.typeAndSubmitKeyword(Key);
		Reporter.log("Searched for"+ Key + "<br>");
		
		c3.waitForC3toLoad();
		Reporter.log("Waiting for Category page to load <br>");
		int productcount = c3.getproductCount();
		Reporter.log("Total Products found"+ productcount + "<br>");
		System.out.println("Total Products found "+ productcount);
		int gennum = wpu.getRandomNumberInts(1, productcount);
		System.out.println(gennum);
		Reporter.log("generate random product number <br>");
		
	    String productid = c3.getProductID(gennum);
	    Reporter.log("Clicked on product ID"+ productid + "<br>");
	    System.out.println("Clicked on product ID"+ productid);
	    c3.clickProductPlateRandom(gennum);
	    Reporter.log("click on random product <br>");
		itdetail.waitForItemDetailLoad();
		Reporter.log("wait for item detail page to load <br>");
		String productdetid= itdetail.getProductID();
		Reporter.log("get product id <br>");
		System.out.println(productid);
		Reporter.log("get product detail id <br>");
		System.out.println(productdetid);
	    assertEquals(productid, productdetid);
		String productPrice = itdetail.getProductPrice();
		Reporter.log("get product price <br>");
		System.out.println(productPrice);
		itdetail.clickAddToWishlistButton();
		Reporter.log("click on Add to wishlist button <br>");
		sign.waitForSignIntoload();
		Reporter.log("wait for sign in page to load <br>");
		sign.Login();
		Reporter.log("give login details <br>");
		perWish.chooseWishlist(1);
		Reporter.log("choose wishlisted item <br>");
//		perWish.switchWindow();
		
		perWish.wishlistMenu();
		Reporter.log("click on wishlist menu <br>");
		perWish.WishlistAddtoBag(2);
		Reporter.log(" add to bag from wishlist page <br>");
		Thread.sleep(5000);
		itdetail.Gotocart();
		Reporter.log("go to cart page <br>");
		driver.findElement(By.id("hasdonation")).click();
		Reporter.log("Uncheck the donation");

		perWish.scrollToBottom();
		Thread.sleep(5000);
		cat.clickcheckout();
		Reporter.log("checkout the product <br>");
		System.out.println("checkout the item");
		sign.EntersignInDet();
		Reporter.log("enter sign in details <br>");
		payment.paymentPageFunctionalities();
		Reporter.log("enter payment functionalities <br>");

//		shipAddr.newAddress();
//		System.out.println("click on new address");
//		shipAddr.createShipAddress();		
//		shipAddr.continueButton1();
//		System.out.println("success creating shipping address");
//		shipAddr.topContinueBtnShipOptPage();		
//		System.out.println("go to payment options");
//		payment.applyPromoCode("QWERTY");
//		payment.chooseDonation(5);
//		payment.cardPayment();
//		payment.newBillingAddr();
//		payment.bottomContinueButton();

	} 
	
	
	
	
	
	/* test case for choosing products from wish list and add to cart using express checkout using same shipping address */	
	@Test(priority=3)
	public void WishlisttocartUsingExpress()throws Exception{
		
		C3category c3 = new C3category(driver);
		ItemDetailPage itdetail = new ItemDetailPage(driver);
		HomePage homePage = new HomePage(driver);
		WebPageUtility wpu = new WebPageUtility();
		Cart cat = new Cart(driver);
		SignIn sign = new SignIn(driver);
		PersonalWishlist perWish= new PersonalWishlist(driver);	
		ShippingAddressPage shipAddr= new ShippingAddressPage(driver);
		PaymentPage payment=new PaymentPage(driver);
		
		homePage.openHomePage();
		Reporter.log("Loading Homepage");
		//Thread.sleep(60000);
		String Key = "Blue";
		homePage.typeAndSubmitKeyword(Key);
		Reporter.log("Searched for"+ Key);
		
		c3.waitForC3toLoad();
		Reporter.log("Waiting for C3 to load");
		int productcount = c3.getproductCount();
		Reporter.log("Total Products found"+ productcount);
		System.out.println("Total Products found "+ productcount);
		int gennum = wpu.getRandomNumberInts(1, productcount);
		System.out.println(gennum);
		
	    String productid = c3.getProductID(gennum);
	    Reporter.log("Clicked on product ID"+ productid);
	    System.out.println("Clicked on product ID"+ productid);
	    c3.clickProductPlateRandom(gennum);
	    
		itdetail.waitForItemDetailLoad();
		String productdetid= itdetail.getProductID();
		System.out.println(productid);
		System.out.println(productdetid);
	    assertEquals(productid, productdetid);
		String productPrice = itdetail.getProductPrice();
		System.out.println(productPrice);
		itdetail.clickAddToWishlistButton();
		
		sign.waitForSignIntoload();
		sign.Login();
		perWish.chooseWishlist(1);
//		perWish.switchWindow();
		
		perWish.wishlistMenu();
		 
		perWish.WishlistAddtoBag(3);
		
		Thread.sleep(5000);
		itdetail.Gotocart();
		driver.findElement(By.id("hasdonation")).click();
		Reporter.log("Uncheck the donation");

		perWish.scrollToBottom();
		Thread.sleep(5000);
		cat.clickcheckout();
		System.out.println("checkout the item");
		sign.EntersignInDet();
		payment.paymentPageFunctionalities();
//		shipAddr.sameAddress(1);
//		System.out.println("use same shipping address");	
//		shipAddr.topContinueBtnShipOptPage();		
//		System.out.println("go to payment options");
//		payment.applyPromoCode("QWERTY");
//		payment.chooseDonation(5);
//		payment.cardPayment();
//		payment.sameShippingAddr();
//		payment.bottomContinueButton();
		
	} 
	
	

	/* test case for remove an item from wishlist */
	@Test(priority=4)
	public void removeWishlist()throws Exception{
		
		C3category c3 = new C3category(driver);
		ItemDetailPage itdetail = new ItemDetailPage(driver);
		HomePage homePage = new HomePage(driver);
		Cart cat = new Cart(driver);
		SignIn sign = new SignIn(driver);
		PersonalWishlist perWish= new PersonalWishlist(driver);
		
		homePage.openHomePage();
		perWish.wishlistMenu();
		sign.waitForSignIntoload();
		sign.Login();
		perWish.removeItemWishlist(10);
		
		
	} 
	
	/* test case for view product details from wishlist */
	
	@Test(priority=5)
	public void viewProductWishlist()throws Exception{
		
		C3category c3 = new C3category(driver);
		ItemDetailPage itdetail = new ItemDetailPage(driver);
		HomePage homePage = new HomePage(driver);
		Cart cat = new Cart(driver);
		SignIn sign = new SignIn(driver);
		PersonalWishlist perWish= new PersonalWishlist(driver);
		
		homePage.openHomePage();
		perWish.wishlistMenu();
		sign.waitForSignIntoload();
		sign.Login();
		perWish.viewItemWishlist(11);
		
	} 
	
	/* test case for share and copy personal wishlist link */
	@Test(priority=6)
	public void shareWishlist()throws Exception{
		
		C3category c3 = new C3category(driver);
		ItemDetailPage itdetail = new ItemDetailPage(driver);
		HomePage homePage = new HomePage(driver);
		Cart cat = new Cart(driver);
		SignIn sign = new SignIn(driver);
		PersonalWishlist perWish= new PersonalWishlist(driver);
		
		homePage.openHomePage();
		perWish.wishlistMenu();
		sign.waitForSignIntoload();
		sign.Login();
		perWish.shareCopyWishlist();
		
	}
	
	/* test case for share  personal wishlist link via facebook */
	@Test(priority=7)
	public void fbShareWishlist()throws Exception{
		
		C3category c3 = new C3category(driver);
		ItemDetailPage itdetail = new ItemDetailPage(driver);
		HomePage homePage = new HomePage(driver);
		Cart cat = new Cart(driver);
		SignIn sign = new SignIn(driver);
		PersonalWishlist perWish= new PersonalWishlist(driver);
		
		homePage.openHomePage();
		perWish.wishlistMenu();
		sign.waitForSignIntoload();
		sign.Login();
		perWish.shareFbWishlist();
		
	}
	
	/* test case for share  personal wishlist link via facebook */
	@Test(priority=8)
	public void twitterShareWishlist()throws Exception{
		
		C3category c3 = new C3category(driver);
		ItemDetailPage itdetail = new ItemDetailPage(driver);
		HomePage homePage = new HomePage(driver);
		Cart cat = new Cart(driver);
		SignIn sign = new SignIn(driver);
		PersonalWishlist perWish= new PersonalWishlist(driver);
		
		homePage.openHomePage();
		perWish.wishlistMenu();
		sign.waitForSignIntoload();
		sign.Login();
		perWish.shareTwitterWishlist();
		
	}
	
	/* test case for create new wishlist */
	@Test(priority=9)
	public void createWishlist()throws Exception{
		
		
		C3category c3 = new C3category(driver);
		ItemDetailPage itdetail = new ItemDetailPage(driver);
		HomePage homePage = new HomePage(driver);
		Cart cat = new Cart(driver);
		SignIn sign = new SignIn(driver);
		PersonalWishlist perWish= new PersonalWishlist(driver);
		
		homePage.openHomePage();
		perWish.wishlistMenu();
		sign.waitForSignIntoload();
		sign.Login();
		perWish.createNewWishlist("wishlist2");
		
	}
	
	/* test case for remove address from address book */
	@Test(priority=10)
	public void removeAddressFromAddressBook()throws Exception{
		
		
		C3category c3 = new C3category(driver);
		ItemDetailPage itdetail = new ItemDetailPage(driver);
		HomePage homePage = new HomePage(driver);
		Cart cat = new Cart(driver);
		SignIn sign = new SignIn(driver);
		PersonalWishlist perWish= new PersonalWishlist(driver);
		
		homePage.openHomePage();
		sign.headerLoginButton();
		sign.Login();
		perWish.removeAddress(1);
		
		
	}
	
	 
	

}
