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

import com.novica.base.BasePageObject;
import com.novica.base.BaseTest;
import com.novica.pages.AddressBookPage;
import com.novica.pages.C3category;
import com.novica.pages.Cart;
import com.novica.pages.HomePage;
import com.novica.pages.ItemDetailPage;
import com.novica.pages.PersonalWishlist;
import com.novica.pages.ShippingAddressPage;
import com.novica.pages.SignIn;
import com.novica.pages.PaymentPage;
import com.novica.base.WebPageUtility;

public class CriticalPathFlow extends BaseTest {
	@Parameters("browser")
	
	
	/* critical path using create new shipping address */
	@Test(priority=0)
	public void crticalPathFlowUsingNewAddress(String keyword) throws Exception {
		
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
		String Key = "blue";
		homePage.typeAndSubmitKeyword(Key);
		Reporter.log("Searched for"+ Key + "<br>");
		c3.waitForC3toLoad();
		Reporter.log("Waiting for C3 to load <br>");
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
	    
		itdetail.waitForItemDetailLoad();
		Thread.sleep(5000);
//		String productdetid= itdetail.getProductID();
	  //  assertEquals(productid, productdetid);
		String productPrice = itdetail.getProductPrice();
		Reporter.log("to get the product prize <br>");
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
		Reporter.log("check put the product <br>");
		sign.EntersignInDet();
		Reporter.log("Login as a user <br>");
		payment.paymentPageFunctionalities();

	}
	

	
	
	
	
}


