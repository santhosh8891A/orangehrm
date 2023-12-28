package pageObjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testCases.BaseClass;

public class LoginPage extends BaseClass {
	

	//I Added below comment from sanjay

	WebDriver ldriver;
	public LoginPage(WebDriver rdriver)
	{
	ldriver = rdriver;
	PageFactory.initElements(rdriver, this);
	}
	
	/********Login Elements******/
	@FindBy(name="username") 
	WebElement inputUserName;
	
	@FindBy(name="password") 
	WebElement inputPassword;
	
	@FindBy(xpath="//button[text()=' Login ']") 
	WebElement buttonLogin;
	
	/********Logout Element****************/
	@FindBy(className = "oxd-userdropdown-tab") 
	WebElement userDropDown;
	
	
	@FindBy(xpath = "//a[text()='Logout']") 
	WebElement logoutButton;
	
	//Application login method
	public void  applicationLogin(String userName,String Password)
	{
		inputUserName.sendKeys(userName);
		logger.info("Provided Username");
		inputPassword.sendKeys(Password);
		logger.info("Provided pasword");
		buttonLogin.click();
		logger.info("Clicked on Login button");
	}
	
	//Application Logout Method
	public void logout()
	{
		userDropDown.click();
		logoutButton.click();
		logger.info("Clicked on logout button");
	}

	
	
}
