package com.qa.OpenCart.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.qa.OpenCart.Pages.HomePage;
import com.qa.OpenCart.Pages.LoginPage;
import com.qa.OpenCart.Pages.ProductInfoPage;
import com.qa.OpenCart.Pages.RegistrationPage;
import com.qa.OpenCart.Pages.ResultsPage;

public class BaseTest {
	
	public BasePage basePage;
	public LoginPage loginPage;
	public HomePage homePage;
	public ProductInfoPage productInfoPage;
	public ResultsPage resultsPage;
	public RegistrationPage registerPage;
	
	public Properties prop;
	public WebDriver driver;
	
	@BeforeTest
	public void setUp() {
		basePage=new BasePage();
		prop=basePage.init_prop();
		String browser=prop.getProperty("browser");
		driver=basePage.init_driver(browser);
		loginPage=new LoginPage(driver);
		driver.get(prop.getProperty("url"));
	}

	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
