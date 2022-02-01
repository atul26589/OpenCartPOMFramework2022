package com.qa.OpenCart.Tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.OpenCart.base.BaseTest;
import com.qa.OpenCart.utils.Constants;
import com.qa.OpenCart.utils.ExcelUtil;

public class RegistrationPageTest extends BaseTest{
	
	@BeforeClass
	public void registerPageSetUp() {
		registerPage=loginPage.navigateToRegistrationPage();
	}
	
	@DataProvider
	public Object[][] getRegisterationData() {
	Object data[][]=	ExcelUtil.getTestData(Constants.REGISTER_SHEET_NAME);
		
	return data;
	
	}
	
	
	@Test(dataProvider="getRegisterationData")
	
	public void userRegistrationTest(String firstname,String lastname,String email,String telephone,String password,String subscribe) {
		registerPage.accountRegistration(firstname, lastname, email, telephone, password,subscribe);
	}

}
