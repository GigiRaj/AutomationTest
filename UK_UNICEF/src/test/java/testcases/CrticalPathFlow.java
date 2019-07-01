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
import com.unicefuk.pages.HomePage;
import com.unicefuk.pages.ItemDetailPage;
import com.unicefuk.pages.PaymentPage;


public class CrticalPathFlow extends BaseTest{
	
	@Parameters("browser")
	@Test(priority=0)
	public void typeandsearch(String keyword) throws Exception {
		
		HomePage homePage = new HomePage(driver);
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
//		Reporter.log("Waiting for C3 to load");
//		int productcount = c3.getproductCount();
//		Reporter.log("Total Products found"+ productcount);
	    String productid = c3.getProductID(1);
//	    Reporter.log("Clicked on product ID"+ productid);
	    c3.clickProductPlateRandom(1);
	    
	    itdetail.waitForItemDetailLoad();
		String productPrice = itdetail.getProductPrice();
		System.out.println(productPrice);
		itdetail.clickAddToCartButton();
		Reporter.log("Added product with "+ productid + "to cart");
		Thread.sleep(10000);
		System.out.println("added product to bag");		
		itdetail.Gotocart();
		Thread.sleep(10000);
		String actualcartprice = cat.getTotalCartPrice();
		System.out.println(actualcartprice);
		assertEquals(productPrice, actualcartprice);
		
		cat.clickcheckout();
	    sign.EntersignInDet();
	    shipAddr.waitForShippingPageToload();
	    shipAddr.manualAddress();
	    shipAddr.dispatchShipping();
	    pay.chooseDonation(3);
	    pay.applyPromoCode("saduysg");
	    pay.billingAddress();

	    
//	    pay.sameShippAddress();
	    pay.cardPayment();
	    pay.saveAndContinue();
	}
	
	/* test case for remove address from address book */
	@Test(priority=1)
	public void removeAddress() throws Exception {
		
		HomePage homePage = new HomePage(driver);
		SignIn sign = new SignIn(driver);
		ShippingAddressPage shipAddr= new ShippingAddressPage(driver);
		
		homePage.openHomePage();
		homePage.clickAcceptCookie();
		sign.clickSignin();
		sign.directLogin();
		shipAddr.addressBookMenu();
		shipAddr.RemoveAddressBook(2);
		shipAddr.RemoveAddressBook(1);
		
	}


}
