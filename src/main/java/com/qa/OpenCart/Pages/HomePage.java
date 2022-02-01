package com.qa.OpenCart.Pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.OpenCart.base.BasePage;
import com.qa.OpenCart.utils.Constants;
import com.qa.OpenCart.utils.ElementUtil;

public class HomePage extends BasePage {
	private WebDriver driver;
	private ElementUtil elementUtil;
	
	private By header=By.xpath("//a[text()='Your Store']");
	private By myAccountIcon =By.xpath("//span[text()='My Account']");
	private By shoppingCartIcon=By.xpath("//a[@title='Shopping Cart']");
	private By accountHeaders=By.cssSelector("div#content h2");
	private By searchText=By.cssSelector("div#search input[name='search']");
	private By searchButton=By.cssSelector("div#search button[type='button']");
	private By searchItemsResult=By.cssSelector(".product-layout .product-thumb");
	private By resultItems=By.cssSelector(".product-thumb h4 a");
	
	
	public  HomePage(WebDriver driver) {
		this.driver=driver;
		elementUtil=new ElementUtil(this.driver);
		
	}
	
	public String getHomePagetitle() {
		return elementUtil.getPageTitle(Constants.HOME_PAGE_TITLE, 10);
		
	}
	
	public String getHeaderValue() {
		//elementUtil.doGetText(header);
		
			return elementUtil.doGetText(header);
		}
		
	
	
	public boolean ismyAccountIconExist() {
		if (elementUtil.getElement(myAccountIcon).isDisplayed()) {
				
			return true;
		}
		return false;
	}
	
	public boolean isshoppingCartIconExist() {
		if (elementUtil.getElement(myAccountIcon).isDisplayed()) {
			return true;
		}
		return false;
	}

	
	public int getAccountSectionsCount()
{
return elementUtil.getElements(accountHeaders).size();
		//findElements(accountHeaders)		

}
	public List<String> getAccountSectionList() {
		List<String> accountsList=new ArrayList<>();
        List<WebElement> accSectionList=elementUtil.getElements(accountHeaders);
	for (WebElement e:accSectionList) {
		accountsList.add(e.getText());
	}
	return accountsList;
	}
	
	public ResultsPage doSearch(String productName) {
		System.out.println("searching the product: " + productName);
		elementUtil.getElement(searchText).sendKeys(productName);
		elementUtil.getElement(searchButton).click();
		return new ResultsPage(driver);
	}
	
	public ProductInfoPage selectProductFromResults(String productName) {
		List<WebElement> resultItemList=elementUtil.getElements(resultItems);
		System.out.println("total no of items displayed: " + resultItemList.size());
	for (WebElement e : resultItemList ) {
		if(e.getText().equals(productName)) {
			e.click();
			break;
		}
	}
	return new ProductInfoPage(driver);
	}
}
