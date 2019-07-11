package testcase;

import static org.testng.Assert.assertEquals;

import org.testng.Reporter;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.novica.base.BaseTest;
import com.novica.base.WebPageUtility;
import com.novica.pages.AddressBookPage;
import com.novica.pages.C3category;
import com.novica.pages.Cart;
import com.novica.pages.HomePage;
import com.novica.pages.ItemDetailPage;
import com.novica.pages.PaymentPage;
import com.novica.pages.ShippingAddressPage;
import com.novica.pages.SignIn;

public class AddressBook  extends BaseTest {
	
	@Parameters("browser")
/* critical path using create same shipping address */
	
	@Test(priority=1)
	public void crticalPathSameAddress(String keyword) throws Exception {
		
		WebPageUtility wpu = new WebPageUtility();
		C3category c3 = new C3category(driver);
		ItemDetailPage itdetail = new ItemDetailPage(driver);
		HomePage homePage = new HomePage(driver);
		Cart cat = new Cart(driver);
		SignIn sign = new SignIn(driver);
		ShippingAddressPage ship=new ShippingAddressPage(driver);
		PaymentPage payment=new PaymentPage(driver);
		
		homePage.openHomePage();
		Reporter.log("Loading Homepage");
		//Thread.sleep(60000);
		String Key = "Red";
		homePage.typeAndSubmitKeyword(Key);
		Reporter.log("Searched for"+ Key);
		c3.waitForC3toLoad();
		Reporter.log("Waiting for C3 to load");
		int productcount = c3.getproductCount();
		Reporter.log("Total Products found "+ productcount);
		int gennum = wpu.getRandomNumberInts(1, productcount);
		System.out.println(gennum);
		
		
	   String productid = c3.getProductID(gennum);
	   Reporter.log("Clicked on product ID"+ productid); 
	   
	   c3.clickProductPlateRandom(gennum);
	    
		itdetail.waitForItemDetailLoad();
		String productdetid= itdetail.getProductID();
	  //  assertEquals(productid, productdetid);
		String productPrice = itdetail.getProductPrice();
		Reporter.log("Get the product price");
		System.out.println(productPrice);
		itdetail.clickAddToCartButton();
		Reporter.log("Added product with "+ productid + "to cart");
		
		itdetail.Gotocart();
		Reporter.log("Redirecting to cart page with price" + productPrice);
		Thread.sleep(10000);
		String actualcartprice = cat.getTotalCartPrice();
		Reporter.log("to get the actual cart price");
		System.out.println(actualcartprice);
		assertEquals(productPrice, actualcartprice);
		cat.clickcheckout();
		Reporter.log("check out the product");
		sign.EntersignInDet();
		Reporter.log("give the user sign in details");
		payment.clickShippingTab();
		Reporter.log("redirecting to shipping page");
		payment.clickSameAddess();
		Reporter.log("use same shipping address");
		Thread.sleep(3000);
		payment.applyPromoCode("PROMOCODE15");
		Reporter.log("Apply promocode");
		payment.chooseDonation(5);
		Reporter.log("choose donation");
		payment.cardPayment();
		Reporter.log("give details for card payment");
		payment.clickContinueButton();
		Reporter.log("redirecting to confirmation page");
	}
	
	/* to remove address from address book*/
	@Test(priority=1)
	public void removeAddress() throws Exception {
		
		HomePage homePage = new HomePage(driver);
		ShippingAddressPage ship=new ShippingAddressPage(driver);
		homePage.openHomePage();
		SignIn sign = new SignIn(driver);
		AddressBookPage add= new AddressBookPage(driver);
		
		homePage.openHomePage();
		sign.clickHeaderSignIn();
		sign.waitForSignIntoload();
		Reporter.log("Redirecting to sig in page");
		sign.Login();
		Reporter.log("log in as user by providing email and password");
		homePage.headeraccount();
		add.clickAddressBook();
		add.removeAddress(1);		
	}

}
