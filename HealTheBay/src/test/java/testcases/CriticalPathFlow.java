package testcases;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.healthebay.base.BaseTest;
import com.healthebay.pages.HomePage;
import com.healthebay.pages.ItemDetailPage;
import com.healthebay.pages.CartPage;
import com.healthebay.pages.CategoryPage;
import com.healthebay.pages.CheckOutPage;
import com.healthebay.base.WebPageUtility;

public class CriticalPathFlow extends BaseTest {
	@Parameters("browser")
	@Test(priority=0)
	public void typeandsearch(String keyword) throws Exception {
		
		HomePage homePage = new HomePage(driver);
		WebPageUtility wpu = new WebPageUtility();
		CategoryPage cat= new CategoryPage(driver);
		ItemDetailPage item= new ItemDetailPage(driver);
		CartPage cart = new CartPage(driver);
		CheckOutPage checkout= new CheckOutPage(driver);
		
		homePage.openHomePage();
		String Key = "rings";
		homePage.typeAndSubmitKeyword(Key);
		Reporter.log("Searched for"+ Key);
		System.out.println(" Searched for rings");
		
		cat.waitForCategorytoLoad();
		int productcount = cat.getproductCount();
		Reporter.log("Total Products found "+ productcount);
		System.out.println("Total Products found "+ productcount);
		int gennum = wpu.getRandomNumberInts(1, productcount);
		System.out.println(gennum);

		
		String productid = cat.getProductID(gennum);
		Reporter.log("Clicked on product ID"+ productid); 
		System.out.println("Clicked on product ID"+ productid);
		cat.clickProductPlateRandom(gennum);
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
		checkout.customerSignIn();
//		checkout.guestLogin("jijitest.sprcn@gmail.com");
//		checkout.shipppingDetails();
		checkout.paymentDetails();
		
	}

}
