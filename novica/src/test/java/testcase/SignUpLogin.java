package testcase;

import org.testng.Reporter;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.novica.base.BaseTest;
import com.novica.pages.HomePage;
import com.novica.pages.SignIn;

public class SignUpLogin extends BaseTest {
	
	@Parameters("browser")
	
	/* test case for login into NOVICA */
	@Test(priority=0)
	public void LoginNovica()throws Exception{
		

		HomePage homePage = new HomePage(driver);
		SignIn sign = new SignIn(driver);

		
		homePage.openHomePage();
		Reporter.log("Redirecting to home page <br>");
		sign.clickHeaderSignIn();
		Reporter.log("click on header sign in button <br>");
		sign.waitForSignIntoload();
		Reporter.log("Redirecting to sign in page <br>");
		sign.Login();
		Reporter.log("log in as user by providing email and password <br>");
	}
	
	
	/* test case for sign up */
	@Test(priority=1)
	public void userSignup()throws Exception{
		
		HomePage homePage = new HomePage(driver);
		SignIn sign = new SignIn(driver);

		homePage.openHomePage();
		Reporter.log("Redirecting to home page <br>");
		sign.clickHeaderSignIn();
		Reporter.log("click on header sign in button <br>");
		sign.waitForSignIntoload();
		Reporter.log("Redirecting to sign in page <br>");
		sign.signup();
		Reporter.log("Sign up as new user <br>");
	}
	
/* test case for Forget password functionality during sign in */
	
	@Test(priority=2)
	public void forgetPassword()throws Exception{
		
		
		HomePage homePage = new HomePage(driver);
		SignIn sign = new SignIn(driver);
		
		homePage.openHomePage();
		Reporter.log("Redirecting to home page <br>");
		sign.clickHeaderSignIn();
		Reporter.log("click on header sign in button <br>");
		sign.waitForSignIntoload();
		Reporter.log("Redirecting to sign in page <br>");
		sign.passwordForget();
		Reporter.log("to perform forgot password function <br>");
	} 

}
