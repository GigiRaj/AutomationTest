package testcases;


import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import com.unicefuk.pages.C3category;
import com.unicefuk.pages.Cart;
import com.unicefuk.pages.SignIn;
import com.unicefuk.pages.ShippingAddressPage;
import com.unicefuk.base.BasePageObject;
import com.unicefuk.base.BaseTest;
import com.unicefuk.base.WebPageUtility;
import com.unicefuk.pages.HomePage;
import com.unicefuk.pages.ItemDetailPage;
import com.unicefuk.pages.PaymentPage;


public class CrticalPathFlow extends BaseTest{
	
	@Parameters("browser")
	@Test(priority=0)
	public void typeandsearch(String keyword) throws Exception {
		
		HomePage homePage = new HomePage(driver);
		WebPageUtility wpu= new WebPageUtility();
		C3category c3 = new C3category(driver);
		ItemDetailPage itdetail = new ItemDetailPage(driver);
		Cart cat = new Cart(driver);
		SignIn sign = new SignIn(driver);
		ShippingAddressPage shipAddr= new ShippingAddressPage(driver);
		PaymentPage pay= new PaymentPage(driver);
		
		
		
		homePage.openHomePage();
		homePage.clickAcceptCookie();
		String Key = "rings";
		homePage.typeAndSubmitKeyword(Key);
		Reporter.log("Searched for"+ Key);
		
		c3.waitForC3toLoad();
		Reporter.log("Waiting for C3 to load");
		int productcount = c3.getproductCount();
		Reporter.log("Total Products found"+ productcount);
		int gennum = wpu.getRandomNumberInts(1, productcount);
		System.out.println(gennum);
		
	    String productid = c3.getProductID(gennum);
	    Reporter.log("Clicked on product ID"+ productid);
	    c3.clickProductPlateRandom(gennum);
	    
	    itdetail.waitForItemDetailLoad();
		String productPrice = itdetail.getProductPrice();
		System.out.println(productPrice);
		itdetail.clickAddToCartButton();
		Reporter.log("Added product with "+ productid + "to cart");
		Thread.sleep(10000);
		Reporter.log("added product to bag");		
		itdetail.Gotocart();
		Thread.sleep(10000);
		String actualcartprice = cat.getTotalCartPrice();
		System.out.println(actualcartprice);
		assertEquals(productPrice, actualcartprice);
		Reporter.log("checked product price and actual price are equal");
		
		cat.clickcheckout();
		Reporter.log("clicked on checkout button");
	    sign.EntersignInDet();
	    pay.paymentFunctionality();
//	    Reporter.log("give username and password");
//	    shipAddr.waitForShippingPageToload();
//	    Reporter.log("lading shipping page");
//	    shipAddr.manualAddress();
//	    Reporter.log("give manual address");
//	    shipAddr.dispatchShipping();
//	    pay.chooseDonation(3);
//	    pay.applyPromoCode("saduysg");
//	    pay.billingAddress();
//
//	    
////	    pay.sameShippAddress();
//	    pay.cardPayment();
//	    pay.saveAndContinue();
	}
	




}
