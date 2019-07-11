package com.novica.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.novica.base.BasePageObject;
public class SignIn extends BasePageObject{
	private static final By username = By.id("email");
	private static final By password = By.id("password");
	private static final By signin = By.id("submitReturnLogin");
	private static final By loginname = By.id("user_email");
	private static final By loginpassword = By.id("user_password"); 
	private static final By loginbutton = By.xpath("//*[@id='main-page']/div/div/div[1]/div[1]/div/form/div[5]/div/button");
	private By wholeSaleLoginButton= By.xpath("//*[@id='main-page']/div/div/div/div[1]/div/form/div[4]/div/button");
	private By SignupButton= By.xpath("//*[@id='main-page']/div/div/div[1]/div[2]/div/div/div[1]/div/a");
	private By firstName= By.id("user_firstname");
	private By lastName= By.id("user_lastname");
	private By emailAddress= By.id("user_email");
	private By emailVerify= By.id("user_email_verify");
	private By signupPassword= By.id("user_password");
	private By verifyPassword= By.id("user_password_verify");
	private By createAccountButton= By.xpath("//*[@id='main-page']/div/div/div[1]/div[1]/div/form/div[8]/div/button");
	private By forgetButton= By.xpath("//*[@id='main-page']/div/div/div[1]/div[1]/div/form/div[4]/div/div/div[2]/a");
	private By forgetEmail= By.xpath("//*[@id='novicamodal']/div/div/div/div/div[2]/form/div[1]/div[2]/div/input");
	private By forgetContinue= By.xpath("//*[@id='novicamodal']/div/div/div/div/div[2]/form/div[2]/div/button[1]");
	private By okButton= By.xpath("//*[@id='novicamodal']/div/div/div/div/button");
	
	
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
		type(password, "spark007");
		click(signin);
		waitForJavascripttoLoad();
		
	}
	
	public void Login()throws Exception{
		
		waitForVisibilityOf(loginname, 10);
		find(loginname).clear();
		find(loginpassword).clear();
		type(loginname, "jijitest.sprcn@gmail.com");
		type(loginpassword, "spark007");
		click(loginbutton);
		waitForJavascripttoLoad();
			
	}
	
	/* to click on header sign in button */
	public void clickHeaderSignIn()throws Exception{
		
		WebElement hoverAccountMenu= driver.findElement(By.id("globalnav-account"));
		WebElement SignInButton= driver.findElement(By.xpath("//*[@id='globalnavitems-account']/li[1]/div/div/a"));
		HoverAndClick(driver,hoverAccountMenu,SignInButton);
	}
	
		/* to register as new user */
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
	
	public void forgetPasswordButton() throws Exception{
		
		waitForClickabilityOf(forgetButton,10);
		click(forgetButton);
		
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
	
	/* to click on whole sale login button */
	public void clickWholeSaleLogin() throws Exception{
		
		By wholeSaleLoginButton= By.xpath("//*[@id='topbanner-text']/div[4]/div/a");
		explicitWait(wholeSaleLoginButton);
		click(wholeSaleLoginButton);
	}
	
	/* whole sale login credentials */
	public void WholeSaleLogin()throws Exception{
		
		waitForVisibilityOf(loginname, 10);
		find(loginname).clear();
		find(loginpassword).clear();
		type(loginname, "jlee@novica.com");
		type(loginpassword, "c8noma");
		click(wholeSaleLoginButton);
		waitForJavascripttoLoad();
			
	}

	
}
