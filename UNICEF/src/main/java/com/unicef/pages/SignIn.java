package com.unicef.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import com.unicef.base.BasePageObject;
public class SignIn extends BasePageObject{
	private static final By username = By.id("email");
	private static final By password = By.id("password");
	private static final By signin = By.id("submitReturnLogin");
	private static final By loginname = By.id("user_email");
	private static final By loginpassword = By.id("user_password");
	private static final By loginbutton = By.className("btn-info");
	private static By checkoutButton= By.id("submitGuestLogin");
	
	public SignIn(WebDriver driver) {
		super(driver);
	}
	public void waitForSignIntoload() throws Exception {
		waitForJavascripttoLoad();
	}
	
	public void EntersignInDet() throws Exception {
		waitForVisibilityOf(username, 10);
		find(username).clear();
		find(password).clear();
		type(username, "jijitest.sprcn@gmail.com");
		type(password, "123456789");
		click(signin);
		waitForJavascripttoLoad();
		
	}
	
	public void Login()throws Exception{
		
		waitForVisibilityOf(loginname, 10);
		find(loginname).clear();
		find(loginpassword).clear();
		type(loginname, "jijitest.sprcn@gmail.com");
		type(loginpassword, "123456789");
		click(loginbutton);
		waitForJavascripttoLoad();
		
	}
	
	public void guestChekOut() throws Exception{
		
		waitForVisibilityOf(checkoutButton,10);
		click(checkoutButton);
		ShippingAddressPage shipAddr= new ShippingAddressPage(driver);
		By emailAddress= By.id("email");
		waitForVisibilityOf(emailAddress,10);
		type(emailAddress,"gigi@gmail.com");
		shipAddr.createShipAddress();
	}
}
