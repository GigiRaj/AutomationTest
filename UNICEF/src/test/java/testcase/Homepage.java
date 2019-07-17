package testcase;

import org.testng.Reporter;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.unicef.base.BaseTest;
import com.unicef.pages.C3category;
import com.unicef.pages.Cart;
import com.unicef.pages.HomePage;
import com.unicef.pages.ItemDetailPage;
import com.unicef.pages.PersonalWishlist;
import com.unicef.pages.SignIn;

public class Homepage extends BaseTest {
	
	@Parameters("browser")

	/* test case for all the header menus working or not */
	@Test(priority=1)
	public void headerMenu()throws Exception{
		
		
		HomePage homePage = new HomePage(driver);
		
		homePage.openHomePage();
		Reporter.log("Redirecting to home page <br>");
		homePage.clickIGHeaderMenu();
		Reporter.log("clicked on IG Header Menu <br>");
		homePage.clickCardGiftsHeaderMenu();
		Reporter.log("clicked on Card Gifts Header Menu <br>");
		homePage.clickGiftFinderHeaderMenu();
		Reporter.log("clicked on Gift Finder Header Menu <br>");
		homePage.clickJewelryHeaderMenu();
		Reporter.log("clicked on Jewelry Header Menu <br>");
		homePage.clickAccessoriesHeaderMenu();
		Reporter.log("clicked on Accessories Header Menu <br>");
		homePage.clickHomeDecorHeaderMenu();
		Reporter.log("clicked on Home Decor Header Menu <br>");
		homePage.clickNewHeaderMenu();
		Reporter.log("clicked on New Header Menu <br>");
		homePage.clickHomeHeaderMenu();
		Reporter.log("clicked on Home Header Menu <br>");
		homePage.clickDonateHeaderMenu();
		Reporter.log("clicked on Donate Header Menu <br>");
		homePage.clickAboutUsHeaderMenu();
		Reporter.log("clicked on About Us Header Menu <br>");
		homePage.clickCatalogHeaderMenu();
		Reporter.log("clicked on Catalog Header Menu <br>");
		homePage.clickLoginHeaderMenu();
		Reporter.log("clicked on Login Header Menu <br>");
		homePage.clickHelpHeaderMenu();
		Reporter.log("clicked on Help Header Menu <br>");
		homePage.clickShipToHeaderMenu();
		Reporter.log("clicked on Ship To Header Menu <br>");

	} 
	
	/* test case for search an item */
	@Test(priority=0)
	public void searchProduct()throws Exception{
		
		
		HomePage homePage = new HomePage(driver);
		
		homePage.openHomePage();
		Reporter.log("Redirecting to home page <br>");
		String Key = "chains";
		homePage.typeAndSubmitKeyword(Key);
		Reporter.log("Searched for the products chains <br>");		
	}
	

}
