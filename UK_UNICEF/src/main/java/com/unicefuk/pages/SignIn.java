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
	private static By headerSignInButton= By.id("account-menu");
	private static By signInLinkButton= By.xpath("//*[@id='shop']/div[1]/div/div[1]/div/div[2]/form/div/div[2]/div/div/div[3]/a");
	private static By emailAddress= By.id("user_email");
	
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
	 /* to click on forgot password link */
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

}
