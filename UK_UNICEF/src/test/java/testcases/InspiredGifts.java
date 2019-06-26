package testcases;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.unicefuk.pages.Cart;
import com.unicefuk.pages.HomePage;
import com.unicefuk.pages.IGgiftPage;
import com.unicefuk.pages.SignIn;
import com.unicefuk.base.BaseTest;

public class InspiredGifts extends BaseTest {
	
@Parameters("browser")
	
	/* test case for create card for IG gift using Printed Card */	
	@Test(priority=0)
	public void IGcreateCardPrintedCard()throws Exception{
		
		
		HomePage homePage = new HomePage(driver);
		Cart cat = new Cart(driver);
		SignIn sign = new SignIn(driver);
		IGgiftPage IG=new IGgiftPage(driver);
		
		homePage.openHomePage();
		IG.IGgiftCategory(4);
		
	}
	

}
