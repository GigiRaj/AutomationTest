package com.unicefuk.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.unicefuk.base.BasePageObject;

public class SignIn extends BasePageObject {
	
	private static final By emailAddressTextField = By.id("email");
	private static final By passwordTextField = By.id("password");
	private static By expressChekoutButton= By.id("submitReturnLogin");
	private static By forgotPasswordButton= By.xpath("//*[@id='loginreturn']/div[3]/div/a");
	private static By guestCheckoutButton= By.className("btn-warning");
	private static By headerSignInButton= By.id("//*[@id='account-menu']/div/a[1]");
	private static By headerRegisterButton= By.id("//*[@id='account-menu']/div/a[2]");
	private static By signInLinkButton= By.xpath("//*[@id='shop']/div[1]/div/div[1]/div/div[2]/form/div/div[2]/div/div/div[3]/a");
	private static By emailAddress= By.id("user_email");
	private static By passwordField= By.id("user_password");
	private static By signInButton= By.xpath("//*[@id='shop']/div[1]/div/div[1]/div/div[2]/div/div[2]/div/form/div[4]/div/button");
	private static By signInForgotPasswordButton = By.xpath("//*[@id='shop']/div[1]/div/div[1]/div/div[2]/div/div[2]/div/form/div[3]/div[2]/a");
	private static By firstNameTextField= By.id("user_firstname");
	private static By lastNameTextField= By.id("user_lastname");
	private static By emaillTextField= By.id("user_email");
	private static By verifyEmailTextField= By.id("user_email_verify");
	private static By createPasswordTextField= By.id("user_password");
	private static By verifyPasswordTextField= By.id("user_password_verify");
	private static By phoneTextField= By.id("phoneNum");
	private static By postcodeTextField= By.id("postcode-lookup");
	private static By lookUpAddressButton= By.id("addrfinderbtn");
	private static By createAccountButton= By.className("createAccountSubmit");
	
	
	public SignIn(WebDriver driver) {
		super(driver);
	}
	
	/* to click on header sign in button */
	public void clickSignin() throws Exception{
		waitForClickabilityOf(headerSignInButton,10);
		click(headerSignInButton);
		
	}
	
	/* to click on sign in link */
	public void SigninLink() throws Exception{
		Thread.sleep(3000);
		waitForClickabilityOf(signInLinkButton,10);
		click(signInLinkButton);
		
	}
	
	public void waitForSignIntoload() throws Exception {
		waitForJavascripttoLoad();
	}
	
	/* to click guest checkout button */
	public void checkoutguest()throws Exception{
		waitForClickabilityOf(guestCheckoutButton,10);
		click(guestCheckoutButton);
		
	}
	 /* to click on forgot password link during check out*/
	public void clickForgetPassword() throws Exception{
		
		waitForClickabilityOf(forgotPasswordButton,10);
		click(forgotPasswordButton);
	}
	 /* to sign in during checkout */
	public void EntersignInDet() throws Exception {
		waitForVisibilityOf(emailAddressTextField, 10);
		find(emailAddressTextField).clear();
		find(passwordTextField).clear();
		type(emailAddressTextField, "jijitest.sprcn@gmail.com");
		type(passwordTextField, "123456");
		click(expressChekoutButton);
		waitForJavascripttoLoad();
		
	}
	
	/* to sign in using header sign in button */
	public void directLogin() throws Exception{
		waitForVisibilityOf(emailAddress, 10);
		Thread.sleep(3000);
		type(emailAddress, "jijitest.sprcn@gmail.com");
		type(passwordField, "123456");
		click(signInButton);
	} 
	
	 /* to click on forgot password and reset password*/
		public void resetPassword() throws Exception{
			
			waitForClickabilityOf(signInForgotPasswordButton,10);
			click(signInForgotPasswordButton);
			Thread.sleep(3000);
			By forgotPasswordEmail= By.xpath("//*[@id='email']");
			type(forgotPasswordEmail,"jijitest.sprcn@gmail.com");
			By forgotPasswordContinueButton= By.xpath("//*[@id='forgotpassword']/div/div[2]/div[1]/button");
			click(forgotPasswordContinueButton);
		}
		
		/* to create a new account as new user */
		public void newUsersignIn()throws Exception{
			
			waitForVisibilityOf(firstNameTextField, 10);
			String random= getRandomString();
			String email="test" +random + "@gmail.com";
			type(firstNameTextField,"gigi");
			type(lastNameTextField,"test"+random);
			type(emaillTextField,email);
			scrollToBottom();
			type(verifyEmailTextField,email);
			type(createPasswordTextField,"123456");
			type(verifyPasswordTextField,"123456");
			type(phoneTextField,"23568956231");
			type(postcodeTextField,"9028");
			click(lookUpAddressButton);
			scrollToBottom();
			click(createAccountButton);
			
		}

}
