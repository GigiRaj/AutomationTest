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
	public void wishlistProduct()throws Exception{
		
		
		HomePage homePage = new HomePage(driver);
		
		homePage.openHomePage();
		homePage.clickIGHeaderMenu();
		homePage.clickCardGiftsHeaderMenu();
		homePage.clickGiftFinderHeaderMenu();
		homePage.clickJewelryHeaderMenu();
		homePage.clickAccessoriesHeaderMenu();
		homePage.clickHomeDecorHeaderMenu();
		homePage.clickNewHeaderMenu();
		homePage.clickHomeHeaderMenu();
		homePage.clickDonateHeaderMenu();
		homePage.clickAboutUsHeaderMenu();
		homePage.clickCatalogHeaderMenu();
		homePage.clickLoginHeaderMenu();
		homePage.clickHelpHeaderMenu();
		homePage.clickShipToHeaderMenu();

	} 
	
	/* test case for search an item */
	@Test(priority=0)
	public void searchProduct()throws Exception{
		
		
		HomePage homePage = new HomePage(driver);
		
		String Key = "chains";
		homePage.typeAndSubmitKeyword(Key);
		Reporter.log("Searched for"+ Key);
	}
	

}
