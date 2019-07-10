package testcases;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.kiva.base.BaseTest;
import com.kiva.base.ShippingPage;
import com.kiva.pages.CartPage;
import com.kiva.pages.CategoryPage;
import com.kiva.pages.DeliveryAddressPage;
import com.kiva.pages.HomePage;
import com.kiva.pages.ItemDetailPage;
import com.kiva.pages.PaymentPage;

public class CrticalPathFlow extends BaseTest {
	
	@Parameters("browser")
	@Test(priority=0)
	public void typeandsearch(String keyword) throws Exception {
		
		HomePage homePage = new HomePage(driver);
		CategoryPage cat= new CategoryPage(driver);
		ItemDetailPage item= new ItemDetailPage(driver);
		CartPage cart = new CartPage(driver);
		DeliveryAddressPage address= new DeliveryAddressPage(driver);
		ShippingPage ship= new ShippingPage(driver);
		PaymentPage pay= new PaymentPage(driver);
		
		homePage.openHomePage();
		homePage.shipToUs();
		String Key = "rings";
		homePage.typeAndSubmitKeyword(Key);
		Reporter.log("Searched for"+ Key);
		
		cat.waitForCategorytoLoad();
		String productid = cat.getProductID(1);
		cat.clickProductPlateRandom(1);
		item.waitForItemDetailLoad();
//		String productPrice = item.getProductPrice();
//		System.out.println(productPrice);
		Thread.sleep(5000);
		item.clickAddToCartButton();
		Reporter.log("Added product with "+ productid + "to cart");
		Thread.sleep(10000);
		System.out.println("added product to bag");
		item.Gotocart();
		cart.clickcheckout();
		address.waitForDeliverAddresstoload();
		address.createAddress();
		address.clickContinue();
		ship.GiftforSomeone();
//		ship.GiftForMe();
		ship.clickSaveandContinue();
		pay.applyPromocode();
		pay.chooseDonation();
//		pay.sameShipAddress();
		pay.createBillingAddress();
		pay.clickPaypal();
		 	
	}

}
