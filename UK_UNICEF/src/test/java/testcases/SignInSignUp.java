package testcases;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.unicefuk.pages.HomePage;
import com.unicefuk.pages.SignIn;
import com.unicefuk.base.BaseTest;

public class SignInSignUp extends BaseTest {
	
@Parameters("browser")
	
	/* test case for login into UNICEF US */
	@Test(priority=0)
	public void LoginUnicefUS()throws Exception{
		

		HomePage homePage = new HomePage(driver);
		SignIn sign = new SignIn(driver);

		
		homePage.openHomePage();
		homePage.clickAcceptCookie();
		sign.clickSignin();
		sign.directLogin();
	}

	/* test case for Forget password functionality during sign in */

	@Test(priority=1)
	public void forgetPassword()throws Exception{
	
	
	HomePage homePage = new HomePage(driver);
	SignIn sign = new SignIn(driver);
	
	homePage.openHomePage();
	homePage.clickAcceptCookie();
	sign.clickSignin();
	sign.resetPassword();
	}

	/* test case for create new account */
	@Test(priority=2)
	public void signup() throws Exception{
		
		HomePage homePage = new HomePage(driver);
		SignIn sign = new SignIn(driver);
		
		homePage.openHomePage();
		sign.clickRegister();
		sign.newUsersignIn();
		
	}
	

}
