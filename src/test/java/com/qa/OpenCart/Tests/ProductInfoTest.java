package com.qa.OpenCart.Tests;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.OpenCart.base.BaseTest;

public class ProductInfoTest extends BaseTest{
	
	@BeforeClass
	public void productInfoPageSetup() {
		homePage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	
	@Test
	public void productImagesTest() {
		resultsPage = homePage.doSearch("iMac ");
		productInfoPage = resultsPage.selectProduct("iMac ");
		Assert.assertEquals(productInfoPage.getProductImagesCount(), 3);
	}
	
	
	@Test
	public void verifyproductInfoTest_MacBook() {
		resultsPage = homePage.doSearch("Macbook");
		productInfoPage = resultsPage.selectProduct("MacBook Pro");
		Map<String, String> actProductInfoMap = productInfoPage.getProductInfo();
		
		Assert.assertEquals(actProductInfoMap.get("name"), "MacBook Pro11");
		Assert.assertEquals(actProductInfoMap.get("Brand"), "Apple");
		Assert.assertEquals(actProductInfoMap.get("Product Code"), "Product 18");
		Assert.assertEquals(actProductInfoMap.get("price"), "$2,000.00");
		//Assert.assertAll();
	}

}
