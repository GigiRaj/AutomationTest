package testcase;

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
		homePage.clickIGHeaderMenu();
		IG.chooseIGItems(5); // choose education related IG gifts	 
		IG.clickIGProductPlateRandom(1);
		IG.addIGtocart();
		IG.createCard();
		IG.printedCard();
		
	}
	
	
	/* test case for create card for IG gift using Print at home Card */
	@Test(priority=1)
	public void IGcreateCardPrintAtHomeCard()throws Exception{
		
		
		HomePage homePage = new HomePage(driver);
		Cart cat = new Cart(driver);
		SignIn sign = new SignIn(driver);
		IGgiftPage IG=new IGgiftPage(driver);
		
		homePage.openHomePage();
		homePage.clickIGHeaderMenu();
		IG.chooseIGItems(5); // choose education related IG gifts	 
		IG.clickIGProductPlateRandom(1);
		IG.addIGtocart();
		IG.createCard();
		IG.printatHomeCard();
		IG.selectImage(1);
		IG.cardMessage();
		IG.addtoMyBagWithCard();
		
	} 
	
	/* test case for create card for IG gift using E-Greeting Card */
	@Test(priority=2)
	public void IGcreateCardEGreeting()throws Exception{
		
		
		HomePage homePage = new HomePage(driver);
		Cart cat = new Cart(driver);
		SignIn sign = new SignIn(driver);
		IGgiftPage IG=new IGgiftPage(driver);
		
		homePage.openHomePage();
		homePage.clickIGHeaderMenu();
		IG.chooseIGItems(5); // choose education related IG gifts	 
		IG.clickIGProductPlateRandom(1);
		IG.addIGtocart();
		IG.createCard();
		IG.EgreetingCard();
		IG.selectImage(1);
		IG.cardMessage();
		IG.sendDetails();
		IG.continueToBag();
	} 
	
	/* test case for create card for IG gift using No Card */
	
	@Test(priority=3)
	public void IGcreateCardNoCard()throws Exception{
		
		
		HomePage homePage = new HomePage(driver);
		Cart cat = new Cart(driver);
		SignIn sign = new SignIn(driver);
		IGgiftPage IG=new IGgiftPage(driver);
		
		homePage.openHomePage();
		homePage.clickIGHeaderMenu();
		IG.chooseIGItems(5); // choose education related IG gifts	 
		IG.clickIGProductPlateRandom(1);
		IG.addIGtocart();
		IG.createCard();
		IG.noCard();
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
		homePage.clickIGHeaderMenu();
		IG.chooseIGItems(5); // choose education related IG gifts	 
		IG.clickIGProductPlateRandom(1);
		IG.addIGtocart();
		IG.createCard();
		IG.EgreetingCard();
		IG.selectImage(1);
		IG.cardMessage();
		IG.sendDetails();
		System.out.println("testfddfdsf");
		IG.continueToBag();
		System.out.println("test");
		Thread.sleep(5000);
		System.out.println("dsfdsfdsf");
		IGShip.topCheckOut();
		System.out.println("checkout the item");
		sign.checkoutguest();		
		System.out.println("go to payment options");
		payment.IGgiftPaymentInfo();
		payment.applyPromoCode("QWERTY");
		payment.chooseDonation(5);
		payment.cardPayment();
		payment.newBillingAddr();
		payment.bottomContinueButton();
	
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
		homePage.clickIGHeaderMenu();
		IG.chooseIGItems(5); // choose education related IG gifts	 
		IG.clickIGProductPlateRandom(1);
		IG.addIGtocart();
		IG.createCard();
		IG.EgreetingCard();
		IG.selectImage(1);
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
		System.out.println("go to payment options");
		payment.applyPromoCode("QWERTY");
		payment.chooseDonation(5);
		payment.cardPayment();
		payment.newBillingAddr();
		payment.bottomContinueButton();
	
	}

}
