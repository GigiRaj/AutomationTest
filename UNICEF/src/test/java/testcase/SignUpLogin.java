package testcase;

import com.unicef.base.BaseTest;
import com.unicef.pages.C3category;
import com.unicef.pages.Cart;
import com.unicef.pages.HomePage;
import com.unicef.pages.ItemDetailPage;
import com.unicef.pages.PaymentPage;
import com.unicef.pages.PersonalWishlist;
import com.unicef.pages.ShippingAddressPage;
import com.unicef.pages.SignIn;
import static org.testng.Assert.assertEquals;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

public class SignUpLogin extends BaseTest {
	
	@Parameters("browser")
	
	/* test case for login into UNICEF US */
	@Test(priority=0)
	public void LoginUnicefUS()throws Exception{
		

		HomePage homePage = new HomePage(driver);
		SignIn sign = new SignIn(driver);

		
		homePage.openHomePage();
		Reporter.log("Redirecting to home page <br>");
		sign.headerLoginButton();
		Reporter.log("clicked on Login header menu <br>");
		sign.Login();
		Reporter.log("Enter sign in details <br>");
	}
	
	/* test case for Forget password functionality during sign in */
	
	@Test(priority=1)
	public void forgetPassword()throws Exception{
		
		
		HomePage homePage = new HomePage(driver);
		SignIn sign = new SignIn(driver);
		
		homePage.openHomePage();
		Reporter.log("Redirecting to home page <br>");
		sign.headerLoginButton();
		Reporter.log("clicked on Login header menu <br>");
		sign.passwordForget();
		Reporter.log("click on forget password link <br>");
	}
	 
	/* test case for signup */
	@Test(priority=2)
	public void userSignup()throws Exception{
		
		HomePage homePage = new HomePage(driver);
		SignIn sign = new SignIn(driver);

		homePage.openHomePage();
		Reporter.log("Redirecting to home page <br>");
		sign.headerLoginButton();
		Reporter.log("clicked on Login header menu <br>");
		sign.signup();
		Reporter.log("signup as new user <br>");
	}

}
