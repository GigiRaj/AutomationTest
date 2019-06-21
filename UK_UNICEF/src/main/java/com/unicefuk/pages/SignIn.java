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
	
	
	public SignIn(WebDriver driver) {
		super(driver);
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
