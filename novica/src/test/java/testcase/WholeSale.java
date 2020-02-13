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

public class WholeSale extends BaseTest{
	
	@Parameters("browser")
	
	/* critical path using create new shipping address */
	@Test(priority=0)
	public void crticalPathFlowWholeSale(String keyword) throws Exception {
		
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
		homePage.clickWholeSaleMenu();
		Reporter.log("click on whole sale menu button on footer <br>");
		sign.clickWholeSaleLogin();
		Reporter.log("click on whole sale sign in button <br>");
		sign.WholeSaleLogin();
		Reporter.log("give whole sale sign in details <br>");
		String Key = "paintings";
		Reporter.log("search for an item <br>");
		homePage.typeAndSubmitKeyword(Key);
		Reporter.log("Searched for"+ Key + "<br>");
		c3.waitForC3toLoad();
		Reporter.log("Waiting for C3 to load <br>");
		int productcount = c3.getproductCount();
		Reporter.log("Total Products found "+ productcount + "<br>");
		System.out.println("Total Products found "+ productcount);
		int gennum = wpu.getRandomNumberInts(1, productcount);
		Reporter.log("get the random product number <br>");
		System.out.println(gennum);
		
		
	   String productid = c3.getProductID(gennum);
	   Reporter.log("Clicked on product ID"+ productid + "<br>"); 
	   System.out.println("Clicked on product ID"+ productid);
	   c3.clickProductPlateRandom(gennum);
	   Reporter.log("click on random product <br>");
		itdetail.waitForItemDetailLoad();
		Reporter.log("wait for item detail page to load <br>");
//		String productdetid= itdetail.getProductID();
	  //  assertEquals(productid, productdetid);
//		String productPrice = itdetail.getProductPrice();
//		Reporter.log("to get the product prize");
//		System.out.println(productPrice);
		itdetail.clickAddToCartButton();
		Reporter.log("Added product with "+ productid + "to cart" + "<br>");
		
		itdetail.Gotocart();
		Reporter.log("redirect to cart page <br>");
//		Reporter.log("Redirecting to cart page with price" + productPrice);
		Thread.sleep(10000);
//		String actualcartprice = cat.getTotalCartPrice();
//		Reporter.log("to get the actual cart price");
//		System.out.println(actualcartprice);
//		assertEquals(productPrice, actualcartprice);
		
		
//		cat.clickcheckout();
		cat.clickKeepShopping();
		System.out.println("keepshopping");
		Reporter.log("click on keep shopping button <br>");
		sign.EntersignInDet();
		Reporter.log("Login as a user <br>");
//		ship.addShippingAddress();
//		Reporter.log("Input new shipping address");
//		ship.continueButton1();
//		ship.bottomContinueBtnShipOptPage();
		payment.paymentPageFunctionalities();
		Reporter.log("give all the payment details <br>");
	}
	

	
	
}
