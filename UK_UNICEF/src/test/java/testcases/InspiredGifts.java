package testcases;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.unicefuk.pages.Cart;
import com.unicefuk.pages.HomePage;
import com.unicefuk.pages.IGCardDetailPage;
import com.unicefuk.pages.IGYourBagPage;
import com.unicefuk.pages.IGgiftPage;
import com.unicefuk.pages.ItemDetailPage;
import com.unicefuk.pages.PaymentPage;
import com.unicefuk.pages.ShippingAddressPage;
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
		IGCardDetailPage IGCard= new IGCardDetailPage(driver);
		ShippingAddressPage shipAddr= new ShippingAddressPage(driver);
		
		
		homePage.openHomePage();
		homePage.clickAcceptCookie();
		IG.IGgiftCategory(4);
		IG.chooseIGGifts(2);
		IG.selectQty(1);
		IG.IGAddtoCart();
		IGCard.clickCreateCard();
		IGCard.clickprintedCard();
		IGCard.viewByOccasion(1);
		IGCard.chooseCoverImage(2);
		IGCard.giveCardMessage();
		IGCard.clickSaveAndContinue();
		IGCard.deliveryAddress();
		IGCard.clickContinueToBag();
		
	}

	/* test case for create card for IG gift using Printed Card */	
	@Test(priority=1)
	public void IGcreatePrintedAtHomeCard()throws Exception{
	
	
	HomePage homePage = new HomePage(driver);
	IGgiftPage IG=new IGgiftPage(driver);
	IGCardDetailPage IGCard= new IGCardDetailPage(driver);
	
	homePage.openHomePage();
	homePage.clickAcceptCookie();
	IG.IGgiftCategory(4);
	IG.chooseIGGifts(2);
	IG.selectQty(1);
	IG.IGAddtoCart();
	IGCard.clickCreateCard();
	IGCard.clickPrintAtHomeCard();
	IGCard.viewByOccasion(1);
	IGCard.chooseCoverImage(2);
	IGCard.giveCardMessage();
	IGCard.clickSavePrintatHome();
	IGCard.printAtHomeContinueToBag();	
}
	

	/* test case for create card for IG gift using Egreeting Card */	
	@Test(priority=2)
	public void IGcreateEGreetingCard()throws Exception{


	HomePage homePage = new HomePage(driver);
	IGgiftPage IG=new IGgiftPage(driver);
	IGCardDetailPage IGCard= new IGCardDetailPage(driver);

	homePage.openHomePage();
	homePage.clickAcceptCookie();
	IG.IGgiftCategory(4);
	IG.chooseIGGifts(2);
	IG.selectQty(1);
	IG.IGAddtoCart();
	IGCard.clickCreateCard();
	IGCard.clickEgreetingCard();
	IGCard.viewByOccasion(1);
	IGCard.chooseCoverImage(2);
	IGCard.giveCardMessage();
	IGCard.clickSavePrintatHome();
	IGCard.emailDetailsECard();
	IGCard.EcardContinueToBag();

}


	/* test case for create card for IG gift using No Card */
	@Test(priority=3)
	public void IGcreateCardNoCard()throws Exception{
		
		HomePage homePage = new HomePage(driver);
		IGgiftPage IG=new IGgiftPage(driver);
		IGCardDetailPage IGCard= new IGCardDetailPage(driver);

		homePage.openHomePage();
		homePage.clickAcceptCookie();
		IG.IGgiftCategory(4);
		IG.chooseIGGifts(2);
		IG.selectQty(1);
		IG.IGAddtoCart();
		IGCard.clickCreateCard();
		IGCard.clickSecondNoCardButton();
		
	}
	
	/* test case for check out IG Gift  using Express checkout */
	@Test(priority=4)
	public void checkOutIGGift()throws Exception{
		
	
	HomePage homePage = new HomePage(driver);
	Cart cat = new Cart(driver);
	SignIn sign = new SignIn(driver);
	IGgiftPage IG=new IGgiftPage(driver);
	IGCardDetailPage IGCard= new IGCardDetailPage(driver);
	ShippingAddressPage shipAddr= new ShippingAddressPage(driver);
	PaymentPage pay= new PaymentPage(driver);
	
	
	homePage.openHomePage();
	homePage.clickAcceptCookie();
	IG.IGgiftCategory(4);
	IG.chooseIGGifts(2);
	IG.selectQty(1);
	IG.IGAddtoCart();
	IGCard.clickCreateCard();
	IGCard.clickprintedCard();
	IGCard.viewByOccasion(1);
	IGCard.chooseCoverImage(2);
	IGCard.giveCardMessage();
	IGCard.clickSaveAndContinue();
	IGCard.deliveryAddress();
	IGCard.clickContinueToBag();
	cat.clickcheckout();
    sign.EntersignInDet();
    pay.paymentFunctionality();
//    pay.chooseDonation(3);
//    pay.applyPromoCode("saduysg");
//    pay.billingAddress();
//    pay.cardPayment();
//    pay.saveAndContinue();
		
	}

	/* to remove the IG gift from basket */

	@Test(priority=4)
	public void RemoveIGGift()throws Exception{
	

		HomePage homePage = new HomePage(driver);
		Cart cat = new Cart(driver);
		SignIn sign = new SignIn(driver);
		IGgiftPage IG=new IGgiftPage(driver);
		IGCardDetailPage IGCard= new IGCardDetailPage(driver);
		ShippingAddressPage shipAddr= new ShippingAddressPage(driver);
		PaymentPage pay= new PaymentPage(driver);
		IGYourBagPage IGBag= new IGYourBagPage(driver);
		
		homePage.openHomePage();
		homePage.clickAcceptCookie();
		IG.IGgiftCategory(4);
		IG.chooseIGGifts(2);
		IG.selectQty(1);
		IG.IGAddtoCart();
		IGCard.clickCreateCard();
		IGCard.clickEgreetingCard();
		IGCard.viewByOccasion(1);
		IGCard.chooseCoverImage(2);
		IGCard.giveCardMessage();
		IGCard.clickSavePrintatHome();
		IGCard.emailDetailsECard();
		IGCard.EcardContinueToBag();
		Thread.sleep(3000);
		IGBag.clickRemove(1);
		IGBag.clickRemoveOkButton();
	}
	
	/* test case for remove address from address book */
	@Test(priority=5)
	public void removeAddress() throws Exception {
		
		HomePage homePage = new HomePage(driver);
		SignIn sign = new SignIn(driver);
		ShippingAddressPage shipAddr= new ShippingAddressPage(driver);
		
		homePage.openHomePage();
		homePage.clickAcceptCookie();
		sign.clickSignin();
		sign.directLogin();
		shipAddr.addressBookMenu();
		shipAddr.RemoveAddressBook(1);
		
	}
	

}
