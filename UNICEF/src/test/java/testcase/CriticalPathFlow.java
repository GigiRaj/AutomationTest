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
		Reporter.log("Loading Homepage <br>");
		//Thread.sleep(60000);
		String Key = "Blue";
		homePage.typeAndSubmitKeyword(Key);
		Reporter.log("Searched for"+ Key + "<br>");
		
		c3.waitForC3toLoad();
		Reporter.log("Waiting for C3 to load <br>");
		int productcount = c3.getproductCount();
		Reporter.log("Total Products found"+ productcount + "<br>");
		int gennum = wpu.getRandomNumberInts(1, productcount);
		System.out.println(gennum);
		
	    String productid = c3.getProductID(gennum);
	    Reporter.log("Clicked on product ID"+ productid + "<br>");
	    c3.clickProductPlateRandom(gennum);
	    
		itdetail.waitForItemDetailLoad();
		Reporter.log("waiting item detail page to load <br>");
		String productdetid= itdetail.getProductID();
		System.out.println(productid);
		System.out.println(productdetid);
	    assertEquals(productid, productdetid);
	    Reporter.log("checked productid and product detail page id are same <br>");
		String productPrice = itdetail.getProductPrice();
		System.out.println(productPrice);
		Reporter.log("get the product prize"+ productPrice + "<br>");
		itdetail.clickAddToCartButton();
		Reporter.log("Added product with "+ productid + "to cart <br>");
		Thread.sleep(10000);
		Reporter.log("Redirecting to cart page with price" + productPrice + "<br>");
		itdetail.Gotocart();
		Reporter.log("redirecting to cart page <br>");
		driver.findElement(By.id("hasdonation")).click();
		Reporter.log("Uncheck the donation <br>");
		Thread.sleep(10000);
		String actualcartprice = cat.getTotalCartPrice();
		System.out.println(actualcartprice);
		assertEquals(productPrice, "$"+actualcartprice);
		Reporter.log("check product prize and actual cart prize are same <br>");
		cat.clickcheckout();
		Reporter.log("clicked on checkout button <br>");
		sign.EntersignInDet();
		Reporter.log("enter the sign in details <br>");
		payment.paymentPageFunctionalities();
		Reporter.log("go to the payment page functionalities <br>");
		
	}
	
	

	
	
	
}


