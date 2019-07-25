package testcase;

import org.testng.Reporter;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.unicef.base.BasePageObject;
import com.unicef.base.BaseTest;
import com.unicef.pages.C3category;
import com.unicef.pages.Cart;
import com.unicef.pages.HomePage;
import com.unicef.pages.IGShippingBag;
import com.unicef.pages.IGgiftPage;
import com.unicef.pages.ItemDetailPage;
import com.unicef.pages.PaymentPage;
import com.unicef.pages.PersonalWishlist;
import com.unicef.pages.ShippingAddressPage;
import com.unicef.pages.SignIn;

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
		Reporter.log("Redirecting to home page <br>");
		homePage.clickIGHeaderMenu();
		Reporter.log("clicked on IG header menu <br>");
		IG.chooseIGItems(5); // choose education related IG gifts	
		Reporter.log("Select Education related IG gifts <br>");
		IG.clickIGProductPlateRandom(1);
		Reporter.log("Clicked first product in the list <br>");
		IG.addIGtocart();
		Reporter.log("added product to the cart <br>");
		IG.createCard();
		Reporter.log("created the card for product <br>");
		IG.printedCard();
		Reporter.log("selected printed card <br>");
		
	}
	
	
	/* test case for create card for IG gift using Print at home Card */
	@Test(priority=1)
	public void IGcreateCardPrintAtHomeCard()throws Exception{
		
		
		HomePage homePage = new HomePage(driver);
		Cart cat = new Cart(driver);
		SignIn sign = new SignIn(driver);
		IGgiftPage IG=new IGgiftPage(driver);
		
		homePage.openHomePage();
		Reporter.log("Redirecting to home page <br>");
		homePage.clickIGHeaderMenu();
		Reporter.log("clicked on IG header menu <br>");
		IG.chooseIGItems(5); // choose education related IG gifts	 
		Reporter.log("Select Education related IG gifts <br>");
		IG.clickIGProductPlateRandom(1);
		Reporter.log("Clicked first product in the list <br>");
		IG.addIGtocart();
		Reporter.log("added product to the cart <br>");
		IG.createCard();
		Reporter.log("created the card for product <br>");
		IG.printatHomeCard();
		Reporter.log("selected printed card <br>");
		IG.selectImage(1);
		Reporter.log("selected first image fr card <br>");
		IG.cardMessage();
		Reporter.log("entered the card message <br>");
		IG.addtoMyBagWithCard();
		Reporter.log("added card to Bag <br>");
		
	} 
	
	/* test case for create card for IG gift using E-Greeting Card */
	@Test(priority=2)
	public void IGcreateCardEGreeting()throws Exception{
		
		
		HomePage homePage = new HomePage(driver);
		Cart cat = new Cart(driver);
		SignIn sign = new SignIn(driver);
		IGgiftPage IG=new IGgiftPage(driver);
		
		homePage.openHomePage();
		Reporter.log("Redirecting to home page <br>");
		homePage.clickIGHeaderMenu();
		Reporter.log("clicked on IG header menu <br>");
		IG.chooseIGItems(5); // choose education related IG gifts	 
		Reporter.log("Select Education related IG gifts <br>");
		IG.clickIGProductPlateRandom(1);
		Reporter.log("Clicked first product in the list <br>");
		IG.addIGtocart();
		Reporter.log("added product to the cart <br>");
		IG.createCard();
		Reporter.log("created the card for product <br>");
		IG.EgreetingCard();
		Reporter.log("selected Egreeting card <br>");
		IG.selectImage(1);
		Reporter.log("selected first image fr card <br>");
		IG.cardMessage();
		Reporter.log("entered the card message <br>");
		IG.sendDetails();
		Reporter.log("entered sender details <br>");
		IG.continueToBag();
		Reporter.log("added card to Bag <br>");
	} 
	
	/* test case for create card for IG gift using No Card */
	
	@Test(priority=3)
	public void IGcreateCardNoCard()throws Exception{
		
		
		HomePage homePage = new HomePage(driver);
		Cart cat = new Cart(driver);
		SignIn sign = new SignIn(driver);
		IGgiftPage IG=new IGgiftPage(driver);
		
		homePage.openHomePage();
		Reporter.log("Redirecting to home page <br>");
		homePage.clickIGHeaderMenu();
		Reporter.log("clicked on IG header menu <br>");
		IG.chooseIGItems(5); // choose education related IG gifts	 
		Reporter.log("Select Education related IG gifts <br>");
		IG.clickIGProductPlateRandom(1);
		Reporter.log("Clicked first product in the list <br>");
		IG.addIGtocart();
		Reporter.log("added product to the cart <br>");
		IG.createCard();
		Reporter.log("created the card for product <br>");
		IG.noCard();
		Reporter.log("selected No card option <br>");
	} 
	
	/* test case for check out IG Gift  using Guest checkout */
	@Test(priority=4)
	public void guestCheckOutIGgift() throws Exception{
		
		HomePage homePage = new HomePage(driver);
		Cart cat = new Cart(driver);
		SignIn sign = new SignIn(driver);
		IGgiftPage IG=new IGgiftPage(driver);
		IGShippingBag IGShip= new IGShippingBag(driver);
		ShippingAddressPage shipAddr= new ShippingAddressPage(driver);
		PaymentPage payment=new PaymentPage(driver);
		
		homePage.openHomePage();
		Reporter.log("Redirecting to home page <br>");
		homePage.clickIGHeaderMenu();
		Reporter.log("clicked on IG header menu <br>");
		IG.chooseIGItems(5); // choose education related IG gifts
		Reporter.log("Select Education related IG gifts <br>");
		IG.clickIGProductPlateRandom(1);
		Reporter.log("Clicked first product in the list <br>");
		IG.addIGtocart();
		Reporter.log("added product to the cart <br>");
		IG.createCard();
		Reporter.log("created the card for product <br>");
		IG.EgreetingCard();
		Reporter.log("selected Egreeting card <br>");
		IG.selectImage(1);
		Reporter.log("selected first image fr card <br>");
		IG.cardMessage();
		Reporter.log("entered the card message <br>");
		IG.sendDetails();
		Reporter.log("entered sender details <br>");
		IG.continueToBag();
		Reporter.log("added card to Bag <br>");
		Thread.sleep(5000);
		IGShip.topCheckOut();
		Reporter.log("checkout the item <br>");
		sign.checkoutguest();
		Reporter.log("check out as guest credentials <br>");
		payment.IGgiftPaymentInfo();
		Reporter.log("go to payment options <br>");
		payment.applyPromoCode("QWERTY");
		Reporter.log("go to payment options <br>");
		payment.chooseDonation(5);
		Reporter.log("choose payment <br>");
		payment.cardPayment();
		Reporter.log("give details of card payment <br>");
		payment.newBillingAddr();
		Reporter.log("give billing address <br>");
		payment.bottomContinueButton();
		Reporter.log("click on continue button ");
	
	}
	
	/* test case for check out IG Gift  using Express checkout */
	@Test(priority=5)
	public void expressCheckOutIGgift() throws Exception{
		
		HomePage homePage = new HomePage(driver);
		Cart cat = new Cart(driver);
		SignIn sign = new SignIn(driver);
		IGgiftPage IG=new IGgiftPage(driver);
		IGShippingBag IGShip= new IGShippingBag(driver);
		ShippingAddressPage shipAddr= new ShippingAddressPage(driver);
		PaymentPage payment=new PaymentPage(driver);
		
		homePage.openHomePage();
		Reporter.log("Redirecting to home page <br>");
		homePage.clickIGHeaderMenu();
		Reporter.log("clicked on IG header menu <br>");
		IG.chooseIGItems(5); // choose education related IG gifts	 
		Reporter.log("Select Education related IG gifts <br>");
		IG.clickIGProductPlateRandom(1);
		Reporter.log("Clicked first product in the list <br>");
		IG.addIGtocart();
		Reporter.log("added product to the cart <br>");
		IG.createCard();
		Reporter.log("created the card for product <br>");
		IG.EgreetingCard();
		Reporter.log("selected Egreeting card <br>");
		IG.selectImage(1);
		Reporter.log("selected first image fr card <br>");
		IG.cardMessage();
		IG.sendDetails();
		System.out.println("testfddfdsf");
		IG.continueToBag();
		System.out.println("test");
		Thread.sleep(5000);
		System.out.println("dsfdsfdsf");
		IGShip.topCheckOut();
		System.out.println("checkout the item");
		sign.EntersignInDet();		
		payment.paymentPageFunctionalities();
//		System.out.println("go to payment options");
//		payment.applyPromoCode("QWERTY");
//		payment.chooseDonation(5);
//		payment.cardPayment();
//		payment.newBillingAddr();
//		payment.bottomContinueButton();
	
	}
	

}
