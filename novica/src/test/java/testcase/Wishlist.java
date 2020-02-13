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
		Reporter.log("Redirecting to home page <br>");
		perWish.wishlistMenu();
		Reporter.log("click on the header wishlist button <br>");
		sign.waitForSignIntoload();
		Reporter.log("Redirecting to sig in page <br>");
		sign.Login();
		Reporter.log("log in as user by providing email and password <br>");
		perWish.waitForWishlisttoLoad();
		int productcount = perWish.getproductCount();
		Reporter.log("Total Products found "+ productcount + "<br>");
		System.out.println("Total Products found "+ productcount);
		int gennum = wpu.getRandomNumberInts(1, productcount);
		System.out.println(gennum);
		Reporter.log("get random product number <br>");
		perWish.clickWishlistProductRandom(gennum);
		Reporter.log("click on random product in the wishlist itemlist <br>");
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
		Reporter.log("Redirecting to home page <br>");
		String key= "Bags";
		homePage.typeAndSubmitKeyword(key);
		Reporter.log("Searching for" +" " + key + "<br>");
		
		c3.waitForC3toLoad();
		Reporter.log("Waiting for Category page to Load <br>");
		int productcount = c3.getproductCount();
		Reporter.log("Total Products found "+ productcount + "<br>");
		System.out.println("Total Products found "+ productcount);
		int gennum = wpu.getRandomNumberInts(1, productcount);
		System.out.println(gennum);
		Reporter.log("get the random product number <br>");
		
		
	   String productid = c3.getProductID(gennum);
	   Reporter.log("Clicked on product ID"+ productid + "<br>"); 
	   System.out.println("Clicked on product ID"+ productid);
	   c3.clickProductPlateRandom(gennum);
	   Reporter.log("click on random product <br>");
		
		itdetail.waitForItemDetailLoad();
		Reporter.log("Waiting for Item Detail page to Load <br>");
		String productdetailId= itdetail.getProductID();
		assertEquals(productdetailId,productid);
		itdetail.clickAddToWishlistButton();
		Reporter.log("add product to wishlist <br>");
		
		sign.waitForSignIntoload();
		Reporter.log("Redirecting to sig in page <br>");
		sign.Login();
		Reporter.log("log in as user by providing email and password <br>");
		perWish.chooseWishlist(1);
		Reporter.log("choose personal wishlist <br>");
		Thread.sleep(3000);
		perWish.wishlistMenu();	
		Reporter.log("click on wishlist button on header <br>");
		perWish.waitForWishlisttoLoad();
		int productcount1 = perWish.getproductCount();
		Reporter.log("Total Products found "+ productcount1 + "<br>");
		System.out.println("Total Products found "+ productcount1);
		int gennum1 = wpu.getRandomNumberInts(1, productcount1);
		System.out.println(gennum1);
		perWish.WishlistAddtoBag(gennum1);
		Reporter.log("add item to bag from wishlist page <br>");
		Thread.sleep(5000);
		itdetail.Gotocart();
		Reporter.log("redirecting to cart page <br>");
		cat.clickcheckout();
		Reporter.log("check out the product <br>");
		sign.EntersignInDet();
		Reporter.log("enter sign in details <br>");
		payment.paymentPageFunctionalities();
		Reporter.log("redirect to payment page <br>");

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
		Reporter.log("Redirecting to home page <br>");
		perWish.wishlistMenu();
		Reporter.log("click on the header wishlist button <br>");
		sign.waitForSignIntoload();
		Reporter.log("Redirecting to sig in page <br>");
		sign.Login();
		Reporter.log("log in as user by providing email and password <br>");
		perWish.removeItemWishlist(2);
		Reporter.log("remove 2nd product from the wishlist page <br>");
	} 
	
	

}
