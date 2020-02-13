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
		Reporter.log("Loading Homepage <br>");
		//Thread.sleep(60000);
		String Key = "Red";
		homePage.typeAndSubmitKeyword(Key);
		Reporter.log("Searched for"+ Key + "<br>");
		c3.waitForC3toLoad();
		Reporter.log("Waiting for C3 to load <br>");
		int productcount = c3.getproductCount();
		Reporter.log("Total Products found "+ productcount + "<br>");
		int gennum = wpu.getRandomNumberInts(1, productcount);
		System.out.println(gennum);
		Reporter.log("get the random product number <br>");
		
		
	   String productid = c3.getProductID(gennum);
	   Reporter.log("Clicked on product ID"+ productid + "<br>"); 
	   
	   c3.clickProductPlateRandom(gennum);
	    
		itdetail.waitForItemDetailLoad();
		String productdetid= itdetail.getProductID();
	  //  assertEquals(productid, productdetid);
		String productPrice = itdetail.getProductPrice();
		Reporter.log("Get the product price <br>");
		System.out.println(productPrice);
		itdetail.clickAddToCartButton();
		Reporter.log("Added product with "+ productid + "to cart" +"<br>");
		
		itdetail.Gotocart();
		Reporter.log("Redirecting to cart page with price" + productPrice + "<br>");
		Thread.sleep(10000);
		String actualcartprice = cat.getTotalCartPrice();
		Reporter.log("to get the actual cart price <br>");
		System.out.println(actualcartprice);
		assertEquals(productPrice, actualcartprice);
		cat.clickcheckout();
		Reporter.log("check out the product <br>");
		sign.EntersignInDet();
		payment.paymentPageFunctionalities();
		Reporter.log("redirect to payment functionalities <br>");
	}
	
	/* to remove address from address book*/
	@Test(priority=1)
	public void removeAddress1() throws Exception {
		
		HomePage homePage = new HomePage(driver);
		ShippingAddressPage ship=new ShippingAddressPage(driver);
		homePage.openHomePage();
		SignIn sign = new SignIn(driver);
		AddressBookPage add= new AddressBookPage(driver);
		
		homePage.openHomePage();
		Reporter.log("Loading Homepage <br>");
		sign.clickHeaderSignIn();
		Reporter.log("click on header sign in button <br>");
		sign.waitForSignIntoload();
		Reporter.log("wait for sign in page to load <br>");
		sign.Login();
		Reporter.log("log in as user by providing email and password");
		homePage.headeraccount();
		Reporter.log("click on account button on header <br>");
		add.clickAddressBook();
		Reporter.log("click on address book button <br>");
		add.removeAddress(1);		
		Reporter.log("emove each address by clicking on remove address button <br>");
	}

}
