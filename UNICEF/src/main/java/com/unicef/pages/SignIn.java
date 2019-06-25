package com.unicef.pages;
import java.util.UUID;

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
	private static By loginButton= By.id("myaccount-header");
	private static By forgetButton= By.xpath("//*[@id='shop']/div[2]/div/div[1]/div/form/div[4]/div/div/div[2]/a");
	private static By forgetPopup= By.xpath("//*[@id='novicamodal']/div/div/div");
	private static By forgetEmail= By.xpath("//*[@id='novicamodal']/div/div/div/div[2]/form/div/div[2]/div/input");
	private static By forgetContinue= By.xpath("//*[@id='novicamodal']/div/div/div/div[2]/form/div[2]/div/button[1]");
	private static By SignupButton= By.xpath("//*[@id='shop']/div[2]/div/div[2]/div/div/div[2]/div/a");
	private static By firstName= By.id("user_firstname");
	private static By lastName= By.id("user_lastname");
	private static By emailAddress= By.id("user_email");
	private static By emailVerify= By.id("user_email_verify");
	private static By signupPassword= By.id("user_password");
	private static By verifyPassword= By.id("user_password_verify");
	private static By createAccountButton= By.xpath("//*[@id='shop']/div[2]/div/div[1]/div/form/div[8]/div/button");
	private static By okButton= By.xpath("//*[@id='novicamodal']/div/div/div/div/button");
			
	public SignIn(WebDriver driver) {
		super(driver);
	}
	public void waitForSignIntoload() throws Exception {
		waitForJavascripttoLoad();
	}
	
	public void headerLoginButton() throws Exception{
		
		waitForClickabilityOf(loginButton,10);
		click(loginButton);
		
	}
	
	/* to click guest checkout button */
	public void checkoutguest()throws Exception{
		waitForClickabilityOf(checkoutButton,10);
		click(checkoutButton);
		
	}
	
	
	public void forgetPasswordButton() throws Exception{
		
		waitForClickabilityOf(forgetButton,10);
		click(forgetButton);
		
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
	
	public void passwordForget() throws Exception{
		
		forgetPasswordButton();
//		waitForVisibilityOf(forgetPopup,10);
		Thread.sleep(5000);
		type(forgetEmail,"jijitest.sprcn@gmail.com");
		click(forgetContinue);	
		Thread.sleep(5000);
		click(okButton);
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
	
	public void signup() throws Exception{
		
		
		String random= getRandomString();
		String email="test" +random + "@gmail.com";
		waitForClickabilityOf(SignupButton,10);
		click(SignupButton);
		waitForJavascripttoLoad();
		type(firstName,"gigi");
		type(lastName,"test"+random);
		type(emailAddress,email);
		type(emailVerify,email);
		scrollToBottom();
		type(signupPassword,"123456789");
		type(verifyPassword,"123456789");	
		click(createAccountButton);	
	}
}
