package com.qa.OpenCart.Tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.OpenCart.base.BaseTest;
import com.qa.OpenCart.utils.Constants;

import junit.framework.Assert;

public class HomePageTest extends BaseTest {
	
	@BeforeClass
	public void homePageSetUp() {
		homePage=loginPage.doLogin(prop.getProperty("username"),prop.getProperty("password"));
	}
	
	@SuppressWarnings("deprecation")
	@Test(priority=1)
	public void homePageTitleTest() {
		String title=homePage.getHomePagetitle();
		System.out.println("home page title: " +title);
		Assert.assertEquals(title, Constants.HOME_PAGE_TITLE);
	}
	
	@SuppressWarnings("deprecation")
	@Test(priority=2)
	public void verifyHomePageHeaderTest() {
		String headerValue=homePage.getHeaderValue();
		System.out.println("home page header Value: " + headerValue);
	Assert.assertEquals(headerValue, Constants.HOME_PAGE_HEADER);
	}
	
	@Test(priority=3)
	public void verifyShoppingCartTest() {
		Assert.assertTrue(homePage.isshoppingCartIconExist());
	}
	
	@Test(priority=4)
	public void verifyMyAccountIconTest() {
		Assert.assertTrue(homePage.ismyAccountIconExist());
	}
	
	@Test(priority=5)
	public void verifyMyAccountSectionsCountTest() {
		Assert.assertTrue(homePage.getAccountSectionsCount() == Constants.ACCOUNTS_SECTIONS);
	}
	
	@Test(priority=5)
	public void verifyMyAccountSectionsistTest() {
		Assert.assertEquals(homePage.getAccountSectionList(),Constants.getAccountSetionsList());	}

	/*@Test(priority=6)
	public void searchTest() {
		Assert.assertTrue(homePage.doSearch("iMac"));	
		}*/
}
