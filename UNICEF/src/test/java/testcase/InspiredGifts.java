package testcase;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.unicef.base.BasePageObject;
import com.unicef.base.BaseTest;
import com.unicef.pages.C3category;
import com.unicef.pages.Cart;
import com.unicef.pages.HomePage;
import com.unicef.pages.IGgiftPage;
import com.unicef.pages.ItemDetailPage;
import com.unicef.pages.PersonalWishlist;
import com.unicef.pages.SignIn;

public class InspiredGifts extends BaseTest {
	
	@Parameters("browser")
	
	/* test case for create card for IG gift using Printed Card */	
//	@Test(priority=0)
//	public void IGcreateCardPrintedCard()throws Exception{
//		
//		
//		HomePage homePage = new HomePage(driver);
//		Cart cat = new Cart(driver);
//		SignIn sign = new SignIn(driver);
//		IGgiftPage IG=new IGgiftPage(driver);
//		
//		homePage.openHomePage();
//		IG.clickIGHeaderMenu();
//		IG.chooseIGItems(5); // choose education related IG gifts	 
//		IG.clickIGProductPlateRandom(1);
//		IG.addIGtocart();
//		IG.createCard();
//		IG.printedCard();
//		
//	}
	
	
	/* test case for choose an Inspired gift and view the details */
	@Test(priority=0)
	public void IGchooseProduct()throws Exception{
		
		
		HomePage homePage = new HomePage(driver);
		Cart cat = new Cart(driver);
		SignIn sign = new SignIn(driver);
		IGgiftPage IG=new IGgiftPage(driver);
		
		homePage.openHomePage();
		IG.clickIGHeaderMenu();
		IG.chooseIGItems(5); // choose education related IG gifts	 
		IG.clickIGProductPlateRandom(1);
		IG.addIGtocart();
		IG.createCard();
		IG.printatHomeCard();
		IG.selectImage(1);
		IG.cardMessage();
		IG.addtoMyBagWithCard();
		
		/* need to write E-greeting card pending codes */
	}

}
