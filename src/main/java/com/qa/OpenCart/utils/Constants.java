package com.qa.OpenCart.utils;

import java.util.ArrayList;
import java.util.List;

public class Constants {
	
	public static final String LOGIN_PAGE_TITLE="Account Login";
	
	public static final String HOME_PAGE_TITLE="My Account";
public static final String HOME_PAGE_HEADER="Your Store";
public static final int ACCOUNTS_SECTIONS=4;

public static final String REGISTER_SHEET_NAME="registration";

public static final String REGISTER_SUCCESS_MESSG="Your Account Has Been Created";

public static final String DEFAULT_TIME_OUT = "10";

public static List<String> getAccountSetionsList(){
	List<String> accountsList=new ArrayList<String>();
accountsList.add("My Account");
accountsList.add("My Orders");
accountsList.add("My Affiliate Account");
accountsList.add("Newsletter");
return accountsList;
}

}
