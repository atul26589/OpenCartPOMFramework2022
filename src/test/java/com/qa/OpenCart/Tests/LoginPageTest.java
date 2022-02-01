package com.qa.OpenCart.Tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.qa.OpenCart.base.BaseTest;
import com.qa.OpenCart.testlisteners.ExtentReportListener;
import com.qa.OpenCart.utils.Constants;


//@Listeners(ExtentReportListener.class)
public class LoginPageTest extends BaseTest{

	
	@Test(priority=1)
	public void verifyLoginPageTitleTest() throws InterruptedException {
		String title=loginPage.getLoginPageTitle();
		System.out.println("login page title is:"+title);
		Assert.assertEquals(title,Constants.LOGIN_PAGE_TITLE);
	}
	@Test(priority=2)
	public void loginTest() {
		loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		
	}
}
