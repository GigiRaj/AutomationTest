package testcase;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.testng.Reporter;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.novica.base.BaseTest;
import com.novica.base.WebPageUtility;
import com.novica.pages.C3category;
import com.novica.pages.Cart;
import com.novica.pages.HomePage;
import com.novica.pages.ItemDetailPage;
import com.novica.pages.PersonalWishlist;
import com.novica.pages.SignIn;
import com.novica.pages.PaymentPage;
import com.novica.pages.ShippingAddressPage;

public class Wishlist extends BaseTest {
	
	@Parameters("browser")
	
	/* test case for choosing products from wish list using index value */
	@Test(priority=0)
	public void wishlistProduct()throws Exception{
		
		
		HomePage homePage = new HomePage(driver);
		SignIn sign = new SignIn(driver);
		PersonalWishlist perWish= new PersonalWishlist(driver);
		WebPageUtility wpu = new WebPageUtility();
		
		homePage.openHomePage();
		Reporter.log("Redirecting to home page");
		perWish.wishlistMenu();
		Reporter.log("click on the header wishlist button");
		sign.waitForSignIntoload();
		Reporter.log("Redirecting to sig in page");
		sign.Login();
		Reporter.log("log in as user by providing email and password");
		perWish.waitForWishlisttoLoad();
		int productcount = perWish.getproductCount();
		Reporter.log("Total Products found "+ productcount);
		System.out.println("Total Products found "+ productcount);
		int gennum = wpu.getRandomNumberInts(1, productcount);
		System.out.println(gennum);
		perWish.clickWishlistProductRandom(gennum);
		Reporter.log("click on random product in the wishlist itemlist");
	}
	
	
	/* test case for choosing products from wish list and add to cart using and checkout using same shipping address */	
	@Test(priority=1)
	public void WishlisttocartUsingExpress()throws Exception{
		
		C3category c3 = new C3category(driver);
		ItemDetailPage itdetail = new ItemDetailPage(driver);
		HomePage homePage = new HomePage(driver);
		Cart cat = new Cart(driver);
		SignIn sign = new SignIn(driver);
		PersonalWishlist perWish= new PersonalWishlist(driver);	
		ShippingAddressPage shipAddr= new ShippingAddressPage(driver);
		PaymentPage payment=new PaymentPage(driver);
		WebPageUtility wpu = new WebPageUtility();
		
		homePage.openHomePage();
		Reporter.log("Redirecting to home page");
		String key= "Bags";
		homePage.typeAndSubmitKeyword(key);
		Reporter.log("Searching for" + key);
		
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
		Reporter.log("Waiting for Item Detail page to Load");
		String productdetailId= itdetail.getProductID();
		assertEquals(productdetailId,productid);
		itdetail.clickAddToWishlistButton();
		Reporter.log("add product to wishlist");
		
		sign.waitForSignIntoload();
		Reporter.log("Redirecting to sig in page");
		sign.Login();
		Reporter.log("log in as user by providing email and password");
		perWish.chooseWishlist(1);
		Reporter.log("choose personal wishlist");
		Thread.sleep(3000);
		perWish.wishlistMenu();	
		Reporter.log("click on wishlist button on header");
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
		Reporter.log("redirecting to cart page");
		cat.clickcheckout();
		Reporter.log("check out the product");
		sign.EntersignInDet();
		Reporter.log("enter user sign in details");
		payment.clickShippingTab();
		Reporter.log("redirecting to shipping page");
		payment.clickSameAddess();
		Reporter.log("chose smae shipping address");
		Thread.sleep(3000);
		payment.applyPromoCode("PROMOCODE15");
		Reporter.log("apply promocode");
		payment.chooseDonation(5);
		Reporter.log("choose donation");
		payment.cardPayment();
		Reporter.log("make payment using card");
		payment.clickContinueButton();
		Reporter.log("redirecting to confirmation page");

	} 
	
	/* test case for remove an item from wishlist */
	@Test(priority=2)
	public void removeWishlist()throws Exception{
		
		C3category c3 = new C3category(driver);
		ItemDetailPage itdetail = new ItemDetailPage(driver);
		HomePage homePage = new HomePage(driver);
		Cart cat = new Cart(driver);
		SignIn sign = new SignIn(driver);
		PersonalWishlist perWish= new PersonalWishlist(driver);
		
		homePage.openHomePage();
		Reporter.log("Redirecting to home page");
		perWish.wishlistMenu();
		Reporter.log("click on the header wishlist button");
		sign.waitForSignIntoload();
		Reporter.log("Redirecting to sig in page");
		sign.Login();
		Reporter.log("log in as user by providing email and password");
		perWish.removeItemWishlist(2);
		Reporter.log("remove 2nd product from the wishlist page");
	} 
	
	

}
