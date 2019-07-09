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
import com.kiva.pages.CategoryPage;
import com.kiva.pages.HomePage;
import com.kiva.pages.ItemDetailPage;

public class CrticalPathFlow extends BaseTest {
	
	@Parameters("browser")
	@Test(priority=0)
	public void typeandsearch(String keyword) throws Exception {
		
		HomePage homePage = new HomePage(driver);
		CategoryPage cat= new CategoryPage(driver);
		ItemDetailPage item= new ItemDetailPage(driver);
		
		homePage.openHomePage();
		homePage.shipToUs();
		String Key = "rings";
		homePage.typeAndSubmitKeyword(Key);
		Reporter.log("Searched for"+ Key);
		
		cat.waitForCategorytoLoad();
		String productid = cat.getProductID(5);
		cat.clickProductPlateRandom(5);
		item.waitForItemDetailLoad();
		String productPrice = item.getProductPrice();
		System.out.println(productPrice);
		item.clickAddToCartButton();
		Reporter.log("Added product with "+ productid + "to cart");
		Thread.sleep(10000);
		System.out.println("added product to bag");
		item.Gotocart();
	}

}
