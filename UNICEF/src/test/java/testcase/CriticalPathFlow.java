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

import com.unicef.base.WebPageUtility;
import com.unicef.base.BasePageObject;
import com.unicef.base.BaseTest;
import com.unicef.pages.C3category;
import com.unicef.pages.Cart;
import com.unicef.pages.HomePage;
import com.unicef.pages.ItemDetailPage;
import com.unicef.pages.PaymentPage;
import com.unicef.pages.PersonalWishlist;
import com.unicef.pages.ShippingAddressPage;
import com.unicef.pages.SignIn;

public class CriticalPathFlow extends BaseTest {
	@Parameters("browser")
	
	
	/* test case for critical path flow */
	@Test(priority=0)
	public void typeandsearch(String keyword) throws Exception {
		
		
		C3category c3 = new C3category(driver);
		WebPageUtility wpu = new WebPageUtility();
		ItemDetailPage itdetail = new ItemDetailPage(driver);
		HomePage homePage = new HomePage(driver);
		Cart cat = new Cart(driver);
		SignIn sign = new SignIn(driver);
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
		itdetail.clickAddToCartButton();
		Reporter.log("Added product with "+ productid + "to cart");
		itdetail.waitForCartFlyoutToload();
		Reporter.log("Redirecting to cart page with price" + productPrice);
		itdetail.Gotocart();
		driver.findElement(By.id("hasdonation")).click();
		Reporter.log("Uncheck the donation");
		Thread.sleep(10000);
		String actualcartprice = cat.getTotalCartPrice();
		System.out.println(actualcartprice);
		assertEquals(productPrice, "$"+actualcartprice);
		
		cat.clickcheckout();
		sign.EntersignInDet();
		shipAddr.createShipAddress();
		System.out.println("create new shipping address");	
		shipAddr.bottomContinueBtnShipOptPage();	
		System.out.println("go to payment options");
		shipAddr.topContinueBtnShipOptPage();
		payment.applyPromoCode("QWERTY");
		payment.chooseDonation(5);
		payment.cardPayment();
		payment.sameShippingAddr();
		payment.bottomContinueButton();
	}
	
	
}


