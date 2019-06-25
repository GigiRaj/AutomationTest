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
		sign.clickSignin();
		sign.SigninLink();
		
	}

}
