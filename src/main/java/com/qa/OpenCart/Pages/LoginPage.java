package com.qa.OpenCart.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.OpenCart.base.BasePage;
import com.qa.OpenCart.utils.Constants;
import com.qa.OpenCart.utils.ElementUtil;

public class LoginPage extends BasePage {
	
	private WebDriver driver;
	private ElementUtil elementUtil;
	//1. By Locators:OR
	private By emailAddress=By.id("input-email");
	private By password=By.id("input-password");
	private By loginButton=By.xpath("//input[@value='Login']");
	
	private By registerLink=By.linkText("Register");
	
	//2.Constructor of page Class
	
public LoginPage(WebDriver driver) {
	this.driver=driver;
	elementUtil=new ElementUtil(driver);
}

//3.Page Actions:Features of the page in the form of methods
public String getLoginPageTitle() throws InterruptedException {
	//Thread.sleep(7000);
	return elementUtil.getPageTitle(Constants.LOGIN_PAGE_TITLE ,10);
}

public HomePage doLogin(String user,String pwd) {
	System.out.println("login with : " + user + " and " + pwd);
	//driver.findElement(emailAddress).sendKeys(user);
	//driver.findElement(password).sendKeys(pwd);
	//driver.findElement(loginButton).click();
	elementUtil.doSendKeys(emailAddress, user);
	elementUtil.doSendKeys(password, pwd);
	elementUtil.doClick(loginButton);
	return new HomePage(driver);
}

public RegistrationPage navigateToRegistrationPage() {
	elementUtil.doClick(registerLink);
	return new RegistrationPage(driver);
	
}
}
